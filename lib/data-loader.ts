import fs from "fs"
import path from "path"
import matter from "gray-matter"

export interface BadSmell {
  slug: string
  nameCn: string
  nameEn: string
  category: string
  description: string
  content: string
  example: string
  explanation?: string
}

export interface QuizQuestion {
  id: string
  code: string
  correct: string
  choices: string[]
  explanation?: string
}

const dataDir = path.join(process.cwd(), "data")

export function getBadSmells(): BadSmell[] {
  const badSmellsDir = path.join(dataDir, "bad-smells")
  const examplesDir = path.join(dataDir, "examples")

  if (!fs.existsSync(badSmellsDir)) {
    return []
  }

  const files = fs.readdirSync(badSmellsDir)
  const badSmells: BadSmell[] = []

  for (const file of files) {
    if (file.endsWith(".md")) {
      const filePath = path.join(badSmellsDir, file)
      const fileContent = fs.readFileSync(filePath, "utf8")
      const { data, content } = matter(fileContent)

      // 读取对应的C++示例文件
      const examplePath = path.join(examplesDir, data.exampleFile)
      console.log(`Loading example from: ${examplePath}`)
      let example = ""
      if (fs.existsSync(examplePath)) {
        example = fs.readFileSync(examplePath, "utf8")
      }

      badSmells.push({
        slug: data.slug,
        nameCn: data.nameCn,
        nameEn: data.nameEn,
        category: data.category,
        description: data.description,
        content,
        example,
        explanation: data.explanation,
      })
    }
  }

  // Sort by category and then by name for consistent ordering
  return badSmells.sort((a, b) => {
    if (a.category !== b.category) {
      const categoryOrder = ["Bloaters", "Object-Orientation Abusers", "Change Preventers", "Dispensables", "Couplers"]
      return categoryOrder.indexOf(a.category) - categoryOrder.indexOf(b.category)
    }
    return a.nameCn.localeCompare(b.nameCn)
  })
}

export function getBadSmellBySlug(slug: string): BadSmell | null {
  const badSmells = getBadSmells()
  return badSmells.find((smell) => smell.slug === slug) || null
}

export function getQuizQuestions(): QuizQuestion[] {
  const quizDir = path.join(dataDir, "quiz")
  const snippetsDir = path.join(dataDir, "snippets")

  if (!fs.existsSync(quizDir)) {
    return []
  }

  const files = fs.readdirSync(quizDir)
  const questions: QuizQuestion[] = []

  for (const file of files) {
    if (file.endsWith(".json")) {
      const filePath = path.join(quizDir, file)
      const fileContent = fs.readFileSync(filePath, "utf8")
      const questionData = JSON.parse(fileContent)

      // 读取对应的C++代码文件
      const codePath = path.join(snippetsDir, questionData.codePath)
      let code = ""
      if (fs.existsSync(codePath)) {
        code = fs.readFileSync(codePath, "utf8")
      }

      questions.push({
        id: questionData.id,
        code,
        correct: questionData.correct,
        choices: questionData.choices,
        explanation: questionData.explanation,
      })
    }
  }

  return questions
}

export function getBadSmellCategories() {
  return {
    Bloaters: "🧱",
    "Object-Orientation Abusers": "🧩",
    "Change Preventers": "🛑",
    Dispensables: "🧹",
    Couplers: "🔗",
  }
}

export function getCategoryColors() {
  return {
    Bloaters: "bg-red-100 text-red-800",
    "Object-Orientation Abusers": "bg-orange-100 text-orange-800",
    "Change Preventers": "bg-yellow-100 text-yellow-800",
    Dispensables: "bg-green-100 text-green-800",
    Couplers: "bg-blue-100 text-blue-800",
  }
}

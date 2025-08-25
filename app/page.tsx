import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { BookOpen, Brain, Code, Target } from "lucide-react"
import { getBadSmells, getBadSmellCategories } from "@/lib/data-loader"

export default function HomePage() {
  const badSmells = getBadSmells()
  const categories = getBadSmellCategories()
  const smellCount = badSmells.length
  const categoryCount = Object.keys(categories).length
  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
      {/* Header */}
      <header className="border-b bg-white/80 backdrop-blur-sm">
        <div className="container mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center space-x-2">
              <Code className="h-8 w-8 text-blue-600" />
              <h1 className="text-2xl font-bold text-gray-900">Refactor</h1>
            </div>
            <nav className="flex space-x-4">
              <Link href="/bad-smells">
                <Button variant="ghost">Smells Reference</Button>
              </Link>
              <Link href="/quiz">
                <Button variant="ghost">Identification Quiz</Button>
              </Link>
            </nav>
          </div>
        </div>
      </header>

      {/* Hero Section */}
      <section className="py-20">
        <div className="container mx-auto px-4 text-center">
          <h2 className="text-5xl font-bold text-gray-900 mb-6">Master the Art of Code Refactoring</h2>
          <p className="text-xl text-gray-600 mb-8 max-w-3xl mx-auto">
            Improve your code quality and refactoring skills by learning classic "bad smells" from "Refactoring: Improving the Design of Existing Code"
          </p>
          <div className="flex justify-center space-x-4">
            <Link href="/bad-smells">
              <Button size="lg" className="bg-blue-600 hover:bg-blue-700">
                <BookOpen className="mr-2 h-5 w-5" />
                Start Learning
              </Button>
            </Link>
            <Link href="/quiz">
              <Button size="lg" variant="outline">
                <Brain className="mr-2 h-5 w-5" />
                Test Skills
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* Features */}
      <section className="py-16 bg-white">
        <div className="container mx-auto px-4">
          <h3 className="text-3xl font-bold text-center text-gray-900 mb-12">Why Choose Refactor Java?</h3>
          <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-8">
            <Card>
              <CardHeader>
                <BookOpen className="h-12 w-12 text-blue-600 mb-4" />
                <CardTitle>Systematic Learning</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>Covers {smellCount} classic code bad smells, systematically organized into {categoryCount} major categories for easy understanding and memorization</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Code className="h-12 w-12 text-green-600 mb-4" />
                <CardTitle>Java Examples</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>Each bad smell comes with real Java code examples, closely aligned with actual development scenarios</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Brain className="h-12 w-12 text-purple-600 mb-4" />
                <CardTitle>Interactive Quizzes</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>Test your learning outcomes through random quizzes with instant feedback to help consolidate knowledge</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Target className="h-12 w-12 text-red-600 mb-4" />
                <CardTitle>Skill Enhancement</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>Improve code review abilities, cultivate good programming habits and refactoring awareness</CardDescription>
              </CardContent>
            </Card>
          </div>
        </div>
      </section>

      {/* Stats */}
      <section className="py-16 bg-gray-50">
        <div className="container mx-auto px-4 text-center">
          <div className="grid md:grid-cols-3 gap-8">
            <div>
              <div className="text-4xl font-bold text-blue-600 mb-2">{smellCount}</div>
              <div className="text-gray-600">Code Smells</div>
            </div>
            <div>
              <div className="text-4xl font-bold text-green-600 mb-2">{categoryCount}</div>
              <div className="text-gray-600">Major Categories</div>
            </div>
            <div>
              <div className="text-4xl font-bold text-purple-600 mb-2">∞</div>
              <div className="text-gray-600">Random Quiz Questions</div>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-900 text-white py-8">
        <div className="container mx-auto px-4 text-center">
          <p className="text-gray-400">Built based on "Refactoring: Improving the Design of Existing Code" • Focused on Java Code Quality Improvement</p>
        </div>
      </footer>
    </div>
  )
}

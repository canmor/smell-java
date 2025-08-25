import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { ArrowLeft, Code } from "lucide-react"
import { getBadSmells, getBadSmellCategories, getCategoryColors } from "@/lib/data-loader"

export default function BadSmellsPage() {
  const badSmells = getBadSmells()
  const categoryIcons = getBadSmellCategories()
  const categoryColors = getCategoryColors()
  const categories = Object.keys(categoryColors)

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <header className="border-b bg-white">
        <div className="container mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center space-x-4">
              <Link href="/">
                <Button variant="ghost" size="sm">
                  <ArrowLeft className="mr-2 h-4 w-4" />
                  Back to Home
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Code className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">Code Smells Reference</h1>
              </div>
            </div>
            <Link href="/quiz">
              <Button>Start Quiz</Button>
            </Link>
          </div>
        </div>
      </header>

      <div className="container mx-auto px-4 py-8">
        <div className="mb-8">
          <h2 className="text-3xl font-bold text-gray-900 mb-4">{badSmells.length} Classic Code Smells</h2>
          <p className="text-gray-600 max-w-3xl">
            Based on the book "Refactoring: Improving the Design of Existing Code", this collection covers all classic code bad smells. Each bad smell includes detailed explanations and Java
            example code to help you quickly identify and understand them.
          </p>
        </div>

        {categories.map((category) => {
          const smellsInCategory = badSmells.filter((smell) => smell.category === category)

          if (smellsInCategory.length === 0) {
            return null
          }

          return (
            <div key={category} className="mb-12">
              <div className="flex items-center space-x-3 mb-6">
                <span className="text-2xl">{categoryIcons[category]}</span>
                <h3 className="text-2xl font-bold text-gray-900">{category}</h3>
                <Badge variant="secondary">{smellsInCategory.length} items</Badge>
              </div>

              <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
                {smellsInCategory.map((smell) => (
                  <Link key={smell.slug} href={`/bad-smells/${smell.slug}`}>
                    <Card className="h-full hover:shadow-lg transition-shadow cursor-pointer">
                      <CardHeader>
                        <div className="flex items-start justify-between">
                          <CardTitle className="text-lg leading-tight">
                            <div className="space-y-1">
                              <div className="font-bold text-gray-900">{smell.nameEn}</div>
                              <div className="text-sm font-normal text-gray-500">{smell.nameCn}</div>
                            </div>
                          </CardTitle>
                          <Badge className={categoryColors[smell.category]}>{smell.category}</Badge>
                        </div>
                      </CardHeader>
                      <CardContent>
                        <CardDescription className="line-clamp-3">{smell.descriptionEn}</CardDescription>
                      </CardContent>
                    </Card>
                  </Link>
                ))}
              </div>
            </div>
          )
        })}

        {badSmells.length === 0 && (
          <div className="text-center py-12">
            <p className="text-gray-500 text-lg">No bad smell data available. Please check if the data files exist.</p>
          </div>
        )}
      </div>
    </div>
  )
}

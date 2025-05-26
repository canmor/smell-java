import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { BookOpen, Brain, Code, Target } from "lucide-react"

export default function HomePage() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
      {/* Header */}
      <header className="border-b bg-white/80 backdrop-blur-sm">
        <div className="container mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center space-x-2">
              <Code className="h-8 w-8 text-blue-600" />
              <h1 className="text-2xl font-bold text-gray-900">Refactor C++</h1>
            </div>
            <nav className="flex space-x-4">
              <Link href="/bad-smells">
                <Button variant="ghost">坏味道参考</Button>
              </Link>
              <Link href="/quiz">
                <Button variant="ghost">识别测验</Button>
              </Link>
            </nav>
          </div>
        </div>
      </header>

      {/* Hero Section */}
      <section className="py-20">
        <div className="container mx-auto px-4 text-center">
          <h2 className="text-5xl font-bold text-gray-900 mb-6">掌握代码重构的艺术</h2>
          <p className="text-xl text-gray-600 mb-8 max-w-3xl mx-auto">
            通过学习《重构：改善既有代码的设计》中的经典"坏味道"，提升你的 C++ 代码质量和重构技能
          </p>
          <div className="flex justify-center space-x-4">
            <Link href="/bad-smells">
              <Button size="lg" className="bg-blue-600 hover:bg-blue-700">
                <BookOpen className="mr-2 h-5 w-5" />
                开始学习
              </Button>
            </Link>
            <Link href="/quiz">
              <Button size="lg" variant="outline">
                <Brain className="mr-2 h-5 w-5" />
                测试技能
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* Features */}
      <section className="py-16 bg-white">
        <div className="container mx-auto px-4">
          <h3 className="text-3xl font-bold text-center text-gray-900 mb-12">为什么选择 Refactor C++？</h3>
          <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-8">
            <Card>
              <CardHeader>
                <BookOpen className="h-12 w-12 text-blue-600 mb-4" />
                <CardTitle>系统化学习</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>涵盖22种经典代码坏味道，按5大类别系统组织，便于理解和记忆</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Code className="h-12 w-12 text-green-600 mb-4" />
                <CardTitle>C++ 实例</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>每种坏味道都配有真实的 C++ 代码示例，贴近实际开发场景</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Brain className="h-12 w-12 text-purple-600 mb-4" />
                <CardTitle>互动测验</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>通过随机测验检验学习效果，即时反馈帮助巩固知识</CardDescription>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <Target className="h-12 w-12 text-red-600 mb-4" />
                <CardTitle>技能提升</CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription>提高代码审查能力，培养良好的编程习惯和重构意识</CardDescription>
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
              <div className="text-4xl font-bold text-blue-600 mb-2">22</div>
              <div className="text-gray-600">种代码坏味道</div>
            </div>
            <div>
              <div className="text-4xl font-bold text-green-600 mb-2">5</div>
              <div className="text-gray-600">大分类体系</div>
            </div>
            <div>
              <div className="text-4xl font-bold text-purple-600 mb-2">∞</div>
              <div className="text-gray-600">随机测验题目</div>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-900 text-white py-8">
        <div className="container mx-auto px-4 text-center">
          <p className="text-gray-400">基于《重构：改善既有代码的设计》构建 • 专注 C++ 代码质量提升</p>
        </div>
      </footer>
    </div>
  )
}

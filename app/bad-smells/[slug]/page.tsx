import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Badge } from "@/components/ui/badge"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { ArrowLeft, Code } from "lucide-react"
import { getBadSmells, getBadSmellBySlug, getCategoryColors } from "@/lib/data-loader"
import { notFound } from "next/navigation"
import ReactMarkdown from "react-markdown"
import { CodeBlock } from "@/components/code-block"

const categoryColors = getCategoryColors()

interface PageProps {
  params: {
    slug: string
  }
}

export default function BadSmellDetailPage({ params }: PageProps) {
  const smell = getBadSmellBySlug(params.slug)

  if (!smell) {
    notFound()
  }

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <header className="border-b bg-white">
        <div className="container mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center space-x-4">
              <Link href="/bad-smells">
                <Button variant="ghost" size="sm">
                  <ArrowLeft className="mr-2 h-4 w-4" />
                  返回列表
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Code className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">坏味道详情</h1>
              </div>
            </div>
            <Link href="/quiz">
              <Button>开始测验</Button>
            </Link>
          </div>
        </div>
      </header>

      <div className="container mx-auto px-4 py-8">
        <div className="max-w-4xl mx-auto">
          {/* Title and Category */}
          <div className="mb-8">
            <div className="flex items-start justify-between mb-4">
              <div className="space-y-2">
                <h2 className="text-4xl font-bold text-gray-900 leading-tight">{smell.nameCn}</h2>
                <p className="text-xl text-gray-500 font-medium">{smell.nameEn}</p>
              </div>
              <Badge className={categoryColors[smell.category]}>{smell.category}</Badge>
            </div>
            <p className="text-xl text-gray-600">{smell.description}</p>
          </div>

          {/* Content */}
          <Card className="mb-8">
            <CardContent className="pt-6">
              <div className="prose prose-gray max-w-none prose-headings:text-gray-900 prose-h1:text-2xl prose-h2:text-xl prose-h3:text-lg prose-p:text-gray-700 prose-li:text-gray-700 prose-strong:text-gray-900">
                <ReactMarkdown>{smell.content}</ReactMarkdown>
              </div>
            </CardContent>
          </Card>

          {/* Code Example */}
          <Card>
            <CardHeader>
              <CardTitle className="flex items-center space-x-2">
                <Code className="h-5 w-5" />
                <span>C++ 示例</span>
              </CardTitle>
            </CardHeader>
            <CardContent>
              <CodeBlock code={smell.example} language="cpp" showLineNumbers={true} />
            </CardContent>
          </Card>

          {/* Navigation */}
          <div className="mt-8 flex justify-between">
            <Link href="/bad-smells">
              <Button variant="outline">
                <ArrowLeft className="mr-2 h-4 w-4" />
                返回列表
              </Button>
            </Link>
            <Link href="/quiz">
              <Button>测试你的识别能力</Button>
            </Link>
          </div>
        </div>
      </div>
    </div>
  )
}

export function generateStaticParams() {
  const badSmells = getBadSmells()
  return badSmells.map((smell) => ({
    slug: smell.slug,
  }))
}

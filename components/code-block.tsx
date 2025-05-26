"use client"

import { Copy, Check } from "lucide-react"
import { useState } from "react"
import { Button } from "@/components/ui/button"

interface CodeBlockProps {
  code: string
  language?: string
  showLineNumbers?: boolean
  className?: string
}

// C++ 语法高亮规则
const highlightCppCode = (code: string): string => {
  // C++ 关键字
  const keywords = [
    "class",
    "struct",
    "enum",
    "namespace",
    "template",
    "typename",
    "public",
    "private",
    "protected",
    "virtual",
    "override",
    "final",
    "static",
    "const",
    "constexpr",
    "mutable",
    "volatile",
    "if",
    "else",
    "for",
    "while",
    "do",
    "switch",
    "case",
    "default",
    "break",
    "continue",
    "return",
    "goto",
    "try",
    "catch",
    "throw",
    "new",
    "delete",
    "sizeof",
    "typeid",
    "this",
    "nullptr",
    "true",
    "false",
    "auto",
    "decltype",
    "using",
    "typedef",
    "int",
    "char",
    "bool",
    "float",
    "double",
    "void",
    "long",
    "short",
    "unsigned",
    "signed",
    "std",
    "string",
    "vector",
    "map",
    "set",
    "cout",
    "cin",
    "endl",
    "include",
    "define",
    "ifdef",
    "ifndef",
    "endif",
  ]

  let highlighted = code

  // 高亮字符串 (双引号)
  highlighted = highlighted.replace(/"([^"\\]|\\.)*"/g, '<span class="text-green-400">$&</span>')

  // 高亮字符串 (单引号)
  highlighted = highlighted.replace(/'([^'\\]|\\.)*'/g, '<span class="text-green-400">$&</span>')

  // 高亮单行注释
  highlighted = highlighted.replace(/\/\/.*$/gm, '<span class="text-gray-500 italic">$&</span>')

  // 高亮多行注释
  highlighted = highlighted.replace(/\/\*[\s\S]*?\*\//g, '<span class="text-gray-500 italic">$&</span>')

  // 高亮预处理指令
  highlighted = highlighted.replace(/^#.*$/gm, '<span class="text-purple-400">$&</span>')

  // 高亮数字
  highlighted = highlighted.replace(/\b\d+\.?\d*\b/g, '<span class="text-orange-400">$&</span>')

  // 高亮关键字
  keywords.forEach((keyword) => {
    const regex = new RegExp(`\\b${keyword}\\b`, "g")
    highlighted = highlighted.replace(regex, `<span class="text-blue-400 font-semibold">${keyword}</span>`)
  })

  // 高亮操作符
  highlighted = highlighted.replace(/[+\-*/%=<>!&|^~?:]+/g, '<span class="text-yellow-400">$&</span>')

  // 高亮括号和分隔符
  highlighted = highlighted.replace(/[{}[\]();,]/g, '<span class="text-gray-300">$&</span>')

  return highlighted
}

export function CodeBlock({ code, language = "cpp", showLineNumbers = true, className = "" }: CodeBlockProps) {
  const [copied, setCopied] = useState(false)

  const handleCopy = async () => {
    try {
      await navigator.clipboard.writeText(code)
      setCopied(true)
      setTimeout(() => setCopied(false), 2000)
    } catch (err) {
      console.error("Failed to copy code:", err)
    }
  }

  const lines = code.split("\n")
  const highlightedCode = language === "cpp" ? highlightCppCode(code) : code
  const highlightedLines = highlightedCode.split("\n")

  return (
    <div className={`relative group ${className}`}>
      {/* Copy button */}
      <Button
        variant="ghost"
        size="sm"
        className="absolute top-2 right-2 z-10 opacity-0 group-hover:opacity-100 transition-opacity bg-gray-800 hover:bg-gray-700 text-white border-gray-600"
        onClick={handleCopy}
      >
        {copied ? (
          <>
            <Check className="h-4 w-4 mr-1" />
            已复制
          </>
        ) : (
          <>
            <Copy className="h-4 w-4 mr-1" />
            复制
          </>
        )}
      </Button>

      <div className="bg-gray-900 rounded-lg overflow-hidden">
        <div className="flex">
          {/* Line numbers */}
          {showLineNumbers && (
            <div className="bg-gray-800 px-4 py-4 text-gray-500 text-sm font-mono select-none border-r border-gray-700">
              {lines.map((_, index) => (
                <div key={index} className="leading-6">
                  {index + 1}
                </div>
              ))}
            </div>
          )}

          {/* Code content */}
          <div className="flex-1 p-4 overflow-x-auto">
            <pre className="text-sm font-mono text-gray-100 leading-6">
              {highlightedLines.map((line, index) => (
                <div key={index} dangerouslySetInnerHTML={{ __html: line || " " }} />
              ))}
            </pre>
          </div>
        </div>
      </div>
    </div>
  )
}

"use client"

import { Copy, Check } from "lucide-react"
import { useState } from "react"
import { Button } from "@/components/ui/button"
import { Highlight, themes } from "prism-react-renderer"

interface CodeBlockProps {
  code: string
  language?: string
  showLineNumbers?: boolean
  className?: string
}

// 将语言标识符转换为 prism-react-renderer 支持的格式
const getLanguage = (language: string): string => {
  // 映射常见的语言标识符
  const languageMap: Record<string, string> = {
    "cpp": "cpp",
    "c++": "cpp",
    "js": "javascript",
    "ts": "typescript",
    "jsx": "jsx",
    "tsx": "tsx",
    "md": "markdown",
    "py": "python",
    // 可根据需要添加更多映射
  }
  
  return languageMap[language.toLowerCase()] || language
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
            Copied
          </>
        ) : (
          <>
            <Copy className="h-4 w-4 mr-1" />
            Copy
          </>
        )}
      </Button>

      <Highlight
        code={code}
        language={getLanguage(language) as any}
        theme={themes.nightOwl}
      >
        {({ className: highlightClassName, style, tokens, getLineProps, getTokenProps }) => (
          <div className="bg-gray-900 rounded-lg overflow-hidden">
            <div className="flex">
              {/* Line numbers */}
              {showLineNumbers && (
                <div className="bg-gray-800 px-4 py-4 text-gray-500 text-sm font-mono select-none border-r border-gray-700">
                  {tokens.map((_, index) => (
                    <div key={index} className="leading-6">
                      {index + 1}
                    </div>
                  ))}
                </div>
              )}

              {/* Code content */}
              <div className="flex-1 p-4 overflow-x-auto">
                <pre className={`text-sm font-mono leading-6`} style={style}>
                  {tokens.map((line, i) => {
                    const lineProps = getLineProps({ line });
                    return (
                      <div key={i} {...lineProps}>
                        {line.map((token, key) => {
                          const tokenProps = getTokenProps({ token });
                          return <span key={key} {...tokenProps} />;
                        })}
                      </div>
                    );
                  })}
                </pre>
              </div>
            </div>
          </div>
        )}
      </Highlight>
    </div>
  )
}

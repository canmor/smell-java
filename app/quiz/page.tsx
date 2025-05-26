"use client"

import { useState, useEffect } from "react"
import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Progress } from "@/components/ui/progress"
import { ArrowLeft, Brain, CheckCircle, XCircle, RotateCcw } from "lucide-react"
import { CodeBlock } from "@/components/code-block"

// Mock quiz data for now since we need client-side data
const mockQuizQuestions = [
  {
    id: "quiz001",
    code: `int processOrder(Order order) {
    if (order.type == "standard") {
        return order.price * 1.0;
    } else if (order.type == "premium") {
        return order.price * 1.1;
    } else if (order.type == "vip") {
        return order.price * 1.2;
    } else if (order.type == "corporate") {
        return order.price * 0.9;
    }
    return order.price;
}`,
    correct: "过多的 switch",
    choices: ["冗长函数", "过多的 switch", "数据团", "原始类型偏执"],
    explanation: "这里使用了一系列if-else语句来处理不同类型，应该使用多态来替代。",
  },
  {
    id: "quiz002",
    code: `class User {
private:
    std::string firstName;
    std::string lastName;
    std::string email;
    std::string phone;
    std::string address;
    std::string city;
    std::string zipCode;
    
public:
    // 只有getter和setter方法
    std::string getFirstName() const { return firstName; }
    void setFirstName(const std::string& name) { firstName = name; }
    std::string getEmail() const { return email; }
    void setEmail(const std::string& e) { email = e; }
    // ... 更多getter/setter
};`,
    correct: "数据类",
    choices: ["过大的类", "数据类", "懒惰类", "原始类型偏执"],
    explanation: "这个类只包含数据和访问器方法，没有任何行为逻辑。",
  },
  {
    id: "quiz003",
    code: `void calculateScore(Player player) {
    int score = 0;
    
    // 计算基础分数
    score += player.level * 100;
    score += player.experience / 10;
    
    // 计算装备加成
    for (auto& item : player.equipment) {
        if (item.type == "weapon") {
            score += item.attack * 2;
        } else if (item.type == "armor") {
            score += item.defense * 1.5;
        }
    }
    
    // 计算技能加成
    for (auto& skill : player.skills) {
        if (skill.level > 5) {
            score += skill.level * skill.multiplier;
        }
    }
    
    // 计算成就加成
    int achievementBonus = 0;
    for (auto& achievement : player.achievements) {
        if (achievement.isCompleted) {
            achievementBonus += achievement.points;
        }
    }
    score += achievementBonus * 0.1;
    
    // 应用特殊规则
    if (player.isVIP) {
        score *= 1.5;
    }
    
    return score;
}`,
    correct: "冗长函数",
    choices: ["冗长函数", "特性嫉妒", "过多的 switch", "重复代码"],
    explanation: "这个函数过长，承担了太多职责，应该拆分为多个小函数。",
  },
]

interface QuizState {
  currentQuestion: number
  score: number
  answers: boolean[]
  showResult: boolean
  selectedAnswer: string | null
  showFeedback: boolean
  startTime: number
  endTime: number | null
}

export default function QuizPage() {
  const [quiz, setQuiz] = useState<QuizState>({
    currentQuestion: 0,
    score: 0,
    answers: [],
    showResult: false,
    selectedAnswer: null,
    showFeedback: false,
    startTime: Date.now(),
    endTime: null,
  })

  const [shuffledQuestions, setShuffledQuestions] = useState(mockQuizQuestions)

  useEffect(() => {
    // Shuffle questions on component mount
    const shuffled = [...mockQuizQuestions].sort(() => Math.random() - 0.5)
    setShuffledQuestions(shuffled)
  }, [])

  const currentQ = shuffledQuestions[quiz.currentQuestion]
  const progress = ((quiz.currentQuestion + 1) / shuffledQuestions.length) * 100

  const handleAnswer = (answer: string) => {
    if (quiz.showFeedback) return

    setQuiz((prev) => ({
      ...prev,
      selectedAnswer: answer,
      showFeedback: true,
    }))

    const isCorrect = answer === currentQ.correct

    setTimeout(() => {
      setQuiz((prev) => {
        const newAnswers = [...prev.answers, isCorrect]
        const newScore = isCorrect ? prev.score + 1 : prev.score
        const isLastQuestion = prev.currentQuestion === shuffledQuestions.length - 1

        return {
          ...prev,
          score: newScore,
          answers: newAnswers,
          currentQuestion: isLastQuestion ? prev.currentQuestion : prev.currentQuestion + 1,
          showResult: isLastQuestion,
          selectedAnswer: null,
          showFeedback: false,
          endTime: isLastQuestion ? Date.now() : null,
        }
      })
    }, 2000)
  }

  const resetQuiz = () => {
    const shuffled = [...mockQuizQuestions].sort(() => Math.random() - 0.5)
    setShuffledQuestions(shuffled)
    setQuiz({
      currentQuestion: 0,
      score: 0,
      answers: [],
      showResult: false,
      selectedAnswer: null,
      showFeedback: false,
      startTime: Date.now(),
      endTime: null,
    })
  }

  const formatTime = (ms: number) => {
    const seconds = Math.floor(ms / 1000)
    const minutes = Math.floor(seconds / 60)
    return `${minutes}:${(seconds % 60).toString().padStart(2, "0")}`
  }

  if (quiz.showResult) {
    const totalTime = quiz.endTime! - quiz.startTime
    const accuracy = Math.round((quiz.score / shuffledQuestions.length) * 100)

    return (
      <div className="min-h-screen bg-gray-50">
        <header className="border-b bg-white">
          <div className="container mx-auto px-4 py-4">
            <div className="flex items-center space-x-4">
              <Link href="/">
                <Button variant="ghost" size="sm">
                  <ArrowLeft className="mr-2 h-4 w-4" />
                  返回首页
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Brain className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">测验结果</h1>
              </div>
            </div>
          </div>
        </header>

        <div className="container mx-auto px-4 py-8">
          <div className="max-w-2xl mx-auto">
            <Card>
              <CardHeader className="text-center">
                <CardTitle className="text-3xl mb-4">🎉 测验完成！</CardTitle>
              </CardHeader>
              <CardContent className="space-y-6">
                <div className="grid grid-cols-3 gap-4 text-center">
                  <div>
                    <div className="text-3xl font-bold text-blue-600">{quiz.score}</div>
                    <div className="text-sm text-gray-600">正确题数</div>
                  </div>
                  <div>
                    <div className="text-3xl font-bold text-green-600">{accuracy}%</div>
                    <div className="text-sm text-gray-600">正确率</div>
                  </div>
                  <div>
                    <div className="text-3xl font-bold text-purple-600">{formatTime(totalTime)}</div>
                    <div className="text-sm text-gray-600">总耗时</div>
                  </div>
                </div>

                <div className="space-y-2">
                  <div className="flex justify-between text-sm">
                    <span>总题数：{shuffledQuestions.length}</span>
                    <span>错误：{shuffledQuestions.length - quiz.score}</span>
                  </div>
                  <Progress value={accuracy} className="h-2" />
                </div>

                <div className="flex space-x-4">
                  <Button onClick={resetQuiz} className="flex-1">
                    <RotateCcw className="mr-2 h-4 w-4" />
                    重新测验
                  </Button>
                  <Link href="/bad-smells" className="flex-1">
                    <Button variant="outline" className="w-full">
                      复习坏味道
                    </Button>
                  </Link>
                </div>
              </CardContent>
            </Card>
          </div>
        </div>
      </div>
    )
  }

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
                  返回首页
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Brain className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">坏味道识别测验</h1>
              </div>
            </div>
            <Badge variant="secondary">
              {quiz.currentQuestion + 1} / {shuffledQuestions.length}
            </Badge>
          </div>
        </div>
      </header>

      <div className="container mx-auto px-4 py-8">
        <div className="max-w-4xl mx-auto">
          {/* Progress */}
          <div className="mb-8">
            <div className="flex justify-between text-sm text-gray-600 mb-2">
              <span>进度</span>
              <span>{Math.round(progress)}%</span>
            </div>
            <Progress value={progress} className="h-2" />
          </div>

          {/* Question */}
          <Card className="mb-8">
            <CardHeader>
              <CardTitle className="flex items-center justify-between">
                <span>题目 {quiz.currentQuestion + 1}</span>
                <Badge>识别坏味道</Badge>
              </CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-gray-700 mb-4">请识别以下 C++ 代码中的坏味道类型：</p>
              <CodeBlock code={currentQ.code} language="cpp" showLineNumbers={true} />
            </CardContent>
          </Card>

          {/* Choices */}
          <div className="grid gap-4">
            {currentQ.choices.map((choice, index) => {
              const isSelected = quiz.selectedAnswer === choice
              const isCorrect = choice === currentQ.correct
              const showCorrect = quiz.showFeedback && isCorrect
              const showWrong = quiz.showFeedback && isSelected && !isCorrect

              return (
                <Button
                  key={index}
                  variant={showCorrect ? "default" : showWrong ? "destructive" : "outline"}
                  className={`p-6 h-auto text-left justify-start ${
                    showCorrect ? "bg-green-600 hover:bg-green-700" : ""
                  }`}
                  onClick={() => handleAnswer(choice)}
                  disabled={quiz.showFeedback}
                >
                  <div className="flex items-center space-x-3">
                    {quiz.showFeedback && (
                      <>
                        {showCorrect && <CheckCircle className="h-5 w-5" />}
                        {showWrong && <XCircle className="h-5 w-5" />}
                      </>
                    )}
                    <span>{choice}</span>
                  </div>
                </Button>
              )
            })}
          </div>

          {quiz.showFeedback && (
            <div className="mt-6 p-4 bg-blue-50 rounded-lg">
              <p className="text-blue-800">
                <strong>正确答案：</strong>
                {currentQ.correct}
              </p>
              {currentQ.explanation && (
                <p className="text-blue-700 mt-2">
                  <strong>解释：</strong>
                  {currentQ.explanation}
                </p>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  )
}

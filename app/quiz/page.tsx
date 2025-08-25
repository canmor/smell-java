"use client"

import { useState, useEffect } from "react"
import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Progress } from "@/components/ui/progress"
import { ArrowLeft, Brain, CheckCircle, XCircle, RotateCcw } from "lucide-react"
import { CodeBlock } from "@/components/code-block"
import { QuizQuestion, BadSmell } from "@/lib/data-loader"

interface QuizState {
  currentQuestion: number
  score: number
  answers: boolean[]
  showResult: boolean
  selectedAnswer: BadSmell | null
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

  const [shuffledQuestions, setShuffledQuestions] = useState<QuizQuestion[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    // Fetch quiz questions from the API
    const fetchQuizData = async () => {
      try {
        setLoading(true)
        const response = await fetch('/api/quizzes')
        
        if (!response.ok) {
          throw new Error('Failed to fetch quiz data')
        }
        
        const quizData: QuizQuestion[] = await response.json()
        
        // Shuffle the questions
        const shuffled = [...quizData].sort(() => Math.random() - 0.5)
        setShuffledQuestions(shuffled)
        setLoading(false)
      } catch (err) {
        console.error('Error fetching quiz data:', err)
        setError('Failed to load quiz questions. Please try again.')
        setLoading(false)
      }
    }

    fetchQuizData()
  }, [])

  // Only calculate these if questions are loaded
  const currentQ = shuffledQuestions.length > 0 ? shuffledQuestions[quiz.currentQuestion] : null
  const progress = shuffledQuestions.length > 0 ? ((quiz.currentQuestion + 1) / shuffledQuestions.length) * 100 : 0

  const handleAnswer = (answer: BadSmell | null) => {
    if (quiz.showFeedback || !currentQ || !answer) return

    setQuiz((prev) => ({
      ...prev,
      selectedAnswer: answer,
      showFeedback: true,
    }))

    const isCorrect = answer.slug === currentQ.correct?.slug

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
    const shuffled = [...shuffledQuestions].sort(() => Math.random() - 0.5)
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
                  Back
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Brain className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">Quiz Results</h1>
              </div>
            </div>
          </div>
        </header>

        <div className="container mx-auto px-4 py-8">
          <div className="max-w-2xl mx-auto">
            <Card>
              <CardHeader className="text-center">
                <CardTitle className="text-3xl mb-4">🎉 Congratulations!</CardTitle>
              </CardHeader>
              <CardContent className="space-y-6">
                <div className="grid grid-cols-3 gap-4 text-center">
                  <div>
                    <div className="text-3xl font-bold text-blue-600">{quiz.score}</div>
                    <div className="text-sm text-gray-600">Correct Answers</div>
                  </div>
                  <div>
                    <div className="text-3xl font-bold text-green-600">{accuracy}%</div>
                    <div className="text-sm text-gray-600">Accuracy</div>
                  </div>
                  <div>
                    <div className="text-3xl font-bold text-purple-600">{formatTime(totalTime)}</div>
                    <div className="text-sm text-gray-600">Total Time</div>
                  </div>
                </div>

                <div className="space-y-2">
                  <div className="flex justify-between text-sm">
                    <span>Total Questions: {shuffledQuestions.length}</span>
                    <span>Incorrect: {shuffledQuestions.length - quiz.score}</span>
                  </div>
                  <Progress value={accuracy} className="h-2" />
                </div>

                <div className="flex space-x-4">
                  <Button onClick={resetQuiz} className="flex-1">
                    <RotateCcw className="mr-2 h-4 w-4" />
                    Retake Quiz
                  </Button>
                  <Link href="/bad-smells" className="flex-1">
                    <Button variant="outline" className="w-full">
                      Review Smells
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

  // Show loading state
  if (loading) {
    return (
      <div className="min-h-screen bg-gray-50 flex items-center justify-center">
        <div className="text-center p-8">
          <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-600 mx-auto mb-4"></div>
          <p className="text-lg text-gray-600">Loading quiz questions...</p>
        </div>
      </div>
    )
  }

  // Show error state
  if (error || shuffledQuestions.length === 0) {
    return (
      <div className="min-h-screen bg-gray-50 flex items-center justify-center">
        <Card className="w-full max-w-md">
          <CardHeader>
            <CardTitle className="text-center text-red-600">Loading Failed</CardTitle>
          </CardHeader>
          <CardContent className="text-center">
            <p className="mb-4">{error || "Unable to load quiz questions. Please ensure the data files are properly configured."}</p>
            <Button onClick={() => window.location.reload()}>
              <RotateCcw className="mr-2 h-4 w-4" />
              Retry
            </Button>
          </CardContent>
        </Card>
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
                  Back to Home
                </Button>
              </Link>
              <div className="flex items-center space-x-2">
                <Brain className="h-6 w-6 text-blue-600" />
                <h1 className="text-xl font-bold">Code Smell Quiz</h1>
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
              <span>Progress</span>
              <span>{Math.round(progress)}%</span>
            </div>
            <Progress value={progress} className="h-2" />
          </div>

          {/* Question */}
          <Card className="mb-8">
            <CardHeader>
              <CardTitle className="flex items-center justify-between">
                <span>Question {quiz.currentQuestion + 1}</span>
                <Badge>Code Smell Recognition</Badge>
              </CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-gray-700 mb-4">Please identify the code smell in the following code:</p>
              {currentQ && <CodeBlock code={currentQ.code} language="cpp" showLineNumbers={true} />}
            </CardContent>
          </Card>

          {/* Choices */}
          <div className="grid gap-4">
            {currentQ && currentQ.choices.map((choice, index) => {
              if (!choice) return null // Skip null choices
              
              const isSelected = quiz.selectedAnswer?.slug === choice.slug
              const isCorrect = choice.slug === currentQ.correct?.slug
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
                    <span>{choice.nameEn}</span>
                  </div>
                </Button>
              )
            })}
          </div>

          {quiz.showFeedback && currentQ && (
            <div className="mt-6 p-4 bg-blue-50 rounded-lg">
              <p className="text-blue-800">
                <strong>Answer:</strong>
                {currentQ.correct?.nameEn || "Unknown"}
              </p>
              {currentQ.explanation && (
                <p className="text-blue-700 mt-2">
                  <strong>Explanation:</strong>
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

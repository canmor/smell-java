import { NextResponse } from 'next/server'
import { getQuizQuestions } from '@/lib/data-loader'

export async function GET() {
  try {
    const quizzes = getQuizQuestions()
    
    if (quizzes.length === 0) {
      return NextResponse.json(
        { error: 'No valid quiz data was found. Please check the quiz files for syntax errors.' }, 
        { status: 404 }
      )
    }
    
    console.log(`Successfully loaded ${quizzes.length} quiz questions`)
    return NextResponse.json(quizzes)
  } catch (error) {
    console.error('Error loading quiz data:', error)
    return NextResponse.json(
      { error: `Failed to load quiz data: ${error instanceof Error ? error.message : 'Unknown error'}` }, 
      { status: 500 }
    )
  }
}

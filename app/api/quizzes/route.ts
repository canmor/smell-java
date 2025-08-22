import fs from 'fs'
import path from 'path'
import { NextResponse } from 'next/server'

export async function GET() {
  try {
    // Get the quiz directory paths
    const quizDir = path.join(process.cwd(), 'data', 'quiz')
    const snippetsDir = path.join(process.cwd(), 'data', 'snippets')
    
    // Check if directories exist
    if (!fs.existsSync(quizDir)) {
      throw new Error(`Quiz directory not found: ${quizDir}`)
    }
    
    if (!fs.existsSync(snippetsDir)) {
      throw new Error(`Snippets directory not found: ${snippetsDir}`)
    }
    
    // Read all quiz JSON files
    const quizFiles = fs.readdirSync(quizDir).filter(file => file.endsWith('.json'))
    
    if (quizFiles.length === 0) {
      console.warn('No quiz files found in', quizDir)
    }
    
    // Parse each file and create the quiz objects
    const quizzes = quizFiles.flatMap(file => {
      try {
        // Get quiz metadata from JSON
        const filePath = path.join(quizDir, file)
        const fileContent = fs.readFileSync(filePath, 'utf8')
        
        // First, try to clean the content by removing any comments 
        // (JSON doesn't support comments but they may have been added)
        const cleanedContent = fileContent
          .replace(/\/\/.*$/gm, '') // Remove single line comments
          .replace(/\/\*[\s\S]*?\*\//g, '') // Remove multi-line comments
        
        const quiz = JSON.parse(cleanedContent)
        
        // Get the corresponding code snippet
        const snippetPath = path.join(snippetsDir, quiz.codePath)
        const code = fs.existsSync(snippetPath) ? fs.readFileSync(snippetPath, 'utf8') : ''
        
        return [{
          ...quiz,
          code
        }]
      } catch (err) {
        console.error(`Error parsing quiz file ${file}:`, err.message)
        return [] // Skip this file if there's an error
      }
    })
    
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
      { error: `Failed to load quiz data: ${error.message}` }, 
      { status: 500 }
    )
  }
}

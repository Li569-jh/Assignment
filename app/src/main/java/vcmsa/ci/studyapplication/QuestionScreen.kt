package vcmsa.ci.studyapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.widget.TextView

class QuestionScreen : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        val questionText = findViewById<TextView>(R.id.questionText)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)


        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        val questions = arrayOf(
            "The average human body has 206 bones?",
            "A average human being should get sunlight for 12 hours a day?",
            "Two to three litres of water per day should be enough for a healthy human?",
            "A human body can survive for 100 years?",
            "A average person can survive for 1 year without eating anything?",
        )
        for (x in questions) {
            println(x)
        }

        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        val correctAnswers = arrayOf(
            "true",
            "false",
            "true",
            "true",
            "false",
        )
        for (x in correctAnswers) {
            println(x)
        }

        fun displayQuestion() {
            questionText.text = questions[currentQuestionIndex]
            questionText.text = questions[currentQuestionIndex]
            questionText.text = questions[currentQuestionIndex]
        }

        // Button Click Listener for True
        btnTrue.setOnClickListener {
            if (currentQuestionIndex < questions.size -1 && currentQuestionIndex < correctAnswers.size - 1) {
                val isCorrect =
                    correctAnswers[currentQuestionIndex].equals("true", ignoreCase = true)
                if (isCorrect) {
                    score++
                    questionText.text = "Correct!"
                } else {
                    questionText.text = "Incorrect!"
                }
                btnTrue.isEnabled = false
                btnFalse.isEnabled = false
            }
        }
        // Button Click Listener for False
        btnFalse.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1 && currentQuestionIndex < correctAnswers.size -1) {
                val isCorrect =
                    correctAnswers[currentQuestionIndex].equals("false", ignoreCase = true)
                if (isCorrect) {
                    score++
                    questionText.text = "Correct!"
                } else {
                    questionText.text = "Incorrect!"
                }
                btnTrue.isEnabled = false
                btnFalse.isEnabled = false
            }
        }
        // Button Click Listener for Next
        btnNext.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1) {
                if (currentQuestionIndex < correctAnswers.size - 1) {
                    currentQuestionIndex++
                    displayQuestion()
                    btnTrue.isEnabled = true
                    btnFalse.isEnabled = true
                } else {
                    if (currentQuestionIndex == questions.size - 1)
                {
                        val intent = Intent(this, ScoreScreen::class.java)
                        intent.putExtra("score", score)
                        intent.putExtra("questions", questions.size)
                        intent.putExtra("correctAnswers", correctAnswers.size)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}







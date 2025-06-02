package vcmsa.ci.studyapplication

import  android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import kotlin.system.exitProcess

class ScoreScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        var score = intent.getIntExtra("score", 0)
        val scoreText = findViewById<TextView>(R.id.score)
        scoreText.text = "Your score is $score"
        if (score > 2) {
            scoreText.text = "Good Job"
        } else {
            scoreText.text = "Try Again"
        }

        btnReview.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
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
            for (x in questions)
                println(x)

            // This code was adapted from W3Schools
            // W3Schools
            // W3Schools.com
            val correctAnswers = arrayOf(
                "True",
                "False",
                "True",
                "True",
                "False",
            )
            for (x in correctAnswers) {
                println(x)
            }
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}
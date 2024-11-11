// MainActivity.kt
package com.example.marcadorbaloncesto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart: Button = findViewById(R.id.button_start)
        buttonStart.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            startActivity(intent)
        }
    }
}

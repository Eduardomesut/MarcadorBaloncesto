// ScoreActivity.kt
package com.example.marcadorbaloncesto

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private var localScore = 0
    private var visitorScore = 0
    private var timer: CountDownTimer? = null
    private var timeLeft = 600000L  // 5000L Prueba 5 segundos
    private var posessionLocal = true
    private var cuartoActual = 1
    private var faltasLocal = 0
    private var faltasVisitante = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        val localScoreText: TextView = findViewById(R.id.localScore)
        val visitorScoreText: TextView = findViewById(R.id.visitorScore)
        val timerText: TextView = findViewById(R.id.timerText)
        val localText: TextView = findViewById(R.id.LocalText)
        val visitanteText: TextView = findViewById(R.id.textVisitante)
        val buttonMasUno: Button = findViewById(R.id.buttonMasUno)
        val buttonMenosUno: Button = findViewById(R.id.buttonmenos1)
        val buttonDosPuntos: Button = findViewById(R.id.buttonDosPuntos)
        val bottonTriple: Button = findViewById(R.id.bottonTriple)
        val buttonStartTimer: Button = findViewById(R.id.buttonStartTimer)
        val buttonStopTimer: Button = findViewById(R.id.buttonStopTimer)
        val atacaVisitante: TextView = findViewById(R.id.AtacaVisitante)
        val atacaLocal: TextView = findViewById(R.id.AtacaLocal)
        val TextoCuarto: TextView = findViewById(R.id.TextoCuarto)
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView5: ImageView = findViewById(R.id.imageView5)
        val imageView6: ImageView = findViewById(R.id.imageView6)
        val imageView8: ImageView = findViewById(R.id.imageView8)
        val imageView7: ImageView = findViewById(R.id.imageView7)
        val imageView9: ImageView = findViewById(R.id.imageView9)
        val imageView11: ImageView = findViewById(R.id.imageView11)
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView13: ImageView = findViewById(R.id.imageView13)
        val imageView10: ImageView = findViewById(R.id.imageView10)
        val buttonFaltasAtaque: Button = findViewById(R.id.buttonFaltaAtaque)
        val buttonFaltasDefensa: Button = findViewById(R.id.buttonFaltaDefensa)
        val textViewBonus1: TextView = findViewById(R.id.textViewBonus1)
        val textViewBonus2: TextView = findViewById(R.id.textViewBonus2)





        buttonMasUno.setOnClickListener {
            if (posessionLocal) {
                localScore += 1
                localScoreText.text = localScore.toString()
            } else {
                visitorScore += 1
                visitorScoreText.text = visitorScore.toString()
            }
        }
        buttonFaltasAtaque.setOnClickListener {
            if (posessionLocal) {
                faltasLocal += 1
                if (faltasLocal == 1) {
                    imageView.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 2) {
                    imageView5.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 3) {
                    imageView6.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 4) {
                    imageView7.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 5) {
                    imageView8.visibility = ImageView.VISIBLE
                    textViewBonus1.visibility = TextView.VISIBLE

                }


            } else {
                faltasVisitante += 1
                if (faltasVisitante == 1) {
                    imageView9.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 2) {
                    imageView10.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 3) {
                    imageView11.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 4) {
                    imageView12.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 5) {
                    imageView13.visibility = ImageView.VISIBLE
                    textViewBonus2.visibility = TextView.VISIBLE
                }

            }
        }
        buttonFaltasDefensa.setOnClickListener {
            if (posessionLocal) {
                faltasVisitante += 1
                if (faltasVisitante == 1) {
                    imageView9.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 2) {
                    imageView10.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 3) {
                    imageView11.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 4) {
                    imageView12.visibility = ImageView.VISIBLE
                }else if (faltasVisitante == 5) {
                    imageView13.visibility = ImageView.VISIBLE
                    textViewBonus2.visibility = TextView.VISIBLE
                }
            }else{
                faltasLocal += 1
                if (faltasLocal == 1) {
                    imageView.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 2) {
                    imageView5.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 3) {
                    imageView6.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 4) {
                    imageView7.visibility = ImageView.VISIBLE
                }else if (faltasLocal == 5) {
                    imageView8.visibility = ImageView.VISIBLE
                    textViewBonus1.visibility = TextView.VISIBLE
                }
            }
        }



        buttonMenosUno.setOnClickListener {
            if (posessionLocal) {
                localScore -= 1
                localScoreText.text = localScore.toString()
            } else {
                visitorScore -= 1
                visitorScoreText.text = visitorScore.toString()
            }
        }
        buttonDosPuntos.setOnClickListener {
            if (posessionLocal) {
                localScore += 2
                localScoreText.text = localScore.toString()
            } else {
                visitorScore += 2
                visitorScoreText.text = visitorScore.toString()
            }
        }
        bottonTriple.setOnClickListener {
            if (posessionLocal) {
                localScore += 3
                localScoreText.text = localScore.toString()
            } else {
                visitorScore += 3
                visitorScoreText.text = visitorScore.toString()
            }
        }
        atacaLocal.setOnClickListener {
            posessionLocal = true
            localText.setBackgroundColor(0xff6750a4.toInt())
            visitanteText.setBackgroundColor(0x00000000)
        }

        atacaVisitante.setOnClickListener {
            posessionLocal = false
            localText.setBackgroundColor(0x00000000)
            visitanteText.setBackgroundColor(0xff6750a4.toInt())
        }


        buttonStartTimer.setOnClickListener { startTimer(timerText) }
        buttonStopTimer.setOnClickListener { stopTimer() }


    }

    private fun startTimer(timerText: TextView) {
        timer?.cancel()
        timer = object : CountDownTimer(timeLeft, 100) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                val minutes = (timeLeft / 1000) / 60
                val seconds = (timeLeft / 1000) % 60
                val tenths = (timeLeft % 1000) / 100
                timerText.text = String.format("%02d:%02d.%d", minutes, seconds, tenths)
            }

            override fun onFinish() {
                timerText.text = "00:00.0"
                resetQuarter()
            }
        }.start()
    }

    fun resetQuarter() {
        val TextoCuarto: TextView = findViewById(R.id.TextoCuarto)
        if (cuartoActual < 4) {
            cuartoActual++

            TextoCuarto.text = "${cuartoActual}ND"
            timeLeft = 600000L
            resetFaltas()
            startTimer(findViewById(R.id.timerText))
        } else {
            TextoCuarto.text = "Final del partido"
        }
    }

    fun resetFaltas() {
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView5: ImageView = findViewById(R.id.imageView5)
        val imageView6: ImageView = findViewById(R.id.imageView6)
        val imageView8: ImageView = findViewById(R.id.imageView8)
        val imageView7: ImageView = findViewById(R.id.imageView7)
        val imageView9: ImageView = findViewById(R.id.imageView9)
        val imageView11: ImageView = findViewById(R.id.imageView11)
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView13: ImageView = findViewById(R.id.imageView13)
        val imageView10: ImageView = findViewById(R.id.imageView10)
        val textViewBonus1: TextView = findViewById(R.id.textViewBonus1)
        val textViewBonus2: TextView = findViewById(R.id.textViewBonus2)
        faltasLocal = 0
        faltasVisitante = 0
        textViewBonus1.visibility = TextView.INVISIBLE
        textViewBonus2.visibility = TextView.INVISIBLE

        imageView.visibility = ImageView.INVISIBLE
        imageView5.visibility = ImageView.INVISIBLE
        imageView6.visibility = ImageView.INVISIBLE
        imageView7.visibility = ImageView.INVISIBLE
        imageView8.visibility = ImageView.INVISIBLE
        imageView9.visibility = ImageView.INVISIBLE
        imageView10.visibility = ImageView.INVISIBLE
        imageView11.visibility = ImageView.INVISIBLE
        imageView12.visibility = ImageView.INVISIBLE
        imageView13.visibility = ImageView.INVISIBLE
    }



    private fun stopTimer() {
        timer?.cancel()

    }
}

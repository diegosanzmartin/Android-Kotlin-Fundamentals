package com.diegosm.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {                                  //Subclase de Activity

    lateinit var resultImg1 : ImageView
    lateinit var resultImg2 : ImageView
    lateinit var rollButton: Button
    lateinit var countUpButton: Button
    lateinit var resetButton: Button
    var randomInt = 0
    var roll = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)                              //Hasta esta funcion los view no son accesibles en memoria

        resultImg1 = findViewById(R.id.result_img1)                         //Única llamada a findViewById() para ImageView
        resultImg2 = findViewById(R.id.result_img2)
        rollButton = findViewById(R.id.roll_button)
        countUpButton = findViewById(R.id.up_count_button)
        resetButton = findViewById(R.id.reset_button)

/*      val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.up_count_button)
        val resetButton: Button = findViewById(R.id.reset_button)*/

        rollButton.setOnClickListener { rollDice() }
        countUpButton.setOnClickListener { countUP() }
        resetButton.setOnClickListener { resetTo0() }
    }

    private fun rollDice(){
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        //val resultText: TextView = findViewById(R.id.result_text)
        //val resultImg: ImageView = findViewById(R.id.result_img)                      Evitamos el máximo nº de llamadas a findViewById()
        //val randomInt = (1..6).random()           //funcion -> getRandomDiceImage()
        //resultText.text = "Dice Rolled!!"
        //resultText.text = randomInt.toString()

/*        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

            resultImg1.setImageResource(drawableResource)
            resultImg1.getTag(randomInt)
        }*/

        resultImg1.setImageResource(getRandomDiceImage())
        resultImg1.setTag(randomInt)
        resultImg2.setImageResource(getRandomDiceImage())
        resultImg2.setTag(randomInt)
        roll = true
    }

    private fun countUP() {
        if(!roll)   //No entra hasta que se haya pulsado al menos 1 vez el boton roll
            return
        //val resultText: TextView = findViewById(R.id.result_text)
        //val resultImg: ImageView = findViewById(R.id.result_img)
        //val countUpButton: Button = findViewById(R.id.up_count_button)
        //var tagImage = resultImg1.getTag().toString().toInt()
        var tagImage1 = resultImg1.getTag().toString().toInt()
        var tagImage2 = resultImg2.getTag().toString().toInt()

/*        if(resultText.text == "Hello World!") {
            resultText.text = "1"
        }
        else if(resultText.text.toString().toInt() < 6) {
            resultText.text = "${resultText.text.toString().toInt() + 1}"
        }*/

/*        var drawableResource = when(tagImage) {
            1 -> R.drawable.dice_2
            2 -> R.drawable.dice_3
            3 -> R.drawable.dice_4
            4 -> R.drawable.dice_5
            else -> R.drawable.dice_6

          resultImg1.setImageResource(drawableResource)
          resultImg1.setTag("${tagImage+1}")
        }*/


        resultImg1.setImageResource(getCoutUpDiceImage(tagImage1))
        resultImg1.setTag("${tagImage1+1}")
        resultImg2.setImageResource(getCoutUpDiceImage(tagImage2))
        resultImg2.setTag("${tagImage2+1}")

//        Toast.makeText(this, resultText.text, Toast.LENGTH_SHORT).show()


        /*
        ----------------------------------------------------------------------------------------------
                                        SOLUCIÓN GOOGLE DEVELOPER
        ----------------------------------------------------------------------------------------------
            val resultText: TextView = findViewById(R.id.result_text)

            // If text is the default "Hello World!" set that text to 1.
            if (resultText.text == "Hello World!") {
                resultText.text = "1"
            } else {
                // Otherwise, increment the number up to 6.
                // The text value in resultText.text is an instance of the CharSequence class;
                // it needs to be converted to a String object before it can be converted to an int.
                var resultInt = resultText.text.toString().toInt()

                if (resultInt < 6) {
                    resultInt++
                    resultText.text = resultInt.toString()
                }
            }
        */
    }

    private fun resetTo0(){
        if(!roll)
            return
        //val resultText: TextView = findViewById(R.id.result_text)
        //val resultImg: ImageView = findViewById(R.id.result_img)

        //resultText.text = "0"
        resultImg1.setImageResource(R.drawable.dice_1)
        resultImg1.setTag("1")
        resultImg2.setImageResource(R.drawable.dice_1)
        resultImg2.setTag("1")
    }

    private fun getRandomDiceImage() : Int {

        randomInt = (1..6).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return drawableResource
    }

    private fun getCoutUpDiceImage( tagInt : Int ) : Int {
        var drawableResource = when (tagInt) {
            1 -> R.drawable.dice_2
            2 -> R.drawable.dice_3
            3 -> R.drawable.dice_4
            4 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return drawableResource
    }
}
package net.ivanvega.mirollera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img1: ImageView
    lateinit var img2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)


        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)
        img1 = findViewById(R.id.imgRoller1)
        img2 = findViewById(R.id.imgRoller2)

        img1.setImageDrawable(resources.getDrawable(R.drawable.dice_3))
        img2.setImageDrawable(resources.getDrawable(R.drawable.dice_3))

        boton.setOnClickListener {
            val valueAndImgId1 = getRandomDiceImage()
            val valueAndImgId2 = getRandomDiceImage()

            Toast.makeText(
                applicationContext,
                "Boton presionado. Se obtuvo " + valueAndImgId1.first + " y " + valueAndImgId2.first,
                Toast.LENGTH_LONG
            ).show()

            img1.setImageResource(valueAndImgId1.second)
            img2.setImageResource(valueAndImgId2.second)

            lbl.text = ( valueAndImgId1.first+ valueAndImgId2.first).toString()

        }
    }

    private fun getRandomDiceImage() : Pair<Int, Int>{
        val al = diceRoller()

        return when (al){
            1 -> Pair(1, R.drawable.dice_1)
            2 -> Pair(2, R.drawable.dice_2)
            3 -> Pair(3, R.drawable.dice_3)
            4 -> Pair(4, R.drawable.dice_4)
            5 -> Pair(5, R.drawable.dice_5)
            6 -> Pair(6, R.drawable.dice_6)
            else -> Pair(7, R.drawable.empty_dice)
        }
    }

    fun diceRoller () : Int {
        return (1..6).random()
    }

}
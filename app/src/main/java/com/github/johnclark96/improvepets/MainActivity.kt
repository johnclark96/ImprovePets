package com.github.johnclark96.improvepets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        avatarAnim()
    }

    val anim = Dice(6)
    val animRoll = anim.roll()

    private fun avatarAnim() {
        val drawableResource = when (animRoll) {

            1 -> R.drawable.improve_pets_slime_1
            2 -> R.drawable.improve_pets_slime_1
            3 -> R.drawable.improve_pets_slime_1
            4 -> R.drawable.improve_pets_slime_2
            5 -> R.drawable.improve_pets_slime_2
            6 -> R.drawable.improve_pets_slime_4

            else -> R.drawable.improve_pets_slime_1

        }
    }
}

class Avatar () {

}

class Walk (private val walkStatus: Boolean) {

    fun walkCounter(): Int {
        return 0;
    }
}

class Dice (private val numberAnims: Int) {

    //Random Dice Roll and Return Result
    fun roll(): Int {
        return (1..numberAnims).random();
    }

}
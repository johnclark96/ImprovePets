package com.github.johnclark96.improvepets

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Start of Code
    // Credits to https://github.com/ajithvgiri/stopwatch
    // Utilized some code to implement the stopwatch function
    var handler: Handler? = null
    private var hour: TextView? = null
    var minute: TextView? = null
    var seconds: TextView? = null
    var milli_seconds: TextView? = null

    internal var MillisecondTime: Long = 0
    internal var StartTime: Long = 0
    internal var TimeBuff: Long = 0
    internal var UpdateTime = 0L

    internal var Seconds: Int = 0
    internal var Minutes: Int = 0
    internal var MilliSeconds: Int = 0

    //Flag intended for a button from the original source code.
    //internal var flag:Boolean=false

    private var startButton: Button? = null
    // End of Code

    private var levelCount = 1


    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //startButton = findViewById(R.id.buttonWalk) // Disabled (could not get it to work)
        bindViews()

        val slimeImage: ImageView = findViewById(R.id.imageSlime)
        val slimeLevel: TextView = findViewById(R.id.textLevel)
        val buttonOne: Button = findViewById(R.id.buttonWalk)
        val buttonTwo: Button = findViewById(R.id.buttonRun)
        val walkButton: Button = findViewById(R.id.textStatus)
        val runButton: Button = findViewById(R.id.textStatus)



        buttonOne.setOnClickListener {
            levelCount++
            val nextLevel = levelCount.toString()
            slimeLevel.text = nextLevel
            //Not good practice to hard code color changes in the code
            //Move to XML in future.
            slimeImage.setImageResource(R.drawable.improvepetsslime2)
            walkButton.text = "WALK"
            walkButton.setBackgroundColor(Color.BLUE)
            walkButton.setTextColor(Color.WHITE)


        }
        //Not good practice to hard code color changes in the code
        //Move to XML in future.
        buttonTwo.setOnClickListener {
            levelCount++
            val nextLevel = levelCount.toString()
            slimeLevel.text = nextLevel
            slimeImage.setImageResource(R.drawable.improvepetsslime3)
            runButton.text = "RUN"
            runButton.setBackgroundColor(rgb(125, 9, 9))
            runButton.setTextColor(Color.WHITE)
        }


        //avatarAnim()
    }

    //Attempt to animate slime
//    private fun avatarAnim() {
//        for (i in 1..4) {
//
//        }
//    }

    /* Start of Code
       Credits to https://github.com/ajithvgiri/stopwatch
       Utilized some code to implement the stopwatch function */
    private fun bindViews() {
        hour = findViewById(R.id.hour)
        minute = findViewById(R.id.minute)
        seconds = findViewById(R.id.seconds)
        //milli_seconds = findViewById(R.id.milli_seconds)

        startButton?.setOnClickListener {
            StartTime = SystemClock.uptimeMillis()
            handler?.postDelayed(runnable, 0)
        }
    }

    private var runnable: Runnable = object : Runnable {
        @SuppressLint("SetTextI18n")
        override fun run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime

            UpdateTime = TimeBuff + MilliSeconds

            Seconds = (UpdateTime / 1000).toInt()

            Minutes = Seconds / 60

            Seconds %= 60

            MilliSeconds = (UpdateTime % 1000).toInt()

            if (Minutes.toString().length < 2) {
                minute?.text = "0$Minutes"
            } else {
                minute?.text = Minutes.toString()
            }
            if (Seconds.toString().length < 2) {
                seconds?.text = "0$Seconds"
            } else {
                seconds?.text = Seconds.toString()
            }

            milli_seconds?.text = MilliSeconds.toString()

            handler?.postDelayed(this, 0)
        }
    }
}

//End of Code


/*  Attempts to implement Dice game to animate our slime avatar */

//    val anim = Dice(6)
//    val animRoll = anim.roll()

//    private fun avatarAnim() {
//        val drawableResource = when (animRoll) {
//
//            1 -> R.drawable.improve_pets_slime_1
//            2 -> R.drawable.improve_pets_slime_1
//            3 -> R.drawable.improve_pets_slime_1
//            4 -> R.drawable.improve_pets_slime_2
//            5 -> R.drawable.improve_pets_slime_2
//            6 -> R.drawable.improve_pets_slime_4
//
//            else -> R.drawable.improve_pets_slime_1
//
//        }
//    }
//}

//class Dice (private val numberAnims: Int) {
//
//    //Random Dice Roll and Return Result
//    fun roll(): Int {
//        return (1..numberAnims).random();
//    }
//
//}
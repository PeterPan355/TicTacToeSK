package com.example.tictactoesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var buttons: Array<Array<Button>>  //2d array of button elements, lateinit var but cannot initialize, layout is not created
    lateinit var tvp1: TextView
    lateinit var tvp2: TextView

    private var p1playing: Boolean = true
    private var countround: Int = 0
    private var p1points: Int = 0
    private var p2points: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvp1 = findViewById(R.id.textViewigrac1) //reference to view
        tvp2 = findViewById(R.id.textViewigrac2)

        buttons = Array(3) { r ->
            Array(3) { c ->
                initButtons(r, c)
            }
        }


        val resetBtn: Button = findViewById(R.id.resetbtn)
        resetBtn.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Reset button is clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun initButtons(r: Int, c: Any): Button {  //return type button

        val btn: Button = findViewById(resources.getIdentifier("btn$r$c", "id", packageName))

        btn.setOnClickListener {
            (onBtnClick(btn))
        }

        // btn.setOnClickListener {
        //     Toast.makeText(applicationContext, "Button $r$c clicked", Toast.LENGTH_SHORT).show()
        // }
        return btn
    }

    private fun onBtnClick(btn: Button) {
        if (btn.text != "") return //if button is populated with value
        if (p1playing) {
            btn.text = "x"
        } else {
            btn.text = "0"
        }
        countround++
        p1playing = !p1playing
        // if(checkwin())
        // {
        //     if(p1playing) win(1)
        //     else
        //         win(2)
        // }
        // else if ( countround == 9){

        //         draw()
        //     }
        //     else
        //     p1playing = !p1playing

        // }
        // }
    }

    private fun draw(): Any {
        return 1
    }

    private fun win() {
        TODO("Not yet implemented")
    }

    private fun checkwin(): Boolean {
        var allfields = Array(3) { r ->
            Array(3) { c ->
                buttons[r][c].text

            }
        }
        return true
    }

}


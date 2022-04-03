package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var preNum:Double=0.0
    private var operation:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }
    fun write(value: View){
        if(value is Button){
            if(textView.text=="0"||textView.text=="0.0") {
                textView.text = ""
            }
            textView.text=textView.text.toString()+value.text.toString()

        }
    }
    fun clear(AC:View){
        preNum=0.0
        textView.text="0"
        operation=""
    }
    fun operation(op:View){
        if(op is Button){
            if(operation!= ""){
                operation=op.text.toString()
                return
            }
            operation=op.text.toString()
            preNum=textView.text.toString().toDouble()
            textView.text="0"
        }
    }
    fun equlas(equal:View){
        val result:Double = when(operation){
            "+"->preNum+textView.text.toString().toDouble()
            "-"->preNum-textView.text.toString().toDouble()
            "*"->preNum*textView.text.toString().toDouble()
            "/"->preNum/textView.text.toString().toDouble()
            else->0.0
        }
        operation=""
        textView.text=result.toString()
    }

    fun Dot(dot: View){
        textView.text = textView.text.toString() + "."
    }



}


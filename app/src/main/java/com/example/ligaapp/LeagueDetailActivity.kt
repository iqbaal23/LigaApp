package com.example.ligaapp

import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class LeagueDetailActivity : AppCompatActivity() {
    private var name: String = ""
    private var description: String = ""
    private var image: Int = 0
    lateinit var nameTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scrollView {
            verticalLayout {
                padding = dip(8)
                imageView = imageView().lparams{
                    height = dip(150)
                    width = matchParent
                }
                nameTextView = textView{
                    textSize = sp(10).toFloat()
                }.lparams {
                    topMargin = dip(8)
                    Typeface.BOLD
                }
                descriptionTextView = textView().lparams {
                    topMargin = dip(8)
                }
            }
        }

        val intent = intent
        name = intent.getStringExtra("name")
        description = intent.getStringExtra("desc")
        image = intent.getIntExtra("image", 0)

        imageView.setImageResource(image)
        nameTextView.text = name
        descriptionTextView.text = description

    }
}
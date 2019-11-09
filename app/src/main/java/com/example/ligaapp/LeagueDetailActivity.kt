package com.example.ligaapp

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class LeagueDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_LEAGUE = "extra_league"
    }
    lateinit var nameTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionbar = supportActionBar

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

        val league = intent.getParcelableExtra(EXTRA_LEAGUE) as LeagueItem
        var name = league.leagueName.toString()
        var description = league.leagueDescription.toString()
        var image = league.leagueImage!!

        actionbar!!.title = name
        actionbar.setDisplayHomeAsUpEnabled(true)

        imageView.setImageResource(image)
        nameTextView.text = name
        descriptionTextView.text = description

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.example.ligaapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    var leagueItems: MutableList<LeagueItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        verticalLayout{
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = LeagueAdapter(this@MainActivity, leagueItems){
                    val leagueItem = LeagueItem(
                        it.leagueName,
                        it.leagueDescription,
                        it.leagueImage
                    )
                    val moveToDetail = Intent(this@MainActivity, LeagueDetailActivity::class.java)
                    moveToDetail.putExtra(LeagueDetailActivity.EXTRA_LEAGUE, leagueItem)
                    startActivity(moveToDetail)
                }
            }
        }
    }


    private fun initData(){
        val name = resources.getStringArray(R.array.league_name)
        val description = resources.getStringArray(R.array.league_description)
        val image = resources.obtainTypedArray(R.array.league_image)
        leagueItems.clear()
        for (i in name.indices){
            leagueItems.add(
                LeagueItem(name[i],
                description[i],
                image.getResourceId(i,0))
            )
        }
        image.recycle()
    }
}

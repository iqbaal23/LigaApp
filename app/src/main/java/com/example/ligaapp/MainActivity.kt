package com.example.ligaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
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
//                    val toast = Toast.makeText(this@MainActivity, it.leagueName, Toast.LENGTH_SHORT)
//                    toast.show()
                    startActivity<LeagueDetailActivity>("name" to it.leagueName, "desc" to it.leagueDescription, "image" to it.leagueImage)
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

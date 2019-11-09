package com.example.ligaapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

class LeagueAdapter(private val context: Context, private val leagueItems: List<LeagueItem>, private val listener : (LeagueItem) -> Unit)
    : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(){

    class LeagueUI : AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                verticalLayout(){
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(8)

                    imageView{
                        id = R.id.league_image
                    }.lparams{
                        height = dip(250)
                        width = matchParent
                    }

                    textView{
                        id = R.id.league_name
                        this.gravity = Gravity.CENTER
                    }.lparams{
                        margin = dip(10)
                        width = matchParent
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder{
        return LeagueViewHolder(LeagueUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = leagueItems.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(leagueItems[position], listener)
    }

    class LeagueViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        val name: TextView = containerView.find(R.id.league_name)
        val image: ImageView = containerView.find(R.id.league_image)
        fun bindItem(leagueItems: LeagueItem, listener: (LeagueItem) -> Unit){
            name.text = leagueItems.leagueName
            leagueItems.leagueImage?.let { Picasso.get().load(it).fit().into(image) }
            itemView.setOnClickListener { listener(leagueItems) }
        }
    }
}
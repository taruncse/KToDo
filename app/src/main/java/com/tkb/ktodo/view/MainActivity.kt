package com.tkb.ktodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.AccountHeader
import com.tkb.ktodo.R

class MainActivity : AppCompatActivity() {

    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer {
            headerViewRes = R.layout.header
            closeOnClick = false

            primaryItem("Home") {
                iicon = FontAwesome.Icon.faw_home
                onClick { _ ->
                    Log.d("DRAWER", "Click.")
                    false
                }
            }
            divider {}
            primaryItem("Users") {
                iicon = FontAwesome.Icon.faw_home
                onClick { _ ->
                    Log.d("DRAWER", "Click.")
                    false
                }
            }
            primaryItem("Settings") {
                iicon = FontAwesome.Icon.faw_home
                onClick { _ ->
                    Log.d("DRAWER", "Click.")
                    false
                }
            }

            headerResult = accountHeader {
                background = R.drawable.header
                savedInstance = savedInstanceState
                translucentStatusBar = true

                profile("Mike Penz", "mikepenz@gmail.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/1476232?v=3&s=460"
                    identifier = 100
                }
                onProfileChanged { _, profile, _ ->
                    Toast.makeText(baseContext, profile.name.toString(), Toast.LENGTH_LONG).show()
                    false
                }
            }
        }
    }
}

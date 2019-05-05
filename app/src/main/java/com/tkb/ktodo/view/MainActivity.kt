package com.tkb.ktodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.tkb.ktodo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer {
            headerViewRes = R.layout.header
            closeOnClick = false

            primaryItem("Home") {
                iicon = FontAwesome.Icon.faw_home
            }
            divider {}
            primaryItem("Users") {
                iicon = FontAwesome.Icon.faw_home
            }
            secondaryItem("Settings") {
                iicon = FontAwesome.Icon.faw_home
                selectable = false
            }
        }
    }
}

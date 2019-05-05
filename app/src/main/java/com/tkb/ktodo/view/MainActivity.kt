package com.tkb.ktodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
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
            }
            divider {}
            primaryItem("Users") {
                iicon = FontAwesome.Icon.faw_home
            }
            secondaryItem("Settings") {
                iicon = FontAwesome.Icon.faw_home
                selectable = false
            }

            headerResult = accountHeader {
                background = R.drawable.header
                savedInstance = savedInstanceState
                translucentStatusBar = true

                profile("Mike Penz", "mikepenz@gmail.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/1476232?v=3&s=460"
                    identifier = 100
                }
                profile("Bernat Borras", "alorma@github.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/887462?v=3&s=460"
                    identifier = 101
                }

                profileSetting("Manage Account") {
                    iicon = GoogleMaterial.Icon.gmd_settings
                    identifier = 100_001
                }

                onProfileChanged { _, profile, _ ->
                    if (profile.identifier == 100_000L) {
                        val size = headerResult.profiles.size
                        val newProfile = ProfileDrawerItem()
                            .withName("New Batman ${size - 1}")
                            .withNameShown(true)
                            .withEmail("batman${size - 1}@gmail.com")
                            .withIcon(R.drawable.profile5)
                            .withIdentifier(100L + size + 1L)
                        headerResult.addProfile(newProfile, size - 2)
                    }
                    false
                }
            }
        }
    }
}

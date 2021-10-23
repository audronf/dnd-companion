package com.audronf.dndcompanion.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.ui.combat.CombatFragment
import com.audronf.dndcompanion.ui.inventory.InventoryFragment
import com.audronf.dndcompanion.ui.notes.NotesFragment
import com.audronf.dndcompanion.ui.spells.SpellsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {

    private lateinit var selectedFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        selectedFragment = HomeFragment.newInstance()
        findViewById<BottomNavigationView>(R.id.bottomNavigationMenu).selectedItemId = R.id.home_item
        replaceFragment(selectedFragment)
        setListeners()
    }

    private fun setListeners() {
        findViewById<BottomNavigationView>(R.id.bottomNavigationMenu).setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home_item -> {
                    selectedFragment = HomeFragment.newInstance()
                }
                R.id.my_spells_item -> {
                    selectedFragment = SpellsFragment.newInstance()
                }
                R.id.combat_item -> {
                    selectedFragment = CombatFragment.newInstance()
                }
                R.id.inventory_item -> {
                    selectedFragment = InventoryFragment.newInstance()
                }
                R.id.notes_item -> {
                    selectedFragment = NotesFragment.newInstance()
                }
            }
            replaceFragment(selectedFragment)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onBackPressed() {
        // This method should be empty for now
    }

    companion object {
        fun start(context: Context) {
            with(Intent(context, HomeActivity::class.java)) {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                context.startActivity(this)
            }
        }
    }
}

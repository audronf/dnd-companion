package com.audronf.dndcompanion.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.ui.DiceActivity
import com.audronf.dndcompanion.ui.combat.CombatFragment
import com.audronf.dndcompanion.ui.inventory.InventoryFragment
import com.audronf.dndcompanion.ui.notes.NotesFragment
import com.audronf.dndcompanion.ui.spells.SpellsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {

    private var selectedFragment: Fragment? = null
    private lateinit var homeFragment: HomeFragment
    private lateinit var spellsFragment: SpellsFragment
    private lateinit var combatFragment: CombatFragment
    private lateinit var inventoryFragment: InventoryFragment
    private lateinit var notesFragment: NotesFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initializeFragments()
        findViewById<BottomNavigationView>(R.id.bottomNavigationMenu).selectedItemId = R.id.home_item
        replaceFragment(homeFragment)
        setListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        DiceActivity.start(this)
        return true
    }

    private fun initializeFragments() {
        homeFragment = HomeFragment.newInstance()
        spellsFragment = SpellsFragment.newInstance()
        combatFragment = CombatFragment.newInstance()
        inventoryFragment = InventoryFragment.newInstance()
        notesFragment = NotesFragment.newInstance()
    }

    private fun setListeners() {
        findViewById<BottomNavigationView>(R.id.bottomNavigationMenu).setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home_item -> {
                    replaceFragment(homeFragment)
                }
                R.id.my_spells_item -> {
                    replaceFragment(spellsFragment)
                }
                R.id.combat_item -> {
                    replaceFragment(combatFragment)
                }
                R.id.inventory_item -> {
                    replaceFragment(inventoryFragment)
                }
                R.id.notes_item -> {
                    replaceFragment(notesFragment)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        selectedFragment = fragment
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

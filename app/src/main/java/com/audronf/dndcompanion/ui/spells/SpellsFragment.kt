package com.audronf.dndcompanion.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.R

class SpellsFragment(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    companion object {
        fun newInstance() = SpellsFragment()
    }
}
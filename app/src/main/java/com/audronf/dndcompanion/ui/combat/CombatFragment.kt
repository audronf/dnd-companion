package com.audronf.dndcompanion.ui.combat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.R

class CombatFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_combat, container, false)
    }

    companion object {
        fun newInstance() = CombatFragment()
    }
}
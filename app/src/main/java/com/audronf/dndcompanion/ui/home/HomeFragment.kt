package com.audronf.dndcompanion.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAbilityScores()
    }

    private fun initAbilityScores() {
        with(binding) {
            strength.apply {
                setAbilityName(getString(R.string.strength))
                setAbilityScore("2")
            }
            dexterity.apply {
                setAbilityName(getString(R.string.dexterity))
                setAbilityScore("2")
            }
            constitution.apply {
                setAbilityName(getString(R.string.constitution))
                setAbilityScore("4")
            }
            intelligence.apply {
                setAbilityName(getString(R.string.intelligence))
                setAbilityScore("1")
            }
            wisdom.apply {
                setAbilityName(getString(R.string.wisdom))
                setAbilityScore("-2")
            }
            charisma.apply {
                setAbilityName(getString(R.string.charisma))
                setAbilityScore("-2")
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
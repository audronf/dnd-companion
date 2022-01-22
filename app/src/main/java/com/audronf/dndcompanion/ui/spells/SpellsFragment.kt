package com.audronf.dndcompanion.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.audronf.dndcompanion.databinding.FragmentSpellsBinding
import com.audronf.dndcompanion.ui.base.RequestStatus
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellsFragment(): Fragment() {

    private val spellsViewModel: SpellsViewModel by viewModel()
    private lateinit var binding: FragmentSpellsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setObservers()
        loadSpells()
        binding = FragmentSpellsBinding.inflate(inflater)
        return binding.root
    }

    private fun setObservers() {
        spellsViewModel.requestStatus.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it is RequestStatus.Loading) View.VISIBLE else View.GONE
        }
    }

    private fun loadSpells() {
        spellsViewModel.getSpells()
    }
    companion object {
        fun newInstance() = SpellsFragment()
    }
}
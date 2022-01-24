package com.audronf.dndcompanion.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.audronf.dndcompanion.databinding.FragmentSpellsBinding
import com.audronf.dndcompanion.ui.adapter.SpellsAdapter
import com.audronf.dndcompanion.ui.base.RequestStatus
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellsFragment(): Fragment() {

    private val spellsViewModel: SpellsViewModel by viewModel()
    private lateinit var binding: FragmentSpellsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setObservers()
        loadSpells()
        binding = FragmentSpellsBinding.inflate(inflater)
        return binding.root
    }

    private fun setObservers() {
        spellsViewModel.requestStatus.observe(viewLifecycleOwner) {
            with(binding) {
                if (it is RequestStatus.Loading) {
                    progressBar.visibility = View.VISIBLE
                    spellsRecyclerView.visibility = View.GONE
                } else {
                    progressBar.visibility = View.GONE
                    spellsRecyclerView.apply {
                        adapter = SpellsAdapter().apply {
                            submitList(spellsViewModel.spells.value)
                        }
                        layoutManager = LinearLayoutManager(requireContext())
                        isNestedScrollingEnabled = false
                        visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun loadSpells() {
        spellsViewModel.getSpells()
    }
    companion object {
        fun newInstance() = SpellsFragment()
    }
}
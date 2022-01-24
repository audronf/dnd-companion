package com.audronf.dndcompanion.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.databinding.ViewholderSpellBinding
import com.audronf.dndcompanion.model.Spell
import com.audronf.dndcompanion.utils.BindingViewHolder

class SpellsAdapter :
    ListAdapter<Spell, BindingViewHolder<Spell, ViewholderSpellBinding>>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<Spell, ViewholderSpellBinding> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewholderSpellBinding.inflate(layoutInflater, parent, false)
        return SpellsViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<Spell, ViewholderSpellBinding>,
        position: Int
    ) {
        with(holder) {
            bind(getItem(position))
        }
    }

    inner class SpellsViewHolder(binding: ViewholderSpellBinding, private val context: Context) :
        BindingViewHolder<Spell, ViewholderSpellBinding>(binding) {
        override fun bind(item: Spell) {
            with(binding) {
                name.text = item.name
                level.text = if (item.level == 0)
                    context.getString(R.string.cantrip_text)
                else
                    context.getString(R.string.spell_level_text, item.level.toString())
                concentration.visibility =
                    if (item.requiresConcentration) View.VISIBLE else View.GONE
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Spell>() {
            override fun areItemsTheSame(oldItem: Spell, newItem: Spell): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Spell, newItem: Spell): Boolean =
                oldItem == newItem
        }
    }
}

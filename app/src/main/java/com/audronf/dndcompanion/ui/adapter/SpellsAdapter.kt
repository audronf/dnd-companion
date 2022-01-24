package com.audronf.dndcompanion.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
                spellContainer.setCardBackgroundColor(
                    when (item.level) {
                        0 -> ContextCompat.getColor(context, R.color.cantrip_color)
                        1 -> ContextCompat.getColor(context, R.color.level_1_spell_color)
                        2 -> ContextCompat.getColor(context, R.color.level_2_spell_color)
                        3 -> ContextCompat.getColor(context, R.color.level_3_spell_color)
                        4 -> ContextCompat.getColor(context, R.color.level_4_spell_color)
                        5 -> ContextCompat.getColor(context, R.color.level_5_spell_color)
                        6 -> ContextCompat.getColor(context, R.color.level_6_spell_color)
                        7 -> ContextCompat.getColor(context, R.color.level_7_spell_color)
                        8 -> ContextCompat.getColor(context, R.color.level_8_spell_color)
                        9 -> ContextCompat.getColor(context, R.color.level_9_spell_color)
                        else -> ContextCompat.getColor(context, R.color.level_1_spell_color)
                    }
                )
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

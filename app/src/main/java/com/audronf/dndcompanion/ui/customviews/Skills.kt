package com.audronf.dndcompanion.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.databinding.ViewSkillsBinding

class Skills @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewSkillsBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        with(binding) {
            acrobatics.setText(context.getString(R.string.acrobatics))
            animalHandling.setText(context.getString(R.string.animal_handling))
            arcana.setText(context.getString(R.string.arcana))
            athletics.setText(context.getString(R.string.athletics))
            deception.setText(context.getString(R.string.deception))
            history.setText(context.getString(R.string.history))
            insight.setText(context.getString(R.string.insight))
            intimidation.setText(context.getString(R.string.intimidation))
            investigation.setText(context.getString(R.string.investigation))
            medicine.setText(context.getString(R.string.medicine))
            nature.setText(context.getString(R.string.nature))
            perception.setText(context.getString(R.string.perception))
            performance.setText(context.getString(R.string.performance))
            persuasion.setText(context.getString(R.string.persuasion))
            religion.setText(context.getString(R.string.religion))
            sleightOfHand.setText(context.getString(R.string.sleight_of_hand))
            stealth.setText(context.getString(R.string.stealth))
            survival.setText(context.getString(R.string.survival))
        }
    }
}

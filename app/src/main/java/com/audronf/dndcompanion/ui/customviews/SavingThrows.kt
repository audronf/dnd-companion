package com.audronf.dndcompanion.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.audronf.dndcompanion.R
import com.audronf.dndcompanion.databinding.ViewSavingThrowsBinding

class SavingThrows @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewSavingThrowsBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        with(binding) {
            strST.setSavingThrow(context.getString(R.string.strength_abbreviation))
            dexST.setSavingThrow(context.getString(R.string.dexterity_abbreviation))
            conST.setSavingThrow(context.getString(R.string.constitution_abbreviation))
            intST.setSavingThrow(context.getString(R.string.intelligence_abbreviation))
            wisST.setSavingThrow(context.getString(R.string.wisdom_abbreviation))
            chaST.setSavingThrow(context.getString(R.string.charisma_abbreviation))
            conST.setIsProficient(true)
        }
    }
}
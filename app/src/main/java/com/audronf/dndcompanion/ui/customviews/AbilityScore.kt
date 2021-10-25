package com.audronf.dndcompanion.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.audronf.dndcompanion.databinding.ViewAbilityScoreBinding

class AbilityScore @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    val binding = ViewAbilityScoreBinding.inflate(LayoutInflater.from(context), this, true)

    fun setAbilityName(name: String) {
        binding.abilityName.text = name
    }

    fun setAbilityScore(score: String) {
        binding.abilityScore.text = score
    }

    fun setAbilityNumber(number: String) {
        binding.abilityNumber.text = number
    }
}

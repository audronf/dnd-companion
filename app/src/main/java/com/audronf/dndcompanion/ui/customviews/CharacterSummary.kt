package com.audronf.dndcompanion.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.audronf.dndcompanion.databinding.ViewCharacterSummaryBinding

class CharacterSummary @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    var binding = ViewCharacterSummaryBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.informationCard.setOnClickListener {
            Toast.makeText(context, "TODO: Character information screen", Toast.LENGTH_SHORT).show()
        }
    }
}

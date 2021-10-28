package com.audronf.dndcompanion.ui.customviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintLayout
import com.audronf.dndcompanion.databinding.ViewProficiencyEditTextBinding

class ProficiencyEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewProficiencyEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.savingThrowScore.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(textView.windowToken, 0)
                binding.savingThrowScore.clearFocus()
                binding.savingThrowContainer.rootView.requestFocus()
            }
            return@setOnEditorActionListener false
        }
    }

    fun setIsProficient(proficient: Boolean = false) {
        binding.isProficient.isChecked = proficient
    }

    fun setText(text: String) {
        binding.isProficient.text = text
    }

    fun setValue(value: String) {
        binding.savingThrowScore.setText(value)
    }
}

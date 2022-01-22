package com.audronf.dndcompanion.ui.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.audronf.dndcompanion.model.SpellResponse
import com.audronf.dndcompanion.repository.SpellsRepository
import com.audronf.dndcompanion.ui.base.BaseViewModel
import com.audronf.dndcompanion.ui.base.RequestStatus
import kotlinx.coroutines.launch

class SpellsViewModel(
    private val spellsRepository: SpellsRepository
): BaseViewModel() {

    private val _state = MutableLiveData<SpellResponse>()
    val state: LiveData<SpellResponse>
        get() = _state

    fun getSpells() {
        viewModelScope.launch {
            _requestStatus.value = RequestStatus.Loading
            // TODO: Replace with character's class.
            val result = spellsRepository.getSpells("paladin")
            if (result.isSuccessful) {
                result.body()!!.spellsOverview.forEach {
                    it.spellInfo = spellsRepository.getSpell(it.index).body()!!
                }
                _state.value = result.body()!!
                _requestStatus.value = RequestStatus.Finished
            } else {
                _requestStatus.value = RequestStatus.Failure
            }
        }
    }
}

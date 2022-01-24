package com.audronf.dndcompanion.ui.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.audronf.dndcompanion.model.Spell
import com.audronf.dndcompanion.model.SpellResponse
import com.audronf.dndcompanion.repository.SpellsRepository
import com.audronf.dndcompanion.ui.base.BaseViewModel
import com.audronf.dndcompanion.ui.base.RequestStatus
import kotlinx.coroutines.launch

class SpellsViewModel(
    private val spellsRepository: SpellsRepository
) : BaseViewModel() {

    private val _state = MutableLiveData<SpellResponse>()
    val state: LiveData<SpellResponse>
        get() = _state

    private val _spells = MutableLiveData<ArrayList<Spell>>()
    val spells: LiveData<ArrayList<Spell>>
        get() = _spells

    fun getSpells() {
        viewModelScope.launch {
            _requestStatus.value = RequestStatus.Loading
            // TODO: Replace with character's class.
            val result = spellsRepository.getSpells("ranger")
            val spellsList = ArrayList<Spell>()
            if (result.isSuccessful) {
                result.body()!!.spellsOverview.take(15).forEach {
                    it.spellInfo = spellsRepository.getSpell(it.index).body()!!
                    spellsList.add(it.spellInfo)
                }
                _state.value = result.body()!!
                _spells.value = ArrayList(spellsList.sortedBy { it.level })
                _requestStatus.value = RequestStatus.Finished
            } else {
                _requestStatus.value = RequestStatus.Failure
            }
        }
    }
}

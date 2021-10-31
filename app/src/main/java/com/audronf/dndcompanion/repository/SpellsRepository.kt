package com.audronf.dndcompanion.repository

import com.audronf.dndcompanion.database.dao.SpellsDao
import com.audronf.dndcompanion.database.entities.SpellEntity
import com.audronf.dndcompanion.network.service.SpellsService
import kotlinx.coroutines.flow.Flow

class SpellsRepository(
    private val service: SpellsService,
    private val database: SpellsDao
) {
    suspend fun getSpells(characterClass: String) =
        service.getSpellsByClass(characterClass)

    fun saveSpell(spell: SpellEntity) = database.insert(spell)

    fun getSavedSpells(): Flow<List<SpellEntity>> = database.getSpells()
}
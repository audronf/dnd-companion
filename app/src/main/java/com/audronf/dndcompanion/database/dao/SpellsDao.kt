package com.audronf.dndcompanion.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.audronf.dndcompanion.database.entities.SpellEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpellsDao {
    @Insert
    fun insert(spell: SpellEntity)

    @Query("SELECT * from spells")
    fun getSpells(): Flow<List<SpellEntity>>
}

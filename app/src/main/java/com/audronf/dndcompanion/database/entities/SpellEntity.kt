package com.audronf.dndcompanion.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spells")
data class SpellEntity(
    @PrimaryKey val index: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url") val url: String
)

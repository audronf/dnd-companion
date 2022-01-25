package com.audronf.dndcompanion.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.audronf.dndcompanion.database.dao.SpellsDao
import com.audronf.dndcompanion.database.entities.SpellEntity

@Database(entities = [SpellEntity::class], version = 1)
abstract class DndCompanionDatabase: RoomDatabase() {

    abstract val spellsDao: SpellsDao

    companion object {
        private const val DATABASE_NAME = "dnd_companion_database"
        @Volatile private var INSTANCE: DndCompanionDatabase? = null

        fun getInstance(context: Context): DndCompanionDatabase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DndCompanionDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}

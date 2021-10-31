package com.audronf.dndcompanion.di

import android.app.Application
import androidx.room.Room
import com.audronf.dndcompanion.database.DndCompanionDatabase
import com.audronf.dndcompanion.database.dao.SpellsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideRoom(application: Application): DndCompanionDatabase =
        Room.databaseBuilder(
            application,
            DndCompanionDatabase::class.java,
            "dnd_companion_database"
        ).build()

    fun provideSpellsDao(db: DndCompanionDatabase): SpellsDao =
        db.spellsDao

    single { provideRoom(androidApplication()) }
    single { provideSpellsDao(get()) }
}

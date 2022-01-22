package com.audronf.dndcompanion.di

import com.audronf.dndcompanion.database.DndCompanionDatabase
import com.audronf.dndcompanion.network.service.SpellsService
import com.audronf.dndcompanion.repository.SpellsRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {
    single { SpellsRepository(get(), get()) }
}

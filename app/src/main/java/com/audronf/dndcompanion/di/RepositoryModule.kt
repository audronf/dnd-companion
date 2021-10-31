package com.audronf.dndcompanion.di

import com.audronf.dndcompanion.repository.SpellsRepository
import com.audronf.dndcompanion.ui.spells.SpellsFragment
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single { SpellsRepository(get(), get()) }
}

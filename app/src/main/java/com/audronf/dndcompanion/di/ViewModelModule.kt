package com.audronf.dndcompanion.di

import com.audronf.dndcompanion.ui.spells.SpellsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SpellsViewModel(get()) }
}

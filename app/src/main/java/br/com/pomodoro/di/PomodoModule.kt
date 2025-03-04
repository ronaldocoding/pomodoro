package br.com.pomodoro.di

import br.com.pomodoro.presentation.viewmodel.PomodoroViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val pomodoroModule = module {
    viewModelOf(::PomodoroViewModel)
}
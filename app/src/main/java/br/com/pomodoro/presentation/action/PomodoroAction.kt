package br.com.pomodoro.presentation.action

sealed class PomodoroAction {
    data object StartPomodoro : PomodoroAction()
}

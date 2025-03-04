package br.com.pomodoro.presentation.state

private const val POMODORO_TIME = 1500

data class PomodoroUiState(
    val countDownTimerInSec: Int = POMODORO_TIME
)

package br.com.pomodoro.presentation.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import br.com.pomodoro.presentation.action.PomodoroAction
import br.com.pomodoro.presentation.state.PomodoroUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private const val POMODORO_TIME = 1500L

class PomodoroViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PomodoroUiState())
    val uiState = _uiState.asStateFlow()

    private var countDownTimer: CountDownTimer? = null

    fun sendAction(action: PomodoroAction) {
        when (action) {
            is PomodoroAction.StartPomodoro -> startPomodoro()
        }
    }

    private fun startPomodoro() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(
            POMODORO_TIME * 1000,
            1000
        ) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000).toInt()
                _uiState.update {
                    it.copy(countDownTimerInSec = secondsRemaining)
                }
            }

            override fun onFinish() {
                // Does nothing
            }
        }.start()
    }
}

package br.com.pomodoro.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.pomodoro.presentation.action.PomodoroAction
import br.com.pomodoro.presentation.viewmodel.PomodoroViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PomodoroScreen(viewModel: PomodoroViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.sendAction(PomodoroAction.StartPomodoro)
    }

    val uiState = viewModel.uiState.collectAsState()

    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(convertSecondsToMinutesAndSeconds(uiState.value.countDownTimerInSec))
        }
    }
}

private fun convertSecondsToMinutesAndSeconds(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return "$minutes:$remainingSeconds"
}
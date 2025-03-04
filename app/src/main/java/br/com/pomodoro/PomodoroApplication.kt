package br.com.pomodoro

import android.app.Application
import br.com.pomodoro.di.pomodoroModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PomodoroApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PomodoroApplication)
            modules(pomodoroModule)
        }
    }
}

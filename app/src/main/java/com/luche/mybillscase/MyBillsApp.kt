package com.luche.mybillscase

import android.app.Application
import com.luche.mybillscase.di.Network
import com.luche.mybillscase.di.Presentation
import com.luche.mybillscase.di.Repository
import com.luche.mybillscase.di.UseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyBillsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        //
        startKoin {
           // androidLogger()
            androidContext(this@MyBillsApp)
            modules(
                Network.network,
                Repository.repository,
                UseCase.useCases,
                Presentation.presentation
            )
        }
    }
}
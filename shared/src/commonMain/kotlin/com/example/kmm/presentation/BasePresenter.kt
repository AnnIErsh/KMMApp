package com.example.kmm.presentation

import com.example.kmm.threads.ioDispatcher
import com.example.kmm.threads.uiDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

open class BasePresenter {
    val job = SupervisorJob()
    val scope: CoroutineScope = CoroutineScope(uiDispatcher + job)

    protected var view: IView? = null

    fun attachView(view: IView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}
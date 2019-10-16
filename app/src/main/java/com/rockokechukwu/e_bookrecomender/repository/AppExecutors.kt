package com.rockokechukwu.e_bookrecomender.repository

import java.util.concurrent.Executor

open class AppExecutors(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor
) {

}
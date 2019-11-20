package com.lambadam.domain.usecase

abstract class UseCase<out R> {

    suspend fun execute() = buildUseCase()

    protected abstract suspend fun buildUseCase(): R
}
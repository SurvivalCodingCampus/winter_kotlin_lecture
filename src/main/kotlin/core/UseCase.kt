package org.example.core

interface UseCase<P : UseCaseParams, O> {
    suspend fun call(input: P): O
}


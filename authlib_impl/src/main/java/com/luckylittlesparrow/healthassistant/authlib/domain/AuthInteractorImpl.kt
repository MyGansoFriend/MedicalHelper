package com.luckylittlesparrow.healthassistant.authlib.domain

import android.content.Intent
import com.luckylittlesparrow.healthassistant.feature_account_api.model.User

/**
 * @author Gusev Andrei
 * @since  1.0
 */
class AuthInteractorImpl(private val authRepository: AuthRepository) : AuthInteractor {
    override suspend fun signIn(username: String, password: String, onResult: (User?) -> Unit): User? {
        authRepository.signIn(username,password).also {
            onResult.invoke(it)
            return it
        }
    }

    override suspend fun signInWithGoogle(data: Intent?, onResult: (User?) -> Unit): User? {
        authRepository.signInWithGoogle(data).also {
            onResult.invoke(it)
            return it
        }
    }

    override suspend fun isAuthenticated(onResult: (Boolean) -> Unit): Boolean {
        authRepository.isAuthenticated().also {
            onResult.invoke(it)
            return it
        }
    }

    override suspend fun signInAnonymously(onResult: (Boolean) -> Unit): Boolean {
        authRepository.signInAnonymously().also {
            onResult.invoke(it)
            return it
        }
    }

    override suspend fun signUp(username: String, email: String, password: String, onResult: (User?) -> Unit): User? {
        authRepository.signUp(username, email, password).also {
            onResult.invoke(it)
            return it
        }
    }

    override suspend fun signOut(onResult: (Boolean) -> Unit): Boolean {
        authRepository.signOut().also {
            onResult.invoke(it)
            return it
        }
    }
}
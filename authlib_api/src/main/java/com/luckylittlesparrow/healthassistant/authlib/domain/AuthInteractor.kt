package com.luckylittlesparrow.healthassistant.authlib.domain

import android.content.Intent
import com.luckylittlesparrow.healthassistant.feature_account_api.model.User

/**
 * @author Gusev Andrei
 * @since  1.0
 */
interface AuthInteractor {
    suspend fun signIn(username: String, password: String, onResult: (User?) -> Unit = {}): User?

    suspend fun signInWithGoogle(data: Intent?, onResult: (User?) -> Unit = {}): User?

    suspend fun signInAnonymously(onResult: (Boolean) -> Unit = {}): Boolean

    suspend fun signUp(username: String, email: String, password: String, onResult: (User?) -> Unit = {}): User?

    suspend fun signOut(onResult: (Boolean) -> Unit = {}): Boolean

    suspend fun isAuthenticated(onResult: (Boolean) -> Unit = {}): Boolean
}
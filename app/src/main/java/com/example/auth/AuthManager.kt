package com.example.auth

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.security.MessageDigest
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class AuthManager(
    private val context: Context,
    private val auth: FirebaseAuth
) {
    private val credentialManager = CredentialManager.create(context)

    suspend fun signInWithGoogle(): Boolean {
        return try {
            val rawNonce = UUID.randomUUID().toString()
            val bytes = rawNonce.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }

            // Replace with your Web client ID from Google Cloud Console
            val serverClientId = com.example.BuildConfig.WEB_CLIENT_ID 

            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(serverClientId)
                .setNonce(hashedNonce)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(context, request)
            handleSignInResult(result)
        } catch (e: GetCredentialException) {
            e.printStackTrace()
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Google Sign-In Credential Error: ${e.message} (Code: ${e.type})", Toast.LENGTH_LONG).show()
            }
            false
        } catch (e: Exception) {
            e.printStackTrace()
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Google Sign-In Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
            false
        }
    }

    private suspend fun handleSignInResult(result: GetCredentialResponse): Boolean {
        val credential = result.credential
        if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
            try {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                val idToken = googleIdTokenCredential.idToken
                
                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                val authResult = auth.signInWithCredential(firebaseCredential).await()
                return authResult.user != null
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }
        return false
    }

    suspend fun signOut() {
        auth.signOut()
    }
}

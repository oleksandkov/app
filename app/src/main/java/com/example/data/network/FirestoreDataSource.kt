package com.example.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreDataSource(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {
    /**
     * Firebase Data Structure:
     * users/
     *   {userId}/
     *     tasks/
     *       {taskId} -> { title, date, startTime, isCompleted, ... }
     *     notes/
     *       {noteId} -> { title, content, categoryId, ... }
     *     categories/
     *       {categoryId} -> { name, colorHex }
     */

    private fun getUserId(): String? = auth.currentUser?.uid

    // Example Sync operations
    suspend fun syncTasksToCloud(tasks: List<Map<String, Any>>) {
        val uid = getUserId() ?: return
        val batch = firestore.batch()
        tasks.forEach { task ->
            val ref = firestore.collection("users").document(uid).collection("tasks").document(task["id"].toString())
            batch.set(ref, task)
        }
        batch.commit().await()
    }
}

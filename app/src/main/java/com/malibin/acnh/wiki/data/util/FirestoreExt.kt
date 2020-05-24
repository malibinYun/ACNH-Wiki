package com.malibin.acnh.wiki.data.util

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.response.FVillager

fun FirebaseFirestore.getCollectionSnapshot(collectionPath: String): Task<QuerySnapshot> {
    return this.collection(collectionPath).get()
}

fun DocumentReference.getCollectionSnapshot(collectionPath: String): Task<QuerySnapshot> {
    return this.collection(collectionPath).get()
}

fun QuerySnapshot.toVillagers(): List<Villager> {
    return this.documents.map {
        it.toObject(FVillager::class.java)?.toVillager() ?: throw CANNOT_CONVERT_EXCEPTION
    }
}

const val VILLAGERS_PATH = "villagers"

private val CANNOT_CONVERT_EXCEPTION = IllegalStateException("객체를 변환할 수 없음")
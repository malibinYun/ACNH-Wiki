package com.malibin.acnh.wiki.data.util

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.getRemoteLocation
import kotlinx.coroutines.tasks.await

suspend fun FirebaseStorage.getRawItemTextOf(itemType: ItemType): String {
    return this.getReference(itemType.getRemoteLocation())
        .getBytes(ONE_MB)
        .await()
        .toString(Charsets.UTF_8)
}

suspend fun FirebaseStorage.getRawItemTextOf(location: String): String {
    return this.getReference(location)
        .getBytes(ONE_MB)
        .await()
        .toString(Charsets.UTF_8)
}

private const val ONE_MB: Long = 1024 * 1024


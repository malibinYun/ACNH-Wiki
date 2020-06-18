package com.malibin.acnh.wiki.data.source.remote

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Music
import com.malibin.acnh.wiki.data.source.ItemDataSource
import com.malibin.acnh.wiki.data.textparser.MusicTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Malibin
 * on 6월 19, 2020
 */

class MusicRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : ItemDataSource<Music> {

    override suspend fun getAllItems(): List<Music> {
        val rawText = firebaseStorage.getRawItemTextOf(ItemType.MUSICS)
        return MusicTextParser.convert(rawText, ItemType.MUSICS)
    }

    override suspend fun getCollectedItems(): List<Music> {
        throw UnsupportedOperationException("Cannot call getCollectedItems in remote source")
    }

    override suspend fun getWishedItems(): List<Music> {
        throw UnsupportedOperationException("Cannot call getWishedItems in remote source")
    }

    override suspend fun saveItems(itemList: List<Music>) {
        throw UnsupportedOperationException("Cannot call saveItems in remote source")
    }

    override suspend fun deleteAllItems() {
        throw UnsupportedOperationException("Cannot call deleteAllItems in remote source")
    }

    override suspend fun checkCollected(item: Music, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkCollected in remote source")
    }

    override suspend fun checkWished(item: Music, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkWished in remote source")
    }
}
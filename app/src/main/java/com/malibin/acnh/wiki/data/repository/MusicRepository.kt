package com.malibin.acnh.wiki.data.repository

import com.malibin.acnh.wiki.data.entity.Music
import com.malibin.acnh.wiki.data.source.ItemDataSource

/**
 * Created By Malibin
 * on 6월 19, 2020
 */

class MusicRepository(
    private val musicLocalDataSource: ItemDataSource<Music>,
    private val musicRemoteDataSource: ItemDataSource<Music>
) : ItemDataSource<Music> {

    override suspend fun getAllItems(): List<Music> {
        val localMusics = musicLocalDataSource.getAllItems()
        if (localMusics.isNotEmpty()) {
            return localMusics
        }
        val remoteMusics = musicRemoteDataSource.getAllItems()
        musicLocalDataSource.saveItems(remoteMusics)
        return remoteMusics
    }

    override suspend fun findItemById(id: Int): Music? {
        return musicLocalDataSource.findItemById(id)
    }

    override suspend fun getCollectedItems(): List<Music> {
        return musicLocalDataSource.getCollectedItems()
    }

    override suspend fun getWishedItems(): List<Music> {
        return musicLocalDataSource.getWishedItems()
    }

    override suspend fun saveItems(itemList: List<Music>) {
        throw UnsupportedOperationException("cannot call saveItems in repository")
    }

    override suspend fun deleteAllItems() {
        musicLocalDataSource.deleteAllItems()
    }

    override suspend fun checkCollected(item: Music, isChecked: Boolean) {
        musicLocalDataSource.checkCollected(item, isChecked)
    }

    override suspend fun checkWished(item: Music, isChecked: Boolean) {
        musicLocalDataSource.checkWished(item, isChecked)
    }

}
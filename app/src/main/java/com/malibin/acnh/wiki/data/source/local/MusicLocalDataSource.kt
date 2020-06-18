package com.malibin.acnh.wiki.data.source.local

import com.malibin.acnh.wiki.data.dao.MusicDao
import com.malibin.acnh.wiki.data.entity.Music
import com.malibin.acnh.wiki.data.source.ItemDataSource

/**
 * Created By Malibin
 * on 6월 19, 2020
 */
class MusicLocalDataSource(
    private val musicDao: MusicDao
) : ItemDataSource<Music> {

    override suspend fun getAllItems(): List<Music> {
        return musicDao.getAllMusics()
    }

    override suspend fun findItemById(id: Int): Music? {
        return musicDao.findMusicById(id)
    }

    override suspend fun getCollectedItems(): List<Music> {
        return musicDao.getCollectedMusics()
    }

    override suspend fun getWishedItems(): List<Music> {
        return musicDao.getWishedMusics()
    }

    override suspend fun saveItems(itemList: List<Music>) {
        musicDao.insertMusics(itemList)
    }

    override suspend fun deleteAllItems() {
        musicDao.deleteAllMusics()
    }

    override suspend fun checkCollected(item: Music, isChecked: Boolean) {
        musicDao.updateMusicCollected(item.id, isChecked)
    }

    override suspend fun checkWished(item: Music, isChecked: Boolean) {
        musicDao.updateMusicWished(item.id, isChecked)
    }
}
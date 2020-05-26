package com.malibin.acnh.wiki

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.malibin.acnh.wiki.data.AppDataBase
import com.malibin.acnh.wiki.data.entity.Rug
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

@ExperimentalCoroutinesApi
class Test {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun test() = runBlockingTest {
        // given
        val database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDataBase::class.java
        ).build()

        val dao = database.rugsDao()

        val rug = Rug(
            id = 1,
            name = "",
            imageUrl = "",
            buyCost = 10,
            sellPrice = 5,
            source = "",
            sourceNote = "",
            colors = listOf("", ""),
            available = "",
            canDiy = true,
            size = "",
            hhaConcepts = listOf("", ""),
            hhaSeries = "",
            milesPrice = 20
        )

        dao.insertRugs(listOf(rug))
        val retrieveRug = dao.getAllRugs()

//        assertThat(retrieveRug).isEqualTo(listOf(rug.apply { milesPrice = 10 }))
    }
}
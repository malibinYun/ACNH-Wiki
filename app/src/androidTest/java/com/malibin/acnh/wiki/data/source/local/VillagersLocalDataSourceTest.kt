package com.malibin.acnh.wiki.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.malibin.acnh.wiki.data.AppDataBase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test

import org.junit.Before

import org.junit.Rule


@ExperimentalCoroutinesApi
class VillagersLocalDataSourceTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private var testDataBase: AppDataBase? = null
    private lateinit var localDataSource: VillagersLocalDataSource

    @Before
    fun setUp() {
        testDataBase =
            Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().context,
                AppDataBase::class.java
            ).build()
        localDataSource = VillagersLocalDataSource(testDataBase!!.villagersDao())
    }

    @After
    fun cleanDatabaseAfterTest() {
        testDataBase?.close()
        testDataBase = null
    }

    // 주민 저장 후 getAllVillagers 테스트
    @Test
    fun saveVillagers_retrievesAllVillagers() = runBlockingTest {
        // given
        val villagers = listOf(VILLAGER_1, VILLAGER_2)
        localDataSource.saveVillagers(villagers)

        // when
        val retrievesVillagers = localDataSource.getAllVillagers()

        // then
        assertThat(retrievesVillagers).isEqualTo(villagers)
    }

    // 주민 저장 후 id로 fetch 해오는 것 테스트
    @Test
    fun saveVillager_retrievesVillagerById() = runBlockingTest {
        // given
        val villagers = listOf(VILLAGER_1)
        localDataSource.saveVillagers(villagers)

        // when
        val retrievesVillager = localDataSource.fetchVillager(VILLAGER_1.amiiboIndex)

        // then
        assertThat(retrievesVillager).isEqualTo(VILLAGER_1)
    }

    // 좋아하는 주민 체크 뒤, 좋아하는 주민 가져오는 메소드 테스트
    @Test
    fun checkFavoriteVillager_retrievesFavoriteVillagers() = runBlockingTest {
        // given
        val villagers = listOf(VILLAGER_1, VILLAGER_2)
        localDataSource.saveVillagers(villagers)
        val expectedVillagers = listOf(VILLAGER_1.copy(isFavorite = true))

        // when
        localDataSource.checkFavoriteVillager(VILLAGER_1, true)
        val retrievesFavoriteVillagers = localDataSource.getFavoriteVillagers()

        // then
        assertThat(retrievesFavoriteVillagers).isEqualTo(expectedVillagers)
    }

    // 거주 주민 체크 뒤, 거주 주민 가져오는 메소드 테스트
    @Test
    fun checkHomeVillager_retrievesVillagersInHome() = runBlockingTest {
        // given
        val villagers = listOf(VILLAGER_1, VILLAGER_2)
        localDataSource.saveVillagers(villagers)
        val expectedVillagers = listOf(VILLAGER_1.copy(isInHome = true))

        // when
        localDataSource.checkHomeVillager(VILLAGER_1, true)
        val retrievesVillagersInHome = localDataSource.getVillagersInHome()

        // then
        assertThat(retrievesVillagersInHome).isEqualTo(expectedVillagers)
    }

    // 주민 전체 삭제하면 빈 리스트 반환
    @Test
    fun deleteAllVillagers_emptyListOfRetrievedTask() = runBlockingTest {
        // given
        val villagers = listOf(VILLAGER_1, VILLAGER_2, VILLAGER_3)
        localDataSource.saveVillagers(villagers)

        // when
        localDataSource.deleteAllVillagers()
        val retrievesVillagers = localDataSource.getAllVillagers()

        // then
        assertThat(retrievesVillagers).isEmpty()
    }
}
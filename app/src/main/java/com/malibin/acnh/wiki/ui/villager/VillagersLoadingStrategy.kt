package com.malibin.acnh.wiki.ui.villager

/**
 * Created By Malibin
 * on 6월 24, 2020
 */

enum class VillagersLoadingStrategy {

    ALL_VILLAGERS {
        override fun loadVillagers(viewModel: VillagersViewModel) {
            viewModel.loadAllVillagers()
        }
    },
    FAVORITE_VILLAGERS {
        override fun loadVillagers(viewModel: VillagersViewModel) {
            viewModel.loadFavoriteVillagers()
        }
    },
    HOME_VILLAGERS {
        override fun loadVillagers(viewModel: VillagersViewModel) {
            viewModel.loadHomeVillagers()
        }
    };

    abstract fun loadVillagers(viewModel: VillagersViewModel)
}
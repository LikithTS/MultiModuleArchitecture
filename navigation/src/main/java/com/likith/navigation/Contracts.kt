package com.likith.navigation

import com.likith.navigation.contracts.BroadbandModuleContract
import com.likith.navigation.contracts.HistoryModuleContract
import com.likith.navigation.contracts.ProfileModuleContract

interface Contracts {
    val broadbandModuleContract: BroadbandModuleContract
    val historyModuleContract: HistoryModuleContract
    val profileModuleContract: ProfileModuleContract
}
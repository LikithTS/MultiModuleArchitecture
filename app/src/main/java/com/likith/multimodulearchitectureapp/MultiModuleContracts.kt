package com.likith.multimodulearchitectureapp

import com.likith.broadband.BroadbandActivity
import com.likith.history.HistoryActivity
import com.likith.navigation.Contracts
import com.likith.navigation.contracts.BroadbandModuleContract
import com.likith.navigation.contracts.HistoryModuleContract
import com.likith.navigation.contracts.ProfileModuleContract
import com.likith.profile.ProfileActivity

class MultiModuleContracts : Contracts {

    override val broadbandModuleContract: BroadbandModuleContract
        get() = BroadbandModuleContract(BroadbandActivity::class.java)
    override val historyModuleContract: HistoryModuleContract
        get() = HistoryModuleContract(HistoryActivity::class.java)
    override val profileModuleContract: ProfileModuleContract
        get() = ProfileModuleContract(ProfileActivity::class.java)
}
package com.likith.navigation.contracts

import android.app.Activity
import android.os.Parcelable
import com.likith.navigation.BaseContract
import kotlinx.parcelize.Parcelize

class BroadbandModuleContract(activityClass: Class<out Activity>): BaseContract<BroadbandModuleContract.Args, BroadbandModuleContract.Result>(activityClass) {

    @Parcelize
    data class Args(
        val argument1: String
    ): Parcelable

    @Parcelize
    data class Result(
        val result1: String
    ): Parcelable
}
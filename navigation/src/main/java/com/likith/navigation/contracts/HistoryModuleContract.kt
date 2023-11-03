package com.likith.navigation.contracts

import android.app.Activity
import com.likith.navigation.BaseContract
import com.likith.navigation.NoArgs
import com.likith.navigation.NoResult

class HistoryModuleContract(activityClass: Class<out Activity>): BaseContract<NoArgs, NoResult>(activityClass)
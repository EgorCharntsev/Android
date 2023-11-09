package com.itis.homework.base

import androidx.appcompat.app.AppCompatActivity
import com.itis.homework.utils.ActionType

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val fragmentContainerId: Int

    abstract fun goToScreen(
        actionType : ActionType,
        destination : BaseFragment,
        key : String? = null,
        isAddToBackStack : Boolean = true
    )
}
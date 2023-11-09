package com.itis.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itis.homework.base.BaseActivity
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.ActivityMainBinding
import com.itis.homework.fragments.StartFragment
import com.itis.homework.utils.ActionType

class MainActivity : BaseActivity() {

    override val fragmentContainerId: Int = R.id.activity_main_container
    private var _viewBinding : ActivityMainBinding? = null
    private val viewBinding : ActivityMainBinding get() = _viewBinding!!
    override fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        key: String?,
        isAddToBackStack: Boolean
    ) {
        supportFragmentManager.beginTransaction().apply {
            when (actionType) {
                ActionType.ADD -> {
                    this.add(fragmentContainerId,destination,key)
                }

                ActionType.REPLACE -> {
                    this.replace(fragmentContainerId,destination,key)
                }

                ActionType.REMOVE -> {
                    this.remove(destination)
                }
            }

            if (isAddToBackStack) {
                this.addToBackStack(null)
            }
        }.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val newBinding = viewBinding.root
        setContentView(newBinding)

        goToScreen(
            ActionType.REPLACE,
            StartFragment.newInstance(),
            StartFragment.START_FRAGMENT_KEY,
            true,
            )
    }
}
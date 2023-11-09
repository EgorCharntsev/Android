package com.itis.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itis.homework.base.BaseActivity
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.ActivityMainBinding
import com.itis.homework.databinding.FragmentStartBinding
import com.itis.homework.fragments.StartFragment
import com.itis.homework.utils.ActionType

class MainActivity : BaseActivity() {

    override val fragmentContainerId: Int = R.id.main_activity_container
    var _viewBinding : ActivityMainBinding? = null
    val viewBinding : ActivityMainBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val newBinding = viewBinding.root
        setContentView(newBinding)

        goToScreen(ActionType.REPLACE, StartFragment.newInstance())
    }

    override fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        tag: String?,
        isAddToBackStack: Boolean
    ) {
        supportFragmentManager.beginTransaction().apply {
            when (actionType) {
                ActionType.ADD -> {
                    this.add(fragmentContainerId, destination, tag)
                }

                ActionType.REPLACE -> {
                    this.replace(fragmentContainerId, destination, tag)
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
}
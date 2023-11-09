package com.itis.homework.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itis.homework.R
import com.itis.homework.adapter.SongAdapter
import com.itis.homework.databinding.FragmentBottomSheetBinding

open class BottomSheetFragment(
    private val adapter: SongAdapter?
) : BottomSheetDialogFragment(R.layout.fragment_bottom_sheet) {

    private var viewBinding: FragmentBottomSheetBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentBottomSheetBinding.bind(view)
        calculateViewDialogHeight()
        initViews()
    }

    private fun initViews() {
        viewBinding?.apply {
            etBottomSheet.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val input = etBottomSheet.text.toString()
                    if (input.isNotEmpty()) {
                        val newsCount = input.toInt()
                        if (newsCount > 5) {
                            etBottomSheet.setText(input.substring(0, input.length - 1))
                            etBottomSheet.text?.let { etBottomSheet.setSelection(it.length) }
                            etBottomSheet.addTextChangedListener(this)
                            etBottomSheet.removeTextChangedListener(this)

                            Toast.makeText(
                                context,
                                getString(R.string.you_should_enter_a_number_between_0_and_5),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            btnSubmit.setOnClickListener {
                val planetCount = etBottomSheet.text.toString()
                if (isValidInput(planetCount)) {
                    SongsDataRepository.addRandomSongs(planetCount.toInt())
                    adapter?.setItems(SongsDataRepository.getAllSongs())
                    dismiss()
                } else Toast.makeText(
                    context,
                    getString(R.string.you_should_enter_a_number_between_0_and_5),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isValidInput(input: String): Boolean {
        if (input.isEmpty()) return false
        return input.toInt() in 1 .. 5
    }

    private fun calculateViewDialogHeight() {
        val displayMetrics = requireContext().resources.displayMetrics
        val dialogHeight = displayMetrics.heightPixels / 10

        val layoutParams =
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
                .apply {
                    height = dialogHeight
                }

        this.viewBinding?.root?.layoutParams = layoutParams
    }

    companion object {
        const val BOTTOM_SHEET_FRAGMENT_TAG = "BOTTOM_SHEET_FRAGMENT_TAG"
    }
}
package com.itis.homework.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import com.itis.homework.R
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentSongInfoBinding
import com.itis.homework.utils.ParamsKey

class SongInfoFragment : BaseFragment(R.layout.fragment_song_info) {
    private var viewBinding: FragmentSongInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentSongInfoBinding.bind(view)
        postponeEnterTransition()

        (view.parent as? ViewGroup)?.doOnPreDraw {
            startPostponedEnterTransition()
        }

        initViews()
    }

    private fun initViews() {
        val transitionName = arguments?.getString(ParamsKey.TRANSITION_NAME_KEY)

        viewBinding?.apply {
            tvSongTitle.text = arguments?.getString(ParamsKey.SONG_NAME_KEY)
            tvSongId.text = arguments?.getString(ParamsKey.SONG_ID_KEY)
            tvSongName.text = arguments?.getString(ParamsKey.SONG_NAME_KEY)
            tvSongAlbum.text = arguments?.getString(ParamsKey.SONG_ALBUM_KEY)
            tvSongAuthor.text = arguments?.getString(ParamsKey.SONG_AUTHOR_KEY)
            tvSongText.text = arguments?.getString(ParamsKey.SONG_LYRICS_KEY)
            arguments?.getInt(ParamsKey.SONG_ICON_KEY)?.let { ivSongIcon.setImageResource(it) }
            ivSongIcon.transitionName = transitionName
        }
    }

    companion object {
        const val SONG_INFO_FRAGMENT_KEY = "SONG_INFO_FRAGMENT_KEY"
        fun newInstance(
            id: String,
            name: String,
            album: String,
            author: String,
            lyrics: String,
            icon: Int?,
            transitionName: String
        ) =
            SongInfoFragment().apply {
                arguments = bundleOf(
                    ParamsKey.SONG_ID_KEY to id,
                    ParamsKey.SONG_NAME_KEY to name,
                    ParamsKey.SONG_ALBUM_KEY to album,
                    ParamsKey.SONG_AUTHOR_KEY to author,
                    ParamsKey.SONG_LYRICS_KEY to lyrics,
                    ParamsKey.SONG_ICON_KEY to icon,
                    ParamsKey.TRANSITION_NAME_KEY to transitionName
                )
            }
    }
}
package com.example.a40_drawerdemo

import MyListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.fragment_pager.*

class PagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().collapsingToolBarLayout.title = getString(R.string.pager_fragment_title)
        requireActivity().toolbarIconImageView.setImageResource(R.drawable.ic_baseline_looks_3_24)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //true表示什么ViewPage
        val adapter = MyListAdapter(true)
        viewPager.adapter = adapter
        adapter.submitList(iconsList())
    }

}
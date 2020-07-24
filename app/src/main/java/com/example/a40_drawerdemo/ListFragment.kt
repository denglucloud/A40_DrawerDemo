package com.example.a40_drawerdemo


import MyListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().collapsingToolBarLayout.title = getString(R.string.list_fragment_title)
        requireActivity().toolbarIconImageView.setImageResource(R.drawable.ic_baseline_looks_two_24)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    /**
     * 创建View
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //创建layoutManager
        val layoutManager = GridLayoutManager(requireContext(),2)
        //创建适配器
        val adapter = MyListAdapter(false)
        /*
            给recyclerView组件配置layoutManager和适配器
         */
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.submitList(iconsList())
    }

}

/**
 * 随机生成50个图标
 */
fun iconsList():List<Int>{
    val array = intArrayOf(
        R.drawable.ic_01,
        R.drawable.ic_02,
        R.drawable.ic_03,
        R.drawable.ic_04,
        R.drawable.ic_05,
        R.drawable.ic_06,
        R.drawable.ic_07,
        R.drawable.ic_08,
        R.drawable.ic_09
    )

    return Array(50){
        array.random()
    }.toList()
}
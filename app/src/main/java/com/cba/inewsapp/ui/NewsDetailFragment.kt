package com.cba.inewsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.cba.core_ui.BaseFragment
import com.cba.inewsapp.R
import com.cba.inewsapp.databinding.FragmentNewsBinding
import com.cba.inewsapp.databinding.FragmentNewsDetailBinding


class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    private val newsViewModel : NewsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNewsDetailBinding.inflate(inflater,container,false)
         binding.model=newsViewModel
        return binding.root
    }


}
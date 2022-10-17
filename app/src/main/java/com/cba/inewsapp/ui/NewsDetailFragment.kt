package com.cba.inewsapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.annotation.Nullable
import androidx.fragment.app.activityViewModels
import com.cba.core_ui.BaseFragment
import com.cba.inewsapp.R
import com.cba.inewsapp.databinding.FragmentNewsBinding
import com.cba.inewsapp.databinding.FragmentNewsDetailBinding


class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    private val newsViewModel : NewsViewModel by activityViewModels()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNewsDetailBinding.inflate(inflater,container,false)
         binding.model=newsViewModel
        setHasOptionsMenu(true);
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
          inflater.inflate(R.menu.mai_menu, menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                share()
                true
            }
            R.id.action_fav -> {
                Toast.makeText(context, "Added to favourite", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun share() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        // type of the content to be shared
        sharingIntent.type = "text/plain"
        // Body of the content
        val shareBody = "Share"
        // subject of the content. you can share anything
        val shareSubject = "Share Using"
        // passing body of the content
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        // passing subject of the content
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
        startActivity(Intent.createChooser(sharingIntent, "Share using"))
    }
}
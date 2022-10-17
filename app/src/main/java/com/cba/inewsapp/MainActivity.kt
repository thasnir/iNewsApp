package com.cba.inewsapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cba.inewsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val menu = getMenuInflater().inflate(R.menu.mai_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                share()
                true
            }
            R.id.action_fav -> {
                Toast.makeText(this, "Added to favourite", Toast.LENGTH_SHORT)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun share() {
        val sharingIntent = Intent(Intent.ACTION_SEND)

        // type of the content to be shared

        // type of the content to be shared
        sharingIntent.type = "text/plain"

        // Body of the content

        // Body of the content
        val shareBody = "Share"

        // subject of the content. you can share anything

        // subject of the content. you can share anything
        val shareSubject = "Share Using"

        // passing body of the content

        // passing body of the content
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

        // passing subject of the content

        // passing subject of the content
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
        startActivity(Intent.createChooser(sharingIntent, "Share using"))

    }

}
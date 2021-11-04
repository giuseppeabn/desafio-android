package com.example.desafio_android.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio_android.databinding.ActivityPullBinding

class PullActivity : AppCompatActivity() {
    private lateinit var bindingPull: ActivityPullBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)
    }
}
package com.example.placesco.view.view.ui

import com.example.placesco.model.Sites

interface ClickListener {
    fun onItemClicked(position : Int, sites: Sites)
}
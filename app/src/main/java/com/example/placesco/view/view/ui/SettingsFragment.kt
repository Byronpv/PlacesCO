package com.example.placesco.view.view.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.placesco.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}
package com.joohyung.android.sharedpreferencegeneric

import android.content.Context
import android.content.SharedPreferences
import com.joohyung.android.sharedpreferencegeneric.GenericPreference.set
import com.joohyung.android.sharedpreferencegeneric.GenericPreference.get


class GenericPreferenceManager(context: Context) {

    private val prefs: SharedPreferences = GenericPreference.defaultPrefs(context)

    fun saveProfile(profile: Profile) {
        prefs["name"] = profile.name
        prefs["age"] = profile.age
        prefs["isStudent"] = profile.isStudent
    }

    fun updateProfile(): Profile {
        return Profile().apply {
            name = prefs["name", ""]
            age = prefs["age", 0]
            isStudent = prefs["isStudent", false]
        }
    }
}
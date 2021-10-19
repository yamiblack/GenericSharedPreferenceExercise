package com.joohyung.android.sharedpreferencegeneric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply
import com.joohyung.android.sharedpreferencegeneric.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val genericPreferenceManager: GenericPreferenceManager by lazy { GenericPreferenceManager(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val profile = Profile().apply {
                name = binding.nameInput.text.toString()
                age = binding.ageInput.text.toString().toInt()
                isStudent = binding.isStudent.isChecked
            }
            genericPreferenceManager.saveProfile(profile)
        }

        binding.updateButton.setOnClickListener {
            val profile = genericPreferenceManager.updateProfile()
            val profileContext = "name : ${profile.name} \n" +
                    "age : ${profile.age} \n" +
                    "is Student? : ${profile.isStudent} \n"
            binding.profile.text = profileContext
        }
    }
}
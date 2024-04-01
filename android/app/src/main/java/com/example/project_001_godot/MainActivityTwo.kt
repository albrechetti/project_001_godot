package com.example.project_001_godot

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.godotengine.godot.Godot
import org.godotengine.godot.GodotFragment
import org.godotengine.godot.GodotHost

class MainActivityTwo : AppCompatActivity(), GodotHost {

    private var godotFragment: GodotFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)

        val currentGodotFragment = supportFragmentManager.findFragmentById(R.id.godot_fragment_container)

        if(currentGodotFragment is GodotFragment){
            godotFragment = currentGodotFragment
        } else{
            godotFragment = GodotFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.godot_fragment_container, godotFragment!!)
                .commitNowAllowingStateLoss()
        }
    }

    override fun getActivity() = this

    override fun getGodot() =  godotFragment?.godot
}
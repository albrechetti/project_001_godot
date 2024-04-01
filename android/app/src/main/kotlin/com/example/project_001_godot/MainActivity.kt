package com.example.project_001_godot

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            "screenPlatform"
        ).setMethodCallHandler {call, result ->
            when(call.method){
            "showGodotScreen" -> {
                val intent = Intent(this, MainActivityTwo::class.java)
                startActivity(intent)
            }
                else -> {
                    result.notImplemented()
                }
        } }
    }

}

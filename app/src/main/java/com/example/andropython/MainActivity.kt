package com.example.andropython

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Python.start(AndroidPlatform(this))

        helloTextView.text = getPythonHelloWorld()
    }

    private fun getPythonHelloWorld(): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("helloworldscript")
        return pythonFile.callAttr("helloworld").toString()
    }
}
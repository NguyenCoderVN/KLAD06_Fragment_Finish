package com.nguyencodervn.klad06_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private lateinit var fragment01Bt: Button
    private lateinit var fragment02Bt: Button
    private lateinit var fragment03Bt: Button
    private lateinit var fragment04Bt: Button
    private lateinit var popBackStack: Button
    private lateinit var showBackStack: Button
    private lateinit var saveBackStack: Button
    private lateinit var restoreBackStack: Button
    private lateinit var showTv : TextView

    companion object {
        const val TAG = "MYTAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "${this::class.simpleName} onCreate: ")
        fragment01Bt = findViewById(R.id.fragment01Bt)
        fragment02Bt = findViewById(R.id.fragment02Bt)
        fragment03Bt = findViewById(R.id.fragment03Bt)
        fragment04Bt = findViewById(R.id.fragment04Bt)
        popBackStack = findViewById(R.id.popBackStack)
        showBackStack = findViewById(R.id.showBackStack)
        saveBackStack = findViewById(R.id.saveBackStack)
        restoreBackStack = findViewById(R.id.restoreBackStack)
        showTv = findViewById(R.id.showTv)

        fragment01Bt.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Fragment01>(R.id.fragment_view)
            }
        }

        fragment02Bt.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<Fragment02>(R.id.fragment_view)
            }
        }

        fragment03Bt.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<Fragment03>(R.id.fragment_view)
            }
        }

        fragment04Bt.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<Fragment04>(R.id.fragment_view)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "${this::class.simpleName} onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "${this::class.simpleName} onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "${this::class.simpleName} onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "${this::class.simpleName} onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "${this::class.simpleName} onSaveInstanceState: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "${this::class.simpleName} onDestroy: ")
    }

}
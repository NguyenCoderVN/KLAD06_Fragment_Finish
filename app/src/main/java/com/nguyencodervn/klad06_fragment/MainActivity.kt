package com.nguyencodervn.klad06_fragment

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
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
    private lateinit var showTv: TextView
    private val fm = supportFragmentManager

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
            val bundle = bundleOf("text" to "KOTLIN")
            if (!checkFragment(Fragment01()) &&
                (!checkBackStack("Fragment01"))
            ) {
                fm.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                    )
                    setReorderingAllowed(true)
                    add<Fragment01>(R.id.fragment_view, args = bundle)
                    addToBackStack("Fragment01")
                }
            } else {
                showWarning()
            }
        }

        fragment02Bt.setOnClickListener {
            if (!checkFragment(Fragment02()) &&
                (!checkBackStack("Fragment02"))
            ) {
                fm.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                    )
                    setReorderingAllowed(true)
                    replace<Fragment02>(R.id.fragment_view)
                    addToBackStack("Fragment02")
                }
            }else {
                showWarning()
            }
        }

        fragment03Bt.setOnClickListener {
            if (!checkFragment(Fragment03()) &&
                (!checkBackStack("Fragment03"))
            ) {
                fm.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                    )
                    setReorderingAllowed(true)
                    replace<Fragment03>(R.id.fragment_view)
                    addToBackStack("Fragment03")
                }
            } else {
                showWarning()
            }
        }

        fragment04Bt.setOnClickListener {
            if (!checkFragment(Fragment04()) &&
                (!checkBackStack("Fragment04"))
            ) {
                fm.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                    )
                    setReorderingAllowed(true)
                    replace<Fragment04>(R.id.fragment_view)
                    addToBackStack("Fragment04")
                }
            } else {
                showWarning()
            }
        }

        showBackStack.setOnClickListener {
            showBackStack()
        }

        popBackStack.setOnClickListener {
            fm.popBackStack()
        }

        saveBackStack.setOnClickListener {
            fm.saveBackStack("Fragment02")
        }

        restoreBackStack.setOnClickListener {
            fm.restoreBackStack("Fragment02")
        }
    }

    private fun showWarning() {
        Toast.makeText(
            applicationContext,
            "This Fragment is in Stack, or Attached",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun checkBackStack(fragment: String): Boolean {
        var check = false
        for (entry in 0 until fm.backStackEntryCount) {
            if (fm.getBackStackEntryAt(entry).name == fragment) {
                check = true
            }
        }
        return check
    }

    private fun <T> checkFragment(fragment: T): Boolean {
        val fragmentName = fragment!!::class.simpleName
        return if (fm.findFragmentById(R.id.fragment_view) != null) {
            try {
                when (fragmentName) {
                    "Fragment01" -> (fm.findFragmentById(R.id.fragment_view) as Fragment01).isAdded
                    "Fragment02" -> (fm.findFragmentById(R.id.fragment_view) as Fragment02).isAdded
                    "Fragment03" -> (fm.findFragmentById(R.id.fragment_view) as Fragment03).isAdded
                    else -> (fm.findFragmentById(R.id.fragment_view) as Fragment04).isAdded
                }
            } catch (e: Exception) {
                false
            }
        } else {
            false
        }
    }

    private fun showBackStack() {
        var str = ""
        for (entry in 0 until fm.backStackEntryCount) {
            str = fm.getBackStackEntryAt(entry).name + "\n" + str
        }
        showTv.text = str
    }

    fun getValue(str: String) {
        showTv.text = str
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
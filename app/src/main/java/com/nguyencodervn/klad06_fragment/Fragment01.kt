package com.nguyencodervn.klad06_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class Fragment01 : Fragment() {
    private lateinit var countBt: Button
    private lateinit var textView: TextView
    private var count = 0

    companion object {
        const val TAG = "MYTAG"
        const val COUNT_KEY = "COUNT_KEY"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "${this::class.simpleName} onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState!=null) {
            count = savedInstanceState.getInt(COUNT_KEY)
        }
        Log.i(TAG, "${this::class.simpleName} onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i(TAG, "${this::class.simpleName} onCreateView: ")
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "${this::class.simpleName} onViewCreated: ")
        countBt = view.findViewById(R.id.countBt)
        textView = view.findViewById(R.id.textView)

//        val text = requireArguments().getString("text")
        val text = arguments?.getString("text")
        textView.text = text

        countBt.text = count.toString()
        countBt.setOnClickListener {
            count++
            countBt.text = count.toString()
            (activity as MainActivity).getValue(count.toString())
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i(TAG, "${this::class.simpleName} onViewStateRestored: ")
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
        outState.putInt(COUNT_KEY, count)
        Log.i(TAG, "${this::class.simpleName} onSaveInstanceState: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "${this::class.simpleName} onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "${this::class.simpleName} onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "${this::class.simpleName} onDetach: ")
    }
}
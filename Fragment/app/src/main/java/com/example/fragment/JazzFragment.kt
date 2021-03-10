package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton

class JazzFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jazz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPlay: ImageButton = view.findViewById(R.id.playBtn)
        btnPlay.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.playBtn) {
            val mDetailJazzFragment = DetailJazzFragment()

            val mBundle = Bundle()
            mBundle.putString(DetailJazzFragment.EXTRA_CATEGORY, "Smooth Jazz")

            val description = "List of Smooth Jazz Music"
            mDetailJazzFragment.arguments = mBundle
            mDetailJazzFragment.description = description

            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayoutMain, mDetailJazzFragment, DetailJazzFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}
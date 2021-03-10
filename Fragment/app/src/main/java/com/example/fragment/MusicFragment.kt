package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton

class MusicFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnJazz: ImageButton = view.findViewById(R.id.jazzBtn)
        btnJazz.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.jazzBtn) {
            val mJazzFragment = JazzFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayoutMain, mJazzFragment, JazzFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}
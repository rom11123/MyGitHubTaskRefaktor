package com.example.mygithubtaskrefacktor.feature_github.presentation

import androidx.fragment.app.Fragment
import com.example.mygithubtaskrefacktor.R
import com.example.mygithubtaskrefacktor.feature_github.presentation.users_detail_screen.BACK_STACK

fun Fragment.addFragment(fragment: Fragment) {
    parentFragmentManager
        .beginTransaction()
        .add(R.id.fragmentContainerView, fragment)
        .addToBackStack(BACK_STACK)
        .commit()
}
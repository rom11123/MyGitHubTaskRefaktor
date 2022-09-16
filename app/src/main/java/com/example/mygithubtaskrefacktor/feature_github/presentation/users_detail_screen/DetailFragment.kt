package com.example.mygithubtaskrefacktor.feature_github.presentation.users_detail_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide


import com.example.mygithubtaskrefacktor.R
import com.example.mygithubtaskrefacktor.databinding.FragmentDetailBinding
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity


private const val ARG = "ARG"
const val BACK_STACK = "backStack"


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
       val users: AllUsersEntity? = arguments?.getSerializable(ARG) as? AllUsersEntity

        Glide.with(binding.detailImage.context)
            .load(users?.avatarUrl)
            .into(binding.detailImage)
        binding.detailLogin.text = users?.login.toString()
    }

    private fun setToolbar() {
      binding.toolbarDetails?.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }




    companion object {
        fun newInstance(users: AllUsersEntity) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG, users)

                }
            }
    }
}
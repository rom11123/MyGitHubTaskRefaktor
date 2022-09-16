package com.example.mygithubtaskrefacktor.feature_github.presentation.my_profile_screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mygithubtaskrefacktor.R
import com.example.mygithubtaskrefacktor.databinding.FragmentMyProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyProfileFragment : Fragment() {
    private lateinit var binding: FragmentMyProfileBinding
    private val viewModel by viewModel<MyProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolBar()
        update()
//        logOut()
//        logOutObserve()
        binding.ivProfile.setOnClickListener {
            pickImageFromGallery()

        }

    }
//
//    private fun logOutObserve(){
//        lifecycleScope.launchWhenStarted {
//            viewModel.logOutEvent.collect {
//                findNavController().navigate(R.id.action_myProfileFragment_to_loginFragment)
//            }
//    }}

    private fun logOut() {
        binding.btnLogout.setOnClickListener {
            viewModel.logout()
        }
    }

    private fun setupToolBar() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfileFragment -> {

                    findNavController().navigate(R.id.action_myProfileFragment_to_settingsFragment)


                    true
                }

                else -> false
            }
        }
    }


    private fun update() {

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                binding.tvName.text = it.user?.name.toString()
                binding.tvUsername.text = it.user?.email.toString()
                binding.tvEmail.text = it.user?.email.toString()

                if (it.error.isNotBlank()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                if (it.isLoading) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

            }


        }
    }


    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            binding.ivProfile.setImageURI(data?.data)
        }
    }
}
package com.example.mygithubtaskrefacktor.feature_authentication.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mygithubtaskrefacktor.R
import com.example.mygithubtaskrefacktor.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment :Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<LoginViewModel>()

    override fun onResume() {
        super.onResume();
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentLoginBinding.inflate(layoutInflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!viewModel.isLoggedIn()) {
            binding.loginBt.setOnClickListener {
                if (viewModel.fieldsAreEmpty(
                        binding.loginEmail.text.toString(),
                        binding.loginPassword.text.toString())) {
                    Snackbar.make(binding.root, "Please Fill in All Fields", Snackbar.LENGTH_SHORT).show()
                } else {
                    viewModel.setToken(binding.loginPassword.text.toString())
                    viewModel.login()
                    lifecycleScope.launch {
                        viewModel.errorMessage.collect { value ->
                            if (value.isNotBlank()) {
                                viewModel.clear()
                                binding.let { it1 ->
                                    Snackbar.make(it1.root, value, Snackbar.LENGTH_SHORT).show() }
                            } else {
                                viewModel.saveCredentials(
                                    email = binding.loginEmail.text.toString(),
                                    password = binding.loginPassword.text.toString())
                                findNavController().navigate(R.id.action_loginFragment_to_repositoryFragment)
                            }

                        }
                    }
                }
            }
        } else {
            findNavController().navigate(R.id.action_loginFragment_to_repositoryFragment)

        }
    }


}
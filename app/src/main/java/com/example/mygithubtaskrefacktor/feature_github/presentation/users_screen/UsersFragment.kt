package com.example.mygithubtaskrefacktor.feature_github.presentation.users_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.mygithubtaskrefacktor.databinding.FragmentUsersBinding
import com.example.mygithubtaskrefacktor.feature_github.presentation.addFragment
import com.example.mygithubtaskrefacktor.feature_github.presentation.users_detail_screen.DetailFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsersFragment : Fragment() {
    private val viewModel by viewModel<UsersViewModel>()
    lateinit var usersAdapter: UsersAdapter
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        update()

    }

    private fun initRecycler() {
        usersAdapter = UsersAdapter()
        usersAdapter.setOnItemClickListener {
            addFragment(DetailFragment.newInstance(it))
        }
        binding.rvUsers.adapter = usersAdapter

    }


    private fun update() {

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {

                usersAdapter.submitList(it.users)
                binding.progressBar.isVisible = false
                if (it.error.isNotBlank()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                if (it.isLoading) {
                    Log.d("tag", "update")
                    binding.progressBar.isVisible = true
                }

            }


        }
    }

}
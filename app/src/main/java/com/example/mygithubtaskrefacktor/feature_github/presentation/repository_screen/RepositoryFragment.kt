package com.example.mygithubtaskrefacktor.feature_github.presentation.repository_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.mygithubtaskrefacktor.databinding.FragmentRepositoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepositoryFragment() : Fragment() {

//    private val viewModel by viewModel<RepositoryViewModel>()
//    private val viewModel by viewModel<NewViewModel>()
    private val viewModel by viewModel<TestRepoViewModel>()
//    private val viewModel by viewModel<ViewModelModel>()

    //    private val repoViewModel by viewModel<RepoViewModel>()
    lateinit var repositoryAdapter:RepoAdapter


    private lateinit var binding: FragmentRepositoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) :View{
        binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        update()
//        update()
//        viewModel.liveData.observe(viewLifecycleOwner,Observer{
//            repositoryAdapter.submitList(it)
//        })
    }




    fun initRecycler() {
        repositoryAdapter = RepoAdapter()
        binding.rvRepository.adapter = repositoryAdapter

    }


    fun update() {

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                repositoryAdapter.submitList(it.data)

                binding.progressBar.isVisible = false
                if (it.error.isNotBlank()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                if (it.isLoading) {
                    binding.progressBar.isVisible = true

                }

            }

        }
    }

//    fun updateCash() {
//        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
//            repositoryAdapter.submitList(it)
//            binding.progressBar.isVisible = false
//
//        })
//    }

//    fun getRepo(){
//        repoViewModel.liveData.observe(viewLifecycleOwner,Observer{
//            binding.rvRepository.isVisible = true
//            repositoryAdapter.submitList(it)
//        })
//    }



}



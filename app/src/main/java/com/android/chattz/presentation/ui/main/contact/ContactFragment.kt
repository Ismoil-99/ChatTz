package com.android.chattz.presentation.ui.main.contact

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentContactBinding
import com.android.chattz.domain.model.User
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.activityNavController
import com.android.chattz.presentation.extesions.hideActionBar
import com.android.chattz.presentation.ui.main.contact.adapter.ListAdapterContacts
import com.android.chattz.presentation.ui.main.message.MessageFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.ArrayList


@AndroidEntryPoint
class ContactFragment:BaseFragment<FragmentContactBinding>(R.layout.fragment_contact) {
    override val binding by viewBinding(FragmentContactBinding::bind)
    private val viewModel : ContactViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun initialize() {
        super.initialize()
        lifecycleScope.launch{
            viewModel.getUser().observe(requireActivity()){
                Log.d("user","$it")
            }
            viewModel.getListContacts().observe(requireActivity()){
                Log.d("user1","$it")
                recyclerView = binding.recyclerView
                if (it.status == "success"){
                    setupAdapter(it.contacts)
                }
            }
        }
        hideActionBar()
    }
    private fun setupAdapter(contacts: ArrayList<User>) {
        val adapter = ListAdapterContacts{
            val directions = MessageFragmentDirections.toMessage(it.name,it.phone)
            activityNavController().navigate(directions)
        }
        adapter.submitList(contacts)
        recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)

    }
}
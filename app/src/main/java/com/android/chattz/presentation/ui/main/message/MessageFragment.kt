package com.android.chattz.presentation.ui.main.message


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentMessageBinding
import com.android.chattz.domain.model.MessageObj
import com.android.chattz.domain.model.SendMessageModel
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.activityNavController
import com.android.chattz.presentation.extesions.childCurrentBack
import com.android.chattz.presentation.extesions.showActionBar
import com.android.chattz.presentation.ui.main.contact.adapter.ListAdapterContacts
import com.android.chattz.presentation.ui.main.message.adapter.MessageAdapter
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MessageFragment:BaseFragment<FragmentMessageBinding>(R.layout.fragment_message) {
    override val binding by viewBinding(FragmentMessageBinding::bind)
    private val viewModel : MessageViewModel by viewModels()
    private val args:MessageFragmentArgs by navArgs()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter
    private var smsList = mutableListOf<MessageObj>()

    override fun initialize() {
        super.initialize()
        childCurrentBack(R.id.fragment_container_view)
        showActionBar()
        requireActivity().findViewById<MaterialToolbar>(R.id.toolbar).title = args.name
        binding.sendMessage.setOnClickListener {
            lifecycleScope.launch(){
                viewModel.sendSmS(
                    SendMessageModel(message = binding.selectSms.text.toString(),phone = "55555")).observe(requireActivity()){
                    Log.d("value","${it}")
                    smsList.add(it.messageObj)
                    adapter.notifyItemInserted(smsList.size)
                }
            }
            Log.d("value","${binding.selectSms.text.toString()},${args.phone}")
        }
        lifecycleScope.launch(){
            viewModel.getDataSms("55555").observe(requireActivity()){
                Log.d("sms","$it")
                recyclerView = binding.recyclerViewChat
                smsList.addAll(it.data)
                setupAdapter(smsList)
            }
        }
    }

    private fun setupAdapter(data: List<MessageObj>) {
        adapter = MessageAdapter()
        adapter.submitList(data)
        recyclerView.adapter = adapter
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.VERTICAL,false)

    }
}
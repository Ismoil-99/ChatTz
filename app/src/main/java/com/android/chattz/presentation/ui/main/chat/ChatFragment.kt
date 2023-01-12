package com.android.chattz.presentation.ui.main.chat

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentChatBinding
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.hideActionBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChatFragment:BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {
    override val binding by viewBinding(FragmentChatBinding::bind)
    private val viewModel : ChatViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        hideActionBar()
    }
}
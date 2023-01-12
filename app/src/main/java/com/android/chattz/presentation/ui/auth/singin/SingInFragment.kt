package com.android.chattz.presentation.ui.auth.singin

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentSinginBinding
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.hideActionBar
import com.android.chattz.presentation.extesions.navigateSafely
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SingInFragment:BaseFragment<FragmentSinginBinding>(R.layout.fragment_singin) {
    override val binding by viewBinding(FragmentSinginBinding::bind)
    private val viewModel : SingInViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        hideActionBar()
        binding.toSignUp.setOnClickListener {
            findNavController().navigateSafely(R.id.to_sign_up)
        }
    }
}
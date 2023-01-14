package com.android.chattz.presentation.ui.main.option


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentOptionBinding
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.hideActionBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class OptionFragment:BaseFragment<FragmentOptionBinding>(R.layout.fragment_option) {
    override val binding by viewBinding(FragmentOptionBinding::bind)
    private val viewModel : OptionViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        hideActionBar()
        binding.logout.setOnClickListener {
            lifecycleScope.launch {

            }
        }
    }
}
package com.android.chattz.presentation.ui.auth.singup

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentSingupBinding
import com.android.chattz.domain.model.User
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.showActionBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SingUpFragment: BaseFragment<FragmentSingupBinding>(R.layout.fragment_singup) {
    override val binding by viewBinding(FragmentSingupBinding::bind)
    private val viewModel : SingUpViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        showActionBar()
            binding.signUp.setOnClickListener {
                lifecycleScope.launch{
                    viewModel.singUp(
                        User(
                            binding.selectName.text.toString(),
                            binding.selectNumber.text.toString(),
                            binding.selectPassword.text.toString()
                        )
                    ).observe(requireActivity()){
                        Log.d("value","$it")
                    }
                }
            }
        }

}

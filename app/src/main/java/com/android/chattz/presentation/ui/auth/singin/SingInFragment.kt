package com.android.chattz.presentation.ui.auth.singin


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.app.App
import com.android.chattz.databinding.FragmentSinginBinding
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.activityNavController
import com.android.chattz.presentation.extesions.hideActionBar
import com.android.chattz.presentation.extesions.navigateSafely
import com.android.chattz.utils.ERROR
import com.android.chattz.utils.TOKEN
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SingInFragment:BaseFragment<FragmentSinginBinding>(R.layout.fragment_singin) {
    override val binding by viewBinding(FragmentSinginBinding::bind)
    private val viewModel : SingInViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        hideActionBar()
        val saveToken = App.sharedPreferencesEditor
        binding.toSignUp.setOnClickListener {
            findNavController().navigateSafely(R.id.to_sign_up)
        }
        lifecycleScope.launch{
            binding.signIn.setOnClickListener {
                viewModel.singInUser(
                    binding.selectName.text.toString(),
                    binding.selectPassword.text.toString()
                ).observe(requireActivity()){
                    if (it.status == ERROR){
                        MaterialAlertDialogBuilder(requireActivity())
                            .setMessage(it.message)
                            .setPositiveButton("Ок") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                    }
                    if (it.status == "success"){
                        activityNavController().navigateSafely(R.id.action_global_to_nav_main)
                        saveToken.putString(TOKEN,it.accessToken)
                        saveToken.apply()
                    }
                }
            }
        }
    }
}
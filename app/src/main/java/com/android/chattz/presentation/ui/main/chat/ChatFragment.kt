package com.android.chattz.presentation.ui.main.chat

import android.annotation.SuppressLint
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.app.App
import com.android.chattz.databinding.FragmentChatBinding
import com.android.chattz.presentation.base.BaseFragment
import com.android.chattz.presentation.extesions.hideActionBar
import com.android.chattz.utils.SAVE_CONTACTS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject


@AndroidEntryPoint
class ChatFragment:BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {
    override val binding by viewBinding(FragmentChatBinding::bind)
    private val viewModel : ChatViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        hideActionBar()
        requestSinglePermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS)
    }

    @SuppressLint("Range")
    private val requestSinglePermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            val contacts = JSONArray()
            if (isGranted) {
                val phones = requireContext().contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null,
                    null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )
                while (phones?.moveToNext() == true){
                    val name :String = phones.getString(
                        phones.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        )
                    )
                    val phone :String = phones.getString(
                        phones.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                    )
                    val obj: JSONObject = JSONObject()
                    obj.put("name",name)
                    obj.put("phone",phone)
                    contacts.put(obj)
                }
                Log.d("contacts","$contacts")
                val statusSave = App.sharedPreferences.getBoolean(SAVE_CONTACTS,false)
                Log.d("status","$statusSave")
                phones?.close()
                lifecycleScope.launch{
                    if (!statusSave){
                        viewModel.getContact(contacts.toString()).observe(requireActivity()){
                            if (it.status == "success"){
                                val saveContacts = App.sharedPreferencesEditor.putBoolean(SAVE_CONTACTS,true)
                                saveContacts.apply()
                            }
                        }
                    }
                }
            } else {

            }
        }
}
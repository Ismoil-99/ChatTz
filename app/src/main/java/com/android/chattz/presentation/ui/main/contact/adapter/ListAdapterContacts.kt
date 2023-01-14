package com.android.chattz.presentation.ui.main.contact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.chattz.R
import com.android.chattz.databinding.ListContactsBinding
import com.android.chattz.domain.model.User

class ListAdapterContacts(): ListAdapter<User, ListAdapterContacts.ContactsViewHolder>(FinishDiffUtil()){
    class FinishDiffUtil : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.phone == newItem.phone
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListContactsBinding.bind(itemView)

        fun bind(test:User ) {
            binding.apply {
                nameContact.text = test.name
                phoneUser.text = test.phone
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder =
        ContactsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_contacts, parent, false)
        )

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
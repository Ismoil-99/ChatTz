package com.android.chattz.presentation.ui.main.message.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.chattz.R
import com.android.chattz.databinding.ChatListLayoutBinding
import com.android.chattz.databinding.ListContactsBinding
import com.android.chattz.domain.model.MessageObj
import com.android.chattz.domain.model.User

class MessageAdapter: ListAdapter<MessageObj, MessageAdapter.ContactsViewHolder>(FinishDiffUtil()){
    class FinishDiffUtil : DiffUtil.ItemCallback<MessageObj>(){
        override fun areItemsTheSame(oldItem: MessageObj, newItem: MessageObj): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: MessageObj, newItem: MessageObj): Boolean {
            return oldItem == newItem
        }
    }
    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ChatListLayoutBinding.bind(itemView)
        fun bind(test:MessageObj ) {
            binding.message.text = test.message
            binding.reciver.text = test.receiver.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder =
        ContactsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_list_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
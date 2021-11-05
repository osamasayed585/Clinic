package com.example.clinic.util.call_back

import androidx.recyclerview.widget.DiffUtil
import com.example.clinic.model.data_class.Service

class ServiceItemDiffCallback: DiffUtil.ItemCallback<Service>() {
    override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean {
        return oldItem == newItem
    }

}
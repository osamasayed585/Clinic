package com.example.clinic.util.call_back

import androidx.recyclerview.widget.DiffUtil
import com.example.clinic.model.data_class.LabService

class ServiceItemDiffCallback: DiffUtil.ItemCallback<LabService>() {
    override fun areItemsTheSame(oldItem: LabService, newItem: LabService): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LabService, newItem: LabService): Boolean {
        return oldItem == newItem
    }

}
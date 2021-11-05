package com.example.clinic.util.call_back

import androidx.recyclerview.widget.DiffUtil
import com.example.clinic.model.data_class.Certificate

class CertificatesItemDiffCallback: DiffUtil.ItemCallback<Certificate>() {
    override fun areItemsTheSame(oldItem: Certificate, newItem: Certificate): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Certificate, newItem: Certificate): Boolean {
        return oldItem == newItem
    }

}
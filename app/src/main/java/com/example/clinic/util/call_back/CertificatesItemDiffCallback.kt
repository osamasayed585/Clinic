package com.example.clinic.util.call_back

import androidx.recyclerview.widget.DiffUtil
import com.example.clinic.model.data_class.AppImage

class CertificatesItemDiffCallback: DiffUtil.ItemCallback<AppImage>() {
    override fun areItemsTheSame(oldItem: AppImage, newItem: AppImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AppImage, newItem: AppImage): Boolean {
        return oldItem == newItem
    }

}
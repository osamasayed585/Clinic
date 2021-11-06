package com.example.clinic.lab_ticket.util.call_back

import androidx.recyclerview.widget.DiffUtil
import com.example.clinic.lab_ticket.model.class_data.LabTicket

class ClosedDiffCallback: DiffUtil.ItemCallback<LabTicket>() {
    override fun areItemsTheSame(oldItem: LabTicket, newItem: LabTicket): Boolean {
        return oldItem.ticketId == newItem.ticketId
    }

    override fun areContentsTheSame(oldItem: LabTicket, newItem: LabTicket): Boolean {
        return oldItem == newItem
    }

}
package com.example.clinic.lab_ticket.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clinic.databinding.RowClosedItemBinding
import com.example.clinic.lab_ticket.model.class_data.LabTicket
import com.example.clinic.lab_ticket.util.call_back.ClosedDiffCallback
import com.example.clinic.util.OnRecyclerItemClick
import com.squareup.picasso.Picasso

class ClosedTicketAdapter : ListAdapter<LabTicket, ClosedTicketAdapter.ClosedTicketHolder>(
    ClosedDiffCallback()
) {

    class ClosedTicketHolder(val binding: RowClosedItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosedTicketHolder {
        return ClosedTicketHolder(
            RowClosedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    lateinit var onClickItem: OnRecyclerItemClick

    override fun onBindViewHolder(holder: ClosedTicketHolder, position: Int) {
        val closed = getItem(position)
        val bind = holder.binding

        bind.ClosedItemTicketId.text = closed.ticketId.toString()
        bind.ClosedItemName.text = closed.user.namePatient
        Picasso.get().load(closed.user.image).centerCrop().fit().into(bind.ClosedItemImage)
        bind.ClosedItemAddress.text = closed.address
        bind.ClosedItemData.text = closed.data
        bind.ClosedItemType.text = closed.type
        bind.ClosedItemAmount.text = "${closed.amount} EGP"
        bind.ClosedItemProviderBrief.text = closed.providerBrief

        if (closed.cash) {
            bind.ClosedItemVisa.isVisible = false
            bind.ClosedItemCash.isVisible = true
        } else if (closed.visaCredit) {
            bind.ClosedItemCash.isVisible = false
            bind.ClosedItemVisa.isVisible = true
        }
        bind.ClosedTicketItem.setOnClickListener {
            onClickItem.onClick(closed)
        }
    }
}
package com.example.clinic.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clinic.databinding.RowServiceItemBinding
import com.example.clinic.model.data_class.LabService
import com.example.clinic.util.OnRecyclerItemClick
import com.example.clinic.util.call_back.ServiceItemDiffCallback

class AddServicesAdapter : ListAdapter<LabService, AddServicesAdapter.ServiceHolder>(
    ServiceItemDiffCallback()
) {

    private var certificate: List<LabService>? = null

    class ServiceHolder(val bind: RowServiceItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        return ServiceHolder(
            RowServiceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    lateinit var onServiceListener: OnRecyclerItemClick

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val service = getItem(position)
        val bind = holder.bind

        bind.itemServiceNameEg.text = service.nameEg
        bind.itemServiceNameAr.text = service.nameAr
        bind.itemServicePrice.text = service.price.toString()
        bind.itemServiceHomeVisits.isChecked = service.homeVisits!!

        bind.itemService.setOnClickListener {
            onServiceListener.onClick(service)
        }
        if (!bind.itemServiceHomeVisits.isChecked) {
            bind.itemServiceAtHomePrice.isVisible = false
            bind.textAtHomePrice.isVisible = false
        }

    }
}
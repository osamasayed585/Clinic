package com.example.clinic.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clinic.databinding.RowServiceItemBinding
import com.example.clinic.model.data_class.Service
import com.example.clinic.util.OnClickServiceListener
import com.example.clinic.util.call_back.ServiceItemDiffCallback

class AddServicesAdapter: ListAdapter<Service, AddServicesAdapter.ServiceHolder>(
    ServiceItemDiffCallback()
) {

    private var certificate: List<Service>? = null

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
    lateinit var onServiceListener: OnClickServiceListener

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val service = getItem(position)
        val bind = holder.bind

        bind.itemServiceNameEg.text = service.nameEg
        bind.itemServiceNameAr.text = service.nameAr
        bind.itemServicePrice.text = service.price.toString()
        bind.itemServiceReservation.isChecked = service.reservation!!
        bind.itemServiceHomeVisits.isChecked = service.homeVisits!!
        bind.itemServiceAtHomePrice.text = service.homeServicePrice.toString()

        bind.itemService.setOnClickListener {
            onServiceListener.onServiceClick(service)
        }
        if (!bind.itemServiceHomeVisits.isChecked){
            bind.itemServiceAtHomePrice.isVisible = false
            bind.textAtHomePrice.isVisible = false
        }

    }
}
package com.example.clinic.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clinic.databinding.RowCertificateItemBinding
import com.example.clinic.model.data_class.AppImage
import com.example.clinic.util.call_back.CertificatesItemDiffCallback
import com.example.clinic.util.OnRecyclerItemClick
import com.squareup.picasso.Picasso

class CertificatesAdapter: ListAdapter<AppImage, CertificatesAdapter.CertificatesHolder>(
    CertificatesItemDiffCallback()
) {

    private var certificate: List<AppImage>? = null

    class CertificatesHolder(val bind: RowCertificateItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificatesHolder {
      return CertificatesHolder(
          RowCertificateItemBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
    }

    lateinit var onClickImage: OnRecyclerItemClick
    lateinit var onClickDelete: OnRecyclerItemClick

    override fun onBindViewHolder(holder: CertificatesHolder, position: Int) {
        val item = getItem(position)
        val bind = holder.bind

        Picasso.get().load(item.photo)
            .centerCrop()
            .fit()
            .into(bind.itemCertificateImage)

        bind.itemCertificateImage.setOnClickListener {
            onClickImage.onClick(item)
        }
    }
}
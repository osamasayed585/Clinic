package com.example.clinic.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clinic.adapter.AddServicesAdapter
import com.example.clinic.adapter.CertificatesAdapter
import com.example.clinic.databinding.FragmentProfileBinding
import com.example.clinic.model.data_class.AppImage
import com.example.clinic.model.data_class.LabService
import com.example.clinic.util.OnRecyclerItemClick

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        val serviceAdapter = AddServicesAdapter()
        binding.profileRcAddService.adapter = serviceAdapter

        val certificateAdapter = CertificatesAdapter()
        binding.profileRcCertificates.adapter = certificateAdapter
        binding.profileRcCertificates.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        viewModel.getServices()
        viewModel.getCertificates()

        viewModel.progressBarLoading.observe(viewLifecycleOwner, {
            initProgressBar(it)
        })


        viewModel.servicesLiveData.observe(viewLifecycleOwner, {
            val service = mutableListOf<LabService>()
            service.addAll(it)
            serviceAdapter.submitList(service)
        })

        viewModel.certificatesLiveData.observe(viewLifecycleOwner, {
            val certificate = mutableListOf<AppImage>()
            certificate.addAll(it)
            certificateAdapter.submitList(certificate)
        })

        serviceAdapter.onServiceListener = object : OnRecyclerItemClick {
            override fun onClick(item: Any) {
                item as LabService
                Toast.makeText(context, "${item.nameAr}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun initProgressBar(status: Boolean) {
        binding.profileProgressBar.isVisible = status
    }

}
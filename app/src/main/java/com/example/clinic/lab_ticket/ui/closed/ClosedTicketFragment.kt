package com.example.clinic.lab_ticket.ui.closed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.clinic.R
import com.example.clinic.databinding.FragmentClosedTicketBinding
import com.example.clinic.lab_ticket.model.class_data.LabTicket
import com.example.clinic.lab_ticket.ui.adapter.ClosedTicketAdapter
import com.example.clinic.util.OnRecyclerItemClick


class ClosedTicketFragment : Fragment() {

    private var _binding: FragmentClosedTicketBinding? = null
    private val binding: FragmentClosedTicketBinding get() = _binding!!

    private lateinit var viewModel: ClosedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClosedTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ClosedViewModel::class.java]

        val adapter = ClosedTicketAdapter()
        binding.closedRecyclerView.adapter = adapter

        viewModel.getClosedTicket()

        viewModel.progressBar.observe(viewLifecycleOwner,{
            initProgressBar(it)
        })
        viewModel.itemMutableLiveData.observe(viewLifecycleOwner,{
            val data = mutableListOf<LabTicket>()
            data.addAll(it)
            adapter.submitList(data)
        })

        adapter.onClickItem = object : OnRecyclerItemClick{
            override fun onClick(item: Any) {
                item as LabTicket
                Toast.makeText(context, "${item.providerBrief}", Toast.LENGTH_SHORT).show()
            }

        }


    }

    fun initProgressBar(status: Boolean) {
        binding.ClosedProgressBar.isVisible = status
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
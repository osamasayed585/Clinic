package com.example.clinic.lab_ticket.ui.main

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.clinic.R
import com.example.clinic.databinding.FragmentTicketBinding
import com.example.clinic.lab_ticket.ui.adapter.PagerAdapter
import com.example.clinic.lab_ticket.ui.closed.ClosedTicketFragment
import com.example.clinic.lab_ticket.ui.inquiry.InquiryFragment
import com.example.clinic.lab_ticket.ui.open.OpenTicketFragment
import com.google.android.material.tabs.TabLayoutMediator


class TicketFragment : Fragment() {

    private var _binding: FragmentTicketBinding? = null
    private val binding: FragmentTicketBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)

        setUpTabs()
        initColorTab()

        return binding.root
    }

    private fun setUpTabs() {
        val fragments = listOf(ClosedTicketFragment(), OpenTicketFragment(), InquiryFragment())
        binding.vpHome.adapter = PagerAdapter(this, fragments)

        TabLayoutMediator(binding.tabLayoutHome, binding.vpHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Open ticket"
                1 -> tab.text = "Closed Ticket"
                2 -> tab.text = "Inquiry"
            }
        }.attach()
    }

    private fun initColorTab() {
        val tabCount: Int = binding.tabLayoutHome.tabCount

        fun setImageButtonStateNew(mContext: Context): StateListDrawable {
            val states = StateListDrawable()
            states.addState(
                intArrayOf(android.R.attr.state_selected),
                ContextCompat.getDrawable(mContext, R.drawable.selected)
            )
            states.addState(
                intArrayOf(-android.R.attr.state_selected),
                ContextCompat.getDrawable(mContext, R.drawable.non_selected)
            )

            return states
        }

        for (i in 0 until tabCount) {
            val tabView: View = (binding.tabLayoutHome.getChildAt(0) as ViewGroup).getChildAt(i)
            tabView.requestLayout()
            ViewCompat.setBackground(tabView, setImageButtonStateNew(requireContext()));
            ViewCompat.setPaddingRelative(
                tabView,
                tabView.paddingStart,
                tabView.paddingTop,
                tabView.paddingEnd,
                tabView.paddingBottom
            );
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
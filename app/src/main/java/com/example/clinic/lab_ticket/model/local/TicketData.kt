package com.example.clinic.lab_ticket.model.local

import com.example.clinic.lab_ticket.model.class_data.LabTicket
import com.example.clinic.lab_ticket.model.class_data.User
import kotlinx.coroutines.delay
import retrofit2.Response

object TicketData {
    private val user_1 = User(
        1,
        "https://png.pngtree.com/png-vector/20190710/ourmid/pngtree-user-vector-avatar-png-image_1541962.jpg",
        "Ahmed Ali"
    )
    private val user_2 = User(
        2,
        "https://images.unsplash.com/photo-1586610393855-d47e3b9ef68a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHw%3D&w=1000&q=80",
        "Asama Mohamed"
    )
    private val user_3 = User(
        3,
        "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",
        "Samar Ashraf"
    )
    private val user_4 = User(
        4,
        "https://preview.keenthemes.com/metronic-v4/theme/assets/pages/media/profile/profile_user.jpg",
        "Khaled said"
    )
    private val user_5 = User(
        5,
        "https://sumoteks.com/assets/img/avatars/avatar.jpg",
        "Hatem Khateb"
    )
    private val listOfTicketData = arrayListOf(
        LabTicket(
            ticketId = 1,
            user = user_1,
            data = "6/11/2021 08:14 pm",
            address = "ElGiza",
            visaCredit = false,
            cash = true,
            amount = 300.00,
            type = "anything",
            providerBrief = "anyOne"
        ),
        LabTicket(
            ticketId = 2,
            user = user_2,
            data = "6/11/2021 07:10 pm",
            address = "الشرقية",
            visaCredit = true,
            cash = false,
            amount = 400.00,
            type = "Female",
            providerBrief = "provider test"
        ),
        LabTicket(
            ticketId = 3,
            user = user_3,
            data = "5/11/2021 05:10 am",
            address = "القاهرة",
            visaCredit = false,
            cash = true,
            amount = 700.00,
            type = "Female",
            providerBrief = "provider test three"
        ),
        LabTicket(
            ticketId = 4,
            user = user_4,
            data = "1/11/2021 02:18 am",
            address = "الفيوم",
            visaCredit = true,
            cash = false,
            amount = 100.00,
            type = "Male",
            providerBrief = "provider test Four"
        ),
        LabTicket(
            ticketId = 5,
            user = user_5,
            data = "29/10/2021 08:10 pm",
            address = "بني سويف",
            visaCredit = false,
            cash = true,
            amount = 280.00,
            type = "Male",
            providerBrief = "provider test Five"
        ),
    )

    suspend fun getAllTickets(): Response<List<LabTicket>> {
        delay(3000)
        return Response.success(listOfTicketData)
    }
}
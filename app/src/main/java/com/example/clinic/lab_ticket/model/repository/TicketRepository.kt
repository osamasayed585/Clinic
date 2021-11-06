package com.example.clinic.lab_ticket.model.repository

import com.example.clinic.lab_ticket.model.class_data.LabTicket
import retrofit2.Response

interface TicketRepository {

    suspend fun getAllTickets(): List<LabTicket>
}
package com.example.clinic.lab_ticket.model.repository

import com.example.clinic.lab_ticket.model.class_data.LabTicket
import com.example.clinic.lab_ticket.model.local.TicketData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TicketRepositoryImp: TicketRepository {

    override suspend fun getAllTickets() =
        withContext(Dispatchers.IO){
            TicketData.getAllTickets().body()!!
        }

}
package com.example.clinic.lab_ticket.model.class_data

data class LabTicket(
    val ticketId:Int,
    val user: User,
    val data: String,
    val address: String,
    val visaCredit: Boolean,
    val cash: Boolean,
    val amount: Double,
    val type: String,
    val providerBrief: String
)
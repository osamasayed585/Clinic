package com.example.clinic.model.repository

import com.example.clinic.model.data_class.Certificate
import com.example.clinic.model.data_class.Service
import retrofit2.Response

interface Repository {

    suspend fun getServices(): List<Service>

    suspend fun getCertificates(): List<Certificate>
}
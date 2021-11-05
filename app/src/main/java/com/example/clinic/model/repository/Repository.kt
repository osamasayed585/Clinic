package com.example.clinic.model.repository

import com.example.clinic.model.data_class.AppImage
import com.example.clinic.model.data_class.LabService

interface Repository {

    suspend fun getServices(): List<LabService>

    suspend fun getCertificates(): List<AppImage>
}
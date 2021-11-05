package com.example.clinic.model.repository

import com.example.clinic.model.local.TestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImp : Repository {

    override suspend fun getServices() =
        withContext(Dispatchers.IO) {
            TestData.getServices().body()!!
        }

    override suspend fun getCertificates() =
        withContext(Dispatchers.IO) {
            TestData.getCertificates().body()!!
        }
}
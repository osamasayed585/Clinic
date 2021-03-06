package com.example.clinic.ui.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.clinic.model.data_class.AppImage
import com.example.clinic.model.data_class.LabService
import com.example.clinic.model.repository.RemoteRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: RemoteRepositoryImp = RemoteRepositoryImp()

    private var _progressBarLoading = MutableLiveData<Boolean>()
    val progressBarLoading: LiveData<Boolean> = _progressBarLoading

    private var _servicesMutableLiveData = MutableLiveData<List<LabService>>()
    val servicesLiveData: LiveData<List<LabService>> = _servicesMutableLiveData

    private var _certificatesMutableLiveData = MutableLiveData<List<AppImage>>()
    val certificatesLiveData: LiveData<List<AppImage>> = _certificatesMutableLiveData


    fun getServices() {
        _progressBarLoading.value = true

        viewModelScope.launch {
            val result = repository.getServices()

            viewModelScope.launch(Dispatchers.Main) {
                _progressBarLoading.value = false
                _servicesMutableLiveData.value = result
            }
        }

    }

    fun getCertificates() {
        _progressBarLoading.value = true

        viewModelScope.launch {
            val result = repository.getCertificates()

            viewModelScope.launch(Dispatchers.Main) {
                _progressBarLoading.value = false
                _certificatesMutableLiveData.value = result
            }
        }

    }
}
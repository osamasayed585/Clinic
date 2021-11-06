package com.example.clinic.lab_ticket.ui.closed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.clinic.lab_ticket.model.class_data.LabTicket
import com.example.clinic.lab_ticket.model.repository.TicketRepositoryImp
import kotlinx.coroutines.launch

class ClosedViewModel(application: Application) : AndroidViewModel(application) {

    private var repositoryImp: TicketRepositoryImp = TicketRepositoryImp()

    private var _itemMutableLiveData = MutableLiveData<List<LabTicket>>()
    val itemMutableLiveData: LiveData<List<LabTicket>> get() = _itemMutableLiveData

    private var _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> get() = _progressBar

    fun getClosedTicket(){
        _progressBar.value = true
        viewModelScope.launch {

            val result = repositoryImp.getAllTickets()
            viewModelScope.launch {
                _progressBar.value = false
                _itemMutableLiveData.value = result
            }
        }
    }


}
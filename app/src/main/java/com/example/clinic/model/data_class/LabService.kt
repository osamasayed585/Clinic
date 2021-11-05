package com.example.clinic.model.data_class

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LabService(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("en_name")
    var nameEg: String,
    @Expose
    @SerializedName("ar_name")
    var nameAr: String,
    @Expose
    @SerializedName("service_price")
    var price: Double,
    @Expose
    @SerializedName("at_home")
    var homeVisits: Boolean,
)

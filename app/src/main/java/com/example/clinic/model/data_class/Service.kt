package com.example.clinic.model.data_class

class Service(){
    var id: Int? = null
    var nameEg: String? = null
    var nameAr: String? = null
    var price: Double? = null
    var reservation: Boolean? = null
    var homeVisits: Boolean? = null
    var homeServicePrice: Double? = null

    constructor(id: Int, nameEg: String, nameAr: String, price: Double, reservation: Boolean, homeVisits: Boolean, homeServicePrice: Double) : this() {
        this.id = id
        this.nameEg = nameEg
        this.nameAr = nameAr
        this.price = price
        this.reservation = reservation
        this.homeVisits = homeVisits
        this.homeServicePrice = homeServicePrice
    }

    constructor(id: Int, nameEg: String, nameAr: String, price: Double, reservation: Boolean, homeVisits: Boolean) : this() {
        this.id = id
        this.nameEg = nameEg
        this.nameAr = nameAr
        this.price = price
        this.reservation = reservation
        this.homeVisits = homeVisits
    }
}
package com.example.clinic.model.local

import com.example.clinic.model.data_class.AppImage
import com.example.clinic.model.data_class.LabService
import kotlinx.coroutines.delay
import retrofit2.Response

object TestData {

    private val listOfServiceItem = arrayListOf(
        LabService(
            1, "Home visits", "الزيارت المنزلية", 50.0,
            homeVisits = true,
        ),
        LabService(
            2, "Finding test results online", "معرفة نتائج التحاليل من خلال الإنترنت", 20.0,
            homeVisits = false,
        ),
        LabService(
            3,
            "Results delivery service to clients", "خدمة توصيل النتائج للعملاء", 30.0,
            homeVisits = true,
        ),
        LabService(
            4,
            "Newborn sampling service", "خدمة سحب عينات الأطفال حديثى الولادة", 70.0,
            homeVisits = true,
        ),

        LabService(
            4,
            "contract", "التعاقد", 1000.0,
            homeVisits = false,
        )
    )

    private val listOfCertificates = arrayListOf(
        AppImage(
            1,
            "https://img.freepik.com/free-vector/elegant-blue-gold-diploma-certificate-template_1017-17257.jpg?size=626&ext=jpg"
        ),
        AppImage(
            2,
            "https://media.istockphoto.com/vectors/certificate-vector-id910062090"
        ),
        AppImage(
            3,
            "https://m.media-amazon.com/images/I/71Qbs73yAYL._AC_SL1424_.jpg"
        ),
        AppImage(
            4,
            "https://static.vecteezy.com/system/resources/thumbnails/002/195/509/small/black-gold-certificate-design-template-free-vector.jpg"
        ),
        AppImage(
            5,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc5CGBk8wWXki_oC1JZPnc-FuNgRBQREBVEw&usqp=CAU"
        )
    )

    suspend fun getServices(): Response<List<LabService>> {
        delay(3000)
        return Response.success(listOfServiceItem)
    }

    suspend fun getCertificates(): Response<List<AppImage>>{
        delay(3000)
        return Response.success(listOfCertificates)
    }

}
package `in`.stc.myapplication
import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.*


interface excelapi {
    @GET("1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM/values/A1:C6")
    fun getData(@Query("key") key: String): Call<Model_Data>


    @POST("1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM/values:batchUpdate")
    fun createSheet(@Query("key") key: String, @Body req: Json4Kotlin_Base): Call<Model_Data>

}

//{
//    "requests": [
//    {
//        "addSheet": {
//        "properties": {
//        "title": "Status"
//    }
//    }
//    }
//    ],
//    "includeSpreadsheetInResponse": true
//}
//

//https://sheets.googleapis.com/v4/spreadsheets/1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM:batchUpdate?key=AIzaSyC7EeNPSz6lT8TyBiRjMYv4TmtFsE2opag
//https://sheets.googleapis.com/v4/spreadsheets/1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM:batchUpdate?key=[YOUR_API_KEY] HTTP/1.1



//https://sheets.googleapis.com/v4/spreadsheets/1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM:batchUpdate?key=[YOUR_API_KEY] HTTP/1.1
//https://sheets.googleapis.com/v4/spreadsheets/1FzpOuNO_DlHr3jBTKWtj-YG-4lEeGyp8bNUgLejMrJM:batchUpdate?key=AIzaSyC7EeNPSz6lT8TyBiRjMYv4TmtFsE2opag

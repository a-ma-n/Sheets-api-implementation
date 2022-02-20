package `in`.stc.myapplication

import com.google.gson.annotations.SerializedName

 data class BodyRequest(
     @SerializedName("requests") val requests:  List<MutableMap<String, MutableMap<String, MutableMap<String, String>>>>,
     @SerializedName("includeSpreadsheetInResponse") val includeResp: Boolean,
        )

// list(
//      as{
//          props{
//                  "title":"Status"

//                  }
//          } ,)

// {
//     "requests": [
//     {
//         "addSheet": {
//         "properties": {
//         "title": "Status"
//     }
//     }
//     }
//     ],
//     "includeSpreadsheetInResponse": true
// }
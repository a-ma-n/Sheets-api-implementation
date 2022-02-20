package `in`.stc.myapplication

import com.google.gson.annotations.SerializedName

data class Model_Data (
    @SerializedName("range") val range : String,
    @SerializedName("majorDimension") val majorDimension : String,
    @SerializedName("values") val values : MutableList<MutableList<String>>
)
package `in`.stc.myapplication

import AddSheet
import Json4Kotlin_Base
import Properties_req
import Requests_req
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    var apikey="APIKEY"
    val retroService = RetrofitInstance.getRetroInstance().create(excelapi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            perform()
            addSheet()
        }
    }

    private fun perform() {

        var model:Model_Data?
        var values:MutableList<MutableList<String>> = mutableListOf()
        retroService.getData(apikey).enqueue(object : Callback<Model_Data> {
            override fun onResponse(
                call: Call<Model_Data>,
                response: Response<Model_Data>,
            ) {
                Log.d("MainActivity,response:", response.body().toString())
                model= response.body()!!
                values= model!!.values
                Log.d("values", values!![0].toString())
                values = process(values)
                addSheet()
                //updateSheet()
            }
            override fun onFailure(call: Call<Model_Data>, t: Throwable) {
                Log.d(TAG, "onFailure: "+call+t.toString())
            }
        })

    }

    private fun updateSheet() {
        TODO("Not yet implemented")
    }

    private fun addSheet() {

        var prop =Properties_req("Status")
        var ads=AddSheet(prop)
        var reqs = Requests_req(ads)
        var jsb = Json4Kotlin_Base(listOf(reqs), true)

        Log.d(TAG, "addSheet: "+jsb)

        retroService.createSheet(apikey,jsb).enqueue(object : Callback<Model_Data> {
            override fun onResponse(
                call: Call<Model_Data>,
                response: Response<Model_Data>,
            ) {
                Log.d(TAG, "onResponse: "+call.toString()+"\n"+
                response.toString())
                Log.d("MainActivity,response:", response.body().toString())
//                updateSheet()
            }
            override fun onFailure(call: Call<Model_Data>, t: Throwable) {
                Log.d(TAG, "onFailure: "+call+t.toString())
            }
        })
    }

    private fun process(values: MutableList<MutableList<String>>):MutableList<MutableList<String>> {
        values.get(0).add("Status")
        for (i in 1..5){
            if(values.get(i).get(2).toInt() >=40){
                values?.get(i)?.add("Pass")
            }
            else{
                values?.get(i)?.add("Fail")
            }
        }

        Log.d(TAG, "onCreate: "+values)
        return values
    }
}
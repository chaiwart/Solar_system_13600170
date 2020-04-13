package th.ac.su.ict.chaiwart.application_solar_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.chaiwart.application_solar_system.Data.Solar
import th.ac.su.ict.chaiwart.application_solar_system.Data.SolarAdapter
import th.ac.su.ict.chaiwart.application_solar_system.Utils.getJsonDataFromAsset

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Solar> = ArrayList<Solar>()
    lateinit var arrayAdapter: ArrayAdapter<Solar>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"Solar_Data.json")

        Log.i("data",jsonFileString)

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Solar>>(){}.type

        var SolarList : ArrayList<Solar> = gson.fromJson(jsonFileString,listItemType)

        itemList = SolarList

        val adapter = SolarAdapter(this@MainActivity,itemList)

        listView.adapter = adapter


        listView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)    //ต้นทางไปปลายททาง
            intent.putExtra("StarName",itemList[position].StarName)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("distance",itemList[position].distance)



            startActivity(intent)   //ส่งค่า
        }


    }
}

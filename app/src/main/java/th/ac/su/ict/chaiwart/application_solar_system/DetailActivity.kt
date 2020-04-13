package th.ac.su.ict.chaiwart.application_solar_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item_solar.*
import kotlinx.android.synthetic.main.list_item_solar.tvsolarName
import kotlinx.android.synthetic.main.list_item_solar.tvdistance
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val StarName = intent.getStringExtra("StarName")
        val descripname = intent.getStringExtra("description")
        val imageFile = intent.getStringExtra("imageFile")
        val distancename = intent.getStringExtra("distancename")
        val translate = intent.getStringExtra("translate")




        tvsolarName.setText(StarName)
        tvdistance.setText(distancename)
        tvSolarDetail.setText(descripname)


        val res = resources
        val drawableId:Int = res.getIdentifier(imageFile,"drawable",packageName)

        imgView.setImageResource(drawableId)

    }
}
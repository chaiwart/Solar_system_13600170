package th.ac.su.ict.chaiwart.application_solar_system.Data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_solar.view.*
import th.ac.su.ict.chaiwart.application_solar_system.R

class SolarAdapter(private val  context: Context, private val dataSource: ArrayList<Solar>) : BaseAdapter(){


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_solar,null)

        rowView.tvDistance.text = dataSource[position].distance
        rowView.tvSolarName.text = dataSource[position].SolarName
        rowView.tvTranslate.text = dataSource[position].translate

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)


        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}
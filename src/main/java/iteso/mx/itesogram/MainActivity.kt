package iteso.mx.itesogram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseObject
import com.parse.ParseQuery
import iteso.mx.itesogram.adapter.AdapterName

class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val activityRecycler = findViewById<RecyclerView>(R.id.activity_recycler_rv)
        val query = ParseQuery.getQuery<ParseObject>("Feed")
        query.findInBackground { photos, e ->
            if (e == null) {
                //view.showPhotos(photos)
                activityRecycler.adapter = AdapterName(photos)
                activityRecycler.layoutManager = LinearLayoutManager(this)
            }
        }
    }




    /*val query: ParseQuery<ParseObject> = ParseQuery.getQuery("Feed")


    query.findInBackground{objects, e ->
        if(e == null){
            recyclerView.adapter = AdapterName(object)

        }
    }*/
}
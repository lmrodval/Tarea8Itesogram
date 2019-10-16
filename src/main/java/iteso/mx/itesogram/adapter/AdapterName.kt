package iteso.mx.itesogram.adapter

import com.parse.ParseFile
import com.parse.ParseObject
import iteso.mx.itesogram.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterName(private val users: List<ParseObject>): RecyclerView.Adapter<PhotoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(users[position])
    }

}

class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val userName: TextView = view.findViewById(R.id.item_title)
    private val coments: TextView = view.findViewById(R.id.item_comentarios)
    private val image: ImageView = view.findViewById(R.id.item_image)


    fun bind(user: ParseObject) {
        val parseFile: ParseFile = user.get("photo") as ParseFile
        Glide.with(view).load(parseFile.url).into(image)
        userName.text = user.get("username") as String
    }
}





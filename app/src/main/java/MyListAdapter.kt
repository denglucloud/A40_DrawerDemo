import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a40_drawerdemo.R
import kotlinx.android.synthetic.main.view_holder.view.*

/**
 * @author  DengLu
 * @date  2020/7/24 20:59
 * @version 1.0
 * @description :
 *
 */
class MyListAdapter : ListAdapter<Int, RecyclerView.ViewHolder>(callback) {
    object callback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //创建View,这里是一个fragment（R.layout.view_holder）
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false)
        //返回一个ViewHolder
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //使用ViewHolder
        holder.itemView.cellImageView.setImageResource(getItem(position))
    }


}
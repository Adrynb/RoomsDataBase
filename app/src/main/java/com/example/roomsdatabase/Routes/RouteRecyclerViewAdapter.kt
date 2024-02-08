package com.example.roomsdatabase.Routes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsdatabase.databinding.FragmentItemrouteBinding

class RouteRecyclerViewAdapter(
    private var values: MutableList<Route>
) : RecyclerView.Adapter<RouteRecyclerViewAdapter.ViewHolder>() {
    var editarClick: ((Int, Route) -> Unit)? = null
    var borrarClick: ((Int, Route) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemrouteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.idView.text = item.id.toString()
        holder.contentView.text = item.nombre
        holder.editarButton.setOnClickListener {
            editarClick?.invoke(position, item)
        }
        holder.borrarButton.setOnClickListener {
            borrarClick?.invoke(position, item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemrouteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.content
        val contentView: TextView = binding.content
        val editarButton: Button = binding.editar
        val borrarButton: Button = binding.borrar

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    fun setValues(values: MutableList<Route>) {
        this.values = values
        notifyDataSetChanged()
    }
}


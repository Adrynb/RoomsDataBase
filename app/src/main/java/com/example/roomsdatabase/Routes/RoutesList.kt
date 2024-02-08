package com.example.roomsdatabase.Routes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsdatabase.R
import com.example.roomsdatabase.databinding.FragmentRoutesListBinding


class RoutesList : Fragment() {

    private lateinit var binding: FragmentRoutesListBinding
    private val viewmodel: RouteViewModel by activityViewModels<RouteViewModel>()
    private var view: View? = null;
    var editar_click: ((Int, Route) -> Unit)? = null
    var borrar_click: ((Int, Route) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_routes_list, container, false)
        view?.findViewById<RecyclerView>(R.id.listado)!!?.layoutManager = GridLayoutManager(context, 0)
        view?.findViewById<RecyclerView>(R.id.listado)!!.adapter = this.viewmodel.routes.value?.let { RouteRecyclerViewAdapter(it.toMutableList()) }

        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RoutesList().apply {

                }
            }
    }

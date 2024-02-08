package com.example.roomsdatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.example.roomsdatabase.databinding.FragmentRouteBinding
import com.example.roomsdatabase.routes.RouteViewModel

class RouteFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private val viewModel: RouteViewModel by viewModels()

    private lateinit var binding: FragmentRouteBinding
    private var view: View? = null

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_route, container, false)
        binding.lifecycleOwner = this
        //binding.model = this.viewModel

        binding.floatingActionButton.setOnClickListener{
            // Se añade el fragmento de Instalacion y se selecciona el route.
        }

        binding.cancelar.setOnClickListener{
            val fm : FragmentManager = parentFragmentManager
            fm.popBackStack()
        }

        binding.aceptar.setOnClickListener{
            this.viewModel.save()
            val toast : Toast
            toast = Toast.makeText(this.activity, "Cliente Almacenado", Toast.LENGTH_SHORT)
            toast.show()
        }

        view = binding.root
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RouteFragment().apply {
                // Aquí puedes inicializar fragmento si es necesario
            }
    }
}

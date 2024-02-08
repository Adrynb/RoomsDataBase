package com.example.roomsdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.roomsdatabase.routes.RoutesList
import com.example.roomsdatabase.databinding.ActivityMainBinding
import com.example.roomsdatabase.routes.RouteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val routeViewModel : RouteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.routeViewModel.init(this)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.principal, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.routes -> {
                val fm = supportFragmentManager

                fm.commit {
                    replace(R.id.fragmentContainerView, RoutesList.newInstance())
                    addToBackStack("Rutas GPS")
                }
                return super.onOptionsItemSelected(item)
            }

            else-> {
                return super.onOptionsItemSelected(item)
            }
        }

    }
}
package com.example.bottomnavigationbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView_: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView_ = findViewById(R.id.bottomNavigationView)

        carregaFragment(Tela1Fragment())

        // Configuração do BottomNavigationView
        bottomNavigationView_.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    carregaFragment(Tela1Fragment())
                    true
                }

                R.id.ferramenta -> {
                    carregaFragment(Tela2Fragment())
                    true
                }

                R.id.cronograma -> {
                    carregaFragment(Tela3Fragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun carregaFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_TelaPrincipal, fragment)
            .commit()
    }
}
package com.example.fichachefapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.example.fichachefapp.adapter.AdapterPrincipal

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        // Configure o ViewPager2
        val adapter = AdapterPrincipal(requireActivity(), 2)
        viewPager.adapter = adapter

        // Sincronize o TabLayout e o ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        // Nome de usuário
        val textUsuario = view.findViewById<TextView>(R.id.text_usuario)
        val user = FirebaseAuth.getInstance().currentUser
        val userName = user?.displayName
        textUsuario.text = userName
    }
}
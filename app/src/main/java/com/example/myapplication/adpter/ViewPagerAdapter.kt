package com.example.myapplication.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(frm: FragmentManager) : FragmentPagerAdapter(
    frm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val listFragment = arrayListOf<Fragment>()
    private val listFragmentTitle = arrayListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {

        listFragment.add(fragment)
        listFragmentTitle.add(title)

    }

    override fun getItem(position: Int): Fragment = listFragment[position]

    override fun getPageTitle(position: Int): CharSequence? = listFragmentTitle[position]

    override fun getCount(): Int = listFragment.size

}
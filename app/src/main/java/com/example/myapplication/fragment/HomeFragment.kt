package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.presenter.PresenterHomeFragment
import kotlinx.android.synthetic.main.fragment_home_.*
import org.koin.android.ext.android.inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class

HomeFragment : Fragment() {

    private val presenter : PresenterHomeFragment by inject()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }








    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.oncreate()
    }

    fun getDataRecycleProduct(data : List<DataProduct>){
        home_fragment_recycle_new.initRecycler(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }

}
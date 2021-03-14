package com.example.myapplication.test

import com.example.myapplication.dataClass.DataProduct

class DataTest {

    companion object{
        fun  getDataRecycleProduct():List<DataProduct>{
            val array = arrayListOf<DataProduct>()
            for (item in 1..10){
                array.add(
                    DataProduct(
                    item,
                    "گوشی موبایل",
                    "https://s.mobile.ir/Static/cache/prd/38942-Galaxy_A21s_01_610_710.jpg",
                    "15000",
                    true,
                    "12000"
                )
                )
            }
            return array
        }
    }
}
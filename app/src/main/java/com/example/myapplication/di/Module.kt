package com.example.myapplication.di

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import com.example.myapplication.fragment.Acount_Fragment
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.fragment.Shop_Fragment
import com.example.myapplication.model.*
import com.example.myapplication.net.ApiService
import com.example.myapplication.presenter.PresenterHomeFragment
import com.example.myapplication.utility.PicasoUtility
import com.squareup.picasso.Picasso
import org.koin.dsl.module.module


val fragmentModules = module {
    single { HomeFragment() }
    single { Shop_Fragment() }
    single { Acount_Fragment() }
}

val modelModules = module {
    single { ModelMainActivity() }
    single { ModelHomeFragment() }
    single { ModelQuestionActivity() }
    single { ModelAboutMeActivity() }


}

val apiModules = module {
    single { Picasso.get()}
    single { ApiService()}
    single { PicasoUtility() }
}

val presenterModules = module {
}

val fragment = module {
    single { PresenterHomeFragment(get() as HomeFragment , get() as ModelHomeFragment) }
}


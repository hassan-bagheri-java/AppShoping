package com.example.myapplication.di

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import com.example.myapplication.fragment.*
import com.example.myapplication.model.*
import com.example.myapplication.net.ApiService
import com.example.myapplication.presenter.PresenterHomeFragment
import com.example.myapplication.presenter.PresenterLoginFragment
import com.example.myapplication.presenter.PresenterRegisterFragment
import com.example.myapplication.utility.PicasoUtility
import com.squareup.picasso.Picasso
import org.koin.dsl.module.module


val fragmentModules = module {
    single { HomeFragment() }
    single { Shop_Fragment() }
    single { Acount_Fragment() }
    factory { LoginFragment() }
    factory { RegisterFragment() }


}

val modelModules = module {
    single { ModelMainActivity() }
    single { ModelHomeFragment() }
    factory { ModelQuestionActivity() }
    factory { ModelAboutMeActivity() }
    factory { ModelLoginFragment() }
    factory { ModelRegisterFragment() }



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
    factory { PresenterLoginFragment(get() as LoginFragment, get() as ModelLoginFragment) }
    factory { PresenterRegisterFragment(get() as RegisterFragment, get() as ModelRegisterFragment) }
}


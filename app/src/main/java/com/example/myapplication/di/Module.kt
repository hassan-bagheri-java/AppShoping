package com.example.myapplication.di

import com.example.myapplication.fragment.Home_Fragment
import com.example.myapplication.model.ModelMainActivity
import org.koin.dsl.module.module


val fragmentModules = module {
    single { Home_Fragment() }
}

val modelModules = module {
    single { ModelMainActivity() }
}

val apiModules = module {
}

val presenterModules = module {
}

val fragment = module {
}


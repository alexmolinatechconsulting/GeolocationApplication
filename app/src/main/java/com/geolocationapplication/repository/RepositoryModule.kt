package com.geolocationapplication.repository

import org.koin.dsl.module

val RepositoryModule = module {
    single{GeolocationRepository(get(), get())}
}
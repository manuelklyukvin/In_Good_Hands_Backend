package manuelklyukvin.in_good_hands.post.di

import manuelklyukvin.in_good_hands.post.data_sources.PostDataSource
import manuelklyukvin.in_good_hands.post.repositories.PostRepository
import manuelklyukvin.in_good_hands.post.repositories.PostRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::PostDataSource)
    singleOf(::PostRepositoryImpl) bind PostRepository::class
}
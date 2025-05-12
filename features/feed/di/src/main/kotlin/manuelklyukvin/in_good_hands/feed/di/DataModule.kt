package manuelklyukvin.in_good_hands.feed.di

import manuelklyukvin.in_good_hands.feed.data_sources.FeedPostDataSource
import manuelklyukvin.in_good_hands.feed.repositories.FeedPostRepository
import manuelklyukvin.in_good_hands.feed.repositories.FeedPostRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::FeedPostDataSource)
    singleOf(::FeedPostRepositoryImpl) bind FeedPostRepository::class
}
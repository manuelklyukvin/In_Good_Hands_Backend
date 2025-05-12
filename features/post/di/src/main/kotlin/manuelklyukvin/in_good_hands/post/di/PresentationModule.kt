package manuelklyukvin.in_good_hands.post.di

import manuelklyukvin.in_good_hands.post.mappers.PostMapper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val presentationModule = module { singleOf(::PostMapper) }
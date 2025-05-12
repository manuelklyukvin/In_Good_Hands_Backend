package manuelklyukvin.in_good_hands.feed.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import manuelklyukvin.in_good_hands.feed.models.toPresentation
import manuelklyukvin.in_good_hands.feed.use_cases.GetFeedPageUseCase
import org.koin.ktor.ext.inject

internal fun Route.getFeedPageRoute() {
    val getFeedPageUseCase by inject<GetFeedPageUseCase>()

    get("page") {
        val postCount = call.parameters.getOrFail<Int>("post_count")
        val currentPage = call.parameters.getOrFail<Int>("current_page")
        val languageId = call.parameters.getOrFail<Int>("language_id")
        val searchQuery = call.parameters["search_query"]

        val feedPage = getFeedPageUseCase(
            postCount = postCount,
            currentPage = currentPage,
            languageId = languageId,
            searchQuery = searchQuery
        ).toPresentation()
        call.respond(feedPage)
    }
}
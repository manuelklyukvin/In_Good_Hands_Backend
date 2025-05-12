package manuelklyukvin.in_good_hands.post.mappers

import manuelklyukvin.in_good_hands.post.models.DomainPost
import manuelklyukvin.in_good_hands.post.models.PresentationPet
import manuelklyukvin.in_good_hands.post.models.PresentationPost
import manuelklyukvin.in_good_hands.post.models.PresentationUser
import manuelklyukvin.in_good_hands.post.use_cases.FormatAddressUseCase

class PostMapper(private val formatAddressUseCase: FormatAddressUseCase) {
    fun toPresentation(domainPost: DomainPost?) = domainPost?.let {
        PresentationPost(
            id = domainPost.id,
            imageNames = domainPost.imageNames,
            user = PresentationUser(
                id = domainPost.user.id,
                avatarName = domainPost.user.avatarName,
                name = domainPost.user.name
            ),
            title = domainPost.title,
            description = domainPost.description,
            pet = PresentationPet(
                nickname = domainPost.pet.nickname,
                typeId = domainPost.pet.typeId,
                genderId = domainPost.pet.genderId,
                ageId = domainPost.pet.ageId,
                breed = domainPost.pet.breed
            ),
            address = formatAddressUseCase(domainPost.address),
            publicationDate = domainPost.publicationDate.toString()
        )
    }
}
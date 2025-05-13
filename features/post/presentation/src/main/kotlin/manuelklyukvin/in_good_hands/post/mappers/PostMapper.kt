package manuelklyukvin.in_good_hands.post.mappers

import manuelklyukvin.in_good_hands.post.models.DomainPost
import manuelklyukvin.in_good_hands.post.models.PresentationPet
import manuelklyukvin.in_good_hands.post.models.PresentationPost
import manuelklyukvin.in_good_hands.post.models.PresentationUser
import manuelklyukvin.in_good_hands.post.use_cases.FormatAddressUseCase

class PostMapper(private val formatAddressUseCase: FormatAddressUseCase) {
    fun toPresentation(domainPost: DomainPost?) = domainPost?.let {
        with(domainPost) {
            PresentationPost(
                id = id,
                imageNames = imageNames,
                user = PresentationUser(
                    id = user.id,
                    avatarName = user.avatarName,
                    name = user.name
                ),
                title = title,
                description = description,
                pet = PresentationPet(
                    nickname = pet.nickname,
                    typeId = pet.typeId,
                    genderId = pet.genderId,
                    ageId = pet.ageId,
                    breed = pet.breed
                ),
                address = formatAddressUseCase(address),
                publicationDate = publicationDate.toString()
            )
        }
    }
}
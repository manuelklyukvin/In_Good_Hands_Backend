package manuelklyukvin.in_good_hands.core.tables.posts

import manuelklyukvin.in_good_hands.core.tables.addresses.Cities
import manuelklyukvin.in_good_hands.core.tables.pets.Pets
import manuelklyukvin.in_good_hands.core.tables.users.Users
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object Posts : Table("posts") {
    val id = long("id").uniqueIndex().autoIncrement()
    val userId = reference("user_id", Users.id)
    val statusId = reference("status_id", PostStatuses.id).default(0)
    val title = varchar("title", 255).index()
    val description = text("description").nullable()
    val petId = reference("pet_id", Pets.id)
    val cityId = reference("city_id", Cities.id)
    val publicationDate = timestamp("publication_date").index()

    override val primaryKey = PrimaryKey(id)
}
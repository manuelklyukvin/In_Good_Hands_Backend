package manuelklyukvin.in_good_hands.core.tables.addresses

import org.jetbrains.exposed.sql.Table

object Regions : Table("regions") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val countryId = reference("country_id", Countries.id)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
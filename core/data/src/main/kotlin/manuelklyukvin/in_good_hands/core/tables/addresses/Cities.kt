package manuelklyukvin.in_good_hands.core.tables.addresses

import org.jetbrains.exposed.sql.Table

object Cities : Table("cities") {
    val id = long("id").uniqueIndex().autoIncrement()
    val regionId = reference("region_id", Regions.id)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
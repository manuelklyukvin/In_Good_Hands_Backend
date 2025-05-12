package manuelklyukvin.in_good_hands.core.tables.addresses

import manuelklyukvin.in_good_hands.core.tables.languages.Languages
import org.jetbrains.exposed.sql.Table

object RegionTranslations : Table("region_translations") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val regionId = reference("region_id", Regions.id)
    val languageId = reference("language_id", Languages.id)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
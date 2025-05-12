package manuelklyukvin.in_good_hands.core.tables.addresses

import manuelklyukvin.in_good_hands.core.tables.languages.Languages
import org.jetbrains.exposed.sql.Table

object CityTranslations : Table("city_translations") {
    val id = long("id").uniqueIndex().autoIncrement()
    val cityId = reference("city_id", Cities.id)
    val languageId = reference("language_id", Languages.id)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
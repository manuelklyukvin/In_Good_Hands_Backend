package manuelklyukvin.in_good_hands.core.tables.addresses

import manuelklyukvin.in_good_hands.core.tables.languages.Languages
import org.jetbrains.exposed.sql.Table

object CountryTranslations : Table("country_translations") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val countryId = reference("country_id", Countries.id)
    val languageId = reference("language_id", Languages.id)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
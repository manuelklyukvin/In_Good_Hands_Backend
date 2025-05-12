package manuelklyukvin.in_good_hands.core.tables.languages

import org.jetbrains.exposed.sql.Table

object Languages : Table("languages") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", 32).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
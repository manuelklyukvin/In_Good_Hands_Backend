package manuelklyukvin.in_good_hands.core.tables.addresses

import org.jetbrains.exposed.sql.Table

object Countries : Table("countries") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
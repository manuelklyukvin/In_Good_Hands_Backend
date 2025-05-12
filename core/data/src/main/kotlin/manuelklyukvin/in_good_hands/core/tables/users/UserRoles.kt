package manuelklyukvin.in_good_hands.core.tables.users

import org.jetbrains.exposed.sql.Table

object UserRoles : Table("user_roles") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", 32).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
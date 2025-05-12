package manuelklyukvin.in_good_hands.core.tables.posts

import org.jetbrains.exposed.sql.Table

object PostStatuses : Table("post_statuses") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", 32).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
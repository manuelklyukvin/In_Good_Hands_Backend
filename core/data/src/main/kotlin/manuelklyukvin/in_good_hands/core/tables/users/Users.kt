package manuelklyukvin.in_good_hands.core.tables.users

import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val id = long("id").uniqueIndex().autoIncrement()
    val roleId = reference("role_id", UserRoles.id).default(0)
    val avatarName = varchar("avatar_name", 255).nullable()
    val email = varchar("email", 255).uniqueIndex()
    val phoneNumber = varchar("phone_number", 32)
    val passwordHash = varchar("password_hash", 255)
    val name = varchar("name", 32)

    override val primaryKey = PrimaryKey(id)
}
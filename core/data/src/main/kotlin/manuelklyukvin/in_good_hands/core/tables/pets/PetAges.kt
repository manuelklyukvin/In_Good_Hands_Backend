package manuelklyukvin.in_good_hands.core.tables.pets

import org.jetbrains.exposed.sql.Table

object PetAges : Table("pet_ages") {
    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", 32).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
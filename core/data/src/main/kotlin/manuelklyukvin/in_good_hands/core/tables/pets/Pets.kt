package manuelklyukvin.in_good_hands.core.tables.pets

import org.jetbrains.exposed.sql.Table

object Pets : Table("pets") {
    val id = long("id").uniqueIndex().autoIncrement()
    val nickname = varchar("nickname", 32).nullable()
    val typeId = reference("type_id", PetTypes.id).default(0)
    val genderId = reference("gender_id", PetGenders.id).default(0)
    val ageId = reference("age_id", PetAges.id).default(0)
    val breed = varchar("breed", 64).nullable().index()

    override val primaryKey = PrimaryKey(id)
}
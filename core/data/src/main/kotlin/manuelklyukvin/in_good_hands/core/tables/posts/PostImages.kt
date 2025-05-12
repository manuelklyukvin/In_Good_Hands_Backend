package manuelklyukvin.in_good_hands.core.tables.posts

import org.jetbrains.exposed.sql.Table

object PostImages : Table("post_images") {
    val id = long("id").uniqueIndex().autoIncrement()
    val postId = reference("post_id", Posts.id)
    val imageName = varchar("image_name", 255).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
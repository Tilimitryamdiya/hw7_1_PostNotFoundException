fun main() {
    val post1 = Post(
        ownerId = 1,
        date = 100922,
        text = "first post",
        friendsOnly = true,
        likes = Likes(count = 1),
        copyright = null,
        postSource = null,
        geo = Geo("Home", "12.34.56"),
        donut = null
    )

    val post2 = Post(
        text = "second post",
        date = 101022,
        likes = Likes(count = 10),
        copyright = null,
        postSource = PostSource("vk", "android", "profilePhoto", "url"),
        geo = null,
        donut = null
    )

    WallService.add(post1)
    WallService.add(post2)

    val newPost2 = Post(
        id = post2.id,
        text = "New text",
        date = 111022,
        copyright = null,
        postSource = PostSource("vk", "android", "profilePhoto", "url"),
        geo = null,
        donut = null,
        attachment = arrayOf(
            PhotoAttachment(Photo(0, width = 1, height = 2)),
            AudioAttachment(Audio(1, title = "song")),
            GiftAttachment(Gift(3, "gift"))
        )
    )

    WallService.update(newPost2)

//    WallService.print()

    println(WallService.createComment(1, Comment(23)))
    println(WallService.createComment(4, Comment(56)))

}

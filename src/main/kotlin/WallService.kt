object WallService {
    private var posts = emptyArray<Post>()
    private var idCounter = 1

    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        val postForComment = findPostById(postId) ?: throw PostNotFoundException("No post with $postId")
        comments += comment
        return comments.last()
    }

    private fun findPostById(postId: Int): Post? {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                return post
            }
        }
        return null
    }

    fun add(post: Post): Post {
        post.id = idCounter
        posts += post
        idCounter++
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        val (id) = newPost
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(
                    fromId = newPost.fromId,
                    createdBy = newPost.createdBy,
                    text = newPost.text,
                    replyOwnerId = newPost.replyOwnerId,
                    replyPostId = newPost.replyPostId,
                    friendsOnly = newPost.friendsOnly,
                    comments = newPost.comments,
                    copyright = newPost.copyright,
                    likes = newPost.likes,
                    reposts = newPost.reposts,
                    views = newPost.views,
                    postType = newPost.postType,
                    postSource = newPost.postSource,
                    geo = newPost.geo,
                    signerId = newPost.signerId,
                    copyHistory = newPost.copyHistory,
                    canPin = newPost.canPin,
                    canDelete = newPost.canDelete,
                    canEdit = newPost.canEdit,
                    isPinned = newPost.isPinned,
                    markedAsAds = newPost.markedAsAds,
                    isFavorite = newPost.isFavorite,
                    donut = newPost.donut,
                    postponedId = newPost.postponedId,
                    attachment = newPost.attachment
                )
                return true
            }
        }
        return false
    }

    fun print() {
        for (post in posts) {
            println(post)
        }
        println()
    }
}

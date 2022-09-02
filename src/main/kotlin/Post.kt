data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comment = Comment(),
    val copyright: Copyright?,
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "default",
    val postSource: PostSource?,
    val geo: Geo?,
    val signerId: Int = 0,
    val copyHistory: Array<Reposts> = emptyArray(),
    val canPin: Boolean = false,
    val canDelete: Int = 0,
    val canEdit: Int = 0,
    val isPinned: Int = 0,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut?,
    val postponedId: Int = 0,
    val attachment: Array<Attachment> = emptyArray()
)

data class Comment(
    var count: Int = 0,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = false,
    var canClose: Boolean = false,
    var canOpen: Boolean = false
)

class Copyright(
    val id: Int = 0,
    val link: String,
    val name: String,
    val type: String
)

class Likes(
    count: Int = 0,
    var userLikes: Boolean = false,
    var canLike: Boolean = true,
    var canPublish: Boolean = false
) {
    var count: Int = count
        set(value) {
            if (value < 0) {
                return
            }
            field = value
        }
}

class Reposts(
    val count: Int = 0,
    val user_reposted: Boolean = false
)

class Views(val count: Int = 0)

class PostSource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)

class Geo(
    val type: String,
    val coordinates: String,
    val place: Place = Place()
)

class Place(
    val id: Int = 0,
    val title: String = "default",
    val latitude: Int = 0,
    val longitude: Int = 0,
    val created: Int = 0,
    val icon: String = "default",
    val checkins: Int = 0,
    val updated: Int = 0,
    val type: Int = 0,
    val country: Int = 0,
    val city: Int = 0,
    val address: String = "default"
)

class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: String,
    val canPublishFreeCopy: Boolean,
    val edit_mode: String
)

data class Photo(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "default",
    val date: Int = 0,
    val sizes: Array<Sizes> = emptyArray(),
    val width: Int = 0,
    val height: Int = 0
)

data class Sizes(
    val type: String = "default",
    val url: String = "url",
    val width: Int = 0,
    val height: Int = 0
)

data class Audio(
    val id: Int,
    val ownerId: Int = 0,
    val artist: String = "default",
    val title: String = "default",
    val duration: Int = 0,
    val url: String = "default",
    val lyricsId: Int = 0,
    val albumId: Int = 0,
    val genreId: Int = 0,
    val date: Int = 0,
    val noSearch: Boolean = false,
    val isHq: Boolean = false
)

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String,
    val description: String = "default",
    val duration: Int = 0,
    val image: Array<Image> = emptyArray(),
    val firstFrame: Array<FirstFrame>,
    val date: Int = 0,
    val addingDate: Int = 0,
    val views: Int = 0,
    val localViews: Int = 0,
    val comments: Int = 0,
    val player: String = "default",
    val platform: String = "default",
    val canAdd: Boolean = false,
    val isPrivate: Boolean = false,
    val accessKey: String = "default",
    val processing: Int = 0,
    val isFavorite: Boolean = false,
    val canComment: Boolean = false,
    val canEdit: Boolean = false,
    val canLike: Boolean = false,
    val canRepost: Boolean = false,
    val canSubscribe: Boolean = false
)

data class Image(
    val height: Int = 0,
    val url: String = "default",
    val width: Int = 0,
    val withPadding: Boolean = false
)

data class FirstFrame(
    val height: Int = 0,
    val url: String = "default",
    val width: Int = 0
)

data class Link(
    val url: String,
    val title: String = "default",
    val caption: String = "default",
    val description: String = "default",
    val photo: Photo = Photo(),
    val product: Product = Product(),
    val previewPage: String = "default",
    val previewUrl: String = "default"
)

data class Product(
    val price: Int = 0
)

data class Gift(
    val id: Int = 0,
    val thumb256: String = "default",
    val thumb96: String = "default",
    val thumb48: String = "default",
)

interface Attachment {
    val type: String
}

data class PhotoAttachment(val photo: Photo) : Attachment {
    override val type: String = "photo"
}

data class AudioAttachment(val audio: Audio) : Attachment {
    override val type: String = "audio"
}

data class VideoAttachment(val audio: Video) : Attachment {
    override val type: String = "video"
}

data class LinkAttachment(val link: Link) : Attachment {
    override val type: String = "link"
}

data class GiftAttachment(val gift: Gift) : Attachment {
    override val type: String = "gift"
}
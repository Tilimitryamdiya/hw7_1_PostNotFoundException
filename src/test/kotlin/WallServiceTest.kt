import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class WallServiceTest {

    @Test
    fun add() {
        val testPost = Post(
            text = "test",
            date = 101010,
            copyright = null,
            postSource = null,
            geo = null,
            donut = null
        )

        WallService.add(testPost)
        val result = testPost.id
        assertNotEquals(0, result)
    }

    @Test
    fun updateIdIsFound() {
        val post = Post(
            text = "test",
            date = 101010,
            copyright = null,
            postSource = null,
            geo = null,
            donut = null
        )

        WallService.add(post)

        val post1 = Post(
            id = post.id,
            text = "test",
            date = 111010,
            copyright = null,
            postSource = null,
            geo = null,
            donut = null
        )

        val result = WallService.update(post1)
        assertEquals(true, result)
    }

    @Test
    fun updateIdNotFound() {
        val post = Post(
            text = "test",
            date = 101010,
            copyright = null,
            postSource = null,
            geo = null,
            donut = null
        )


        WallService.add(post)

        val post1 = Post(
            id = 0,
            text = "test",
            date = 111010,
            copyright = null,
            postSource = null,
            geo = null,
            donut = null
        )

        val result = WallService.update(post1)
        assertEquals(false, result)
    }
}
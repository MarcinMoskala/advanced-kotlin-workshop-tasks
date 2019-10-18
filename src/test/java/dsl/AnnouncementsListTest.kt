package dsl

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@Suppress("FunctionName")
class AnnouncementsListTest {

    @Test
    fun `Reminders have title "Remember!"`() {
        val (r1, _, _, r2, _) = getAnnouncements("", "")
        assertEquals(r1.title, "Remember!")
        assertEquals(r2.title, "Remember!")
    }

    @Test
    fun `Info without title fills it with null`() {
        val (_, _, _, _, info) = getAnnouncements("", "")
        assertNull(info.title)
    }

    @Test
    fun `Whole announcements list is interpreted correctly`() {
        val actual = getAnnouncements("passing", "internships")
        val expected = listOf(
                Announcement("Remember!", "If you want to receive internship, you need to provide documents till end of September"),
                Announcement("Students who are passing:", "passing"),
                Announcement("Internships:", "internships"),
                Announcement("Remember!", "Work hard whole year and prepare to all classes"),
                Announcement(null, "Checking this app periodically will help you be up to date with your university")
        )
        assertEquals(expected, actual)
    }
}
package dsl

fun getAnnouncements(passingStudentsListText: String, bestStudentsListText: String): List<Announcement> = TODO()
//        announcements {
//            reminder("If you want to receive internship, you need to provide documents till end of September")
//            info {
//                title = "Students who are passing:"
//                content = passingStudentsListText
//            }
//            info {
//                title = "Internships:"
//                content = bestStudentsListText
//            }
//            reminder("Work hard whole year and prepare to all classes")
//            info {
//                content = "Checking this app periodically will help you be up to date with your university"
//            }
//        }

data class Announcement(
    val title: String?,
    val text: String
)
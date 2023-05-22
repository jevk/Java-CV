package program

import structs.CV
import javax.swing.JTextArea
import java.util.Locale
import java.util.ResourceBundle
import structs.Details
import structs.Degree
import structs.Experience

abstract class Information {
    private var lang: String? = null
    fun getCV(cv: CV, detail: JTextArea, strength: JTextArea, degree: JTextArea, course: JTextArea, experience: JTextArea, itSkills: JTextArea, languages: JTextArea, hobbies: JTextArea, positions: JTextArea, referees: JTextArea) {
        lang = cv.LOCALE
        val l = Locale(lang)
        val r = ResourceBundle.getBundle("Bundle_$lang", l)
        val details = cv.details
        detail.text = ""
        detail.append("""${r.getString("name")} ${details.name}
""")
        detail.append("""${r.getString("address")} ${details.address}
""")
        detail.append("""${r.getString("town")} ${details.town}, ${details.zip}
""")
        detail.append("""${r.getString("phone")} ${details.phone}
""")
        detail.append("""${r.getString("email")} ${details.email}
""")
        if (details.other.isNotEmpty()) detail.append("Other: " + details.other)
        val strengths = cv.strengths
        strength.text = ""
        for (i in strengths.indices) {
            if (strengths[i] != null) {
                strength.append("""
    ${strengths[i]}
    
    """.trimIndent())
            }
        }
        val degrees = cv.degrees
        degree.text = ""
        for (i in degrees.indices) {
            if (degrees[i] != null) {
                val deg = degrees[i]
                degree.append("""
    ${deg!!.school}
    
    """.trimIndent())
                degree.append("""
    ${deg.education}, ${deg.degree}
    
    """.trimIndent())
                degree.append("""${deg.startYear} - ${deg.endYear}

""")
            }
        }
        val courses = cv.courses
        course.text = ""
        for (i in courses.indices) {
            if (courses[i] != null) {
                course.append("""
    ${courses[i]}
    
    """.trimIndent())
            }
        }
        val exps = cv.experience
        experience.text = ""
        for (i in exps.indices) {
            if (exps[i] != null) {
                val exp = exps[i]
                experience.append("""
    ${exp!!.workplace}
    
    """.trimIndent())
                experience.append("""
    ${exp.job}
    
    """.trimIndent())
                experience.append("""
    ${exp.jobtitle}
    
    """.trimIndent())
                experience.append("""
    ${exp.length}
    
    
    """.trimIndent())
            }
        }
        val it = cv.itSkills
        itSkills.text = ""
        for (i in it.indices) {
            if (it[i] != null) {
                itSkills.append("""
    ${it[i]}
    
    """.trimIndent())
            }
        }
        val lang = cv.langs
        languages.text = ""
        for (i in lang.indices) {
            if (lang[i] != null) {
                if (lang[i]!!.nativeLang) {
                    languages.append("""
    ${lang[i]!!.langName}:
    
    """.trimIndent())
                    languages.append("""
    - ${r.getString("speech")}:${r.getString("native")}
    
    """.trimIndent())
                    languages.append("""
    - ${r.getString("written")}:${r.getString("native")}
    
    
    """.trimIndent())
                } else {
                    languages.append("""
    ${lang[i]!!.langName}:
    
    """.trimIndent())
                    languages.append("""
    - ${r.getString("speech")}:${lang[i]!!.spoken}
    
    """.trimIndent())
                    languages.append("""
    - ${r.getString("written")}:${lang[i]!!.written}
    
    
    """.trimIndent())
                }
            }
        }
        val hobby = cv.hobbies
        hobbies.text = ""
        for (i in hobby.indices) {
            if (hobby[i] != null) {
                hobbies.append("""
    ${hobby[i]}
    
    """.trimIndent())
            }
        }
        val position = cv.positions
        positions.text = ""
        for (i in position.indices) {
            if (position[i] != null) {
                positions.append("""
    ${position[i]}
    
    """.trimIndent())
            }
        }
        val referee = cv.referees
        referees.text = ""
        for (i in referee.indices) {
            if (referee[i] != null) {
                referees.append("""
    ${referee[i]}
    
    """.trimIndent())
            }
        }
    }
}
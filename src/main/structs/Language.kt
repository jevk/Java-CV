package structs

class Language {
    @JvmField
    var langName: String
    @JvmField
    var spoken: String
    @JvmField
    var written: String
    @JvmField
    var nativeLang: Boolean

    constructor(langName: String, spoken: String, written: String, nativeLang: Boolean) {
        this.langName = langName
        this.spoken = spoken
        this.written = written
        this.nativeLang = nativeLang
    }

    constructor() {
        langName = ""
        spoken = ""
        written = ""
        nativeLang = false
    }
}
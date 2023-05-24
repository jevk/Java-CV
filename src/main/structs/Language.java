package structs;

public class Language {
    public String langName;
    public String spoken;
    public String written;
    public boolean nativeLang;

    public Language(String langName, String spoken, String written, boolean nativeLang) {
        this.langName = langName;
        this.spoken = spoken;
        this.written = written;
        this.nativeLang = nativeLang;
    }
    public Language() {
        this.langName = "";
        this.spoken = "";
        this.written = "";
        this.nativeLang = false;
    }
}
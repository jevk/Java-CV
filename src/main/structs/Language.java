package structs;

// Literally just a struct for the languages
public class Language {
    // Store the language name
    public String langName;
    // Store the spoken skill level
    public String spoken;
    // Store the written skill level
    public String written;
    // Store whether the language is the user's native language or not
    public boolean nativeLang;

    // Constructors
    public Language() {
        // Initialize variables
        this.langName = "";
        this.spoken = "";
        this.written = "";
        this.nativeLang = false;
    }
}
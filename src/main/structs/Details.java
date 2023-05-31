package structs;

public class Details {
    // Variable declarations
    // Store the user's name
    public String name;
    // Store the user's address
    public String address;
    // Store the user's zip code
    public String zip;
    // Store the user's town
    public String town;
    // Store the user's phone number
    public String phone;
    // Store the user's email
    public String email;
    // Store any other information the user wants to add (such as a website)
    public String other;

    // Constructors
    public Details() {
        // Initialize variables
        this.name = "";
        this.address = "";
        this.zip = "";
        this.town = "";
        this.phone = "";
        this.email = "";
        this.other = "";
    }
}
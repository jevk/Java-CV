package structs;

public class Details {
	// Variable declarations
	private String name;
	private String address;
	private String zip;
	private String town;
	private String phone;
	private String email;
	
	// Constructors
	public Details() {
		this.name = "";
		this.address = "";
		this.zip = "";
		this.town = "";
		this.phone = "";
		this.email = "";
	}
	public Details(String name, String address, int zip, String town, int phone, String email) {
		this.name = name;
		this.address = address;
		this.zip = Integer.toString(zip);
		this.town = town;
		this.phone = Integer.toString(phone);
		this.email = email;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

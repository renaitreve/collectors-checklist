
// The name Item was chosen for this class as it accurately represents
// the relationship this class has with the main class, being the class responsible for
// forming an item that can be found in the main checklist. A singular name was chosen over
// the plural "Items", as this class is responsible for storing information about only one item
// rather than collecting information on many items. 

// This is one of the two classes included as required by the specifications, 
// where this class has a 0-to-many relationship with the main class, as a checklist
// can have no items on it, or have many items on it.

// This class does not contain the main method as it is not the main application class. 

public class Item {

	// The following object member variables and arrays are declared in the class
	// as they are used in multiple methods throughout the class, and are made
	// private as only this class is assigned to modify the values of the object member
	// variables located in this class rather than different classes.

	// The identifier names and the data types selected can be justified by the use
	// of these same names and data types in the main program.

	private String itemName;
	private int yearReleased;
	private int itemPrice;
	private boolean isObtained;

	// The constructor was named Item to align with the class of the
	// same name as there is no other choice without causing
	// an error in the code.

	// This constructor has no return statement as it is primarily used in the
	// initialisation of the object member variables and arrays declared above.

	// These parameters were chosen as they are referred back to in the main
	// application class, allowing for values taken in this class to be accessed by 
	// the main application class through subsequent methods.

	public Item(String itemName, int yearReleased, int itemPrice, boolean isObtained) {
		this.itemName = itemName;
		this.yearReleased = yearReleased;
		this.itemPrice = itemPrice;
		this.isObtained = isObtained;
	}

	// These subsequent methods were necessary as they allow for private object
	// member variables to be accessed and modified by the other class through 
	// the use of public get and set methods, all of which are named according to convention, 
	// where the variable name is preceded by 'get' or 'set' depending on the method's function.

	// This is to ensure that the main application cannot modify these object member
	// variables unless allowed to do so by this class.
	// These methods also abide by specification in that they do not directly
	// interact with the user, all of which is done by the main application program.

	// The get methods are not a void, but rather returns a value depending on the
	// data type in question, and thus requires a return value. This is to ensure that 
	// the information needed from this class can be accessed by the main application program.

	// The set methods are void methods and thus requires no return statement as it
	// doesn't return a value. This is to ensure that the information obtained from the main
	// application class can be used to edit the respective value in this class.

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getYearReleased() {
		return this.yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public int getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public boolean getIsObtained() {
		return this.isObtained;
	}

	public void setIsObtained(boolean isObtained) {
		this.isObtained = isObtained;

	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// sample-data.csv file sources: 

// C. Woods, "Barbie dolls now worth a fortune." Familyminded.com.
// https://www.familyminded.com/s/priciest-barbie-dolls-ranked-8254998d4cb64b5b
// (accessed Oct. 8, 2020).

// Barbie, "1970s dolls." Barbie.Mattel.com.
// https://barbie.mattel.com/shop/en-us/ba/1970s-barbie-dolls
// (accessed Oct. 8, 2020).

// Invaluable, "The guide to vintage Barbie dolls." Invaluable.com.
// https://www.invaluable.com/blog/vintage-barbie-dolls/
// (accessed Oct. 8, 2020).

// The name CollectorChecklist was chosen for this class as it accurately represents
// the program's function, where the user can create a list of items
// they are collecting and "check" them off as they obtain them, and was chosen
// over a more non-specific name like "Checklist" or "itemChecklist".

// This is one of the two classes included as the code would not run without it, 
// and serves as the class that interacts with the user. 

public class CollectorChecklist {

	// The following object member variables and arrays are declared in the class
	// as they are used in multiple methods throughout the program.
	// This is to ensure that the right variable/array can be referred to in the off
	// chance that there are similarly named variables/arrays in individual methods,
	// and the wrong value won't be overwritten.

	// The general justification for the use of int data types are as follows:

	// The int data type was used over a double or a float because whole numbers are
	// being stored over decimal numbers (which double and float are best used for).
	// Because the quantity of items (which determine the length of the arrays),
	// the price of the items, counting the amount of obtained items,
	// the year the item was released, the value which is used to navigate
	// arrays to find a matching value are typically and more appropriately stored
	// as whole numbers, the int data type was used.

	// This justification applies for the following int type variables:
	// maxNumItems, currentNumItems,countObtained, foundIndex, itemPrice,
	// yearReleased, i

	// The int data type was chosen over String data type, a
	// non-primitive data type, because Strings are best suited for storing
	// a sequence of characters, not solely numbers.

	// The general justification for the use of String data types and String type
	// arrays are as follows:

	// The String data type was chosen over numerical data types (like int or
	// double) because they are best fit to store inputs comprising of characters
	// like both letters and numbers, and are not solely a true/false statement
	// (which would be covered by booleans). Because item names, inputs in text
	// fields, and obtaining a row from the table yield a collection of characters,
	// the String data type was used.

	// This justification applies for the following String type variables:
	// itemInput, itemName, selectedRow, searchItemName, searchTerm

	// Similarly, the String type array was used over a normal String variable
	// it contains a series of characters when taken from the table
	// to be split and then parsed into their respective data forms.

	// This justification applies for the following String type arrays: itemDetails

	// The general justification for the use of boolean data type are as follows:

	// The boolean data type was chosen to store related information about whether
	// an item has been obtained or not because it is a true or false/yes or no statement,
	// meaning that the String data type or a numerical data type like int or double
	// would not be appropriate.

	// This justification applies for the following boolean data type variable:
	// isObtained, searchObtained, changeObtained

	// The identifier name 'gtMain' was chosen over another identifier name like
	// itemSheet as it is the primary window where most of the program's functions
	// occur, and is also an appropriate identifier for indicating that it is invoking
	// GTerm functions.

	// This justification applies for all instances where "this.gtMain" is called.

	private GTerm gtMain;

	// The identifier name 'gtEdit' was chosen over another identifier name like
	// editScreen as it is a secondary window where users can edit the information
	// inputed into the table, and is also an appropriate identifier for indicating
	// that it is invoking GTerm functions.

	// This justification applies for all instances where "this.gtEdit" is called.

	private GTerm gtEdit;

	// The identifier name 'gtAward' was chosen over another identifier name like
	// completedStatus as it is a tertiary window that pops up to show an "award"
	// for completing the checklist, which can be shared (by taking a photo or
	// screenshot), and is also an appropriate identifier for indicating that it is
	// invoking GTerm functions.

	// This justification applies for all instances where "this.gtAward" is called.

	private GTerm gtAward;

	// The identifier name 'maxNumItems' was chosen over another identifier name 
	// like maxNumberOfItems to be more concise, as well as to indicate that this is 
	// the value which determines the maximum number of items that can be stored 
	// by the program at any one time.

	// This justification applies for all instances where "this.maxNumItems" is called.

	private int maxNumItems;

	// The identifier name 'currentNumItems' was chosen over another identifier name 
	// like CurrentNumberOfItems to be more concise, as well as to indicate that this is 
	// the value which reflects how many items have been inputed into the program so far

	// This justification applies for all instances where "this.currentNumItems" is called

	private int currentNumItems;

	// The identifier name 'countObtained' was chosen over another identifier name like obtainedNumber 
	// because this variable counts how many items have been listed as obtained in the checklist.

	// This justification applies for all instances where "this.countObtained" is called

	private int countObtained;

	// The Item datatype was chosen for this array as it refers back to the Item class, which contains
	// the details related to one of the items on the checklist. It was made into 
	// an array type because there are multiple 'items' whose details need to be store in the checklist,
	// and it was named accordingly.

	private Item[] items;

	// The constructor was named CollectorChecklist to align with the class of the same name 
	// as there is no other choice without causing an error in the code.
	// This constructor has no return statement as it is primarily used in the initialisation
	// of the object member variables and arrays declared above.

	// As a constructor was a requirement for the criteria, the program could not be
	// formed without one.

	public CollectorChecklist() {

		this.gtMain = new GTerm(970, 590);

		// gtEdit and gtAward are given null values rather than GTerm windows in the
		// constructor unlike gtMain as these two windows do not need to be open
		// when the program is first run and only when the methods that require those
		// windows are called upon later on.

		this.gtEdit = null;
		this.gtAward = null;

		// maxNumItems was chosen to determine the length of the arrays/ over currentNumItems 
		// as it better reflects how many items can be inputed into the program in the future 
		// rather than how many/ items are currently present in the program. A purposefully low number
		// for maxNumItems was chosen as upcoming code will make it so that/ the length of the arrays
		// are determined by how many inputs are needed by the user rather than being hard-coded.

		this.maxNumItems = 5;
		this.currentNumItems = 0;

		this.items = new Item[this.maxNumItems];

		this.gtMain.setXY(30, 20);
		this.gtMain.setBackgroundColor(117, 184, 255);
		this.gtMain.setFontSize(25);
		this.gtMain.setFontColor(255, 255, 255);
		this.gtMain.println("BELLE'S COLLECTOR'S CHECKLIST");
		this.gtMain.println("");
		this.gtMain.setFontSize(12);
		this.gtMain.setFontColor(0, 0, 0);
		this.gtMain.setFontColor(255, 255, 255);
		this.gtMain.addTextField("", 470);
		this.gtMain.setFontColor(0, 0, 0);
		this.gtMain.addButton("Add item", this, "addItemFromEntry");
		this.gtMain.addButton("Load item list", this, "loadList");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.addTable(705, 300, "Item\tYear Released\tPrice\tObtained?");
		this.gtMain.addButton("Edit selected item", this, "editSelectedItem");
		this.gtMain.setXY(735, 150);
		this.gtMain.addButton("Remove selected item", this, "removeSelectedItem");
		this.gtMain.setXY(735, 190);
		this.gtMain.addButton("Save item list", this, "saveList");
		this.gtMain.setXY(735, 215);
		this.gtMain.addButton("Save item list as...", this, "saveAsList");
		this.gtMain.setXY(735, 255);
		this.gtMain.addButton("Search exact item name", this, "exactSearchItemNameFromEntry");
		this.gtMain.setXY(735, 280);
		this.gtMain.addButton("Search partial item name", this, "partialSearchItemNameFromEntry");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.setXY(30, 450);
		this.gtMain.addButton("Show unobtained items", this, "showUnobtainedItems");
		this.gtMain.addButton("Show obtained items", this, "showObtainedItems");
		this.gtMain.addButton("Show checklist", this, "refreshTable");
		this.gtMain.addButton("Check off selected item", this, "checkOffSelectedItem");
		this.gtMain.setFontColor(255, 255, 255);
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.println(
				"-----------------------------------------------------------------------------------------------------");
		this.gtMain.println("");
		this.gtMain.setXY(90, 530);
		this.gtMain.addTextField(this.countObtained + "", 60);
		this.gtMain.setXY(160, 530);
		this.gtMain.addTextField("", 280);
		this.gtMain.setFontColor(0, 0, 0);
		this.gtMain.setXY(440, 530);
		this.gtMain.addButton("Have you collected them all?", this, "countCollectedItems");

	}

	// This method was created out of necessity, as it is invoked by a button
	// made for adding items into the table in the main window.

	// This method was named "addItemFromEntry" as it better reflects its
	// function as the first instance where participants are added into the table 
	// from the text field in the main window.

	// As this is a void method, it has no return statement as it doesn't return a value.

	// The above justification can be applied to subsequent void methods.

	public void addItemFromEntry() {

		// itemInput was initialised and declared in this code block as it is
		// specific only to this code block rather than being referred to elsewhere.

		// The name 'itemInput' was used over another name like itemDetails
		// because the string refers to information being inputed for the first time,
		// and to distinguish it from when the information is being placed into the
		// array, and also when it is being called back on when selecting a row from a table.

		// The above justification can be applied for subsequent uses of itemInput.

		String itemInput = this.gtMain.getTextFromEntry(0);
		this.gtMain.setTextInEntry(0, "");

		// The logic of the following if statements is as follows:

		// If there is information in the text field, then the rest of the code will run.
		
		// If the text field is blank, an error message will show prompting the user to
		// input information into the text field. This is because there/ needs to be information 
		// in the text field for it to be included into a table.

		// This if statement was placed here to act as a check on the entry (or lack
		// thereof) before progressing further.

		if (itemInput != null) {

			// The name 'itemDetails' was used over another name like itemInput because 
			// it distinguishes the input from the array of information
			// that comes from splitting the initial input to place into the table.

			// The above justification can be applied for subsequent uses of itemDetails.

			String itemDetails[] = itemInput.split(",");

			// The logic of the following if statement is as follows:

			// If the string array has a length that is not equal to four (that is, the
			// input did not have all four components of the item name, year released, item
			// price and whether the item has been obtained or not) then it will trigger an error message.

			// This if statement was placed here, near the start of the code block, to act
			// as a check on the entry before running the rest of the code

			if (itemDetails.length != 4) {
				this.gtMain.showErrorDialog(
						"Please input item details in the form of item name,year released,item price, obtained?");
			}

			// The identifier name 'itemName' was chosen over a different name like
			// 'nameOfItem' or simply 'Name' to be more accurate to what the String 
			// is storing and to be more concise.

			// The above justification can be referred to when itemName is used in subsequent methods.

			String itemName = itemDetails[0];

			// The identifier name 'foundIndex' was chosen as it is the number returned from
			// the getItemIndexByName method, which refers to whether an item could be found
			// with the same item name.

			// The above justification can be referred to when foundIndex is used in
			// subsequent methods.

			// The method 'getItemIndexByName' was invoked here rather repeating the
			// code that is contained in the method, where i acts as a point of reference
			// using the item name to identify which element in the array is being edited.

			// The above justification can also be used in other instances where
			// the getItemIndexByName method is invoked.

			int foundIndex = getItemIndexByName(itemName);

			// The logic of the following if statement is as follows:

			// If there is no matching name determined in the getItemIndexByName method,
			// foundIndex will return a value that is less than 0, which will thus cause the
			// information to be inputed into the table as a row and then added into the arrays
			// through the addParticipant methods.

			// If foundIndex returns with a match, a value greater than 0 is given, meaning
			// that an error message will be triggered.
			// This check was added to make sure that duplicate names are not inputed into
			// the table via the main entry.

			if (foundIndex < 0) {

				// The identifier name 'yearReleased' was chosen over another name like
				// yearObtained or yearPublished because it refers to when the item itself
				// was available to be purchased widely.

				// The above justification can be referred to when yearReleased is used in
				// subsequent methods.

				int yearReleased = Integer.parseInt(itemDetails[1]);

				// The logic of the following if statement is as follows:

				// If the yearReleased value is a negative number or is a year over 2020,
				// then an error dialogue will play to input a different year. This is because
				// a year cannot be negative, nor can an item be released in the future.
				// Otherwise, the rest of the code will run.

				if (yearReleased <= 0 || yearReleased > 2020) {
					this.gtMain.showErrorDialog(
							"The inputted year is invalid! Please input a year before 2020, and not a negative number.");

				} else {

					// The identifier name 'itemPrice' was chosen over another name like
					// priceOfTheItem because it refers to how much the item would cost
					// to obtain, and is more concise than other alternatives.

					// The above justification can be referred to when itemPrice is used in
					// subsequent methods.

					// The use of temporary strings like the below example were excluded for brevity
					// unless specified otherwise:

					// String priceTemp = itemDetails[2];
					// int itemPrice = Integer.parseInt(pricetemp);

					// Instead, the string input received from the user or from the table was parsed
					// directly and consequently stored as an int value.

					// The above justification about temporary strings is applicable to other int
					// and boolean variables that are parsed and stored directly from a string.

					int itemPrice = Integer.parseInt(itemDetails[2]);

					// The logic of the following if statement is as follows:

					// If itemPrice is below zero, then an error dialogue will play.
					// This is because an item's monetary value would not make sense to be below
					// zero. Otherwise, the rest of the code will run.

					if (itemPrice <= 0) {
						this.gtMain
								.showErrorDialog("Item prices cannot be negative! Please input a positive item price.");

					} else {

						boolean isObtained = Boolean.parseBoolean(itemDetails[3]);

						// The method 'addItem' was invoked here rather repeating the code that
						// is contained in the method, where a new participant is being added to the table/array if
						// their name does not match with existing names in the table.

						// The parameters from that method are also used here, which allows for inputs
						// of the same data type from this method (which are also similarly named
						// for consistency) to be used in the function.

						// The above justification is applicable for subsequent uses of addItem.

						addItem(itemName, yearReleased, itemPrice, isObtained);

						// The method 'refreshTable' was invoked here rather repeating the code that is
						// contained in the method, where all of the information currently contained in
						// the arrays are represented as rows in the table.

						// The above justification is applicable for subsequent uses of refreshTable.

						refreshTable();
					}
				}

			} else
				this.gtMain.showErrorDialog("There's already an item named " + itemName + ".");
		} else
			this.gtMain.showErrorDialog(
					"Please input item details in the form of item name,year released,item price, obtained?");
	}

	// This method was created to reduce repetition of code when an item's information is added 
	// into the items array.
	// The parameters were chosen as they are all of the data types relevant to
	// information present in the Item class.

	// The name 'addItem' was used because it still describes the function of the method 
	// without confusing it with the other adding method, where items are added in
	// initially rather than being added or adjusted via the edit functions.

	// These parameters were chosen as they are the variables and data types that
	// are used in other methods, as well as the data types used in the Item class.

	public void addItem(String itemName, int yearReleased, int itemPrice, boolean isObtained) {

		int foundIndex = getItemIndexByName(itemName);

		// The logic of the following if statement is as follows:
		
		// If there is no matching name determined in the getItemIndexByName method,
		// foundIndex will return a value that is less than 0, which will thus cause the
		// information (obtained in the method in which addItem is invoked)
		// that matches the data type of the parameters to be placed into the items
		// array.
		// If there is a matching name, an error message will play indicating that there
		// was a matching name.

		if (foundIndex < 0) {

			this.items[this.currentNumItems] = new Item(itemName, yearReleased, itemPrice, isObtained);
			this.currentNumItems += 1;

			// This logic of this while statement is as follows:

			// As currentNumItems refers to how many elements are currently
			// in the array, and maxNumItems refers to how many elements
			// the array can contain, when currentNumItems starts to become
			// greater than or equal to maxRaffleParticipants in length, then
			// maxNumItems will increase incrementally until it is larger
			// than currentNumItems, doubling the existing size of the current array each
			// time.

			while (this.currentNumItems >= this.maxNumItems) {
				this.maxNumItems *= 2;

				// The "longer" array is declared and initialised only in this code block
				// as they are only pertinent to when the current items array is being placed
				// into an array with a larger length to accommodate for more entries.
				// This name was chosen as it refers to being an array with
				// more space to hold both past and future inputs.

				Item longerItems[] = new Item[this.maxNumItems];

				// The logic of the following while statement is as follows:

				// As i increases by 1 from 0, the older value at position i from the previous
				// array (represented by currentNumItems) is
				// copied into the new array, moving one spot each time.
				// When i exceed the currentNumItems, the loop stops as there is no longer
				// any previous values to copy into a new array.

				// This while loop was added as the specifications that the length of the array
				// expands dynamically, accommodating for as many inputs as the user needs
				// by copying older values into newer arrays with a longer length.

				// 'i' was chosen as the identifier name as it is easy to recognise in its
				// function as a variable that can be used to traverse through arrays using
				// a specific point of reference.

				// The above justification can also be applied in other instances where 'i'
				// is used as the variable to navigate arrays in other methods.

				int i = 0;
				while (i < this.currentNumItems) {
					longerItems[i] = this.items[i];
					i += 1;
				}

				// This assignment statement was included to re-use
				// the name of the older array for the newer, longer array
				// so it can be referred to in other methods.

				this.items = longerItems;
			}

		} else
			this.gtMain.showErrorDialog("There's already an item named " + itemName + ".");

	}

	// This method created out of necessity, as it is invoked by a button
	// made for editing inputs was created in the constructor.
	// This method was named "editSelectedItem" as it better reflects its
	// function as being responsible for editing the information about an item
	// selected in the table.

	public void editSelectedItem() {

		// 'SelectedRow' was declared and assigned in their respective methods
		// as the value of 'selectedRow' could change between methods
		// rather than being a consistent value that is referred to throughout.

		// The name "selectedRow" was used because it reflects how a row is selected
		// from a table, and is a more concise way of saying "selectedItemDetails"

		// The logic of the following if statement is as follows:

		// If the selected row in the table does contain information within it, the rest
		// of the statement will run. If there is no row selected, an error message will run.

		// This is because an item's details can't be edited if no item
		// is selected in the first place.

		// This if statement was placed near the start of the code block to act as a
		// check on the input before proceeding with the rest of the code.

		// This above justification can be applied to future instances where selectedRow
		// is used when selecting a row from a table, and the logic of the if statement
		// in the variable's use when acting as a check.

		String selectedRow = this.gtMain.getSelectedRowFromTable(0);
		if (selectedRow != null) {

			// The logic of the nested if statement is as follows:

			// If there is an existing window of gtEdit open, it will close it. This is to
			// make sure there won't be duplicate editing windows open to confuse users as
			// to which item is being adjusted.

			if (this.gtEdit != null)
				this.gtEdit.close();

			// This window was initialised here formally as this window only needs to be
			// open when this method is invoked rather than being open from the start of the
			// program.

			this.gtEdit = new GTerm(400, 270);
			this.gtEdit.setBackgroundColor(81, 136, 219);
			String[] itemDetails = selectedRow.split("\t");
			String itemName = itemDetails[0];
			int i = getItemIndexByName(itemName);

			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.setFontSize(30);
			this.gtEdit.setXY(28, 20);
			this.gtEdit.println("BELLE'S ITEM EDITOR");

			this.gtEdit.setFontSize(12);
			this.gtEdit.println("");

			this.gtEdit.setXY(95, 80);

			// The following text fields are pre-filled with the values at position i,
			// which are obtained using get methods from the Item class. This was added
			// so it's easy to reference which element is being adjusted.

			this.gtEdit.addTextField(this.items[i].getItemName(), 100);
			this.gtEdit.println(" - Item");

			this.gtEdit.addTextField("" + this.items[i].getYearReleased(), 100);
			this.gtEdit.println(" - Year released");

			this.gtEdit.addTextField("" + this.items[i].getItemPrice(), 100);
			this.gtEdit.println(" - Item price");

			this.gtEdit.addTextField("" + this.items[i].getIsObtained(), 100);
			this.gtEdit.println(" - Obtained?");

			this.gtEdit.println("");
			this.gtEdit.println("");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.setXY(145, 210);
			this.gtEdit.addButton("Update", this, "updateItem");

		} else
			this.gtMain.showErrorDialog("Please select an item to edit!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for updating the item in the edit window.

	// This method was named "updateItem" as it better reflects its
	// function as being responsible for updating the information
	// of the item selected in the table.

	public void updateItem() {

		String itemName = this.gtEdit.getTextFromEntry(0);

		// These subsequent if statements were included to act as a check on the
		// inputs as the user must input details correctly before the rest of the code
		// proceeds, and was thus placed near the start of the code block.

		// The logic of the following if statement is as follows:

		// If the item name is not left blank, then the rest of the code will play.
		// Otherwise, an error message will play informing the user to input an item
		// name. This is because the most "identifying" and unique aspect of the item
		// is the name.

		if (!itemName.isBlank()) {

			int yearReleased = Integer.parseInt(this.gtEdit.getTextFromEntry(1));

			// The logic of the following if statement is as follows:

			// If the year released is not a negative number or is under or equal to 2020,
			// then the rest of the code will play. Otherwise, an error message will play
			// informing the user to input a valid year. This is because a year cannot
			// be a negative number, or be a year in the future.

			if (yearReleased > 0 & yearReleased <= 2020) {

				int itemPrice = Integer.parseInt(this.gtEdit.getTextFromEntry(2));

				// The logic of the following if statement is as follows:

				// If the item price is not a negative number, then the rest of the code will
				// play.
				// Otherwise, an error message will play informing the user to input a positive
				// number.
				// This is because the price of an item cannot be below zero.

				if (itemPrice > 0) {

					boolean isObtained = Boolean.parseBoolean(this.gtEdit.getTextFromEntry(3));

					int i = getItemIndexByName(itemName);

					// The logic of the following if statement is as follows:

					// If there is an item with a matching name as determined in the
					// getItemIndexByName method,
					// 'i' will have a value that is greater or equal to 0.

					// The array value that is in i will then updated according to the values taken
					// from the text fields above.

					// If there is no matching name, then a new item will be added with that name
					// in the array.

					if (i >= 0) {

						// The values at position i are updated by using the set methods from the
						// Item class.

						this.items[i].setItemName(itemName);
						this.items[i].setYearReleased(yearReleased);
						this.items[i].setItemPrice(itemPrice);
						this.items[i].setIsObtained(isObtained);

					} else

						// The method 'addItem' was invoked here rather repeating the code that is
						// contained in the method, where a new item is being added to the table/array 
						// if their name does not match any existing item names in the table.

						addItem(itemName, yearReleased, itemPrice, isObtained);

					refreshTable();

				} else
					this.gtMain.showErrorDialog("Item prices cannot be negative! Please input a positive item price.");

			} else
				this.gtMain.showErrorDialog(
						"The inputted year is invalid! Please input a year before 2020, and not a negative number.");

		} else
			this.gtMain.showErrorDialog("The name cannot be left blank! Please input a name.");

	}

	// This method created out of necessity, as it is invoked by a button
	// made for removing an item that is selected from the table/the array.

	// This method was named "removeSelectedItem" as it better reflects
	// how the method gives the illusion that it is removing an item from the table
	// and is more intuitive to users than saying "overwriteSelectedItem"

	public void removeSelectedItem() {
		String selectedRow = this.gtMain.getSelectedRowFromTable(0);
		if (selectedRow != null) {
			String itemDetails[] = selectedRow.split("\t");

			String itemName = itemDetails[0];
			int i = getItemIndexByName(itemName);

			// The logic of the following if statement and while statement is as follows:

			// If there is a matching name, as determined by running the itemName through
			// the getItemIndexByName method, i will be assigned a value greater than
			// or equal to 0, which is the position from which the while statement can then
			// proceed, moving the values succeeding position i into position i's place.

			// This is represented by the +1s next to the arrays.
			
			// As i can increase by 1 until the while loop is satisfied, a -1 was added
			// next to currentNumItems so that it doesn't reach values that are too far into the array.

			if (i >= 0) {
				while (i < this.currentNumItems - 1) {

					this.items[i] = this.items[i + 1];

					i += 1;
				}

				// As an element was overwritten, 1 was subtracted from the current number of
				// items to reflect this.

				this.currentNumItems -= 1;
				refreshTable();
			}

		} else
			this.gtMain.showErrorDialog("Please select an item to remove!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for loading a .txt or .csv file to place inputs into the array.
	// This function was also a requirement in the specifications, and this method
	// was thus added to facilitate this function.

	// This method was named "loadList" as it better reflects the function of the
	// method, as it seems as if a list filled with items and their details are being loaded
	// onto the problem.

	public void loadList() {

		// The following try and catch exceptions were added to account for errors that
		// may occur when using the BufferedReader to read a .txt/.csv file, where an error
		// message will be displayed if something goes wrong when the file is being read.

		try {

			// The identifier name "inputFile" was chosen over "fileItems" as it represents
			// how the inputs going into the arrays are coming from a file loaded in by the user
			// rather than from manual inputting them in from a text field.

			BufferedReader inputFile = new BufferedReader(new FileReader(this.gtMain.getFilePath()));
			String itemInput = inputFile.readLine();

			// The logic of the following while statement is as follows:

			// If the itemInput that comes from reading lines from the file is not blank,
			// then the details of the item are added into the array using the addItem method,
			// and will continue to read each line until there are no more lines left.
			// The table is then refreshed, showing the new values in the array represented
			// on the table.

			while (itemInput != null) {

				String[] itemDetails = itemInput.split(",");

				String itemName = itemDetails[0];
				int yearReleased = Integer.parseInt(itemDetails[1]);
				int itemPrice = Integer.parseInt(itemDetails[2]);
				boolean isObtained = Boolean.parseBoolean(itemDetails[3]);
				addItem(itemName, yearReleased, itemPrice, isObtained);
				itemInput = inputFile.readLine();

			}

			inputFile.close();

		} catch (Exception e) {
			this.gtMain.showErrorDialog("Something went wrong when opening the file.");
		}

		refreshTable();
	}

	// This method created out of necessity, as it is invoked by a button
	// made for saving a .txt or .csv file containing the current information
	// located in the arrays. This function was also a requirement in the specifications,
	// and this method was thus added to facilitate this function.

	// This method was named "saveList" as it better reflects the function of the
	// method, as it saves a list (in the form of a .txt or .csv file) of the items that are
	// currently in the program. This method is also slightly distinguished from its "saveAs"
	// counterpart, as saving a list using this method gives a pre-coded file name and type,
	// which is saved in the program's folder.

	public void saveList() {

		// The following try and catch exceptions were added to account for errors that
		// may occur when using the BufferedWriter to write a .txt/.csv file, where an error
		// message will be displayed if something goes wrong when the file is being saved.

		// This justification can also be applied to the "saveAsList" method, as they
		// are functionally the same.

		try {

			// The identifier name "outputFile" was chosen over "itemsToSave" as it
			// represents how the information from the arrays are being outputed and saved as a file.

			// This justification can also be applied to subsequent uses of outputFile.

			BufferedWriter outputFile = new BufferedWriter(new FileWriter("checklist.csv"));

			int i = 0;

			// The logic of the following while and if statement is as follows:

			// While i is lower than the amount of items currently in the checklist,
			// the information currently in the items array at position i is saved onto
			// the file, where i incrementally increases by 1 to traverse the arrays and
			// saves item details until there are no more items to save.

			// This justification can also be applied to the "saveAsList" method, as they
			// are functionally the same.

			while (i < this.currentNumItems) {

				String itemDetails = this.items[i].getItemName() + "," + this.items[i].getYearReleased() + ","
						+ this.items[i].getItemPrice() + "," + this.items[i].getIsObtained();

				outputFile.write(itemDetails + "\n");
				i += 1;

			}

			outputFile.close();

		} catch (Exception e) {

			this.gtMain.showErrorDialog("Something went wrong when saving the file.");

		}

	}

	// This method created out of necessity, as it is invoked by a button
	// made for saving a .txt or .csv file containing the current information
	// located in the arrays. This function was also a requirement in the specifications,
	// and this method was thus added to facilitate this function.

	// This method was named "saveAsList" as it better reflects the function of the
	// method, as it saves a list (in the form of a .txt or .csv file) of the items that are
	// currently in the program while giving the user the option to name and save the file
	// what they like and wherever they choose.

	public void saveAsList() {

		try {

			BufferedWriter outputFile = new BufferedWriter(new FileWriter(this.gtMain.setFilePath()));

			int i = 0;
			while (i < this.currentNumItems) {

				String itemDetails = this.items[i].getItemName() + "," + this.items[i].getYearReleased() + ","
						+ this.items[i].getItemPrice() + "," + this.items[i].getIsObtained();

				outputFile.write(itemDetails + "\n");
				i += 1;

			}

			outputFile.close();

		} catch (Exception e) {

			this.gtMain.showErrorDialog("Something went wrong when saving the file.");

		}

	}

	// This method was created primarily to reduce duplication of code,
	// as it works to find the position of the array elements
	// the user wants to edit, remove, add into newer arrays etc.

	// The identifier name 'getItemIndexByName' was chosen over another name
	// like getItemName as it more accurately reflects how it's not getting
	// any one name specifically, but where an item and their details are located
	// in the array as determined by their name.

	// The searchItemName parameter was chosen as it best refers to how the name
	// of the item is the most unique, identifying part of the item, as multiple
	// items can be released in any one year, and items can have similar prices.

	public int getItemIndexByName(String searchItemName) {

		int foundIndex = 0;

		// The logic of the following while and if statement is as follows:

		// The loop will continue to traverse through the array through the value
		// of foundIndex as it increases by one because the loop hasn't yet exceeded
		// the number of current items in the checklist nor has it found
		// a match for the name being searched.

		// The loop will stop once a match is found, or alternatively if foundIndex
		// exceeds the amount of current items in the checklist, in which case
		// there was no match, and a value of -1 is given.

		while ((foundIndex < this.currentNumItems)
				&& (this.items[foundIndex].getItemName().compareToIgnoreCase(searchItemName) != 0))
			foundIndex += 1;

		if (foundIndex >= this.currentNumItems)
			foundIndex = -1;

		// As this method is not a void, but rather returns an int value
		// in the form of "foundIndex", a return value was necessary.

		return foundIndex;

	}

	// This method created out of necessity, as it is invoked by a button
	// made for doing an exact search for an item based on their name.

	// This method was named "exactSearchItemNameFromEntry" as it better reflects
	// how a user can input a name in the text field from the same text field
	// where item details were entered, as well as this method being used to
	// contrast with the partial search method.

	public void exactSearchItemNameFromEntry() {

		// searchTerm was declared and initialised only in this code block as it is
		// only relevant and used in this code block.

		// searchTerm was the identifier name used to distinguish over 'searchItemName',
		// as searchTerm is the input contained in the text field, which is a temporary string 
		// that is to be checked before being parsed into searchItemName.

		// This justification can also be applied to other instances where searchTerm
		// is used.

		String searchTerm = this.gtMain.getTextFromEntry(0);

		// The logic of the following if statement is as follows:

		// if the searchTerm string is blank and contains no value, then an error
		// message will be triggered.
		// This was included so that the rest of the code will only run if there is an
		// name that is to be searched, acting as a check on the input.

		// This is also the reason why the if statement was placed near the start of the
		// code block.

		if (!searchTerm.isBlank()) {
			String searchItemName = searchTerm;
			this.gtMain.setTextInEntry(0, "");
			int i = getItemIndexByName(searchItemName);

			// If there is an item with a matching name as determined in the
			// getItemIndexByName method, i will have a value that is greater or equal
			// to 0.

			// The array values that is in position i will then be displayed in the first
			// row of the table by using the get methods for each data type
			// from the Item class.

			// If there is no matching name, then an error message will appear that says
			// there is no matching name before refreshing the table.

			if (i >= 0) {

				this.gtMain.clearRowsOfTable(0);
				String itemDetails = this.items[i].getItemName() + "\t" + this.items[i].getYearReleased() + "\t"
						+ this.items[i].getItemPrice() + "\t" + this.items[i].getIsObtained();
				this.gtMain.addRowToTable(0, itemDetails);

			} else {
				this.gtMain.showErrorDialog("There's no item with the name " + searchItemName + ".");
				refreshTable();
			}
		} else
			this.gtMain.showErrorDialog("Please input a search term!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for doing an partial search for an item based on their name.

	// This method was named "partialSearchItemNameFromEntry" as it better reflects
	// how a user can input a name in the text field from the same text field
	// where item details were entered, as well as this method being used to
	// contrast with the exact search method.

	public void partialSearchItemNameFromEntry() {

		String searchTerm = this.gtMain.getTextFromEntry(0);

		if (!searchTerm.isBlank()) {

			this.gtMain.setTextInEntry(0, "");
			this.gtMain.clearRowsOfTable(0);

			int i = 0;

			// The logic of the following while and if statement is as follows:

			// While i is lower than the amount of items currently in the checklist,
			// the items that contain the name listed in the searchTerm will be obtained
			// using the get methods from the Item class and printed on the table.
			// i incrementally increases by 1 to traverse the arrays and print relevant
			// details until there are no more items to print.

			while (i < this.currentNumItems) {
				if (this.items[i].getItemName().contains(searchTerm)) {

					String itemDetails = this.items[i].getItemName() + "\t" + this.items[i].getYearReleased() + "\t"
							+ this.items[i].getItemPrice() + "\t" + this.items[i].getIsObtained();
					this.gtMain.addRowToTable(0, itemDetails);

				}

				i += 1;
			}

		} else
			this.gtMain.showErrorDialog("Please input a search term!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for filtering out items that have not been obtained.

	// This method was named "showUnobtainedItems" as it better reflects
	// how the user will be shown only the unobtained items in the checklist,
	// which was contrasted with the method which will show the obtained items.

	public void showUnobtainedItems() {

		// The logic of the following if statement is as follows:

		// If currentNumItems is greater than 0, then the rest of the code will play.
		// Otherwise, an error message will play telling the user to input an item into
		// the table. This is because there is nothing to filter in the table.

		if (this.currentNumItems > 0) {

			this.gtMain.setTextInEntry(0, "false");
			String searchTerm = this.gtMain.getTextFromEntry(0);
			this.gtMain.setTextInEntry(0, "");

			// searchObtained was declared and initialised only in this code block as it is
			// only relevant and used in this code block.

			// searchObtained was the identifier name used to distinguish over 'searchTerm',
			// as searchTerm is/ the input contained in the text field, which is a temporary string 
			// that is to be checked before being parsed into searchObtained.

			// This justification can be applied to future instances where searchObtained is used.

			Boolean searchObtained = Boolean.parseBoolean(searchTerm);
			this.gtMain.clearRowsOfTable(0);

			// The logic of the following while and if statement is as follows:

			// While i is lower than the amount of items currently in the checklist,
			// the items which are marked as 'false', which was pre-typed in
			// in the main text field, will be obtained using the get methods from the Item class
			// and printed on the table.
			// i incrementally increases by 1 to traverse the arrays and print relevant
			// details until there are no more items to print.

			int i = 0;
			while (i < this.currentNumItems) {
				if (this.items[i].getIsObtained() == searchObtained) {

					String itemDetails = this.items[i].getItemName() + "\t" + this.items[i].getYearReleased() + "\t"
							+ this.items[i].getItemPrice() + "\t" + this.items[i].getIsObtained();
					this.gtMain.addRowToTable(0, itemDetails);
				}

				i += 1;
			}

		} else
			this.gtMain.showErrorDialog("Please have at least one item inputted into the table!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for filtering out items that have been obtained.

	// This method was named "showObtainedItems" as it better reflects
	// how the user will be shown only the obtained items in the checklist,
	// which was contrasted with the method which will show the unobtained items.

	public void showObtainedItems() {

		// The logic of the following if statement is as follows:

		// If currentNumItems is greater than 0, then the rest of the code will play.
		// Otherwise, an error message will play telling the user to input an item into
		// the table. This is because there is nothing to filter in the table.

		if (this.currentNumItems > 0) {

			this.gtMain.setTextInEntry(0, "true");
			String searchTerm = this.gtMain.getTextFromEntry(0);
			this.gtMain.setTextInEntry(0, "");
			Boolean searchObtained = Boolean.parseBoolean(searchTerm);
			this.gtMain.clearRowsOfTable(0);

			// The logic of the following while and if statement is as follows:

			// While i is lower than the amount of items currently in the checklist,
			// the items which are marked as 'true', which was pre-typed in
			// in the main text field, will be obtained
			// using the get methods from the Item class and printed on the table.
			// i incrementally increases by 1 to traverse the arrays and print relevant
			// details until there are no more items to print.

			int i = 0;
			while (i < this.currentNumItems) {
				if (this.items[i].getIsObtained() == searchObtained) {

					String itemDetails = this.items[i].getItemName() + "\t" + this.items[i].getYearReleased() + "\t"
							+ this.items[i].getItemPrice() + "\t" + this.items[i].getIsObtained();
					this.gtMain.addRowToTable(0, itemDetails);

				}

				i += 1;
			}

		} else
			this.gtMain.showErrorDialog("Please have at least one item inputted into the table!");

	}

	// This method created out of necessity, as it is invoked by a button
	// made for marking an item off as being obtained.

	// This method was named "checkOffSelectedItem" as it better reflects
	// how the function replicates the idea of 'checking off' an item from your
	// checklist when the user has obtained the item.

	// This is done by using get and set methods from the Item class and changing
	// the boolean value "isObtained" with the pre-typed "true" in the text field
	// "changeObtained" before refreshing the table to show the changes.

	public void checkOffSelectedItem() {
		String selectedRow = this.gtMain.getSelectedRowFromTable(0);
		if (selectedRow != null) {
			String itemDetails[] = selectedRow.split("\t");

			String itemName = itemDetails[0];
			int i = getItemIndexByName(itemName);
			this.items[i].getIsObtained();

			this.gtMain.setTextInEntry(0, "true");

			// The identifier name "changeObtained" was chosen to distinguish from
			// the 'isObtained' value taken from splitting and parsing the String value,
			// and also refers to how the obtained value is being changed.

			boolean changeObtained = Boolean.parseBoolean(this.gtMain.getTextFromEntry(0));
			this.gtMain.setTextInEntry(0, "");

			this.items[i].setIsObtained(changeObtained);
			refreshTable();
		} else
			this.gtMain.showErrorDialog("Please select an item to check off the list!");
	}

	// This method was created primarily to reduce duplication of code,
	// as it returns all of the inputed values in the tables after
	// an entry is added or edited or removed.

	// The identifier name 'refreshTable' was chosen over another name like
	// ShowAllRows as it more accurately reflects how the table is refreshed after
	// changes are made or if a search has changed what rows are being viewed.

	public void refreshTable() {
		this.gtMain.clearRowsOfTable(0);
		int i = 0;

		// This while statement works as follows:
		// The values inside each array at position i are added to the table as rows,
		// and with each increase of i by 1, the subsequent values are printed, and will
		// continue to do so until the value of i exceeds that of how many items there are and
		// their details to print.

		while (i < this.currentNumItems) {
			String itemDetails = this.items[i].getItemName() + "\t" + this.items[i].getYearReleased() + "\t"
					+ this.items[i].getItemPrice() + "\t" + this.items[i].getIsObtained();
			this.gtMain.addRowToTable(0, itemDetails);

			i += 1;
		}

	}

	// This method created out of necessity, as it is invoked by a button
	// made for checking how many items have been obtained, and whether
	// all the items in the checklist have been obtained.

	// The identifier name 'countCollectedItems' was chosen over another name like
	// showCompletedList as it more accurately reflects how the method can check
	// how many items have been completed compared to how many items there are in
	// total, rather than working only if the list has been completed.

	public void countCollectedItems() {

		// The logic of the following if statement is as follows:

		// If the currentNumItems is greater than 0, then the rest of the code will run.
		// Otherwise, an error message will play prompting the user to input an item.
		// This is because items cannot be counted for their obtained status if there
		// are no items to count.

		if (this.currentNumItems > 0) {

			// countObtained was assigned in this code block as values are taken from
			// this code block and no where else, but it was declared at the class-level
			// as the value obtained from here is referred to elsewhere.

			this.countObtained = 0;

			this.gtMain.setTextInEntry(1, "");

			int i = 0;

			// The logic of the following while and if statement is as follows:

			// While i is lower than the amount of items currently in the checklist,
			// the items which are marked as 'true', which is obtained using
			// a get method from the Item class, are counted and added to
			// the countObtained value.
			// i incrementally increases by 1 to traverse the arrays and count items
			// marked as 'true' until there are no more items to count.

			while (i < this.currentNumItems) {
				if (this.items[i].getIsObtained() == true) {
					this.countObtained += 1;
				}

				i += 1;
			}

			this.gtMain.setTextInEntry(1, this.countObtained + " / " + this.currentNumItems);

			// The logic of the following if statement is as follows:

			// If the number of obtained items is the same as the existing number of items
			// in the checklist, as in every item has been obtained, then a separate window
			// specifically for showing the 'award' screen will be opened.

			// Otherwise, the user will be notified that they haven't completed the
			// checklist via a text field near the bottom of the table.

			if (this.countObtained == this.currentNumItems) {

				// The logic of the following if statement is as follows:

				// If there is an existing window of gtAward is open, it will close it. This is
				// to make sure that the user is not confused as to which award they've won,
				// which change depending on how many items they've obtained.

				if (this.gtAward != null)
					this.gtAward.close();

				this.gtMain.setTextInEntry(2, "");

				// This window was assigned here formally as this window only needs to be
				// open when this method is invoked rather than being open from the start of the program.

				this.gtAward = new GTerm(505, 590);
				this.gtAward.setBackgroundColor(115, 169, 255);
				this.gtAward.setFontColor(255, 255, 255);
				this.gtAward.setFontSize(45);
				this.gtAward.setXY(36, 510);
				this.gtAward.println("CONGRATULATIONS!");

				// The logic of the following if statements is as follows:

				// Different flavour images were added for personalisation,
				// which vary depending on how many total items the user has collected.

				// M.Y. Dungca, "Medals in Various Colours", unpublished, October 2020.

				if (this.countObtained < 10) {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("bluemedal.png");
				} else if (this.countObtained < 20) {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("greenmedal.png");
				} else if (this.countObtained < 30) {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("orangemedal.png");
				} else if (this.countObtained < 40) {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("pinkmedal.png");
				} else if (this.countObtained < 50) {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("purplemedal.png");
				} else {
					this.gtAward.setXY(0, 10);
					this.gtAward.addImageIcon("redmedal.png");
				}

			} else
				this.gtMain.setTextInEntry(2, "Not completed, but you're almost there!");

		} else
			this.gtMain.showErrorDialog("Please have at least one item inputted into the table!");

	}

	// This method was created out of necessity, and was declared as the main (and
	// static) method as the program would not run without it and could not be
	// excluded. The main method was also added to this class as this is the 'main'
	// class which bears the name of the application.

	// An object was also created out of the main application class
	// (CollectorChecklist) as stated by the specification, which is also necessary 
	// in making the program.

	// The name "ccObj" was used to create an object of CollectorChecklist as the
	// initials "cc" is more concise than using the full name, while Obj refers to
	// how the class is being created into an object for the purpose of facilitating
	// the code's functionality.

	public static void main(String[] args) {
		CollectorChecklist ccObj = new CollectorChecklist();
	}

}
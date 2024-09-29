import java.text.ParseException;

public class Invoice {
	//class Attributes
	private int numOfInvoices;
	public int invoiceNumber;
	public String invoiceDate;
	public int invoiceAmount;

	private BookRoom bookRoom;
	
	
	//Constructor Method
	public Invoice(BookRoom bookRoom) throws ParseException {
		numOfInvoices ++;
		invoiceNumber = numOfInvoices;
		invoiceDate = bookRoom.getBookingDate();
		this.bookRoom = bookRoom;
		invoiceAmount = (int) (bookRoom.room.roomPrice * bookRoom.getNumOfDaysBooked());
		
	}

	//Creating the class methods
	public void generateInvoice() {
		System.out.println("Here we shall be write code to generate invoice");
	}

	public void updateInvoice() {
		System.out.println("Here we shall be write code to update invoice");
	}


	//Class getters
	public int getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public String getInvoiceDate() {
		return this.invoiceDate;
	}

	public int getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public BookRoom getBookRoom() {
		return this.bookRoom;
	}


	//the class toString method
	@Override
	public String toString() {
		return "\n\nThe Invoice Details are:" +
			
			"\nInvoice Number: " + getInvoiceNumber() +
			"\nInvoice Date: " + getInvoiceDate() +
			"\nRoom Type: " + bookRoom.room.roomType +
			"\nRoom Number: " + bookRoom.room.roomNumber +
			"\ninvoice Amount: " + getInvoiceAmount();
	}
	
}

import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		
	//Instantiating the Customer and Admin Users
	Customer c1 = new Customer("Daniel", "example@email", "653230810");
	AdminUser a1 = new AdminUser("Moses", "moses@email", "07121956548");

	//Print Customer details
	System.out.println("customer Details Are: \nCustomer ID: " + c1.getCustomerId() 
		+ "\nCustomer name: " + c1.names + "\nCustomer Email: " + c1.email + "\nCustomer Phone: " + c1.phoneNumber);

	//Print Admin details
	System.out.println("\n\nAdmin Details Are: \nAdmin ID: " + a1.getAdminId() 
		+ "\nAdmin name: " + a1.names + "\nAdmin Email: " + a1.email + "\nAdmin Phone: " + a1.phoneNumber);

	
	
	//Instantiating a room
	Room r1 =new Room("standard", 2000);

	//Print Room details
	System.out.println("\n\nThe room details are: \nRoom number: " + r1.getRoomId() + "\nRoom Type: " + r1.roomType 
	+ "\nRoom Price: " + r1.roomPrice + "\nRoom available: " + r1.isRoomIsAvailable());



	//Instantiating room class
	BookRoom b1 =new BookRoom(c1, "23/06/2022", "27/06/2022", r1);
	
	//Print Room details
	System.out.println("\n\nThe Booking details are: \nCustomer Name: " + c1.names + "\nBooking date: " + b1.getBookingDate() 
	+ "\nCheckin date: " + b1.checkInDate + "\nCheckout date: " + b1.checkOutDate + "\nRoom Number: " + r1.roomNumber);



	//Instantiating an Invoice
	Invoice in1 = new Invoice(b1);

	//Printing Invoice details
	System.out.println(in1.toString());
	
	
	//Instantiating payment class
	Payments p1 = new Payments("Bank", b1, in1);

	//calling the makepayment method in payments class
	p1.makePayment(8000);

	
	//instantiating the notification class
	Notification n1 = new Notification(p1, b1);	

	//calling the send nottification method
	n1.sendNotification();


	//instantiating the cancelbooking 
	CancelBooking cancel1 = new CancelBooking(b1, r1);

	//calling cancel method
	cancel1.cancel();

	}

	

	

	

}


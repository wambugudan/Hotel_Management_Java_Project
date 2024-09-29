//Importing the relevant libraries

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// import java.time.temporal.ChronoUnit;
// import java.time.LocalDate;

public class BookRoom {
	// Create the class attributes
	private int bookId;
	private int numOfBookings;
	private String bookingDate;
	public String checkInDate;
	public String checkOutDate;
	private boolean bookingIsCompleted;
	
	//linking the BookRoom class with the Room class using the Aggregation relationship
	public Customer customer;
	public Room room;
	// private Invoice invoice;
	// private Payments payments;
	
	//Get current Date
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();


	// Create the class constructor
	public BookRoom(Customer customer, String checkInDate, String checkOutDate, Room room) {
		numOfBookings ++;
		bookId = numOfBookings;
		bookingDate = formatter.format(date);
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingIsCompleted = false;
			
		
		this.customer = customer;
		this.room = room;
		
	}
	
	//creating a method to calculate number of days booked
	public long getNumOfDaysBooked() throws ParseException {
		Date d1 = formatter.parse(checkInDate);
		Date d2 = formatter.parse(checkOutDate);
		long numOfDaysBooked = (d2.getTime() - d1.getTime())/86400000;
		return numOfDaysBooked;
	}
	

	//setting Booking completion status getter
	public boolean isBookingIsCompleted() {
		return this.bookingIsCompleted;
	}

	//setting Booking completion status setter
	public void setBookingIsCompleted(boolean bookingIsCompleted) {
		this.bookingIsCompleted = bookingIsCompleted;
	}


    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    

    /**
     * @return String return the bookingDate
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }


}

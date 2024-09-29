import java.text.SimpleDateFormat;
import java.util.Date;

public class CancelBooking {
    //creating class attribute
    private int numOfCanceledBookings;
    private int cancelationId;
    private String cancelationDate;  
    
    protected BookRoom bookRoom;
    protected Room room;

    //Get current Date
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();

    public CancelBooking(BookRoom bookRoom, Room room) {
        numOfCanceledBookings ++;
        cancelationId = numOfCanceledBookings;
        cancelationDate = formatter.format(date);
        this.bookRoom = bookRoom;
        this.room = room;
    }

    public void cancel( ){
        bookRoom.setBookingIsCompleted(false); 
        room.setRoomIsAvailable(true);
       sendCancelationNotification();
    }

    public void sendCancelationNotification(){
		
		System.out.println("Dear customer, your cancelation for room " + bookRoom.room.roomNumber + " with booking Id " 
		+ bookRoom.getBookId() + " done on " + getCancelationDate() +" was successful. The cancelation Id is " + getCancelationId());
		
	}

    public int getCancelationId() {
        return this.cancelationId;
    }

    public String getCancelationDate() {
        return this.cancelationDate;
    }

}

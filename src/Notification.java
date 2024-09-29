
public class Notification {
	private int numOfNotifications;
	private int notificationId;
	
	//user defined variables	
	private Payments payments;
	private BookRoom bookRoom;
	
	//class constructor
	public Notification(Payments payments, BookRoom bookRoom) {
		numOfNotifications ++;
		notificationId= numOfNotifications;
		this.payments = payments;
		this.bookRoom = bookRoom;
	}

	public void sendNotification(){
		if(payments.paymentBalance == 0){
			System.out.println("Booking with notification Id " + notificationId + " for room number" 
			+ bookRoom.room.roomNumber + " was successful");
		}else{
			System.out.println("Booking with notification Id " + notificationId + " for room number" 
			+ bookRoom.room.roomNumber + " is pending due to payment arreas of " + payments.paymentBalance);
		}
	}

	

	public int getNotificationId() {
		return this.notificationId;
	}

}

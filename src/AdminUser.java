
public class AdminUser extends Users{
	private int adminId;
	public int numOfAdmins;

	/*
	 * Creating the class constructor using both the inherited and local attributes
	 */
	public AdminUser(String names, String email, String phoneNumber) {
		
		super(names, email, phoneNumber);
		numOfAdmins ++;
		adminId = numOfAdmins;
	}
	
	public void updateProfile() {
		super.updateProfile();
	}
	
	//declaring methods that are specific to the AdminUser class
		public void viewBookings() {
			System.out.println("Dear " + names + ", you can view all bookings from here");
		}
		
		public void manageBooking() {
			System.out.println("Dear " + names + ", you can manage all booking from here");
		}

    /**
     * @return int return the adminId
     */
    public int getAdminId() {
        return adminId;
    }

   
}

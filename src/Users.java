
//This will be a parent class to Customer and Admin User
abstract public class Users {

//Outlining class attributes
	public  String names;
	protected String email;
	protected String phoneNumber;
	protected int password;

	//Class constructor
	public Users( String names, String email, String phoneNumber) {
		this.names = names;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	    


	    
//	    Declaring Class Methods
	    public void updateProfile() {
	    	System.out.println("Hi " + names +", You can update your profile here");
	    }

		public void verifyLogin(){
			System.out.println("To be used for user verification");
		}

		public void createAccount(){
			System.out.println("To be used for account creation");
		}
		
}
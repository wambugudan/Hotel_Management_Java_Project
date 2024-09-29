

public class Customer extends Users{
	private int customerId;
	static int numOfCustomers;

	/*
		Creating the class constructor with attributes from Parent class and the local attributes
	 */	
	public Customer(String names, String email, String phoneNumber) {		
		//Inheriting attributes from the super class		
		super(names, email, phoneNumber);
		numOfCustomers ++; 
		customerId = numOfCustomers;
	}
	



    /**
     * @return the customerId 
     */
    public int getCustomerId() {
        return customerId;
    }


}

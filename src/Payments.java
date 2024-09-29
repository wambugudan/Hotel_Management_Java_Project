import java.text.SimpleDateFormat;
import java.util.Date;

public class Payments {
	//declaring the class attributes
	private int paymentId;
	private int numOfPayments;
	private String paymentDate;
	private String paymentType;
	private int paymentAmount;
	protected Invoice invoice;
	private BookRoom bookRoom;
	int paid;
	int paymentBalance;

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	//crating the class constructor
	public Payments(String paymentType, BookRoom bookRoom, Invoice invoice) {
		numOfPayments ++;
		paymentId = numOfPayments;
		paymentDate = formatter.format(date);
		// paymentAmount = invoice.invoiceAmount;
		this.paymentType = paymentType;
		this.bookRoom = bookRoom;
		this.invoice = invoice;
	}

	//creating a method to allow for payment
	public void makePayment(int paid){
		
		if(paid == invoice.invoiceAmount){
			paymentAmount = paid;

            
			bookRoom.setBookingIsCompleted(true);

            bookRoom.room.setRoomIsAvailable(false);
			
			System.out.println("\n\nDear " + bookRoom.customer.names + ", your " + paymentType +"  payment of Ksh " 
			+ paid + " for invoice number " + invoice.invoiceNumber 
			+ ", has been been received. Thank you for choosing us." );
		}else{
			paymentBalance = invoice.invoiceAmount - paid;

			System.out.println("\n\nDear " + bookRoom.customer.names + ", your " + paymentType +" payment of Ksh " 
			+ paid + " for invoice number " + invoice.invoiceNumber 
			+ ", has been been received. You have an invoice balance of Ksh " + paymentBalance 
			+ ". Please pay the invoice balace to complete the booking." );

		}
	}

    /**
     * @return int return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return int return the numOfPayments
     */
    public int getNumOfPayments() {
        return numOfPayments;
    }

    /**
     * @param numOfPayments the numOfPayments to set
     */
    public void setNumOfPayments(int numOfPayments) {
        this.numOfPayments = numOfPayments;
    }

    /**
     * @return String return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return String return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return int return the paymentAmount
     */
    public int getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return Invoice return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}

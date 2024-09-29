
import javax.swing.JOptionPane;

public class CreditCardPayment implements PaymentStrategy
{
   @Override
   public void pay(String amount){
       System.out.println("Thank you for paying Ksh" + amount + " through Credit Card!");
       JOptionPane.showMessageDialog(null, "Thank you for paying Ksh " + amount + " through Credit Card!", "Credit Card", JOptionPane.INFORMATION_MESSAGE);
   } 
    
}

import javax.swing.JOptionPane;


public class BitCoinsPayment implements PaymentStrategy
{
   @Override
   public void pay(String amount){
       System.out.println("Thank you for paying Ksh" + amount + " through Bitcoin!");
       JOptionPane.showMessageDialog(null, "Thank you for paying Ksh " + amount + " through Bitcoin!", "Bitcoin",
       JOptionPane.INFORMATION_MESSAGE);
   } 
    
}
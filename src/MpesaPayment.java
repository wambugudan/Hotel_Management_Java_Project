
import javax.swing.JOptionPane;

public class MpesaPayment implements PaymentStrategy
{
   @Override
   public void pay(String amount){
//       System.out.println("Thank you for paying Ksh" + amount + " through Mpesa!");
       JOptionPane.showMessageDialog(null, "Thank you for paying Ksh " + amount + " through Mpesa!", "Mpesa", JOptionPane.INFORMATION_MESSAGE);
   } 
    
}

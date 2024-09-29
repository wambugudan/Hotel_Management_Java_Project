public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    
    //Customer to set the payment method to be used
    public void setPaymentStrategy(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }
    
    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy;
    }
    
    public void pay(String amount){
        paymentStrategy.pay(amount);
    }
         
}


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pay extends javax.swing.JFrame {

    String invoiceID;
    String amountPayable; 
    String bookingID;
    String roomIDVal;
    String firstName;
    String checkInDate;
    String checkOutDate;
    String roomNum;
    String roomType;
    String userIDVal;
    String payDate;
    String payType;
    
    DatabaseConnection conn;
    Connection dbconn = DatabaseConnection.connectDB();
    
    /**
     * Creates new form Pay
     */
    public Pay() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Pay(String invoiceID, String amountPayable, String bookingID, String roomIDVal, String firstName, String checkInDate, String checkOutDate, String roomNum, String roomType, String userIDVal) {
        initComponents();
        getPaymentType();
        
        this.setLocationRelativeTo(null); 
        
        this.invoiceID = invoiceID;
        this.amountPayable = amountPayable;
        this.bookingID = bookingID;
        this.roomIDVal = roomIDVal;
        this.firstName = firstName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.userIDVal = userIDVal;
    }
    
    //Save the payment data to the database
    public void saveToDB(){
       try{
           String selectedPayType = selection.getSelectedItem().toString();
           int selectedPayTypeVal = 0;

           //Get The selected type
           if (null != selectedPayType) 
           switch (selectedPayType) {
               case "Mpesa" -> selectedPayTypeVal = 1;
               case "Credit Card" -> selectedPayTypeVal = 2;
               case "Bitcoin" -> selectedPayTypeVal = 3;
               default -> {
               }
           }

           //Save data to the database
           String sql = "INSERT INTO `payment`(`paymentTypeID`, `invoiceID`) VALUES (?,?)";
           PreparedStatement pst = (PreparedStatement)
                   dbconn.prepareStatement(sql);        

           pst.setInt(1, selectedPayTypeVal);
           pst.setString(2, invoiceID);

           pst.execute();

           JOptionPane.showMessageDialog(null, "Saving data was Successful!");
       }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    //Update the bookingIsComplete Value in the Booking table
    public void setBookingIsCompleteState(String bookingIDVal){
       try{
          
           //update the bookingIsComplete Value database
           String sql = "UPDATE `bookings` SET `bookingIsComplete` = 1 WHERE `bookingID` = ?";
           PreparedStatement pst = (PreparedStatement)
                   dbconn.prepareStatement(sql); 
           pst.setString(1, bookingIDVal);

           pst.execute();

           JOptionPane.showMessageDialog(null, "updating booking was Successful!");
       }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    
     //Update the room availability Value in the Rooms table
    public void setRoomIsAvailableState(String roomID){
       try{
          
           //update the roomIsAvailable Value in the database
           String sql = "UPDATE `room` SET `roomIsAvailable` = 0 WHERE `roomID` = ?";
           PreparedStatement pst = (PreparedStatement)
                   dbconn.prepareStatement(sql);
           pst.setString(1, roomID);

           pst.execute();

           JOptionPane.showMessageDialog(null, "Updating rooms was Successful!");
       }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
        
    //Get Payment Type from the database
    private void getPaymentType(){
        try{
            //Fetch data from the database
            String sql = "SELECT * FROM `paymenttype`";
            PreparedStatement pst = (PreparedStatement)
                    dbconn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            //Populate the Combobox
            while(rs.next()){
                payType = rs.getString("paymentTypeName");

                selection.addItem(payType);
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
     //Get Payment Time from the database
    private void getPaymentTime(){
        try{
            //Fetch data from the database
            String sql = "SELECT * FROM `payment`";
            PreparedStatement pst = (PreparedStatement)
                    dbconn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            //Populate the Combobox
            while(rs.next()){
                payDate = rs.getString("paymentDate");
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selection = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 153, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Payment");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Select Payment Type:");

        selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Enter Amount to be paid");

        amountField.setEditable(false);
        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setText("Confirm Selection");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selection, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(amountField)))
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String selectedPaymentType = selection.getSelectedItem().toString();        
        JOptionPane.showMessageDialog(null, amountPayable);  
        
        String amountValue = amountField.getText();        
        PaymentContext ctx = new PaymentContext();        
        if(null == selectedPaymentType){
            JOptionPane.showMessageDialog(null, "Make sure to select a Payment type", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else switch (selectedPaymentType) {
            case "Mpesa" -> ctx.setPaymentStrategy(new MpesaPayment());
            case "Credit Card" -> ctx.setPaymentStrategy(new CreditCardPayment());
            case "Bitcoin" -> ctx.setPaymentStrategy(new BitCoinsPayment());
            default -> JOptionPane.showMessageDialog(null, "Make sure to select a Payment type", "Error", JOptionPane.ERROR_MESSAGE);
        }      
                 
        if(" ".equals(amountField.getText())){
            JOptionPane.showMessageDialog(null, "There was an error fetching amount payable from your booking",
            "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Save the payment data to the database
            saveToDB();            
            //call the payment context to be excuted
            ctx.pay(amountValue);            
            //Update the Booking table booking is compete value
            setBookingIsCompleteState(bookingID);            
            //Update room availability
            setRoomIsAvailableState(roomIDVal);
            // Get Payment Date & Time
            getPaymentTime();
        }
   
        PaymentReceiptFrame payReciet = new PaymentReceiptFrame(invoiceID, amountPayable, firstName,checkInDate, checkOutDate, roomNum, roomType, userIDVal, payDate, payType);
        payReciet.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField amountField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selection;
    // End of variables declaration//GEN-END:variables
}

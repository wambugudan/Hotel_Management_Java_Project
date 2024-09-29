
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dwambugu
 */
public class BookRoomFrame extends javax.swing.JFrame {

    String userIDVal;
    String roomIDVal;
    String checkInDate;
    String checkOutDate;
    String amountPayable;
    String firstName;
    String roomNum;
    String roomType;
    String roomPrice;
    String bookingID;
    /**
     * Creates new form BookRoomFrame
     */
    DatabaseConnection conn;
    Connection dbconn = DatabaseConnection.connectDB();
    
    public BookRoomFrame() {
        initComponents();  
        this.setLocationRelativeTo(null);
        
    }
    
    //Class Constructor
    public BookRoomFrame(String userID, String firstName) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.userIDVal = userID;
        this.firstName = firstName;
        
        //Create Connection to the database
        conn  = new DatabaseConnection();
        
        //Display Error if dbconnection is not available
        if(conn == null){
            JOptionPane.showMessageDialog(null, "DB Connection is not available", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method to clear Jframe Fields
    private void clearFields(){
        
        roomNoField.setText(" ");
        roomTypeField.setText(" ");
        roomPriceField.setText(" ");
        checkInDateField.setCalendar(null);
        checkOutDateField.setCalendar(null);
        checkInDateField.setText(" ");
    }
    
    //Get Booking ID
    public void getBookingID(){
        try{
            //Fetch data from the database
            String sql = "SELECT * from `bookings` WHERE bookings.userID = '"+userIDVal+"' AND bookings.roomID = '"+roomIDVal+"';";
            PreparedStatement pst = (PreparedStatement)
                    dbconn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            // Store db values in some variables
            if(rs.next()){
                bookingID = rs.getString("bookingID");
            }else{
                JOptionPane.showMessageDialog(null, "No data Found");
            }          
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        testlbl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        showAvailableRoomsBtn = new javax.swing.JButton();
        roomNoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roomTypeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roomPriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkInDateField = new javax.swing.JTextField();
        bookBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        calcAmountBtn = new javax.swing.JButton();
        amountPayableField1 = new javax.swing.JTextField();
        checkOutDateField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableRoomsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Book Room");

        LogoutBtn.setBackground(new java.awt.Color(255, 102, 0));
        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LogoutBtn.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        testlbl.setBackground(java.awt.SystemColor.controlHighlight);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        showAvailableRoomsBtn.setBackground(new java.awt.Color(0, 0, 0));
        showAvailableRoomsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showAvailableRoomsBtn.setForeground(new java.awt.Color(255, 102, 0));
        showAvailableRoomsBtn.setText("Show Available Rooms");
        showAvailableRoomsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAvailableRoomsBtnActionPerformed(evt);
            }
        });

        roomNoField.setEditable(false);

        jLabel1.setText("Room No");

        jLabel3.setText("Room Type ");

        roomTypeField.setEditable(false);

        jLabel4.setText("Checkin Date");

        jLabel5.setText("Room Price ");

        roomPriceField.setEditable(false);

        jLabel6.setText("Checkout Date");

        jLabel7.setText("Amount Payable");

        checkInDateField.setEditable(false);

        bookBtn.setBackground(new java.awt.Color(0, 0, 0));
        bookBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bookBtn.setForeground(new java.awt.Color(204, 102, 0));
        bookBtn.setText("Book ");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(0, 0, 0));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(204, 102, 0));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        calcAmountBtn.setBackground(new java.awt.Color(0, 0, 0));
        calcAmountBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        calcAmountBtn.setForeground(new java.awt.Color(204, 102, 0));
        calcAmountBtn.setText("Calculate Amount");
        calcAmountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcAmountBtnActionPerformed(evt);
            }
        });

        amountPayableField1.setEditable(false);

        checkOutDateField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomNoField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(roomTypeField)
                            .addComponent(roomPriceField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(showAvailableRoomsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(calcAmountBtn)
                        .addGap(96, 96, 96)
                        .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkOutDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkInDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(721, Short.MAX_VALUE)
                    .addComponent(amountPayableField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(144, 144, 144)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(checkInDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(checkOutDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(roomNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showAvailableRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcAmountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(amountPayableField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );

        availableRoomsTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        availableRoomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Room Num", "Room Type", "Room Price"
            }
        ));
        availableRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableRoomsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(availableRoomsTable);

        javax.swing.GroupLayout testlblLayout = new javax.swing.GroupLayout(testlbl);
        testlbl.setLayout(testlblLayout);
        testlblLayout.setHorizontalGroup(
            testlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testlblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        testlblLayout.setVerticalGroup(
            testlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testlblLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(testlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Fetch available room from the database and populate them in the Jtable
    private void showAvailableRoomsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAvailableRoomsBtnActionPerformed
        
         //Fetch data from the database to populate the JTable
        try{
           
            PreparedStatement pst = (PreparedStatement)
                    dbconn.prepareStatement("SELECT * FROM `room` INNER JOIN roomtype on room.roomTypeID = roomtype.roomTypeID WHERE roomIsAvailable = 1;");
            
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)availableRoomsTable.getModel();
            model.setRowCount(0);
            
            //Display Data on the table 
            while(rs.next()){
                model.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(7)});
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);        
        }
        
    }//GEN-LAST:event_showAvailableRoomsBtnActionPerformed

    
    //Clear all fields in the Jform
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:

        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    
    //populate the textfields with values from the selected row in the Jtable
    private void availableRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsTableMouseClicked
        
        
        int rowData = availableRoomsTable.getSelectedRow();
        TableModel model = availableRoomsTable.getModel();
        
        roomIDVal = model.getValueAt(rowData,0).toString();
        roomNum = model.getValueAt(rowData,1).toString();
        roomType = model.getValueAt(rowData,2).toString();
        roomPrice = model.getValueAt(rowData,3).toString();
                
        // Populate textfields with values from the selected row
        roomNoField.setText(roomNum);
        roomTypeField.setText(roomType);
        roomPriceField.setText(roomPrice);
        
    }//GEN-LAST:event_availableRoomsTableMouseClicked

    
    //Calculate the amount payable field
    private void calcAmountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcAmountBtnActionPerformed
        // TODO add your handling code here:
        
        try{
           //Calculating the number of Days between            
            checkInDate = ((JTextField)checkInDateField.getDateEditor().getUiComponent()).getText();
            checkOutDate = ((JTextField)checkOutDateField.getDateEditor().getUiComponent()).getText();
            
            LocalDate checkIn = LocalDate.parse(checkInDate);
            LocalDate checkOut = LocalDate.parse(checkOutDate);
            
            long daysBooked = ChronoUnit.DAYS.between(checkIn, checkOut);
            
            int numOfDaysBooked = (int) daysBooked + 1; 
            
            //String numOfDaysBookedString = Integer.toString(numOfDaysBooked);
            
            //Calculate money Payable for the booked period

            int roomPriceInt = Integer.parseInt(roomPriceField.getText());

            int amountPayableInt = numOfDaysBooked * roomPriceInt;

            //Print the amount payable
            amountPayable = Integer.toString(amountPayableInt);
            
            
            checkInDateField.setText(amountPayable);

            
        }catch (Exception e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please fill in all the details to calculate", "Incomplete Forms", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_calcAmountBtnActionPerformed

    
    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        //Save Details of Booked room to the database
        //int userId = Integer.parseInt(userID);
        //int roomId = Integer.parseInt(roomID);
        
       try{
            //Save data to the database
            String sql = "INSERT INTO `bookings`( `ckeckInDate`, `checkOutDate`, `userID`, `roomID`, `amountPayable`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = (PreparedStatement)
                    dbconn.prepareStatement(sql);            
                        
            pst.setString(1, checkInDate);
            pst.setString(2, checkOutDate);
            pst.setInt(3, Integer.parseInt(userIDVal));
            pst.setInt(4, Integer.parseInt(roomIDVal));
            pst.setInt(5, Integer.parseInt(amountPayable));
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Booking was Successful!");
            
            //Clear Fields after adding data to database
            clearFields();
            
            //Call the method for getting the booking ID
            getBookingID();
                        
            //Proceed to the invoice Frame
                //Instantiate the Invoice Frame class
            InvoiceFrame iFrame = new InvoiceFrame(userIDVal, roomIDVal, bookingID, amountPayable, firstName,checkInDate, checkOutDate, roomNum, roomType);
            
            iFrame.invoiceTextArea.setText("Dear " + firstName + ", \n\nThank you for booking a hotel room with us.\n\n"
                    + "The booked room is of type " + roomType + " costing " + roomPrice + " per day."
                    + "\n" + "Your room number is " + roomNum + ".\nTo complete the booking process, please pay " 
                    + amountPayable + " by clicking on the pay button below."
                    + "\n\nThank you once again for choosing us. \n\n\n Best Regards, \n Hotel Accarde Management");
            
            this.dispose();
            iFrame.setVisible(true);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Make sure to have calulated the amount payable before proceeding to book");
        } 
        
    }//GEN-LAST:event_bookBtnActionPerformed
       
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
            java.util.logging.Logger.getLogger(BookRoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookRoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookRoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookRoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookRoomFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JTextField amountPayableField1;
    private javax.swing.JTable availableRoomsTable;
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton calcAmountBtn;
    private javax.swing.JTextField checkInDateField;
    private javax.swing.JTextField checkOutDateField;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField roomNoField;
    private javax.swing.JTextField roomPriceField;
    private javax.swing.JTextField roomTypeField;
    private javax.swing.JButton showAvailableRoomsBtn;
    private javax.swing.JPanel testlbl;
    // End of variables declaration//GEN-END:variables
}

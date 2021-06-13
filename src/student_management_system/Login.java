package student_management_system;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Buddhi Rangana
 */
public final class Login extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("SMS Icon.png")).getImage());
        setTitle("User Login");
        currentDate();
        shotime();
        date2_lbl.setText(now("yyyy MMMM dd"));
        time2_lbl.setText(now("hh:mm aaa"));
        conn = db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        createuser_btn.setForeground(java.awt.Color.green);
    }

    public void displayTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        ImageIcon icon = new ImageIcon(getClass().getResource("SMS Gif.gif"));
        Image image = icon.getImage();
        TrayIcon trayIcon = new TrayIcon(image);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Student Management System is running");
        tray.add(trayIcon);
        trayIcon.displayMessage("Message", "Welcome to SMS, Student Management System is Starting", TrayIcon.MessageType.INFO);
    }

    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());

    }

    public void currentDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd");
        date2_lbl.setText(sdf.format(d));
    }

    public void shotime() {
        new Timer(0, (ActionEvent e) -> {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:a");
            time2_lbl.setText(sdf.format(d));
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlebg_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        password_lbl = new javax.swing.JLabel();
        password_ptxt = new javax.swing.JPasswordField();
        cancel_btn = new javax.swing.JButton();
        login_btn = new javax.swing.JButton();
        txt_combo = new javax.swing.JComboBox<>();
        utype_lbl = new javax.swing.JLabel();
        createuser_btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        body_lbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        date1_lbl = new javax.swing.JMenu();
        date2_lbl = new javax.swing.JMenu();
        time1_lbl = new javax.swing.JMenu();
        time2_lbl = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 150, 150, 150));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlebg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/loginpic.png"))); // NOI18N
        getContentPane().add(titlebg_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 160, -1));

        username_lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username_lbl.setForeground(new java.awt.Color(255, 255, 255));
        username_lbl.setText("Username");
        getContentPane().add(username_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, 60));

        username_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 150, -1));

        password_lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password_lbl.setForeground(new java.awt.Color(255, 255, 255));
        password_lbl.setText("Password");
        getContentPane().add(password_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, 40));

        password_ptxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(password_ptxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 150, -1));

        cancel_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/cancel icon.png"))); // NOI18N
        cancel_btn.setText("Cancel");
        cancel_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel_btnMouseExited(evt);
            }
        });
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });
        getContentPane().add(cancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        login_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/login icon.png"))); // NOI18N
        login_btn.setText("Login");
        login_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/login icon.png"))); // NOI18N
        login_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btnMouseExited(evt);
            }
        });
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        getContentPane().add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 90, -1));

        txt_combo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Usertype --", "Admin", "Guest" }));
        getContentPane().add(txt_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 150, 30));

        utype_lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        utype_lbl.setForeground(new java.awt.Color(255, 255, 255));
        utype_lbl.setText("User Type");
        getContentPane().add(utype_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 30));

        createuser_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        createuser_btn.setForeground(new java.awt.Color(204, 204, 204));
        createuser_btn.setText("Click here to create guest account");
        createuser_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createuser_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createuser_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createuser_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createuser_btnMouseExited(evt);
            }
        });
        getContentPane().add(createuser_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 190, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/SMS Gif.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 70, 154, 100));

        body_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/login bg.jpg"))); // NOI18N
        getContentPane().add(body_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 620, 380));

        date1_lbl.setText("Date");
        jMenuBar1.add(date1_lbl);

        date2_lbl.setForeground(new java.awt.Color(0, 0, 102));
        jMenuBar1.add(date2_lbl);

        time1_lbl.setText("Time");
        jMenuBar1.add(time1_lbl);

        time2_lbl.setForeground(new java.awt.Color(0, 0, 102));
        jMenuBar1.add(time2_lbl);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        if (!(username_txt.getText().isEmpty() || password_ptxt.getText().isEmpty() || txt_combo.getSelectedItem().equals("-- Select Usertype --"))) {
            String sql = "select User_id,Username,Password,UserType from user Where (Username =? and Password =? and UserType =?)";

            try {
                int count = 0;

                pst = conn.prepareStatement(sql);

                pst.setString(1, username_txt.getText());
                pst.setString(2, password_ptxt.getText());
                pst.setString(3, txt_combo.getSelectedItem().toString());

                rs = pst.executeQuery();

                {
                }
                while (rs.next()) {
                    int id = rs.getInt(1);
                    Emp.UserId = id;
                    count = count + 1;

                }
                String access = (txt_combo.getSelectedItem().toString());
                if (("Admin".equals(access))) {

                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Login Success");

                        MainMenu j = new MainMenu();
                        j.setVisible(true);

                        this.dispose();

                        Date currentDate = GregorianCalendar.getInstance().getTime();
                        DateFormat df = DateFormat.getDateInstance();
                        String dateString = df.format(currentDate);

                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        String timeString = sdf.format(d);

                        String value0 = timeString;
                        String values = dateString;

                        int value = Emp.UserId;
                        String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Logged in')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();
                        this.dispose();
                    } else if (count > 1) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Duplicate Username or Password Access denied", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Username, Password or Usertype is not correct", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (("Guest".equals(access))) {

                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Login Sucess");

                        MainMenuGuest j = new MainMenuGuest();
                        j.setVisible(true);

                        this.dispose();

                        Date currentDate = GregorianCalendar.getInstance().getTime();
                        DateFormat df = DateFormat.getDateInstance();
                        String dateString = df.format(currentDate);

                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        String timeString = sdf.format(d);

                        String value0 = timeString;
                        String values = dateString;

                        int value = Emp.UserId;
                        String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Logged in')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();
                        this.dispose();

                    } else if (count > 1) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Duplicate Username or Password Access denied", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Username, Password or Usertype is not correct", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {

                try {
                    rs.close();
                    pst.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_login_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel programme?", "Cancel", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void login_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btnMouseEntered

    private void login_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btnMouseExited

    private void cancel_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_btnMouseEntered

    private void cancel_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_btnMouseExited

    private void createuser_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuser_btnMouseEntered
        createuser_btn.setForeground(java.awt.Color.white);
    }//GEN-LAST:event_createuser_btnMouseEntered

    private void createuser_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuser_btnMouseExited
        createuser_btn.setForeground(java.awt.Color.green);
    }//GEN-LAST:event_createuser_btnMouseExited

    private void createuser_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuser_btnMouseClicked
        this.setVisible(false);
        NewGuest object = new NewGuest();
        object.setVisible(true);
    }//GEN-LAST:event_createuser_btnMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body_lbl;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel createuser_btn;
    private javax.swing.JMenu date1_lbl;
    private javax.swing.JMenu date2_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JPasswordField password_ptxt;
    private javax.swing.JMenu time1_lbl;
    private javax.swing.JMenu time2_lbl;
    private javax.swing.JLabel titlebg_lbl;
    private javax.swing.JComboBox<String> txt_combo;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField username_txt;
    private javax.swing.JLabel utype_lbl;
    // End of variables declaration//GEN-END:variables

}

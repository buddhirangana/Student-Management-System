package student_management_system;

import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Buddhi Rangana
 */
public final class MainMenu extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MainMenu() {
        conn = db.java_db();
        initComponents();
        setTitle("Main Menu");
        setIconImage(new ImageIcon(getClass().getResource("SMS Icon.png")).getImage());
        currentDate();
        shotime();
        date2_lbl.setText(now("yyyy MMMM dd"));
        time2_lbl.setText(now("hh:mm aaa"));
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        txt_emp.setText(String.valueOf(Emp.UserId));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        adduser_btn = new javax.swing.JButton();
        info_btn = new javax.swing.JButton();
        audit_btn = new javax.swing.JButton();
        out_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        stumanage_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        coursemanage_btn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_emp = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        date1_lbl = new javax.swing.JMenu();
        date2_lbl = new javax.swing.JMenu();
        time1_lbl = new javax.swing.JMenu();
        time2_lbl = new javax.swing.JMenu();
        help = new javax.swing.JMenu();
        about2_lbl = new javax.swing.JMenuItem();
        help_lbl = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Admin Settings");

        adduser_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        adduser_btn.setText("Add New User");
        adduser_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adduser_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_btnActionPerformed(evt);
            }
        });

        info_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        info_btn.setText("Login Information");
        info_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        info_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info_btnMouseExited(evt);
            }
        });
        info_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info_btnActionPerformed(evt);
            }
        });

        audit_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        audit_btn.setText("Audit");
        audit_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        audit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                audit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                audit_btnMouseExited(evt);
            }
        });
        audit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audit_btnActionPerformed(evt);
            }
        });

        out_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        out_btn.setText("Logout");
        out_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        out_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                out_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                out_btnMouseExited(evt);
            }
        });
        out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_btnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Admin Task");

        stumanage_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        stumanage_btn.setText("Student Management ");
        stumanage_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stumanage_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stumanage_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stumanage_btnMouseExited(evt);
            }
        });
        stumanage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stumanage_btnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Add.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/login information.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/audit.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/logout3.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Users-Student-icon.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/NIIBS gif_2.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(302, 302, 302))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        coursemanage_btn.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        coursemanage_btn.setText("Course Management");
        coursemanage_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coursemanage_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coursemanage_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                coursemanage_btnMouseExited(evt);
            }
        });
        coursemanage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursemanage_btnActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Text-Edit-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adduser_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(info_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(audit_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coursemanage_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(out_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stumanage_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coursemanage_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adduser_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(info_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(stumanage_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(audit_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 60, 680, 380);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("  Logged in As :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(640, 20, 110, 14);

        txt_emp.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp.setText("emp");
        jPanel1.add(txt_emp);
        txt_emp.setBounds(730, 20, 30, 14);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Admin icon.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(622, -10, 20, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/main menu bg.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 490);

        date1_lbl.setText("Date");
        jMenuBar1.add(date1_lbl);

        date2_lbl.setForeground(new java.awt.Color(0, 0, 102));
        jMenuBar1.add(date2_lbl);

        time1_lbl.setText("Time");
        jMenuBar1.add(time1_lbl);

        time2_lbl.setForeground(new java.awt.Color(0, 0, 102));
        jMenuBar1.add(time2_lbl);

        help.setText("Help");
        help.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        about2_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/about.png"))); // NOI18N
        about2_lbl.setText("About SMS");
        about2_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        about2_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about2_lblActionPerformed(evt);
            }
        });
        help.add(about2_lbl);

        help_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/about.png"))); // NOI18N
        help_lbl.setText("Help Center");
        help_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        help_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help_lblActionPerformed(evt);
            }
        });
        help.add(help_lbl);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void about2_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about2_lblActionPerformed
        AboutUs j = new AboutUs();
        j.setVisible(true);
    }//GEN-LAST:event_about2_lblActionPerformed

    private void stumanage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stumanage_btnActionPerformed
        setVisible(false);
        StudentManagementSystem object = new StudentManagementSystem();
        object.setVisible(true);
    }//GEN-LAST:event_stumanage_btnActionPerformed

    private void adduser_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_btnActionPerformed
        NewUser j = new NewUser();
        j.setVisible(true);
    }//GEN-LAST:event_adduser_btnActionPerformed

    private void info_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info_btnActionPerformed
        Users j = new Users();
        j.setVisible(true);
    }//GEN-LAST:event_info_btnActionPerformed

    private void audit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audit_btnActionPerformed
        Audit_details j = new Audit_details();
        j.setVisible(true);
    }//GEN-LAST:event_audit_btnActionPerformed

    private void out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_out_btnActionPerformed
        Login j = new Login();
        j.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(null, "Logout Success");
        
        try {
            Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(currentDate);

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String values = dateString;

            int value = Emp.UserId;
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Logged out')";
            pst = conn.prepareStatement(reg);
            pst.execute();
            this.dispose();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_out_btnActionPerformed

    private void help_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help_lblActionPerformed
        Help h = new Help();
        h.setVisible(true);
    }//GEN-LAST:event_help_lblActionPerformed

    private void coursemanage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursemanage_btnActionPerformed
        setVisible(false);
        CourseManagement object = new CourseManagement();
        object.setVisible(true);
    }//GEN-LAST:event_coursemanage_btnActionPerformed

    private void coursemanage_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursemanage_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_coursemanage_btnMouseEntered

    private void coursemanage_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursemanage_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_coursemanage_btnMouseExited

    private void info_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_info_btnMouseEntered

    private void info_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_info_btnMouseExited

    private void stumanage_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stumanage_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_stumanage_btnMouseEntered

    private void stumanage_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stumanage_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_stumanage_btnMouseExited

    private void audit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_audit_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_audit_btnMouseEntered

    private void audit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_audit_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_audit_btnMouseExited

    private void out_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_out_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_out_btnMouseEntered

    private void out_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_out_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_out_btnMouseExited

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about2_lbl;
    private javax.swing.JButton adduser_btn;
    private javax.swing.JButton audit_btn;
    private javax.swing.JButton coursemanage_btn;
    private javax.swing.JMenu date1_lbl;
    private javax.swing.JMenu date2_lbl;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem help_lbl;
    private javax.swing.JButton info_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton out_btn;
    private javax.swing.JButton stumanage_btn;
    private javax.swing.JMenu time1_lbl;
    private javax.swing.JMenu time2_lbl;
    private javax.swing.JLabel txt_emp;
    // End of variables declaration//GEN-END:variables

}

package student_management_system;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import static com.itextpdf.text.Element.ALIGN_CENTER;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Buddhi Rangana
 */
public final class StudentManagementSystem extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public StudentManagementSystem() {

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

        initComponents();
        setTitle("Student Management");
        setIconImage(new ImageIcon(getClass().getResource("SMS Icon.png")).getImage());
        conn = db.java_db();
        txt_name.requestFocus();
        Fillcombobox();
        Fillcombobox2();
        currentDate();
        shotime();
        Update_table();
        Update_table2();
        Update_table3();
        Update_table4();
        Update_table5();
        tableHeader();
        txt_studentid.setEnabled(false);
        txt_age.setEnabled(false);
        txt_emp.setText(String.valueOf(Emp.UserId));
        

    }

    private void Fillcombobox() {

        try {
            String sql = "select * from Course";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Course_name");
                course_combo.addItem(name);
                course_combo1.addItem(name);
                course_combo2.addItem(name);
                course_combo3.addItem(name);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Fillcombobox2() {

        try {
            String sql = "select * from Subject";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String subject = rs.getString("Subject_name");
                subject_combo.addItem(subject);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void tableHeader() {

        JTableHeader header1 = student_table.getTableHeader();
        header1.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header2 = studentatten_table.getTableHeader();
        header2.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header3 = studentpresentage_table.getTableHeader();
        header3.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header4 = studentPayment_table.getTableHeader();
        header4.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header5 = studentMark_table.getTableHeader();
        header5.setFont(new Font("Arial", Font.BOLD, 12));

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

    private void Update_table() {

        try {
            String sql = "select * from Student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            student_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Update_table2() {

        try {
            String sql = "select * from Attendence";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            studentatten_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Update_table3() {

        try {
            String sql = "select * from Eligible";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            studentpresentage_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Update_table4() {
        try {
            String sql = "select * from Payments";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            studentPayment_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void Update_table5() {
        try {
            String sql = "select * from Marks";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            studentMark_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        save_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_studentid = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        r_male = new javax.swing.JRadioButton();
        r_female = new javax.swing.JRadioButton();
        course_combo = new javax.swing.JComboBox<>();
        txt_address = new javax.swing.JTextField();
        txt_address2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        print_btn = new javax.swing.JButton();
        export_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_stuid = new javax.swing.JTextField();
        pre_rbtn = new javax.swing.JCheckBox();
        abs_rbtn = new javax.swing.JCheckBox();
        save_btn1 = new javax.swing.JButton();
        clear_btn1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        course_combo1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_name1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentatten_table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        stid_lbl = new javax.swing.JLabel();
        stname_lbl = new javax.swing.JLabel();
        presenta_lbl = new javax.swing.JLabel();
        message_lbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        show_btn = new javax.swing.JButton();
        clear2_btn = new javax.swing.JButton();
        stuid_txt = new javax.swing.JTextField();
        name_txt = new javax.swing.JTextField();
        nofdays_txt = new javax.swing.JTextField();
        nofstu_txt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentpresentage_table = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        stuid_txt1 = new javax.swing.JTextField();
        stuname_txt = new javax.swing.JTextField();
        regfee_txt = new javax.swing.JTextField();
        courfee_txt = new javax.swing.JTextField();
        exafee_txt = new javax.swing.JTextField();
        course_combo2 = new javax.swing.JComboBox<>();
        save_btn2 = new javax.swing.JButton();
        clear_btn2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentPayment_table = new javax.swing.JTable();
        print_btn1 = new javax.swing.JButton();
        export_btn1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        reset_btn = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        stuid_txt2 = new javax.swing.JTextField();
        stuname_txt1 = new javax.swing.JTextField();
        assignm_txt = new javax.swing.JTextField();
        writtenm_txt = new javax.swing.JTextField();
        practicalm_txt = new javax.swing.JTextField();
        course_combo3 = new javax.swing.JComboBox<>();
        subject_combo = new javax.swing.JComboBox<>();
        r_do = new javax.swing.JRadioButton();
        r_not = new javax.swing.JRadioButton();
        save_btn3 = new javax.swing.JButton();
        clear_btn3 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        id_lbl = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        course_lbl = new javax.swing.JLabel();
        sub_lbl = new javax.swing.JLabel();
        assigns_lbl = new javax.swing.JLabel();
        mark_lbl = new javax.swing.JLabel();
        grade_lbl = new javax.swing.JLabel();
        status_lbl = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentMark_table = new javax.swing.JTable();
        print_btn2 = new javax.swing.JButton();
        export_btn2 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        search_txt1 = new javax.swing.JTextField();
        reset_btn1 = new javax.swing.JButton();
        txt_emp = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_lbl = new javax.swing.JMenu();
        coursemanage_lbl = new javax.swing.JMenuItem();
        mainmenu_lbl = new javax.swing.JMenuItem();
        logout_lbl = new javax.swing.JMenuItem();
        date1_lbl = new javax.swing.JMenu();
        date2_lbl = new javax.swing.JMenu();
        time1_lbl = new javax.swing.JMenu();
        time2_lbl = new javax.swing.JMenu();
        help = new javax.swing.JMenu();
        about_lbl = new javax.swing.JMenuItem();
        help_lbl = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1700, 736));
        setResizable(false);

        jTabbedPane1.setForeground(new java.awt.Color(44, 62, 80));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(1684, 598));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact Number :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date of Birth :");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name :");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address Line 01 :");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Age :");

        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn.setText("Add Record");
        save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        clear_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear_btn.setText("Clear");
        clear_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/update .png"))); // NOI18N
        update_btn.setText("Update");
        update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/delete.gif"))); // NOI18N
        delete_btn.setText("Delete");
        delete_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student ID :");

        txt_studentid.setToolTipText("No need to add. System automatic generated.");
        txt_studentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_studentidKeyReleased(evt);
            }
        });

        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telKeyReleased(evt);
            }
        });

        txt_age.setToolTipText("No need to add age. \nSystem automatic calculate age.");
        txt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ageActionPerformed(evt);
            }
        });
        txt_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ageKeyReleased(evt);
            }
        });

        r_male.setForeground(new java.awt.Color(255, 255, 255));
        r_male.setText("Male");
        r_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_maleActionPerformed(evt);
            }
        });

        r_female.setForeground(new java.awt.Color(255, 255, 255));
        r_female.setText("Female");
        r_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_femaleActionPerformed(evt);
            }
        });

        course_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------- Select Course --------------" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address Line 02 :");

        jDateChooser.setBackground(new java.awt.Color(44, 62, 80));
        jDateChooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserMouseClicked(evt);
            }
        });
        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });
        jDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r_female, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(r_male, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_studentid)
                                    .addComponent(txt_tel)
                                    .addComponent(txt_age)
                                    .addComponent(course_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_address)
                                    .addComponent(txt_address2))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_studentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_female)
                            .addComponent(r_male)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(course_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student_id", "Name", "Dob", "Telephone", "Address1", "Address2", "Gender", "Age", "Course"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        student_table.setInheritsPopupMenu(true);
        student_table.getTableHeader().setReorderingAllowed(false);
        student_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(student_table);

        print_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Pdf Icon.png"))); // NOI18N
        print_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });

        export_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Excel Icon.png"))); // NOI18N
        export_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(export_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(print_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Registration", jPanel5);

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mark Student Attendence", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student ID :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Attenden :");

        txt_stuid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_stuidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stuidKeyReleased(evt);
            }
        });

        pre_rbtn.setForeground(new java.awt.Color(255, 255, 255));
        pre_rbtn.setText("Present");
        pre_rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_rbtnActionPerformed(evt);
            }
        });

        abs_rbtn.setForeground(new java.awt.Color(255, 255, 255));
        abs_rbtn.setText("Absent");
        abs_rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abs_rbtnActionPerformed(evt);
            }
        });

        save_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn1.setText("Add Attendance");
        save_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn1ActionPerformed(evt);
            }
        });

        clear_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear_btn1.setText("Clear");
        clear_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btn1ActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name :");

        course_combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------- Select Course --------------" }));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Date :");

        jDateChooser1.setBackground(new java.awt.Color(44, 62, 80));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_stuid, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_name1)
                            .addComponent(course_combo1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(pre_rbtn)
                                .addGap(13, 13, 13)
                                .addComponent(abs_rbtn))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save_btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_stuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(course_combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abs_rbtn)
                    .addComponent(pre_rbtn)
                    .addComponent(jLabel12))
                .addGap(20, 20, 20))
        );

        jPanel6.setBackground(new java.awt.Color(44, 62, 80));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Attendence Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        studentatten_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Attenden_id", "Name", "Course", "Student_id", "Date", "Attenden"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studentatten_table.getTableHeader().setReorderingAllowed(false);
        studentatten_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentatten_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentatten_table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(44, 62, 80));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Eligible", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student ID :");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Name :");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Number of days the course was held :");

        jPanel8.setBackground(new java.awt.Color(44, 62, 80));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stid_lbl.setForeground(new java.awt.Color(204, 204, 204));

        stname_lbl.setForeground(new java.awt.Color(204, 204, 204));

        presenta_lbl.setForeground(new java.awt.Color(255, 102, 102));

        message_lbl.setForeground(new java.awt.Color(204, 204, 204));

        jLabel20.setText("Student ID :");

        jLabel21.setText("Name :");

        jLabel22.setText("Presentage :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(message_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(presenta_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stname_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stid_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(stid_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(stname_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(presenta_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        show_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/search-icon.png"))); // NOI18N
        show_btn.setText("Show Eligible");
        show_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_btnActionPerformed(evt);
            }
        });

        clear2_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear2_btn.setText("Clear");
        clear2_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear2_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2_btnActionPerformed(evt);
            }
        });

        stuid_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuid_txtActionPerformed(evt);
            }
        });
        stuid_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stuid_txtKeyReleased(evt);
            }
        });

        nofdays_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nofdays_txtKeyReleased(evt);
            }
        });

        nofstu_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nofstu_txtKeyReleased(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Number of days the student has arrived :");

        studentpresentage_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Eligible_id", "Student_id", "Name", "Presentage", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studentpresentage_table.getTableHeader().setReorderingAllowed(false);
        studentpresentage_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentpresentage_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(studentpresentage_table);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stuid_txt)
                                    .addComponent(name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                            .addComponent(nofdays_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nofstu_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(show_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clear2_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(stuid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nofdays_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nofstu_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(show_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear2_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Attendence", jPanel2);

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBackground(new java.awt.Color(44, 62, 80));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Student Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Student ID :");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Name :");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Course :");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Registration Fee :");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Course Fee :");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Examination Fee : ");

        stuid_txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stuid_txt1KeyReleased(evt);
            }
        });

        regfee_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                regfee_txtKeyReleased(evt);
            }
        });

        courfee_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                courfee_txtKeyReleased(evt);
            }
        });

        exafee_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                exafee_txtKeyReleased(evt);
            }
        });

        course_combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------- Select Course ---------" }));

        save_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn2.setText("Add Payments");
        save_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn2ActionPerformed(evt);
            }
        });

        clear_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear_btn2.setText("Clear");
        clear_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stuid_txt1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stuname_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(course_combo2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(regfee_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(courfee_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exafee_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                .addGap(92, 92, 92))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(stuid_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(stuname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(course_combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(regfee_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(courfee_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(exafee_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(44, 62, 80));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Payment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        studentPayment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Payment_id", "Name", "Student_id", "Course", "Reg_Fee", "Course_Fee", "Exam_Fee"
            }
        ));
        studentPayment_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        studentPayment_table.getTableHeader().setReorderingAllowed(false);
        studentPayment_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentPayment_tableMouseClicked(evt);
            }
        });
        studentPayment_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentPayment_tableKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(studentPayment_table);

        print_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Pdf Icon.png"))); // NOI18N
        print_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btn1ActionPerformed(evt);
            }
        });

        export_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Excel Icon.png"))); // NOI18N
        export_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(print_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(44, 62, 80));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Student ID :");

        search_txt.setToolTipText("Type here to search");
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        reset_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        reset_btn.setText("Reset");
        reset_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset_btn)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Payments", jPanel9);

        jPanel13.setBackground(new java.awt.Color(44, 62, 80));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel14.setBackground(new java.awt.Color(44, 62, 80));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Student Exam Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Student ID :");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Name :");

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Course :");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Subject :");

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Assignment Status :");

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Assignment Mark :");

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Written Exam Mark :");

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Practical Mark :");

        stuid_txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stuid_txt2KeyReleased(evt);
            }
        });

        assignm_txt.setToolTipText("Maximum range 20.");
        assignm_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                assignm_txtKeyReleased(evt);
            }
        });

        writtenm_txt.setToolTipText("Maximum range 50.");
        writtenm_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                writtenm_txtKeyReleased(evt);
            }
        });

        practicalm_txt.setToolTipText("Maximum range 30.");
        practicalm_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                practicalm_txtKeyReleased(evt);
            }
        });

        course_combo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------- Select Course --------" }));

        subject_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------- Select Subject --------" }));

        r_do.setForeground(new java.awt.Color(255, 255, 255));
        r_do.setText("Do");
        r_do.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_doActionPerformed(evt);
            }
        });

        r_not.setForeground(new java.awt.Color(255, 255, 255));
        r_not.setText("Not");
        r_not.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_notActionPerformed(evt);
            }
        });

        save_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn3.setText("Add Mark");
        save_btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn3ActionPerformed(evt);
            }
        });

        clear_btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear_btn3.setText("Clear");
        clear_btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btn3ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(44, 62, 80));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setText("Student ID :");

        jLabel39.setText("Name :");

        jLabel40.setText("Course :");

        jLabel41.setText("Subject :");

        jLabel42.setText("Assignment Status :");

        jLabel43.setText("Final Mark :");

        jLabel44.setText("Grade :");

        jLabel45.setText("Status :");

        id_lbl.setForeground(new java.awt.Color(204, 204, 204));

        name_lbl.setForeground(new java.awt.Color(204, 204, 204));

        course_lbl.setForeground(new java.awt.Color(204, 204, 204));

        sub_lbl.setForeground(new java.awt.Color(204, 204, 204));

        assigns_lbl.setForeground(new java.awt.Color(204, 204, 204));

        mark_lbl.setForeground(new java.awt.Color(255, 102, 102));

        grade_lbl.setForeground(new java.awt.Color(255, 102, 102));

        status_lbl.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(course_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assigns_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mark_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grade_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(course_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assigns_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mark_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grade_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(status_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(save_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(87, 87, 87))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stuname_txt1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(stuid_txt2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subject_combo, 0, 189, Short.MAX_VALUE)
                            .addComponent(course_combo3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(r_do, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(r_not, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(assignm_txt)
                            .addComponent(writtenm_txt)
                            .addComponent(practicalm_txt)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(stuid_txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuname_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(course_combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subject_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(r_do)
                    .addComponent(r_not))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignm_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(writtenm_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(practicalm_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(44, 62, 80));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Marks Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        studentMark_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mark_id", "Name", "Student_id", "Course", "Subject", "Assign_status", "Final_mark", "Grade", "Status"
            }
        ));
        studentMark_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentMark_table.setName(""); // NOI18N
        studentMark_table.getTableHeader().setReorderingAllowed(false);
        studentMark_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentMark_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(studentMark_table);

        print_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Pdf Icon.png"))); // NOI18N
        print_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btn2ActionPerformed(evt);
            }
        });

        export_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Excel Icon.png"))); // NOI18N
        export_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(print_btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export_btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(44, 62, 80));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Student ID :");

        search_txt1.setToolTipText("Type here to search");
        search_txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txt1KeyReleased(evt);
            }
        });

        reset_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        reset_btn1.setText("Reset");
        reset_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset_btn1)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn1))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Exam Marks", jPanel13);

        txt_emp.setText("emp");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Admin icon.png"))); // NOI18N
        jLabel46.setText("Logged in As :");

        jPanel18.setBackground(new java.awt.Color(44, 62, 80));
        jPanel18.setPreferredSize(new java.awt.Dimension(881, 57));

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Niibs Logo.png"))); // NOI18N
        jLabel49.setText(" Copyright © 2019 - 2020 NIIBS, Group 01. All Rights Reserved.");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(jLabel49)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addContainerGap())
        );

        menu_lbl.setText("Menu");
        menu_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        coursemanage_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Text-Edit-icon2.png"))); // NOI18N
        coursemanage_lbl.setText("Course Management");
        coursemanage_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        coursemanage_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursemanage_lblActionPerformed(evt);
            }
        });
        menu_lbl.add(coursemanage_lbl);

        mainmenu_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/home-icon2.png"))); // NOI18N
        mainmenu_lbl.setText("Main Menu");
        mainmenu_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainmenu_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenu_lblActionPerformed(evt);
            }
        });
        menu_lbl.add(mainmenu_lbl);

        logout_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/logout2.png"))); // NOI18N
        logout_lbl.setText("Log Out");
        logout_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logout_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_lblActionPerformed(evt);
            }
        });
        menu_lbl.add(logout_lbl);

        jMenuBar1.add(menu_lbl);

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
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        about_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/about.png"))); // NOI18N
        about_lbl.setText("About SMS");
        about_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        about_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_lblActionPerformed(evt);
            }
        });
        help.add(about_lbl);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1725, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_emp)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        if (!(jDateChooser.getDate() == null || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty()
                || course_combo.getSelectedItem().equals("--------------- Select Course --------------"))) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?", "Add Record", JOptionPane.YES_NO_OPTION);
                if (p == 0) {

                    try {
                        String sql = "insert into Student"
                                + "(Name,Dob,"
                                + "Telephone,Address1,Address2,"
                                + "Gender,"
                                + "Age,Course) values (?,?,?,?,?,?,?,?) ";

                        Date d = new Date();
                        SimpleDateFormat f = new SimpleDateFormat("yyyy");
                        int yearNow = Integer.parseInt(f.format(d));
                        int yearDob = Integer.parseInt(f.format(jDateChooser.getDate()));
                        int BD = (yearNow - yearDob);
                        String age = Integer.toString(BD);
                        txt_age.setText(age);

                        pst = conn.prepareStatement(sql);
                        pst.setString(1, txt_name.getText());

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        String date = sdf.format(jDateChooser.getDate());

                        pst.setString(2, date);
                        pst.setString(3, txt_tel.getText());
                        pst.setString(4, txt_address.getText());
                        pst.setString(5, txt_address2.getText());
                        pst.setString(6, gender);
                        pst.setString(7, txt_age.getText());
                        pst.setString(8, course_combo.getSelectedItem().toString());

                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Data is saved successfully");

                    } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                    Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);

                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);

                    String value0 = timeString;
                    String value1 = dateString;
                    String val = txt_emp.getText();
                    try {

                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Student Details')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {

                        try {
                            rs.close();
                            pst.close();

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                    Update_table();
                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        txt_name.setText("");
        txt_tel.setText("");
        jDateChooser.setDate(null);
        txt_address.setText("");
        txt_address2.setText("");
        course_combo.setSelectedIndex(0);
        txt_studentid.setText("");
        txt_age.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        if (!(jDateChooser.getDate() == null || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty()
                || course_combo.getSelectedItem().equals("--------------- Select Course --------------") || txt_studentid.getText().isEmpty() || txt_age.getText().isEmpty())) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Update Record", JOptionPane.YES_NO_OPTION);
                if (p == 0) {

                    try {

                        String value1 = txt_name.getText();

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        String date = sdf.format(jDateChooser.getDate());

                        String value2 = date;
                        String value3 = txt_studentid.getText();
                        String value4 = txt_tel.getText();
                        String value5 = txt_address.getText();
                        String value6 = txt_address2.getText();
                        String value7 = gender;
                        String value8 = txt_age.getText();
                        String value9 = course_combo.getSelectedItem().toString();

                        String sql = "update Student set Student_id='" + value3 + "',Name='" + value1 + "', Dob='" + value2 + "', "
                                + "Telephone='" + value4 + "',Address1='" + value5 + "',Address2='" + value6 + "',Gender= '" + value7 + "', "
                                + "Age='" + value8 + "',Course ='" + value9 + "'"
                                + "where Student_id='" + value3 + "' ";

                        pst = conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Record Updated");

                    } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                    Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);

                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);

                    String value0 = timeString;
                    String values = dateString;
                    String val = txt_emp.getText();
                    try {
                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + values + "','Updated Student Details')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {

                        try {
                            rs.close();
                            pst.close();

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                    Update_table();
                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (!(jDateChooser.getDate() == null || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty()
                || course_combo.getSelectedItem().equals("--------------- Select Course --------------") || txt_studentid.getText().isEmpty() || txt_age.getText().isEmpty())) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?", "Delete", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);

                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);

                    String value0 = timeString;
                    String value1 = dateString;
                    String val = txt_emp.getText();
                    try {
                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Deleted Student Details')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    String sql = "delete from Student where Student_id=? ";
                    try {
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, txt_studentid.getText());
                        pst.execute();

                        JOptionPane.showMessageDialog(null, "Record Deleted");

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
                    Update_table();

                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void txt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageActionPerformed

    private void r_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_maleActionPerformed
        gender = "Male";
        r_male.setSelected(true);
        r_female.setSelected(false);
    }//GEN-LAST:event_r_maleActionPerformed

    private void r_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_femaleActionPerformed
        gender = "Female";
        r_female.setSelected(true);
        r_male.setSelected(false);
    }//GEN-LAST:event_r_femaleActionPerformed

    private void jDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserMouseClicked

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserPropertyChange

    private void jDateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserKeyReleased

    private void student_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) student_table.getModel();
        int SelectedRowIndex = student_table.getSelectedRow();

        txt_studentid.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        txt_name.setText(model.getValueAt(SelectedRowIndex, 1).toString());

        try {
            int srow = student_table.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy.MM.dd").parse((String) model.getValueAt(srow, 2));
            jDateChooser.setDate(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        gender = (model.getValueAt(SelectedRowIndex, 3).toString());
        if (gender.equals("Male")) {
            r_male.setSelected(true);
            r_female.setSelected(false);
        } else if (gender.equals("Female")) {
            r_female.setSelected(true);
            r_male.setSelected(false);
        }

        txt_tel.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        txt_address.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        txt_address2.setText(model.getValueAt(SelectedRowIndex, 6).toString());
        txt_age.setText(model.getValueAt(SelectedRowIndex, 7).toString());

        course = (model.getValueAt(SelectedRowIndex, 8).toString());
        for (int i = 0; i < course_combo.getItemCount(); i++) {
            if (course_combo.getItemAt(i).equalsIgnoreCase(course)) {
                course_combo.setSelectedIndex(i);
            }
        }

    }//GEN-LAST:event_student_tableMouseClicked

    private void mainmenu_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenu_lblActionPerformed
        setVisible(false);
        MainMenu object = new MainMenu();
        object.setVisible(true);
    }//GEN-LAST:event_mainmenu_lblActionPerformed

    private void logout_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_lblActionPerformed
        setVisible(false);
        Login object = new Login();
        object.setVisible(true);
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

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_logout_lblActionPerformed

    private void about_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_lblActionPerformed
        AboutUs j = new AboutUs();
        j.setVisible(true);
    }//GEN-LAST:event_about_lblActionPerformed

    private void help_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help_lblActionPerformed
        Help h = new Help();
        h.setVisible(true);
    }//GEN-LAST:event_help_lblActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpActionPerformed

    private void txt_stuidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stuidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stuidKeyPressed

    private void pre_rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_rbtnActionPerformed
        attenden = "Present";
        pre_rbtn.setSelected(true);
        abs_rbtn.setSelected(false);
    }//GEN-LAST:event_pre_rbtnActionPerformed

    private void abs_rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abs_rbtnActionPerformed
        attenden = "Absent";
        abs_rbtn.setSelected(true);
        pre_rbtn.setSelected(false);
    }//GEN-LAST:event_abs_rbtnActionPerformed

    private void save_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn1ActionPerformed
        if (!(jDateChooser1.getDate() == null || txt_name1.getText().isEmpty() || txt_stuid.getText().isEmpty()
                || course_combo1.getSelectedItem().equals("--------------- Select Course --------------"))) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add attendance?", "Add Attendance", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {
                    String sql = "insert into Attendence "
                            + "(Name,Student_id,"
                            + "Course,Date,"
                            + "Attenden) values(?,?,?,?,?) ";

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txt_name1.getText());
                    pst.setString(2, txt_stuid.getText());
                    pst.setString(3, course_combo1.getSelectedItem().toString());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                    String date = sdf.format(jDateChooser1.getDate());
                    pst.setString(4, date);
                    pst.setString(5, attenden);

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data is saved successfully");

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String val = txt_emp.getText();
                try {

                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Mark Attendence')";
                    pst = conn.prepareStatement(reg);
                    pst.execute();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {

                    try {
                        rs.close();
                        pst.close();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                }
                Update_table2();
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btn1ActionPerformed

    private void clear_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn1ActionPerformed

        txt_name1.setText("");
        jDateChooser1.setDate(null);
        course_combo1.setSelectedIndex(0);
        txt_stuid.setText("");
    }//GEN-LAST:event_clear_btn1ActionPerformed

    private void studentatten_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentatten_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) studentatten_table.getModel();
        int SelectedRowIndex = studentatten_table.getSelectedRow();

        txt_name1.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        course = (model.getValueAt(SelectedRowIndex, 2).toString());
        for (int i = 0; i < course_combo1.getItemCount(); i++) {
            if (course_combo1.getItemAt(i).equalsIgnoreCase(course)) {
                course_combo1.setSelectedIndex(i);
            }
        }
        txt_stuid.setText(model.getValueAt(SelectedRowIndex, 3).toString());
    }//GEN-LAST:event_studentatten_tableMouseClicked

    private void show_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_btnActionPerformed
        if (!(stuid_txt.getText().isEmpty() || nofstu_txt.getText().isEmpty()
                || nofdays_txt.getText().isEmpty() || name_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to show eligible?", "Show Eligible", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {
                    String sql = "insert into Eligible "
                            + "(Student_id,"
                            + "Name,Presentage,Status) values(?,?,?,?)";

                    String name = name_txt.getText();
                    String id = stuid_txt.getText();
                    String schooldays = nofdays_txt.getText();
                    String studentdays = nofstu_txt.getText();

                    int x = Integer.parseInt(schooldays);
                    int y = Integer.parseInt(studentdays);
                    int presentage = ((y * 100) / x);

                    stid_lbl.setText(id);
                    stname_lbl.setText(name);
                    presenta_lbl.setText(presentage + "%");

                    if (presentage >= 80) {
                        message_lbl.setText("Can do exam");
                    } else {
                        message_lbl.setText("Can't do exam");
                    }
                    JOptionPane.showMessageDialog(null, "Data is saved successfully");

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, stuid_txt.getText());
                    pst.setString(2, name_txt.getText());
                    pst.setInt(3, presentage);
                    pst.setString(4, message_lbl.getText());
                    pst.execute();

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String val = txt_emp.getText();
                try {

                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Search Eligible')";
                    pst = conn.prepareStatement(reg);
                    pst.execute();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {

                    try {
                        rs.close();
                        pst.close();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                }
                Update_table3();
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Please enter required data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_show_btnActionPerformed

    private void clear2_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2_btnActionPerformed

        stuid_txt.setText("");
        name_txt.setText("");
        nofdays_txt.setText("");
        nofstu_txt.setText("");
        stid_lbl.setText("");
        stname_lbl.setText("");
        presenta_lbl.setText("");
        message_lbl.setText("");
    }//GEN-LAST:event_clear2_btnActionPerformed

    private void stuid_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuid_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuid_txtActionPerformed

    private void studentpresentage_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentpresentage_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) studentpresentage_table.getModel();
        int SelectedRowIndex = studentpresentage_table.getSelectedRow();

        stid_lbl.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        stname_lbl.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        presenta_lbl.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        message_lbl.setText(model.getValueAt(SelectedRowIndex, 4).toString());
    }//GEN-LAST:event_studentpresentage_tableMouseClicked

    private void save_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn2ActionPerformed
        if (!(regfee_txt.getText().isEmpty() || stuid_txt1.getText().isEmpty() || stuname_txt.getText().isEmpty()
                || course_combo2.getSelectedItem().equals("--------- Select Course ---------") || courfee_txt.getText().isEmpty() || exafee_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add payments?", "Add Payments", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {
                    String sql = "insert into Payments "
                            + "(Student_id,Name,"
                            + "Course,Reg_Fee,"
                            + "Course_Fee,Exam_Fee) values (?,?,?,?,?,?)";

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, stuid_txt1.getText());
                    pst.setString(2, stuname_txt.getText());
                    pst.setString(3, course_combo2.getSelectedItem().toString());
                    pst.setString(4, regfee_txt.getText());
                    pst.setString(5, courfee_txt.getText());
                    pst.setString(6, exafee_txt.getText());

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data is saved successfully");

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String val = txt_emp.getText();
                try {

                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Payments')";
                    pst = conn.prepareStatement(reg);
                    pst.execute();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {

                    try {
                        rs.close();
                        pst.close();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                }
                Update_table4();
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btn2ActionPerformed

    private void clear_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn2ActionPerformed

        stuname_txt.setText("");
        stuid_txt1.setText("");
        regfee_txt.setText("");
        exafee_txt.setText("");
        course_combo2.setSelectedIndex(0);
        courfee_txt.setText("");
    }//GEN-LAST:event_clear_btn2ActionPerformed

    private void studentPayment_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentPayment_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPayment_tableMouseClicked

    private void studentPayment_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentPayment_tableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPayment_tableKeyPressed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        try {

            String sql = "select * from Payments where Student_id=? ";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search_txt.getText());
            rs = pst.executeQuery();
            studentPayment_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {

                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }//GEN-LAST:event_search_txtKeyReleased

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        Update_table4();
        search_txt.setText("");
    }//GEN-LAST:event_reset_btnActionPerformed

    private void r_doActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_doActionPerformed
        assignment = "Do";
        r_do.setSelected(true);
        r_not.setSelected(false);
    }//GEN-LAST:event_r_doActionPerformed

    private void r_notActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_notActionPerformed
        assignment = "Not";
        r_not.setSelected(true);
        r_do.setSelected(false);
    }//GEN-LAST:event_r_notActionPerformed

    private void save_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn3ActionPerformed
        if (!(stuid_txt2.getText().isEmpty() || stuname_txt1.getText().isEmpty() || assignm_txt.getText().isEmpty() || course_combo3.getSelectedItem().equals("---------- Select Course --------")
                || subject_combo.getSelectedItem().equals("---------- Select Subject --------")
                || practicalm_txt.getText().isEmpty() || writtenm_txt.getText().isEmpty())) {

            String id = stuid_txt2.getText();
            String name = stuname_txt1.getText();
            String cour = (String) course_combo3.getSelectedItem();
            String sub = (String) subject_combo.getSelectedItem();
            String assignsta = assignment;
            String a = assignm_txt.getText();
            String w = writtenm_txt.getText();
            String pr = practicalm_txt.getText();

            double assign = Double.parseDouble(a);
            double written = Double.parseDouble(w);
            double practical = Double.parseDouble(pr);

            if ((assign >= 0) && (assign <= 20)) {
                if ((written >= 0) && (written <= 50)) {
                    if ((practical >= 0) && (practical <= 30)) {
                        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add marks?", "Add Marks", JOptionPane.YES_NO_OPTION);
                        if (p == 0) {

                            try {
                                String sql = "insert into Marks "
                                        + "(Name,Student_id,"
                                        + "Course,Subject,"
                                        + "Assign_status,"
                                        + "Final_mark,Grade,Status) values (?,?,?,?,?,?,?,?) ";

                                double mark = (assign + written + practical);
                                String m = Double.toString(mark);
                                if ((mark >= 0) && (mark <= 100)) {

                                    id_lbl.setText(id);
                                    name_lbl.setText(name);
                                    course_lbl.setText(cour);
                                    sub_lbl.setText(sub);
                                    assigns_lbl.setText(assignsta);

                                    if (mark >= 85) {
                                        grade_lbl.setText("A+");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 84 || mark >= 70) {
                                        grade_lbl.setText("A");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 69 || mark >= 65) {
                                        grade_lbl.setText("A-");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 64 || mark >= 60) {
                                        grade_lbl.setText("B+");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 59 || mark >= 55) {
                                        grade_lbl.setText("B");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 54 || mark >= 50) {
                                        grade_lbl.setText("B-");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 49 || mark >= 45) {
                                        grade_lbl.setText("C+");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 44 || mark >= 40) {
                                        grade_lbl.setText("C");
                                        status_lbl.setText("Pass");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 39 || mark >= 35) {
                                        grade_lbl.setText("C-");
                                        status_lbl.setText("Repead");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 34 || mark >= 30) {
                                        grade_lbl.setText("D+");
                                        status_lbl.setText("Fail");
                                        mark_lbl.setText(m);
                                    } else if (mark >= 29 || mark >= 25) {
                                        grade_lbl.setText("D");
                                        status_lbl.setText("Fail");
                                        mark_lbl.setText(m);
                                    } else {
                                        grade_lbl.setText("E");
                                        status_lbl.setText("Fail");
                                        mark_lbl.setText(m);
                                    }
                                    pst = conn.prepareStatement(sql);
                                    pst.setString(1, stuname_txt1.getText());
                                    pst.setString(2, stuid_txt2.getText());
                                    pst.setString(3, course_combo3.getSelectedItem().toString());
                                    pst.setString(4, subject_combo.getSelectedItem().toString());
                                    pst.setString(5, assignment);
                                    pst.setString(6, mark_lbl.getText());
                                    pst.setString(7, grade_lbl.getText());
                                    pst.setString(8, status_lbl.getText());
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Data is saved successfully");
                                } else {
                                    getToolkit().beep();
                                    JOptionPane.showMessageDialog(this, "Enter valid marks", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (HeadlessException | NumberFormatException | SQLException e) {
                                JOptionPane.showMessageDialog(null, e);
                            }

                            Date currentDate = GregorianCalendar.getInstance().getTime();
                            DateFormat df = DateFormat.getDateInstance();
                            String dateString = df.format(currentDate);

                            Date d = new Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                            String timeString = sdf.format(d);

                            String value0 = timeString;
                            String value1 = dateString;
                            String val = txt_emp.getText();
                            try {

                                String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Marks')";
                                pst = conn.prepareStatement(reg);
                                pst.execute();

                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, e);
                            } finally {

                                try {
                                    rs.close();
                                    pst.close();

                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, e);

                                }
                            }
                            Update_table5();
                        }

                    } else {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(this, "Enter valid practical exam marks", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(this, "Enter valid written exam marks", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "Enter valid assignment marks", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btn3ActionPerformed

    private void clear_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn3ActionPerformed
        stuname_txt1.setText("");
        stuid_txt2.setText("");
        writtenm_txt.setText("");
        assignm_txt.setText("");
        subject_combo.setSelectedIndex(0);
        course_combo3.setSelectedIndex(0);
        practicalm_txt.setText("");
        id_lbl.setText("");
        name_lbl.setText("");
        course_lbl.setText("");
        sub_lbl.setText("");
        assigns_lbl.setText("");
        mark_lbl.setText("");
        grade_lbl.setText("");
        status_lbl.setText("");
    }//GEN-LAST:event_clear_btn3ActionPerformed

    private void studentMark_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMark_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) studentMark_table.getModel();
        int SelectedRowIndex = studentMark_table.getSelectedRow();

        stuid_txt2.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        stuname_txt1.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        course = (model.getValueAt(SelectedRowIndex, 3).toString());
        for (int i = 0; i < course_combo3.getItemCount(); i++) {
            if (course_combo3.getItemAt(i).equalsIgnoreCase(course)) {
                course_combo3.setSelectedIndex(i);
            }
        }
        id_lbl.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        name_lbl.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        course_lbl.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        sub_lbl.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        assigns_lbl.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        mark_lbl.setText(model.getValueAt(SelectedRowIndex, 6).toString());
        grade_lbl.setText(model.getValueAt(SelectedRowIndex, 7).toString());
        status_lbl.setText(model.getValueAt(SelectedRowIndex, 8).toString());
    }//GEN-LAST:event_studentMark_tableMouseClicked

    private void search_txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txt1KeyReleased
        try {

            String sql = "select * from Marks where Student_id=? ";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search_txt1.getText());
            rs = pst.executeQuery();
            studentMark_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {

                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_search_txt1KeyReleased

    private void reset_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btn1ActionPerformed
        Update_table5();
        search_txt1.setText("");
    }//GEN-LAST:event_reset_btn1ActionPerformed

    private void export_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btnActionPerformed

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport = null;

        DefaultTableModel model = (DefaultTableModel) student_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Student Details Report");

                excelSheet.setColumnWidth(1, 5000);
                excelSheet.setColumnWidth(2, 4000);
                excelSheet.setColumnWidth(4, 4000);
                excelSheet.setColumnWidth(5, 8000);
                excelSheet.setColumnWidth(6, 8000);

                for (int i = 0; i < model.getRowCount(); i++) {

                    XSSFRow excelRow = excelSheet.createRow(i);

                    for (int j = 0; j < model.getColumnCount(); j++) {

                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }

                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExport.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Export Successfully");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExport != null) {
                        excelJTableExport.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        }
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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student details to excel')";
            pst = conn.prepareStatement(reg);
            pst.execute();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_export_btnActionPerformed

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed

        String path = "";
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PDF FILE", "pdf");
        j.setFileFilter(fnef);
        int pdfChooser = j.showSaveDialog(this);

        if (pdfChooser == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        com.itextpdf.text.Font blueFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, com.itextpdf.text.Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Document doc = new Document(PageSize.A4.rotate());
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream(path + ".pdf"));
            doc.open();

            doc.add(new Paragraph((new Chunk("Student Details Report" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(9);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Report"));
            cell.setColspan(9);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Student_id"));
            cell2.setColspan(1);
            cell2.setBackgroundColor(BaseColor.GRAY);
            cell2.setPadding(5.0f);
            tb1.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Name"));
            cell3.setColspan(1);
            cell3.setBackgroundColor(BaseColor.GRAY);
            cell3.setPadding(5.0f);
            tb1.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Dob"));
            cell4.setColspan(1);
            cell4.setBackgroundColor(BaseColor.GRAY);
            cell4.setPadding(5.0f);
            tb1.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Gender"));
            cell5.setColspan(1);
            cell5.setBackgroundColor(BaseColor.GRAY);
            cell5.setPadding(5.0f);
            tb1.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Telephone"));
            cell6.setColspan(1);
            cell6.setBackgroundColor(BaseColor.GRAY);
            cell6.setPadding(5.0f);
            tb1.addCell(cell6);

            PdfPCell cell7 = new PdfPCell(new Paragraph("Address1"));
            cell7.setColspan(1);
            cell7.setBackgroundColor(BaseColor.GRAY);
            cell7.setPadding(5.0f);
            tb1.addCell(cell7);

            PdfPCell cell8 = new PdfPCell(new Paragraph("Address2"));
            cell8.setColspan(1);
            cell8.setBackgroundColor(BaseColor.GRAY);
            cell8.setPadding(5.0f);
            tb1.addCell(cell8);

            PdfPCell cell9 = new PdfPCell(new Paragraph("Age"));
            cell9.setColspan(1);
            cell9.setBackgroundColor(BaseColor.GRAY);
            cell9.setPadding(5.0f);
            tb1.addCell(cell9);

            PdfPCell cell10 = new PdfPCell(new Paragraph("Course"));
            cell10.setColspan(1);
            cell10.setBackgroundColor(BaseColor.GRAY);
            cell10.setPadding(5.0f);
            tb1.addCell(cell10);

            for (int i = 0; i < student_table.getRowCount(); i++) {

                String ID = student_table.getValueAt(i, 0).toString();
                String name = student_table.getValueAt(i, 1).toString();
                String dob = student_table.getValueAt(i, 2).toString();
                String tele = student_table.getValueAt(i, 3).toString();
                String add1 = student_table.getValueAt(i, 4).toString();
                String add2 = student_table.getValueAt(i, 5).toString();
                String gen = student_table.getValueAt(i, 6).toString();
                String ag = student_table.getValueAt(i, 7).toString();
                String cour = student_table.getValueAt(i, 8).toString();

                tb1.addCell(ID);
                tb1.addCell(name);
                tb1.addCell(dob);
                tb1.addCell(tele);
                tb1.addCell(add1);
                tb1.addCell(add2);
                tb1.addCell(gen);
                tb1.addCell(ag);
                tb1.addCell(cour);

            }
            doc.add(tb1);

        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        doc.close();

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student details to pdf')";
            pst = conn.prepareStatement(reg);
            pst.execute();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_print_btnActionPerformed

    private void print_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btn1ActionPerformed

        String path = "";
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PDF FILE", "pdf");
        j.setFileFilter(fnef);
        int pdfChooser = j.showSaveDialog(this);

        if (pdfChooser == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        com.itextpdf.text.Font blueFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, com.itextpdf.text.Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Document doc = new Document(PageSize.A4.rotate());
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream(path + ".pdf"));
            doc.open();

            doc.add(new Paragraph((new Chunk("Student Payment Details" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(7);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Payments"));
            cell.setColspan(7);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Payment_id"));
            cell2.setColspan(1);
            cell2.setBackgroundColor(BaseColor.GRAY);
            cell2.setPadding(5.0f);
            tb1.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Name"));
            cell3.setColspan(1);
            cell3.setBackgroundColor(BaseColor.GRAY);
            cell3.setPadding(5.0f);
            tb1.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Student_id"));
            cell4.setColspan(1);
            cell4.setBackgroundColor(BaseColor.GRAY);
            cell4.setPadding(5.0f);
            tb1.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Course"));
            cell5.setColspan(1);
            cell5.setBackgroundColor(BaseColor.GRAY);
            cell5.setPadding(5.0f);
            tb1.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Reg_Fee"));
            cell6.setColspan(1);
            cell6.setBackgroundColor(BaseColor.GRAY);
            cell6.setPadding(5.0f);
            tb1.addCell(cell6);

            PdfPCell cell7 = new PdfPCell(new Paragraph("Course_Fee"));
            cell7.setColspan(1);
            cell7.setBackgroundColor(BaseColor.GRAY);
            cell7.setPadding(5.0f);
            tb1.addCell(cell7);

            PdfPCell cell8 = new PdfPCell(new Paragraph("Exam_Fee"));
            cell8.setColspan(1);
            cell8.setBackgroundColor(BaseColor.GRAY);
            cell8.setPadding(5.0f);
            tb1.addCell(cell8);

            for (int i = 0; i < studentPayment_table.getRowCount(); i++) {

                String Id = studentPayment_table.getValueAt(i, 0).toString();
                String name = studentPayment_table.getValueAt(i, 1).toString();
                String sid = studentPayment_table.getValueAt(i, 2).toString();
                String cour = studentPayment_table.getValueAt(i, 3).toString();
                String regfee = studentPayment_table.getValueAt(i, 4).toString();
                String courfee = studentPayment_table.getValueAt(i, 5).toString();
                String examfee = studentPayment_table.getValueAt(i, 6).toString();

                tb1.addCell(Id);
                tb1.addCell(name);
                tb1.addCell(sid);
                tb1.addCell(cour);
                tb1.addCell(regfee);
                tb1.addCell(courfee);
                tb1.addCell(examfee);

            }
            doc.add(tb1);
        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        doc.close();

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student payments to pdf')";
            pst = conn.prepareStatement(reg);
            pst.execute();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_print_btn1ActionPerformed

    private void export_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btn1ActionPerformed

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport = null;

        DefaultTableModel model = (DefaultTableModel) studentPayment_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Student Payment Details");

                excelSheet.setColumnWidth(1, 5000);

                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExport.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Export Successfully");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExport != null) {
                        excelJTableExport.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        }
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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student payments to excel')";
            pst = conn.prepareStatement(reg);
            pst.execute();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_export_btn1ActionPerformed

    private void print_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btn2ActionPerformed

        String path = "";
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PDF FILE", "pdf");
        j.setFileFilter(fnef);
        int pdfChooser = j.showSaveDialog(this);

        if (pdfChooser == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        com.itextpdf.text.Font blueFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, com.itextpdf.text.Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Document doc = new Document(PageSize.A4.rotate());
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream(path + ".pdf"));
            doc.open();

            doc.add(new Paragraph((new Chunk("Student Exam Mark" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(9);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Result Sheet"));
            cell.setColspan(9);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Mark_id"));
            cell2.setColspan(1);
            cell2.setBackgroundColor(BaseColor.GRAY);
            cell2.setPadding(5.0f);
            tb1.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Name"));
            cell3.setColspan(1);
            cell3.setBackgroundColor(BaseColor.GRAY);
            cell3.setPadding(5.0f);
            tb1.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Student_id"));
            cell4.setColspan(1);
            cell4.setBackgroundColor(BaseColor.GRAY);
            cell4.setPadding(5.0f);
            tb1.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Course"));
            cell5.setColspan(1);
            cell5.setBackgroundColor(BaseColor.GRAY);
            cell5.setPadding(5.0f);
            tb1.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Subject"));
            cell6.setColspan(1);
            cell6.setBackgroundColor(BaseColor.GRAY);
            cell6.setPadding(5.0f);
            tb1.addCell(cell6);

            PdfPCell cell7 = new PdfPCell(new Paragraph("Assign_status"));
            cell7.setColspan(1);
            cell7.setBackgroundColor(BaseColor.GRAY);
            cell7.setPadding(5.0f);
            tb1.addCell(cell7);

            PdfPCell cell8 = new PdfPCell(new Paragraph("Final_mark"));
            cell8.setColspan(1);
            cell8.setBackgroundColor(BaseColor.GRAY);
            cell8.setPadding(5.0f);
            tb1.addCell(cell8);

            PdfPCell cell9 = new PdfPCell(new Paragraph("Grade"));
            cell9.setColspan(1);
            cell9.setBackgroundColor(BaseColor.GRAY);
            cell9.setPadding(5.0f);
            tb1.addCell(cell9);

            PdfPCell cell10 = new PdfPCell(new Paragraph("Status"));
            cell10.setColspan(1);
            cell10.setBackgroundColor(BaseColor.GRAY);
            cell10.setPadding(5.0f);
            tb1.addCell(cell10);

            for (int i = 0; i < studentMark_table.getRowCount(); i++) {

                String mId = studentMark_table.getValueAt(i, 0).toString();
                String name = studentMark_table.getValueAt(i, 1).toString();
                String sid = studentMark_table.getValueAt(i, 2).toString();
                String cour = studentMark_table.getValueAt(i, 3).toString();
                String sub = studentMark_table.getValueAt(i, 4).toString();
                String assign = studentMark_table.getValueAt(i, 5).toString();
                String mark = studentMark_table.getValueAt(i, 6).toString();
                String grade = studentMark_table.getValueAt(i, 7).toString();
                String status = studentMark_table.getValueAt(i, 8).toString();

                tb1.addCell(mId);
                tb1.addCell(name);
                tb1.addCell(sid);
                tb1.addCell(cour);
                tb1.addCell(sub);
                tb1.addCell(assign);
                tb1.addCell(mark);
                tb1.addCell(grade);
                tb1.addCell(status);

            }
            doc.add(tb1);
        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        doc.close();

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student exam marks to pdf')";
            pst = conn.prepareStatement(reg);
            pst.execute();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_print_btn2ActionPerformed

    private void export_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btn2ActionPerformed

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport = null;

        DefaultTableModel model = (DefaultTableModel) studentMark_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Student Exam Mark");

                excelSheet.setColumnWidth(1, 5000);
                excelSheet.setColumnWidth(4, 8000);

                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExport.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Export Successfully");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExport != null) {
                        excelJTableExport.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        }
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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get student exam marks to excel')";
            pst = conn.prepareStatement(reg);
            pst.execute();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_export_btn2ActionPerformed

    private void coursemanage_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursemanage_lblActionPerformed
        setVisible(false);
        CourseManagement object = new CourseManagement();
        object.setVisible(true);
    }//GEN-LAST:event_coursemanage_lblActionPerformed

    private void txt_telKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_telKeyPressed

    private void txt_telKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyReleased
        try {
            int i = Integer.parseInt(txt_tel.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            txt_tel.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_telKeyReleased

    private void txt_ageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ageKeyReleased
        try {
            int a = Integer.parseInt(txt_age.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            txt_age.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_ageKeyReleased

    private void txt_studentidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_studentidKeyReleased
        try {
            int a = Integer.parseInt(txt_studentid.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            txt_studentid.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_studentidKeyReleased

    private void txt_stuidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stuidKeyReleased
        try {
            int a = Integer.parseInt(txt_stuid.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            txt_stuid.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_stuidKeyReleased

    private void stuid_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuid_txtKeyReleased
        try {
            int a = Integer.parseInt(stuid_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            stuid_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stuid_txtKeyReleased

    private void nofdays_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nofdays_txtKeyReleased
        try {
            int a = Integer.parseInt(nofdays_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            nofdays_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nofdays_txtKeyReleased

    private void nofstu_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nofstu_txtKeyReleased
        try {
            int a = Integer.parseInt(nofstu_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            nofstu_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nofstu_txtKeyReleased

    private void stuid_txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuid_txt1KeyReleased
        try {
            int a = Integer.parseInt(stuid_txt1.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            stuid_txt1.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stuid_txt1KeyReleased

    private void stuid_txt2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuid_txt2KeyReleased
        try {
            int a = Integer.parseInt(stuid_txt2.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            stuid_txt2.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stuid_txt2KeyReleased

    private void assignm_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_assignm_txtKeyReleased
        try {
            int a = Integer.parseInt(assignm_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            assignm_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_assignm_txtKeyReleased

    private void writtenm_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_writtenm_txtKeyReleased
        try {
            int a = Integer.parseInt(writtenm_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            writtenm_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_writtenm_txtKeyReleased

    private void practicalm_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_practicalm_txtKeyReleased
        try {
            int a = Integer.parseInt(practicalm_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            practicalm_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_practicalm_txtKeyReleased

    private void regfee_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regfee_txtKeyReleased
        try {
            int a = Integer.parseInt(regfee_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            regfee_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_regfee_txtKeyReleased

    private void courfee_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courfee_txtKeyReleased
        try {
            int a = Integer.parseInt(courfee_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            courfee_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_courfee_txtKeyReleased

    private void exafee_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exafee_txtKeyReleased
        try {
            int a = Integer.parseInt(exafee_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            exafee_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exafee_txtKeyReleased

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
            java.util.logging.Logger.getLogger(StudentManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudentManagementSystem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about_lbl;
    private javax.swing.JCheckBox abs_rbtn;
    private javax.swing.JTextField assignm_txt;
    private javax.swing.JLabel assigns_lbl;
    private javax.swing.JButton clear2_btn;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton clear_btn1;
    private javax.swing.JButton clear_btn2;
    private javax.swing.JButton clear_btn3;
    private javax.swing.JTextField courfee_txt;
    private javax.swing.JComboBox<String> course_combo;
    private javax.swing.JComboBox<String> course_combo1;
    private javax.swing.JComboBox<String> course_combo2;
    private javax.swing.JComboBox<String> course_combo3;
    private javax.swing.JLabel course_lbl;
    private javax.swing.JMenuItem coursemanage_lbl;
    private javax.swing.JMenu date1_lbl;
    private javax.swing.JMenu date2_lbl;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField exafee_txt;
    private javax.swing.JButton export_btn;
    private javax.swing.JButton export_btn1;
    private javax.swing.JButton export_btn2;
    private javax.swing.JLabel grade_lbl;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem help_lbl;
    private javax.swing.JLabel id_lbl;
    public com.toedter.calendar.JDateChooser jDateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem logout_lbl;
    private javax.swing.JMenuItem mainmenu_lbl;
    private javax.swing.JLabel mark_lbl;
    private javax.swing.JMenu menu_lbl;
    private javax.swing.JLabel message_lbl;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField nofdays_txt;
    private javax.swing.JTextField nofstu_txt;
    private javax.swing.JTextField practicalm_txt;
    private javax.swing.JCheckBox pre_rbtn;
    private javax.swing.JLabel presenta_lbl;
    private javax.swing.JButton print_btn;
    private javax.swing.JButton print_btn1;
    private javax.swing.JButton print_btn2;
    private javax.swing.JRadioButton r_do;
    private javax.swing.JRadioButton r_female;
    private javax.swing.JRadioButton r_male;
    private javax.swing.JRadioButton r_not;
    private javax.swing.JTextField regfee_txt;
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton reset_btn1;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton save_btn1;
    private javax.swing.JButton save_btn2;
    private javax.swing.JButton save_btn3;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField search_txt1;
    private javax.swing.JButton show_btn;
    private javax.swing.JLabel status_lbl;
    private javax.swing.JLabel stid_lbl;
    private javax.swing.JLabel stname_lbl;
    private javax.swing.JTable studentMark_table;
    public javax.swing.JTable studentPayment_table;
    private javax.swing.JTable student_table;
    private javax.swing.JTable studentatten_table;
    private javax.swing.JTable studentpresentage_table;
    private javax.swing.JTextField stuid_txt;
    private javax.swing.JTextField stuid_txt1;
    private javax.swing.JTextField stuid_txt2;
    private javax.swing.JTextField stuname_txt;
    private javax.swing.JTextField stuname_txt1;
    private javax.swing.JLabel sub_lbl;
    private javax.swing.JComboBox<String> subject_combo;
    private javax.swing.JMenu time1_lbl;
    private javax.swing.JMenu time2_lbl;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_address2;
    public javax.swing.JTextField txt_age;
    private javax.swing.JLabel txt_emp;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_name1;
    private javax.swing.JTextField txt_studentid;
    private javax.swing.JTextField txt_stuid;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField writtenm_txt;
    // End of variables declaration//GEN-END:variables
    private String gender;
    private String course;
    private String attenden;
    private String assignment;
}

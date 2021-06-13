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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Buddhi Rangana
 */
public final class CourseManagement extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public CourseManagement() {

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

        initComponents();
        setTitle("Course Management");
        setIconImage(new ImageIcon(getClass().getResource("SMS Icon.png")).getImage());
        conn = db.java_db();
        currentDate();
        shotime();
        tableHeader();
        Update_table();
        Update_table2();
        Update_table3();
        txt_age.setEnabled(false);
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

    public void tableHeader() {

        JTableHeader header1 = course_table.getTableHeader();
        header1.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header2 = subject_table.getTableHeader();
        header2.setFont(new Font("Arial", Font.BOLD, 12));
        JTableHeader header3 = lecturer_table.getTableHeader();
        header3.setFont(new Font("Arial", Font.BOLD, 12));

    }

    private void Update_table() {

        try {
            String sql = "select * from Course";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            course_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
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
            String sql = "select * from Subject";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            subject_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
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
            String sql = "select * from Lecturer";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            lecturer_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Courseid_txt = new javax.swing.JTextField();
        Coursename_txt = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        coursedura_txt = new javax.swing.JTextField();
        coursefee_txt = new javax.swing.JTextField();
        coursecredit_txt = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_table = new javax.swing.JTable();
        print_btn1 = new javax.swing.JButton();
        export_btn1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        save_btn2 = new javax.swing.JButton();
        clear_btn2 = new javax.swing.JButton();
        update_btn2 = new javax.swing.JButton();
        delete_btn2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_lecid = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        r_male = new javax.swing.JRadioButton();
        r_female = new javax.swing.JRadioButton();
        txt_address = new javax.swing.JTextField();
        txt_address2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lecturer_table = new javax.swing.JTable();
        export_btn2 = new javax.swing.JButton();
        print_btn2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        subcode_txt = new javax.swing.JTextField();
        subname_txt = new javax.swing.JTextField();
        subcreadits_txt = new javax.swing.JTextField();
        save_btn1 = new javax.swing.JButton();
        update_btn1 = new javax.swing.JButton();
        delete_btn1 = new javax.swing.JButton();
        clear_btn1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sublecid_txt = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();
        export_btn = new javax.swing.JButton();
        print_btn = new javax.swing.JButton();
        txt_emp = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_lbl = new javax.swing.JMenu();
        stumanage_lbl = new javax.swing.JMenuItem();
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
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(1720, 734));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1720, 648));
        jTabbedPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTabbedPane1PropertyChange(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1684, 598));

        jPanel7.setBackground(new java.awt.Color(44, 62, 80));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Course ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        Coursename_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Coursename_txtActionPerformed(evt);
            }
        });

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

        coursecredit_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coursecredit_txtKeyReleased(evt);
            }
        });

        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn.setText("Add Record");
        save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
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

        clear_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/erase.png"))); // NOI18N
        clear_btn.setText("Clear");
        clear_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course ID :");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Name :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Start Date :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duration :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course Fee :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Credits :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delete_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(save_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clear_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(coursecredit_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coursefee_txt)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coursedura_txt)
                    .addComponent(Courseid_txt)
                    .addComponent(Coursename_txt))
                .addGap(87, 87, 87))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Courseid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Coursename_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursedura_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursefee_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursecredit_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(44, 62, 80));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Course_id", "Corse_name", "Start_date", "Duration", "Course_fee", "Credits"
            }
        ));
        course_table.getTableHeader().setReorderingAllowed(false);
        course_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(course_table);

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(print_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1718, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Courses", jPanel1);

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        jPanel6.setBackground(new java.awt.Color(44, 62, 80));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(44, 62, 80));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Lecturer Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 383));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact Number :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date of Birth :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name :");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address Line 01 :");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Age :");

        save_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn2.setText("Add Record");
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

        update_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/update .png"))); // NOI18N
        update_btn2.setText("Update");
        update_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn2ActionPerformed(evt);
            }
        });

        delete_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/delete.gif"))); // NOI18N
        delete_btn2.setText("Delete");
        delete_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn2ActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Lecturer ID :");

        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
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

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Address Line 02 :");

        jDateChooser1.setBackground(new java.awt.Color(44, 62, 80));
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(jLabel11))
                .addGap(41, 41, 41)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(r_male, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r_female, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_tel)
                    .addComponent(txt_address)
                    .addComponent(txt_lecid)
                    .addComponent(txt_name)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_address2)
                    .addComponent(txt_age))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_lecid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_female)
                    .addComponent(r_male)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(44, 62, 80));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lecturer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        lecturer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Lecturer_id", "Name", "Dob", "Telephone", "Address1", "Address2", "Gender", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        lecturer_table.getTableHeader().setReorderingAllowed(false);
        lecturer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lecturer_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lecturer_table);

        export_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Excel Icon.png"))); // NOI18N
        export_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btn2ActionPerformed(evt);
            }
        });

        print_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Pdf Icon.png"))); // NOI18N
        print_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(print_btn2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(export_btn2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Lecturer", jPanel3);

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Subjects ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(500, 383));

        subname_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subname_txtActionPerformed(evt);
            }
        });

        subcreadits_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subcreadits_txtKeyReleased(evt);
            }
        });

        save_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/save.png"))); // NOI18N
        save_btn1.setText("Add Record");
        save_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn1ActionPerformed(evt);
            }
        });

        update_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/update .png"))); // NOI18N
        update_btn1.setText("Update");
        update_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn1ActionPerformed(evt);
            }
        });

        delete_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/delete.gif"))); // NOI18N
        delete_btn1.setText("Delete");
        delete_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn1ActionPerformed(evt);
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

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Subject Code :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Subject Name :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Credits :");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Lecturer ID :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(delete_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(clear_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(subname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(subcode_txt)
                    .addComponent(sublecid_txt)
                    .addComponent(subcreadits_txt))
                .addGap(87, 87, 87))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subcode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subcreadits_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sublecid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(44, 62, 80));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subject Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        subject_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Subject_code", "Subject_name", "Credits", "Lecturer_id"
            }
        ));
        subject_table.getTableHeader().setReorderingAllowed(false);
        subject_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subject_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(subject_table);

        export_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Excel Icon.png"))); // NOI18N
        export_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btnActionPerformed(evt);
            }
        });

        print_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Pdf Icon.png"))); // NOI18N
        print_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(export_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(print_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Subjects", jPanel2);

        txt_emp.setText("emp");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Admin icon.png"))); // NOI18N
        jLabel46.setText("Logged in As :");

        jPanel12.setBackground(new java.awt.Color(47, 62, 80));
        jPanel12.setPreferredSize(new java.awt.Dimension(881, 57));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Niibs Logo 2.png"))); // NOI18N
        jLabel20.setText(" Copyright © 2019 - 2020 NIIBS, Group 01. All Rights Reserved.");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 11, -1, 35));

        menu_lbl.setText("Menu");
        menu_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_lblActionPerformed(evt);
            }
        });

        stumanage_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student_management_system/image/Users-Student-icon2.png"))); // NOI18N
        stumanage_lbl.setText("Student Management");
        stumanage_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        stumanage_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stumanage_lblActionPerformed(evt);
            }
        });
        menu_lbl.add(stumanage_lbl);

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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_emp)
                    .addComponent(jLabel46))
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void menu_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_lblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_lblActionPerformed

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

    private void Coursename_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Coursename_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Coursename_txtActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        if (!(jDateChooser.getDate() == null || Courseid_txt.getText().isEmpty() || Coursename_txt.getText().isEmpty() || coursedura_txt.getText().isEmpty() || coursefee_txt.getText().isEmpty() || coursecredit_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add course?", "Add Course", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {
                    String sql = "insert into Course"
                            + "(Course_id,Course_name,"
                            + "Start_date,Duration,Course_fee,"
                            + "Credits)values (?,?,?,?,?,?) ";

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, Courseid_txt.getText());
                    pst.setString(2, Coursename_txt.getText());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                    String date = sdf.format(jDateChooser.getDate());

                    pst.setString(3, date);
                    pst.setString(4, coursedura_txt.getText());
                    pst.setString(5, coursefee_txt.getText());
                    pst.setString(6, coursecredit_txt.getText());

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

                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Course Details')";
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
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        Coursename_txt.setText("");
        coursedura_txt.setText("");
        jDateChooser.setDate(null);
        coursefee_txt.setText("");
        coursecredit_txt.setText("");
        Courseid_txt.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        if (!(jDateChooser.getDate() == null || Courseid_txt.getText().isEmpty() || Coursename_txt.getText().isEmpty() || coursedura_txt.getText().isEmpty() || coursefee_txt.getText().isEmpty() || coursecredit_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Update Course", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {

                    String value1 = Coursename_txt.getText();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                    String date = sdf.format(jDateChooser.getDate());

                    String value2 = date;
                    String value3 = Courseid_txt.getText();
                    String value4 = coursedura_txt.getText();
                    String value5 = coursefee_txt.getText();
                    String value6 = coursecredit_txt.getText();

                    String sql = "update Course set Course_id='" + value3 + "',Course_name='" + value1 + "', Start_date='" + value2 + "', "
                            + "Duration='" + value4 + "',Course_fee='" + value5 + "',Credits='" + value6 + "'"
                            + "where Course_id='" + value3 + "' ";

                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Course Updated");

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
                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + values + "','Updated Course Details')";
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
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (!(jDateChooser.getDate() == null || Courseid_txt.getText().isEmpty() || Coursename_txt.getText().isEmpty() || coursedura_txt.getText().isEmpty() || coursefee_txt.getText().isEmpty() || coursecredit_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete course?", "Delete", JOptionPane.YES_NO_OPTION);
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
                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Deleted Course Details')";
                    pst = conn.prepareStatement(reg);
                    pst.execute();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                String sql = "delete from Course where Course_id=? ";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, Courseid_txt.getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Course Deleted");

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
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void jDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserMouseClicked

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserPropertyChange

    private void jDateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserKeyReleased

    private void course_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) course_table.getModel();
        int SelectedRowIndex = course_table.getSelectedRow();

        Courseid_txt.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        Coursename_txt.setText(model.getValueAt(SelectedRowIndex, 1).toString());

        try {
            int srow = course_table.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy.MM.dd").parse((String) model.getValueAt(srow, 2));
            jDateChooser.setDate(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        coursedura_txt.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        coursefee_txt.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        coursecredit_txt.setText(model.getValueAt(SelectedRowIndex, 5).toString());

    }//GEN-LAST:event_course_tableMouseClicked

    private void subname_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subname_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subname_txtActionPerformed

    private void save_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn1ActionPerformed
        if (!(subcode_txt.getText().isEmpty() || subname_txt.getText().isEmpty() || subcreadits_txt.getText().isEmpty() || sublecid_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add subject?", "Add Subject", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {
                    String sql = "insert into Subject"
                            + "(Subject_code,Subject_name,"
                            + "Credits,Lecturer_id)values (?,?,?,?) ";

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, subcode_txt.getText());
                    pst.setString(2, subname_txt.getText());
                    pst.setString(3, subcreadits_txt.getText());
                    pst.setString(4, sublecid_txt.getText());

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

                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Subject Details')";
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

    private void update_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn1ActionPerformed
        if (!(subcode_txt.getText().isEmpty() || subname_txt.getText().isEmpty() || subcreadits_txt.getText().isEmpty() || sublecid_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Update Subject", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                try {

                    String value1 = subname_txt.getText();
                    String value2 = subcreadits_txt.getText();
                    String value3 = subcode_txt.getText();
                    String value4 = sublecid_txt.getText();

                    String sql = "update Subject set Subject_code='" + value3 + "',Subject_name='" + value1 + "', "
                            + "Credits='" + value2 + "', Lecturer_id='" + value4 + "'"
                            + "where Subject_code='" + value3 + "' ";

                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Subject Updated");

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
                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + values + "','Updated Subject Details')";
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
    }//GEN-LAST:event_update_btn1ActionPerformed

    private void delete_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn1ActionPerformed
        if (!(subcode_txt.getText().isEmpty() || subname_txt.getText().isEmpty() || subcreadits_txt.getText().isEmpty() || sublecid_txt.getText().isEmpty())) {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete subject?", "Delete", JOptionPane.YES_NO_OPTION);
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
                    String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Deleted Subject Details')";
                    pst = conn.prepareStatement(reg);
                    pst.execute();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                String sql = "delete from Subject where Subject_code=? ";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, subcode_txt.getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Subject Deleted");

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
                Update_table2();

            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_btn1ActionPerformed

    private void clear_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn1ActionPerformed
        subname_txt.setText("");
        subcreadits_txt.setText("");
        subcode_txt.setText("");
        sublecid_txt.setText("");
    }//GEN-LAST:event_clear_btn1ActionPerformed

    private void subject_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subject_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) subject_table.getModel();
        int SelectedRowIndex = subject_table.getSelectedRow();
        subcode_txt.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        subname_txt.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        subcreadits_txt.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        sublecid_txt.setText(model.getValueAt(SelectedRowIndex, 3).toString());
    }//GEN-LAST:event_subject_tableMouseClicked

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void save_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn2ActionPerformed
        if (!(jDateChooser1.getDate() == null || txt_lecid.getText().isEmpty() || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty())) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add lecturer?", "Add Lecturer", JOptionPane.YES_NO_OPTION);
                if (p == 0) {

                    try {
                        String sql = "insert into Lecturer"
                                + "(Lecturer_id,Name,"
                                + "Dob,Telephone,Address1,"
                                + "Address2,Gender,"
                                + "Age) values (?,?,?,?,?,?,?,?) ";

                        Date d = new Date();
                        SimpleDateFormat f = new SimpleDateFormat("yyyy");
                        int yearNow = Integer.parseInt(f.format(d));
                        int yearDob = Integer.parseInt(f.format(jDateChooser1.getDate()));
                        int BD = (yearNow - yearDob);
                        String age = Integer.toString(BD);
                        txt_age.setText(age);

                        pst = conn.prepareStatement(sql);
                        pst.setString(1, txt_lecid.getText());
                        pst.setString(2, txt_name.getText());

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        String date = sdf.format(jDateChooser1.getDate());

                        pst.setString(3, date);
                        pst.setString(4, txt_tel.getText());
                        pst.setString(5, txt_address.getText());
                        pst.setString(6, txt_address2.getText());
                        pst.setString(7, gender);
                        pst.setString(8, txt_age.getText());

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

                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Added Lecturer Details')";
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
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btn2ActionPerformed

    private void clear_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn2ActionPerformed
        txt_name.setText("");
        txt_tel.setText("");
        jDateChooser1.setDate(null);
        txt_address.setText("");
        txt_address2.setText("");
        txt_lecid.setText("");
        txt_age.setText("");
    }//GEN-LAST:event_clear_btn2ActionPerformed

    private void update_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn2ActionPerformed
        if (!(jDateChooser1.getDate() == null || txt_age.getText().isEmpty() || txt_lecid.getText().isEmpty() || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty())) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Update Lecturer", JOptionPane.YES_NO_OPTION);
                if (p == 0) {

                    try {

                        String value1 = txt_name.getText();

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        String date = sdf.format(jDateChooser1.getDate());

                        String value2 = date;
                        String value3 = txt_lecid.getText();
                        String value4 = txt_tel.getText();
                        String value5 = txt_address.getText();
                        String value6 = txt_address2.getText();
                        String value7 = gender;
                        String value8 = txt_age.getText();

                        String sql = "update Lecturer set Lecturer_id='" + value3 + "',Name='" + value1 + "', Dob='" + value2 + "', "
                                + "Telephone='" + value4 + "',Address1='" + value5 + "',Address2='" + value6 + "',Gender= '" + value7 + "', "
                                + "Age='" + value8 + "'"
                                + "where Lecturer_id='" + value3 + "' ";

                        pst = conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Lecturer Updated");

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
                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + values + "','Updated Lecturer Details')";
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
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_btn2ActionPerformed

    private void delete_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn2ActionPerformed
        if (!(jDateChooser1.getDate() == null || txt_age.getText().isEmpty() || txt_lecid.getText().isEmpty() || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty() || txt_address.getText().isEmpty() || txt_address2.getText().isEmpty())) {
            if (txt_tel.getText().length() == 10) {
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete lecturer?", "Delete", JOptionPane.YES_NO_OPTION);
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
                        String reg = "insert into Audit (User_id, Date, Status) values ('" + val + "','" + value0 + " / " + value1 + "','Deleted Lecturer Details')";
                        pst = conn.prepareStatement(reg);
                        pst.execute();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    String sql = "delete from Lecturer where Lecturer_id=? ";
                    try {
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, txt_lecid.getText());
                        pst.execute();

                        JOptionPane.showMessageDialog(null, "Lecturer Deleted");

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
                    Update_table3();

                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Enter valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "One or more required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_btn2ActionPerformed

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

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void lecturer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturer_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();
        int SelectedRowIndex = lecturer_table.getSelectedRow();

        txt_lecid.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        txt_name.setText(model.getValueAt(SelectedRowIndex, 1).toString());

        try {
            int srow = lecturer_table.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy.MM.dd").parse((String) model.getValueAt(srow, 2));
            jDateChooser1.setDate(date);
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

    }//GEN-LAST:event_lecturer_tableMouseClicked

    private void stumanage_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stumanage_lblActionPerformed
        setVisible(false);
        StudentManagementSystem object = new StudentManagementSystem();
        object.setVisible(true);
    }//GEN-LAST:event_stumanage_lblActionPerformed

    private void export_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btnActionPerformed

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport = null;

        DefaultTableModel model = (DefaultTableModel) subject_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Subject Details");

                excelSheet.setColumnWidth(0, 5000);
                excelSheet.setColumnWidth(1, 8000);

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get subject details to excel')";
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

            doc.add(new Paragraph((new Chunk("Subject Details" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(4);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Subjects"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Subject_code"));
            cell2.setColspan(1);
            cell2.setBackgroundColor(BaseColor.GRAY);
            cell2.setPadding(5.0f);
            tb1.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Subject_name"));
            cell3.setColspan(1);
            cell3.setBackgroundColor(BaseColor.GRAY);
            cell3.setPadding(5.0f);
            tb1.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Credits"));
            cell4.setColspan(1);
            cell4.setBackgroundColor(BaseColor.GRAY);
            cell4.setPadding(5.0f);
            tb1.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Lecturer_id"));
            cell5.setColspan(1);
            cell5.setBackgroundColor(BaseColor.GRAY);
            cell5.setPadding(5.0f);
            tb1.addCell(cell5);

            for (int i = 0; i < subject_table.getRowCount(); i++) {

                String code = subject_table.getValueAt(i, 0).toString();
                String name = subject_table.getValueAt(i, 1).toString();
                String crea = subject_table.getValueAt(i, 2).toString();
                String lec = subject_table.getValueAt(i, 3).toString();

                tb1.addCell(code);
                tb1.addCell(name);
                tb1.addCell(crea);
                tb1.addCell(lec);

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get subject details to pdf')";
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

            doc.add(new Paragraph((new Chunk("Lecturer Details" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(8);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Details Report"));
            cell.setColspan(8);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Lecturer_id"));
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

            for (int i = 0; i < lecturer_table.getRowCount(); i++) {

                String lId = lecturer_table.getValueAt(i, 0).toString();
                String name = lecturer_table.getValueAt(i, 1).toString();
                String dob = lecturer_table.getValueAt(i, 2).toString();
                String gen = lecturer_table.getValueAt(i, 3).toString();
                String tele = lecturer_table.getValueAt(i, 4).toString();
                String add1 = lecturer_table.getValueAt(i, 5).toString();
                String add2 = lecturer_table.getValueAt(i, 6).toString();
                String age = lecturer_table.getValueAt(i, 7).toString();

                tb1.addCell(lId);
                tb1.addCell(name);
                tb1.addCell(dob);
                tb1.addCell(gen);
                tb1.addCell(tele);
                tb1.addCell(add1);
                tb1.addCell(add2);
                tb1.addCell(age);
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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get lecturer details to pdf')";
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

            doc.add(new Paragraph((new Chunk("Course Details" + "\n", blueFont))));
            doc.add(new Paragraph((year) + "/" + (month + 1) + "/" + day));
            PdfPTable tb1 = new PdfPTable(6);
            tb1.setHorizontalAlignment(ALIGN_CENTER);
            tb1.setWidthPercentage(100);
            tb1.setSpacingBefore(10f);
            tb1.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Courses"));
            cell.setColspan(6);
            cell.setHorizontalAlignment(ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(10.0f);
            tb1.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Course_id"));
            cell2.setColspan(1);
            cell2.setBackgroundColor(BaseColor.GRAY);
            cell2.setPadding(5.0f);
            tb1.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Course_name"));
            cell3.setColspan(1);
            cell3.setBackgroundColor(BaseColor.GRAY);
            cell3.setPadding(5.0f);
            tb1.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Start_date"));
            cell4.setColspan(1);
            cell4.setBackgroundColor(BaseColor.GRAY);
            cell4.setPadding(5.0f);
            tb1.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Duration"));
            cell5.setColspan(1);
            cell5.setBackgroundColor(BaseColor.GRAY);
            cell5.setPadding(5.0f);
            tb1.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Paragraph("Course_Fee"));
            cell6.setColspan(1);
            cell6.setBackgroundColor(BaseColor.GRAY);
            cell6.setPadding(5.0f);
            tb1.addCell(cell6);

            PdfPCell cell7 = new PdfPCell(new Paragraph("Credits"));
            cell7.setColspan(1);
            cell7.setBackgroundColor(BaseColor.GRAY);
            cell7.setPadding(5.0f);
            tb1.addCell(cell7);

            for (int i = 0; i < course_table.getRowCount(); i++) {

                String cId = course_table.getValueAt(i, 0).toString();
                String cname = course_table.getValueAt(i, 1).toString();
                String sd = course_table.getValueAt(i, 2).toString();
                String dur = course_table.getValueAt(i, 3).toString();
                String courfee = course_table.getValueAt(i, 4).toString();
                String cre = course_table.getValueAt(i, 5).toString();

                tb1.addCell(cId);
                tb1.addCell(cname);
                tb1.addCell(sd);
                tb1.addCell(dur);
                tb1.addCell(courfee);
                tb1.addCell(cre);

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get course details to pdf')";
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

        DefaultTableModel model = (DefaultTableModel) course_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Course Details");

                excelSheet.setColumnWidth(0, 6000);
                excelSheet.setColumnWidth(2, 4000);
                excelSheet.setColumnWidth(3, 4000);
                excelSheet.setColumnWidth(4, 4000);

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get course details to excel')";
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

    private void export_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btn2ActionPerformed

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport = null;

        DefaultTableModel model = (DefaultTableModel) lecturer_table.getModel();

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(this);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Lecturer Details");

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
            String reg = "insert into Audit (User_id,Date,Status) values ('" + value + "','" + value0 + " / " + values + "','Get lecturer details to excel')";
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

    private void coursecredit_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coursecredit_txtKeyReleased
        try {
            int a = Integer.parseInt(coursecredit_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            coursecredit_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_coursecredit_txtKeyReleased

    private void txt_telKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyReleased
        try {
            int a = Integer.parseInt(txt_tel.getText());

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

    private void subcreadits_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subcreadits_txtKeyReleased
        try {
            int a = Integer.parseInt(subcreadits_txt.getText());

        } catch (NumberFormatException e) {
            getToolkit().beep();
            subcreadits_txt.setText("");
            JOptionPane.showMessageDialog(null, "You can add numbers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_subcreadits_txtKeyReleased

    private void jTabbedPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1PropertyChange

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
            java.util.logging.Logger.getLogger(CourseManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CourseManagement().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Courseid_txt;
    private javax.swing.JTextField Coursename_txt;
    private javax.swing.JMenuItem about_lbl;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton clear_btn1;
    private javax.swing.JButton clear_btn2;
    private javax.swing.JTable course_table;
    private javax.swing.JTextField coursecredit_txt;
    private javax.swing.JTextField coursedura_txt;
    private javax.swing.JTextField coursefee_txt;
    private javax.swing.JMenu date1_lbl;
    private javax.swing.JMenu date2_lbl;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton delete_btn1;
    private javax.swing.JButton delete_btn2;
    private javax.swing.JButton export_btn;
    private javax.swing.JButton export_btn1;
    private javax.swing.JButton export_btn2;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem help_lbl;
    public com.toedter.calendar.JDateChooser jDateChooser;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable lecturer_table;
    private javax.swing.JMenuItem logout_lbl;
    private javax.swing.JMenuItem mainmenu_lbl;
    private javax.swing.JMenu menu_lbl;
    private javax.swing.JButton print_btn;
    private javax.swing.JButton print_btn1;
    private javax.swing.JButton print_btn2;
    private javax.swing.JRadioButton r_female;
    private javax.swing.JRadioButton r_male;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton save_btn1;
    private javax.swing.JButton save_btn2;
    private javax.swing.JMenuItem stumanage_lbl;
    private javax.swing.JTextField subcode_txt;
    private javax.swing.JTextField subcreadits_txt;
    private javax.swing.JTable subject_table;
    private javax.swing.JTextField sublecid_txt;
    private javax.swing.JTextField subname_txt;
    private javax.swing.JMenu time1_lbl;
    private javax.swing.JMenu time2_lbl;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_address2;
    public javax.swing.JTextField txt_age;
    private javax.swing.JLabel txt_emp;
    private javax.swing.JTextField txt_lecid;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_btn1;
    private javax.swing.JButton update_btn2;
    // End of variables declaration//GEN-END:variables

    private String gender;
}

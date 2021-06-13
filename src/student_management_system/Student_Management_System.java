package student_management_system;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.ImageIcon;

/**
 *
 * @author Buddhi Rangana
 */
public class Student_Management_System {

    public static void main(String[] args) throws AWTException {

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Loading lu = new Loading();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            lu.setVisible(true);
        });

        lu.setVisible(true);
        Login lo = new Login();

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                lu.out.setText(Integer.toString(i) + "%");
                if (i == 100) {
                    lu.setVisible(false);
                    lo.setVisible(true);

                }
            }
        } catch (InterruptedException e) {
        }
        lo.displayTray();
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
}

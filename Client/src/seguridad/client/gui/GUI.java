package seguridad.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JInternalFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 686, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(3, 431, 667, -432);
		frame.getContentPane().add(desktopPane);
		
		JPanel adminpanel = new JPanel();
		adminpanel.setBackground(new Color(176, 224, 230));
		adminpanel.setBounds(6, 6, 658, 417);
		frame.getContentPane().add(adminpanel);
		GridBagLayout gbl_adminpanel = new GridBagLayout();
		gbl_adminpanel.columnWidths = new int[]{0, 149, 51, 51, 43, 151, 0};
		gbl_adminpanel.rowHeights = new int[]{0, 0, 0};
		gbl_adminpanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_adminpanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		adminpanel.setLayout(gbl_adminpanel);
		
		JLabel lblUserList = new JLabel("USER LIST");
		lblUserList.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblUserList = new GridBagConstraints();
		gbc_lblUserList.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserList.gridx = 1;
		gbc_lblUserList.gridy = 0;
		adminpanel.add(lblUserList, gbc_lblUserList);
		
		JLabel lblAdminList = new JLabel("ADMIN LIST");
		lblAdminList.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblAdminList = new GridBagConstraints();
		gbc_lblAdminList.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdminList.gridx = 5;
		gbc_lblAdminList.gridy = 0;
		adminpanel.add(lblAdminList, gbc_lblAdminList);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		adminpanel.add(list, gbc_list);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 5;
		gbc_list_1.gridy = 1;
		adminpanel.add(list_1, gbc_list_1);
		
	/**	JInternalFrame LoginFrame = new JInternalFrame("Log In");
		LoginFrame.setBounds(163, 70, 381, 231);
		frame.getContentPane().add(LoginFrame);
		LoginFrame.setBackground(new Color(204, 204, 255));
		LoginFrame.setResizable(false);
		LoginFrame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(22, 29, 77, 35);
		LoginFrame.getContentPane().add(lblUser);
		
		textField = new JTextField();
		textField.setBounds(109, 38, 196, 20);
		LoginFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPassword.setBounds(22, 75, 77, 35);
		LoginFrame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 84, 196, 20);
		LoginFrame.getContentPane().add(passwordField);
		
		JButton btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginFrame.dispose();
			}
		});
		btnDone.setBounds(146, 167, 89, 23);
		LoginFrame.getContentPane().add(btnDone);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtp.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOtp.setBounds(22, 121, 77, 35);
		LoginFrame.getContentPane().add(lblOtp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 130, 196, 20);
		LoginFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		desktopPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{LoginFrame, LoginFrame.getContentPane(), lblUser, textField, lblPassword, passwordField, btnDone, lblOtp, textField_1}));
		LoginFrame.setVisible(true);**/
	}
}
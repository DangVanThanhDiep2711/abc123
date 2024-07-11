package entity;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JScrollPane;

public class ManageForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton btnlManagerEmployee;
	private JButton btnNewButton_1;
	private JPanel panelManagerEmployee;
	private JTable employeeTable;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageForm frame = new ManageForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageForm() {
		setTitle("ManagerForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 701);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnlManagerEmployee = new JButton("Manager Employee");
		menuBar.add(btnlManagerEmployee);

		btnNewButton_1 = new JButton("New button");
		menuBar.add(btnNewButton_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
//-------------------------------------------------------------------------------------------------------------------------------
		// Tạo panelManagerEmployee
		panelManagerEmployee = new JPanel();
		contentPane.add(panelManagerEmployee, "UserInformation");
		panelManagerEmployee.setLayout(null);

		// trong panelManagerEmployee
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1054, 537);
		panelManagerEmployee.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(307, 578, 89, 23);
		panelManagerEmployee.add(btnAdd);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(429, 578, 89, 23);
		panelManagerEmployee.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(558, 578, 89, 23);
		panelManagerEmployee.add(btnDelete);

// -------------------------------------------------------------------------------------------------------------------------------

		
	}
}

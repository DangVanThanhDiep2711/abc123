package entity;


import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class EmployeeMainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton btnRequestLeave;
	private JPanel panelRequestLeave;
	private JButton btnNotification;
	private JButton btnUserInformation;
	private JPanel panelUserInfor;
	private JPanel panelNotification;
	private CardLayout cardLayout;
	private JLabel nameLabel;
    private JLabel roleLabel;
	private JLabel lblLeavetype;
	private JComboBox<String> leaveTypeCombo;
	private JLabel lblLeaveRequests;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(() -> {
			try {
				EmployeeMainForm frame = new EmployeeMainForm();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeMainForm() {
		setLocationByPlatform(true);
		setTitle("EmployeeMainForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 510);

		// Tạo CardLayout và đặt cho contentPane
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Tạo menuBar và các nút
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnRequestLeave = new JButton("Request Leave");
		btnRequestLeave.addActionListener(this::btnRequestLeaveActionPerformed);
		menuBar.add(btnRequestLeave);

		btnNotification = new JButton("Notification");
		btnNotification.addActionListener(e -> cardLayout.show(contentPane, "Notification"));
		menuBar.add(btnNotification);

		btnUserInformation = new JButton("User Information");
		btnUserInformation.addActionListener(e -> cardLayout.show(contentPane, "UserInformation"));
		menuBar.add(btnUserInformation);

		// Tạo panelNotification
		panelNotification = new JPanel();
		panelNotification.setBackground(new Color(0, 255, 0));
		contentPane.add(panelNotification, "Notification");

		// Tạo panelUserInfor
		panelUserInfor = new JPanel();
		contentPane.add(panelUserInfor, "UserInformation");
		panelUserInfor.setLayout(null);
		
		//trong userInfor
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        nameLabel = new JLabel("Tên: [Tên nhân viên]");
        roleLabel = new JLabel("Vai trò: [Vai trò nhân viên]");

        panel.add(nameLabel);
        panel.add(roleLabel);

        getContentPane().add(panel);


		// Tạo panelRequestLeave
		panelRequestLeave = new JPanel();
		panelRequestLeave.setBackground(new Color(192, 192, 192));
		contentPane.add(panelRequestLeave, "RequestLeave");
		panelRequestLeave.setLayout(null);

		// trong RequestLeave
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(42, 147, 129, 25);
		panelRequestLeave.add(lblStartDate);

		JTextField txtStartDate = new JTextField();
		txtStartDate.setBounds(104, 147, 497, 25);
		panelRequestLeave.add(txtStartDate);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(42, 183, 129, 25);
		panelRequestLeave.add(lblEndDate);

		JTextField txtEndDate = new JTextField();
		txtEndDate.setBounds(104, 183, 497, 25);
		panelRequestLeave.add(txtEndDate);

		JButton btnSubmitRequest = new JButton("Submit Request");
		btnSubmitRequest.setBounds(205, 294, 240, 30);
		btnSubmitRequest.addActionListener(e -> {
			String startDate = txtStartDate.getText();
			String endDate = txtEndDate.getText();
			if (startDate.isEmpty() || endDate.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter both start and end dates.");
			} else {
				// Xử lý yêu cầu nghỉ phép ở đây
				JOptionPane.showMessageDialog(this, "Request Submitted: " + startDate + " to " + endDate);
			}
		});
		panelRequestLeave.add(btnSubmitRequest);

		lblLeavetype = new JLabel("LeaveType :");
		lblLeavetype.setBounds(42, 111, 129, 25);
		panelRequestLeave.add(lblLeavetype);

		leaveTypeCombo = new JComboBox<>(new String[] { "Nghỉ bệnh", "Nghỉ cá nhân", "Nghỉ thai sản", "Khác" });
		leaveTypeCombo.setBounds(104, 111, 497, 25);
		panelRequestLeave.add(leaveTypeCombo);

		lblLeaveRequests = new JLabel("Leave Requests");
		lblLeaveRequests.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblLeaveRequests.setBounds(208, 38, 202, 25);
		panelRequestLeave.add(lblLeaveRequests);

		// Hiển thị panelNotification đầu tiên khi ứng dụng khởi động
		cardLayout.show(contentPane, "UserInformation");
	}

	// Phương thức xử lý sự kiện cho nút Request Leave
	protected void btnRequestLeaveActionPerformed(ActionEvent e) {
		// Hiển thị panelRequestLeave bằng cách sử dụng CardLayout
		cardLayout.show(contentPane, "RequestLeave");
	}
}
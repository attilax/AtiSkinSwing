package com.attilax.mail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComboBox;

//import chrriis.dj.nativeswing.swtimpl.demo.examples.webbrowser.Ati4vod;





import com.attilax.io.pathx;
import com.attilax.skin.SkinX;
import com.attilax.ui.MsgBox;

public class AccTesterGUI {

	private JFrame frame;
	private JTextField txtCemtxt;
	private JTextField txtCpwdtxt;
	private JTextField txtCrzttxt;
	private JTextField textField;
	private JTextField txtAttilaxqqcom;
	JComboBox comboBox = new JComboBox();
	
	protected void skinCombox_change_event(ItemEvent e) {
		  if(e.getStateChange() == ItemEvent.SELECTED){  
		 String index= (String) this.comboBox.getSelectedItem();
		 SkinX.setSkin(index,this.frame);
	//	MsgBox.setTxt("ttt");
		 }
			
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 String f = pathx.classPath()+File.separator+"a.ico";
		    f = pathx.classPath()+File.separator+"mov.png";
		 System.out.println(new File(f).exists());
		 System.out.println(f);
		final ImageIcon icon=new ImageIcon(f);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccTesterGUI window = new AccTesterGUI();
					
				 	SkinX.setComboBoxVal(window.comboBox);
					window.frame.setIconImage(icon.getImage());
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
	public AccTesterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("导入邮箱列表");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				import_email();
			}
		});
		btnNewButton.setBounds(10, 26, 130, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("密码列表");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imoprt_pwd();
			}
		});
		btnNewButton_1.setBounds(20, 59, 120, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txtCemtxt = new JTextField();
		txtCemtxt.setText("C:\\EM.TXT");
		txtCemtxt.setBounds(150, 27, 490, 21);
		frame.getContentPane().add(txtCemtxt);
		txtCemtxt.setColumns(10);
		
		txtCpwdtxt = new JTextField();
		txtCpwdtxt.setText("c:\\pwd.txt");
		txtCpwdtxt.setColumns(10);
		txtCpwdtxt.setBounds(150, 60, 490, 21);
		frame.getContentPane().add(txtCpwdtxt);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("@之前");
		chckbxNewCheckBox.setBounds(108, 107, 103, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("邮箱全部");
		checkBox.setBounds(225, 107, 103, 23);
		frame.getContentPane().add(checkBox);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(29, 111, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSmtp = new JLabel("smtp服务器");
		lblSmtp.setBounds(29, 152, 54, 15);
		frame.getContentPane().add(lblSmtp);
		
		JCheckBox checkBox_1 = new JCheckBox("@后面的顶级域名");
		checkBox_1.setBounds(108, 148, 103, 23);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox chckbxMail = new JCheckBox("mail+顶级域名");
		chckbxMail.setBounds(225, 148, 103, 23);
		frame.getContentPane().add(chckbxMail);
		
		JCheckBox chckbxSmtp = new JCheckBox("smtp+顶级域名");
		chckbxSmtp.setBounds(379, 148, 103, 23);
		frame.getContentPane().add(chckbxSmtp);
		
		JLabel lblNewLabel_1 = new JLabel("保存结果");
		lblNewLabel_1.setBounds(29, 209, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtCrzttxt = new JTextField();
		txtCrzttxt.setText("c:\\rzt.txt");
		txtCrzttxt.setColumns(10);
		txtCrzttxt.setBounds(112, 206, 490, 21);
		frame.getContentPane().add(txtCrzttxt);
		
		JLabel lblNewLabel_2 = new JLabel("线程数");
		lblNewLabel_2.setBounds(29, 260, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText("5");
		textField.setBounds(108, 257, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("测试邮件");
		label.setBounds(29, 184, 54, 15);
		frame.getContentPane().add(label);
		
		txtAttilaxqqcom = new JTextField();
		txtAttilaxqqcom.setText("attilax2@qq.com");
		txtAttilaxqqcom.setColumns(10);
		txtAttilaxqqcom.setBounds(112, 175, 490, 21);
		frame.getContentPane().add(txtAttilaxqqcom);
		
		JButton btnNewButton_2 = new JButton("开始");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start_click();
			}
		});
		btnNewButton_2.setBounds(29, 296, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("停止");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(173, 296, 93, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(243, 350, 4, 24);
		frame.getContentPane().add(textArea);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(53, 329, 651, 148);
		frame.getContentPane().add(textPane);
		
	
		comboBox.setBounds(498, 257, 210, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_1 = new JLabel("skin");
		label_1.setBounds(461, 260, 24, 15);
		frame.getContentPane().add(label_1);
		
		  comboBox.addItemListener(new ItemListener() {
			  	public void itemStateChanged(ItemEvent arg0) {
			  		skinCombox_change_event(arg0);
			  	}
			  });
	}

	protected void imoprt_pwd() {
		JFileChooser	jFileChooser1 = new javax.swing.JFileChooser();
		jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				File f = jFileChooser1.getSelectedFile();
				txtCpwdtxt.setText(f.getAbsolutePath());
			//	jTextArea1.setText(f.getAbsolutePath());
			//	jTextField3_file.setText(f.getAbsolutePath());
				// jtex
			}
		});
		jFileChooser1.showOpenDialog(this.frame);
		
	}
	protected void import_email() {
		JFileChooser	jFileChooser1 = new javax.swing.JFileChooser();
		jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				File f = jFileChooser1.getSelectedFile();
				txtCemtxt.setText(f.getAbsolutePath());
			//	jTextArea1.setText(f.getAbsolutePath());
			//	jTextField3_file.setText(f.getAbsolutePath());
				// jtex
			}
		});
		jFileChooser1.showOpenDialog(this.frame);
		
	}
	protected void start_click() {
		int threadCount = Integer.parseInt(this.textField.getText());
	//	es= Executors.newFixedThreadPool(threadCount);
		AccTester ax = new AccTester(threadCount);
		ax.start(txtCemtxt.getText(), txtCpwdtxt.getText(), txtCrzttxt.getText());
		 MsgBox.setTxt("ok");
		
	}
}

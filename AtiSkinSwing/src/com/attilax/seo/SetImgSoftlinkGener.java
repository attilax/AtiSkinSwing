package com.attilax.seo;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.SpringLayout;

import com.attilax.skin.IS‌kinInir;
import com.attilax.skin.SkinX;
import com.attilax.ui.MsgBox;
import com.birosoft.liquid.LiquidLookAndFeel;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;

public class SetImgSoftlinkGener   {

	private JFrame frame;
	private JTextField txtWatcheskof;
	private JTextField txtimagesallwatchesttwimagemedium;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 //   UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
		//   LiquidLookAndFeel.setLiquidDecorations(true );
	//	JFrame.setDefaultLookAndFeelDecorated(true);
	//	UIManager.setLookAndFeel(LnF);
	//	SwingUtilities.updateComponentTreeUI(this);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetImgSoftlinkGener window = new SetImgSoftlinkGener();
				//	window.comboBox.addItem(arg0);
				//	window.comboBox.addItem(new String[]{"a","b"});
					SkinX.setComboBoxVal(window.comboBox);
					//window.comboBox.addItem(SkinX.skinNames());
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
	public SetImgSoftlinkGener() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("imgPostion");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 54, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 27, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 103, SpringLayout.WEST, frame.getContentPane());
	//	springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.NORTH, frame.getContentPane());
		
		frame.getContentPane().add(lblNewLabel);
		
		txtWatcheskof = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtWatcheskof, 21, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtWatcheskof, 113, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtWatcheskof, 566, SpringLayout.WEST, frame.getContentPane());
		//springLayout.putConstraint(SpringLayout.SOUTH, txtWatcheskof, 0, SpringLayout.NORTH, frame.getContentPane());
		txtWatcheskof.setText("watcheskof");
		frame.getContentPane().add(txtWatcheskof);
		txtWatcheskof.setColumns(10);
		
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 129, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, 21, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -22, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, -20, SpringLayout.EAST, frame.getContentPane());
	//	springLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, frame.getContentPane());
		
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btn_click();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   String name=txtWatcheskof.getText();
				     String imgPostion=txtimagesallwatchesttwimagemedium.getText();
				     String tmp=" ln -s   @img  /home_src/@wbst0/public_html/images/";
				     tmp=tmp.replaceAll("@img", imgPostion).replaceAll("@wbst", name);
				     tmp=tmp+"small"+"\r\n"+tmp+"medium"+"\r\n"+tmp+"large";
				     textArea.setText(tmp);
			}
		});
		frame.getContentPane().add(btnNewButton);
	
		
		JLabel label = new JLabel("websiteName");
		springLayout.putConstraint(SpringLayout.NORTH, label, 24, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 27, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, 103, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		txtimagesallwatchesttwimagemedium = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 15, SpringLayout.SOUTH, txtimagesallwatchesttwimagemedium);
		springLayout.putConstraint(SpringLayout.NORTH, txtimagesallwatchesttwimagemedium, 51, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtimagesallwatchesttwimagemedium, 113, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtimagesallwatchesttwimagemedium, 566, SpringLayout.WEST, frame.getContentPane());
		txtimagesallwatchesttwimagemedium.setText("/images_all/watches_ttw888/image_medium");
		txtimagesallwatchesttwimagemedium.setColumns(10);
		frame.getContentPane().add(txtimagesallwatchesttwimagemedium);
		
		  comboBox = new JComboBox();
		  comboBox.addItemListener(new ItemListener() {
		  	public void itemStateChanged(ItemEvent arg0) {
		  		skinCombox_change_event(arg0);
		  	}
		  });
//		  comboBox.addActionListener(new ActionListener() {
//		  	public void actionPerformed(ActionEvent arg0) {
//		  		skinCombox_change_event(arg0);
//		  	}
//		  });
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 1, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, -149, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, txtWatcheskof);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSkin = new JLabel("skin");
		springLayout.putConstraint(SpringLayout.NORTH, lblSkin, 4, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, lblSkin, -21, SpringLayout.WEST, comboBox);
		frame.getContentPane().add(lblSkin);
	}
protected void skinCombox_change_event(ItemEvent e) {
	  if(e.getStateChange() == ItemEvent.SELECTED){  
	 String index= (String) this.comboBox.getSelectedItem();
	 SkinX.setSkin(index,frame);
	MsgBox.setTxt("ttt");
	 }
		
	}

@Deprecated
	protected void btn_click() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	  //	SwingUtilities.updateComponentTreeUI(this);
		
		//  LiquidLookAndFeel.setLiquidDecorations(true );
		  
		  //change title 
		//  frame.getContentPane().setw
		//  frame.hide();//is outtime ,,will use setVisible  
		//  frame.setVisible(false);
		  
		//frame.setDefaultLookAndFeelDecorated(arg0);
		//  frame.fre
		
		//	SwingUtilities.updateComponentTreeUI(this);//apply  new ui

		//	window.frame
		//	SwingUtilities.upd
			
			
		
			
		
	     
		
	}
}

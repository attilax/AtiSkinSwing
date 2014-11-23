package com.attilax.ui;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class MsgBox {

	public static void setTxt(String string) {
		//不带图标 alert
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, string, "标题", JOptionPane.PLAIN_MESSAGE);
		
	}

}

package com.attilax.skin;

import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.birosoft.liquid.LiquidLookAndFeel;

public class SkinX {
	// public SkinX() {
	// super();
	// // TODO Auto-generated constructor stub
	// }
	private static void setUndecoratedTitlebar(JFrame frame, boolean b) {
		// -----------refresh titlebar

		frame.dispose();
		frame.setUndecorated(b);
		// if(index.equals("windows"))
		// {
		// frame.setUndecorated(false);// set Notitlebar true
		// //set frame whether show raw ExtraTitlebar
		// }else
		// {
		// frame.setUndecorated(true);
		// }

		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);// set
																		// titlebar
		Notitlebar = true;
		frame.setVisible(true);

	}

	public static Map map;
	static {
		map = new HashMap() {
			{
				this.put("windows", new IS‌kinInir() {

					@Override
					public void ini(JFrame frame) {
						setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						setUndecoratedTitlebar(frame, false);

					}

				});
				// --指定为Windows的界面外观, 仅在Windows平台起作用.
				this.put("mac.Liquid", new IS‌kinInir() {

					@Override
					public void ini(JFrame frame) {
						String skinClass = "com.birosoft.liquid.LiquidLookAndFeel";
						setLookAndFeel(skinClass);
						LiquidLookAndFeel.setLiquidDecorations(true);
						setUndecoratedTitlebar(frame, true);
					}

				});
				// UIManager.get
				this.put("java", new IS‌kinInir() {

					@Override
					public void ini(JFrame frame) {

						setLookAndFeel(UIManager
								.getCrossPlatformLookAndFeelClassName());
						setUndecoratedTitlebar(frame, true);
					}
				});
				// );
				// "javax.swing.plaf.metal.MetalLookAndFeel"
				// --指定为Java的界面外观,
				// 也就是方法UIManager.getCrossPlatformLookAndFeelClassName()的返回值.
				this.put("sys", new IS‌kinInir() {

					@Override
					public void ini(JFrame frame) {

						setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
						setUndecoratedTitlebar(frame, false);
					}
				});
				// );
				// UIManager.getSystemLookAndFeelClassName()
				// --指定为当前平台的界面外观.在32位Windows平台, 为Windows界面外观; 在Mac OS平台, 为Mac
				// OS界面外观; 在Sun平台, 为CDE/Motif界面外观.
				// LiquidLookAndFeel.setLiquidDecorations(true ); } );
				this.put("CDE/Motif", new IS‌kinInir() {

					@Override
					public void ini(JFrame frame) {

						setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
						setUndecoratedTitlebar(frame, false);
					}
				});
				// );

				// --指定为CDE/Motif的界面外观, 可以在所有平台起作用.
				// jeig ui window hamyar k neke l ...

				this.put("mac(only in macOS)",
						"javax.swing.plaf.mac.MacLookAndFeel");

				// --指定为Mac OS的界面外观, 仅在Mac OS平台起作用.

				// "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
				// com.birosoft.liquid.LiquidLookAndFeel
			}
		};
	}

	private static void setLookAndFeel(String skinClass) {
		try {
			UIManager.setLookAndFeel(skinClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("ClassNotFoundException" + skinClass);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException("InstantiationException");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("IllegalAccessException");

		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			throw new RuntimeException("UnsupportedLookAndFeelException");

		}
	}

	public static void main(String[] args) {

	}

//	@SuppressWarnings("rawtypes")
//	public static Vector skinNames() {
//
//		return (Vector) map.entrySet();
//	}

	public static void setComboBoxVal(JComboBox comboBox) {
		// TODO Auto-generated method stub
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String str = it.next();
			comboBox.addItem(str);
		}
	}

	public static void setSkin(String index, JFrame frame) {
		Object item = SkinX.map.get(index);

		// 改变标题栏 title bar and border JFrame JDialog
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		if (item instanceof IS‌kinInir) {
			((IS‌kinInir) item).ini(frame);
		} else {
			setLookAndFeel(item.toString());
		}
		if (Notitlebar) {
		}

	 
		SwingUtilities.updateComponentTreeUI(frame);// apply new ui
		// frame.pack(); jeig bnen use ,beirs main win gchw le
		// .重置每个顶层容器的大小来适应它所包含的组件的新大小

	}

	static boolean Notitlebar = false;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.tgrynchuk.xml.mvc.gui;

import com.epam.tgrynchuk.xml.mvc.engine.XmlController;

import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Taras
 */
@SuppressWarnings("serial")
public class MainWindow extends javax.swing.JFrame {
	private final XmlController controller;

	/**
	 * Creates new form MainWindow
	 */

	/**
	 * Creates new form MainWindow
	 * 
	 * @param controller
	 */
	public MainWindow(XmlController controller) {
		super(controller.getCurrentFile().getPath());
		this.controller = controller;
		initComponents();

		java.awt.EventQueue.invokeLater(() -> {
			MainWindow.this.setVisible(true);
		});
	}

	public void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(this, message, title,
				JOptionPane.OK_OPTION);
	}

	public void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(this, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	public void println(Object obj) {
		text.setText(text.getText() + obj.toString() + "\n");
	}

	public void clear() {
		text.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		text = new javax.swing.JTextArea();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		importMenu = new javax.swing.JMenu();
		importCheckXSD = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JPopupMenu.Separator();
		importDOMParser = new javax.swing.JMenuItem();
		importSAXParser = new javax.swing.JMenuItem();
		importSTAXParser = new javax.swing.JMenuItem();
		importEmptyMenu = new javax.swing.JMenuItem();
		convertMenu = new javax.swing.JMenu();
		convertToXML = new javax.swing.JMenuItem();
		convertToHTML = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		text.setColumns(20);
		text.setRows(5);
		jScrollPane1.setViewportView(text);

		fileMenu.setMnemonic('f');
		fileMenu.setText("File");

		openMenuItem.setMnemonic('o');
		openMenuItem.setText("Open");
		openMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(openMenuItem);

		exitMenuItem.setMnemonic('x');
		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		importMenu.setMnemonic('e');
		importMenu.setText("Import");

		importCheckXSD.setMnemonic('t');
		importCheckXSD.setText("Check XSD");
		importCheckXSD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importCheckXSDActionPerformed(evt);
			}
		});
		importMenu.add(importCheckXSD);
		importMenu.add(jSeparator2);

		importDOMParser.setMnemonic('y');
		importDOMParser.setText("DOM Parser");
		importDOMParser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importDOMParserActionPerformed(evt);
			}
		});
		importMenu.add(importDOMParser);

		importSAXParser.setMnemonic('p');
		importSAXParser.setText("SAX Parser");
		importSAXParser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importSAXParserActionPerformed(evt);
			}
		});
		importMenu.add(importSAXParser);

		importSTAXParser.setMnemonic('d');
		importSTAXParser.setText("STAX Parser");
		importSTAXParser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importSTAXParserActionPerformed(evt);
			}
		});
		importMenu.add(importSTAXParser);
		importEmptyMenu.setText("Show inital file");
		importEmptyMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importEmptyMenuActionPerformed(evt);
			}
		});
		importMenu.add(importEmptyMenu);

		menuBar.add(importMenu);

		convertMenu.setMnemonic('h');
		convertMenu.setText("Convert");

		convertToXML.setMnemonic('c');
		convertToXML.setText("to XML");
		convertToXML.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				convertToXMLActionPerformed(evt);
			}
		});
		convertMenu.add(convertToXML);

		convertToHTML.setMnemonic('a');
		convertToHTML.setText("to HTML");
		convertToHTML.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				convertToHTMLActionPerformed(evt);
			}
		});
		convertMenu.add(convertToHTML);

		menuBar.add(convertMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 567,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 329,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {

	}

	private void importCheckXSDActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.checkXSD();
	}

	private void importDOMParserActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.parseXML("DOMParser");
	}

	private void importSAXParserActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.parseXML("SAXParser");
	}

	private void importSTAXParserActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.parseXML("STAXParser");
	}

	private void importEmptyMenuActionPerformed(java.awt.event.ActionEvent evt) {
		controller.showInitalFile();
	}

	private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser openFile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"XML files (*.xml)", "xml");
		openFile.setFileFilter(filter);
		if (openFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = openFile.getSelectedFile();
			String fileName = file.getAbsolutePath();
			try {

				controller.setCurrentFile(file);

				this.setTitle(file.getPath());
				println("File opened: " + file.getName());

				// showMessage(fileName, "File opened !");

			} catch (Exception e) {
				showErrorMessage("Error opening file !\n" + fileName + "\n",
						"Error !");
			}
		}
	}

	private void convertToHTMLActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.convertToHTML();
	}

	private void convertToXMLActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		controller.convertToXML();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		// java.awt.EventQueue.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		// new MainWindow().setVisible(true);
		// }
		// });
	}

	// Variables declaration - do not modify
	private javax.swing.JMenu convertMenu;
	private javax.swing.JMenuItem convertToHTML;
	private javax.swing.JMenuItem convertToXML;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenuItem importCheckXSD;
	private javax.swing.JMenuItem importDOMParser;
	private javax.swing.JMenuItem importEmptyMenu;
	private javax.swing.JMenu importMenu;
	private javax.swing.JMenuItem importSAXParser;
	private javax.swing.JMenuItem importSTAXParser;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPopupMenu.Separator jSeparator2;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JTextArea text;
	// End of variables declaration

}

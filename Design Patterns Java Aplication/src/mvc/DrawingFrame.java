package mvc;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import observer.ButtonsObserver;

import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;

public class DrawingFrame extends JFrame {	
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	
	private JToggleButton tglbtnPoint, tglbtnLine, tglbtnRectangle, tglbtnCircle;
	private JPanel navPanel;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtnDonut;
	private JToggleButton tglbtnHexagon;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSavePainting;
	private JButton btnDelete;
	private JButton btnEdit;
	private JToggleButton tglbtnSelect;
	private JPanel bottomPanel;
	private JButton btnBringToFront;
	private JButton btnBringToBack;
	private JButton btnToFront;
	private JButton btnToBack;
	private JButton btnInsideColor;
	private JPanel LeftPanel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnUndo;
	private JButton btnRedo;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnOutsideColor;
	private JPanel panel;
	private JLabel lblLog;
	private JTextArea textAreaLog;
	private JScrollPane scrollPane;
	private JMenuItem menuItemOpenPainting;
	private JMenuItem mntmSaveLog;
	private JMenuItem mntmOpenLog;
	private JButton btnloadNext;
	private JSeparator separator_4;
	private JSeparator separator_5;
	
	public JPanel getNavPanel() {
		return navPanel;
	}
	
	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public JToggleButton getTglbtnHexagon() {
		return tglbtnHexagon;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public JTextArea getTextAreaLog() {
		return textAreaLog;
	}
	
	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}
	
	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public JButton getBtnInsideColor() {
		return btnInsideColor;
	}

	public JButton getBtnOutsideColor() {
		return btnOutsideColor;
	}
	
	public JButton getBtnloadNext() {
		return btnloadNext;
	}

	public DrawingFrame() {
		setTitle("Drawing App");
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					controller.mouseClicked(arg0);
					/*if(tglbtnPoint.isSelected())
						controller.mouseClicked(arg0,"point");
					else if (tglbtnLine.isSelected())
						controller.mouseClicked(arg0, "line");
					else if (tglbtnRectangle.isSelected())
						controller.mouseClicked(arg0, "rectangle");
					else if (tglbtnCircle.isSelected())
						controller.mouseClicked(arg0, "circle");
					else if (tglbtnDonut.isSelected())
						controller.mouseClicked(arg0, "donut");
					else if (tglbtnHexagon.isSelected())
						controller.mouseClicked(arg0, "hexagon");
					else if (tglbtnSelect.isSelected())
						controller.mouseClicked(arg0, "select");*/
			}
		});
		getContentPane().add(view, BorderLayout.CENTER);
		
		navPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) navPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(navPanel, BorderLayout.NORTH);
		
		tglbtnSelect = new JToggleButton("Select");
		navPanel.add(tglbtnSelect);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mouseClickedDelete(e);
			}
		});
		navPanel.add(btnDelete);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mouseClickedEdit(e);
			}
		});
		btnEdit.setEnabled(false);
		navPanel.add(btnEdit);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmSavePainting = new JMenuItem("Save painting");
		mntmSavePainting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.savePainting();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmSavePainting);
		
		menuItemOpenPainting = new JMenuItem("Open painting");
		menuItemOpenPainting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.openPainting();
					//controller.selectEditUpdate();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mntmSaveLog = new JMenuItem("Save log");
		mntmSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveLog();
			}
		});
		mnFile.add(mntmSaveLog);
		mnFile.add(menuItemOpenPainting);
		
		mntmOpenLog = new JMenuItem("Open log");
		mntmOpenLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.openLog();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmOpenLog);
		buttonGroup.add(tglbtnSelect);
		
		separator = new JSeparator();
		navPanel.add(separator);
		
		separator_1 = new JSeparator();
		navPanel.add(separator_1);
		
		btnUndo = new JButton("Undo");
		btnUndo.setEnabled(false);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.undo();
				//controller.selectEditUpdate();
				btnRedo.setEnabled(true);
				btnloadNext.setEnabled(false);
				//System.out.println("Stek: "+controller.getCmdStack().getUndoStack().size());
				if((controller.getCmdStack().getCurrent()+1)==0){
					btnUndo.setEnabled(false);
					btnloadNext.setEnabled(false);
				}
			}
		});
		navPanel.add(btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				//controller.selectEditUpdate();
				btnUndo.setEnabled(true);
				if(controller.getCmdStack().getCurrent()==controller.getCmdStack().getList().size()-1){
					btnRedo.setEnabled(false);
					if(controller.isloadLogEnd()) {
						btnloadNext.setEnabled(false);
					} else {
						btnloadNext.setEnabled(true); 
					}
				}
			}
		});
		navPanel.add(btnRedo);
		
		separator_2 = new JSeparator();
		navPanel.add(separator_2);
		
		separator_3 = new JSeparator();
		navPanel.add(separator_3);
		
		btnInsideColor = new JButton("Inside Color");
		navPanel.add(btnInsideColor);
		
		btnOutsideColor = new JButton("Outside Color");
		btnOutsideColor.setBackground(Color.WHITE);
		btnOutsideColor.setForeground(Color.BLACK);
		btnOutsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOutsideColor.setBackground(JColorChooser.showDialog(null, "Chose inside color", Color.RED));
				if(btnOutsideColor.getBackground().equals(Color.BLACK)) {
					btnOutsideColor.setForeground(Color.WHITE);
				}
			}
		});
		btnInsideColor.setBackground(Color.WHITE);
		btnInsideColor.setForeground(Color.BLACK);
		navPanel.add(btnOutsideColor);
		
		separator_4 = new JSeparator();
		navPanel.add(separator_4);
		
		separator_5 = new JSeparator();
		navPanel.add(separator_5);
		
		btnloadNext = new JButton("Load next");
		btnloadNext.setEnabled(false);
		btnloadNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadNext();
				//controller.selectEditUpdate();
			}
		});
		navPanel.add(btnloadNext);
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsideColor.setBackground(JColorChooser.showDialog(null, "Chose inside color", Color.RED));
				if(btnInsideColor.getBackground().equals(Color.BLACK)) {
					btnInsideColor.setForeground(Color.WHITE);
				}
			}
		});
		
		bottomPanel = new JPanel();
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		lblLog = new JLabel("Log");
		bottomPanel.add(lblLog, BorderLayout.NORTH);
		
		textAreaLog = new JTextArea(5, 20);
		textAreaLog.setEditable(false);
		//bottomPanel.add(textAreaLog, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(textAreaLog);
		bottomPanel.add(scrollPane, BorderLayout.SOUTH);
		
		LeftPanel = new JPanel();
		getContentPane().add(LeftPanel, BorderLayout.WEST);
		LeftPanel.setLayout(new MigLayout("", "[57px]", "[][][][][][]"));
		
		tglbtnPoint = new JToggleButton("Point");
		LeftPanel.add(tglbtnPoint, "cell 0 0,grow");
		
		buttonGroup.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		LeftPanel.add(tglbtnLine, "cell 0 1,growx");
		buttonGroup.add(tglbtnLine);
		
			tglbtnRectangle = new JToggleButton("Rectangle");
			LeftPanel.add(tglbtnRectangle, "cell 0 2,growx");
			buttonGroup.add(tglbtnRectangle);
			
			tglbtnCircle = new JToggleButton("Circle");
			LeftPanel.add(tglbtnCircle, "cell 0 3,growx");
			buttonGroup.add(tglbtnCircle);
			
			tglbtnDonut = new JToggleButton("Donut");
			LeftPanel.add(tglbtnDonut, "cell 0 4,growx");
			buttonGroup.add(tglbtnDonut);
			
			tglbtnHexagon = new JToggleButton("Hexagon");
			LeftPanel.add(tglbtnHexagon, "cell 0 5,growx");
			buttonGroup.add(tglbtnHexagon);
			
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.EAST);
			panel.setLayout(new MigLayout("", "[]", "[][][][]"));
			
			btnBringToFront = new JButton("Front");
			btnBringToFront.setEnabled(false);
			btnBringToFront.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.bringForward();
					controller.buttonsUpdate();
				}
			});
			panel.add(btnBringToFront, "cell 0 0,growx");
			
			btnBringToBack = new JButton("Back");
			btnBringToBack.setEnabled(false);
			btnBringToBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.bringBackward();
					controller.buttonsUpdate();
				}
			});
			panel.add(btnBringToBack, "cell 0 1,growx");
			
			btnToFront = new JButton("To Front");
			btnToFront.setEnabled(false);
			btnToFront.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.bringToFront();
					controller.buttonsUpdate();
				}
			});
			panel.add(btnToFront, "cell 0 2,growx");
			
			btnToBack = new JButton("To Back");
			btnToBack.setEnabled(false);
			panel.add(btnToBack, "cell 0 3,growx");
			btnToBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.bringToBack();
					controller.buttonsUpdate();
				}
			});
	}
	
	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	/*@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("deleteButton")) {
			btnDelete.setEnabled((boolean)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("editButton")) {
			btnEdit.setEnabled((boolean)evt.getNewValue());
		}
	}*/
	
	/*ButtonsObserver bean = new ButtonsObserver();
    bean.addPropertyChangeListener(e -> 
        label.setText((String) e.getNewValue())
    );*/
	
	
}

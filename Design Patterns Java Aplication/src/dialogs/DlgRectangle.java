package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DlgRectangle extends JDialog {
	
	private boolean isOK;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	
	private JButton btnInsideColor;
	private JButton btnEdgeColor;
	
	private Color edgeColor = Color.BLACK;
	private Color insideColor = Color.BLACK;
	private JTextField textFieldUpperLeftX;
	private JTextField textFieldUpperLeftY;
	
	private JLabel lblUpperLeftX, lblUpperLeftY;
	
	public JTextField getTextFieldUpperLeftX() {
		return textFieldUpperLeftX;
	}

	public JTextField getTextFieldUpperLeftY() {
		return textFieldUpperLeftY;
	}

	public JLabel getLblUpperLeftX() {
		return lblUpperLeftX;
	}

	public JLabel getLblUpperLeftY() {
		return lblUpperLeftY;
	}

	public JButton getBtnInsideColor() {
		return btnInsideColor;
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public boolean isOK() {
		return isOK;
	}
	
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public Color getInsideColor() {
		return insideColor;
	}
	
	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				isOK=false;
			}
		});
		setTitle("Rectangle");
		setModal(true);
		setBounds(100, 100, 318, 287);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldHeight.getText().isEmpty() || textFieldWidth.getText().isEmpty()) {
							isOK = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "You must fill in all the fields!","Error", JOptionPane.WARNING_MESSAGE);
						} else {
							isOK = true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOK = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
			{
				JLabel lblEnterHeight = new JLabel("Enter height:");
				panel.add(lblEnterHeight, "cell 0 0,alignx center");
			}
			{
				textFieldHeight = new JTextField();
				textFieldHeight.setTransferHandler(null);
				textFieldHeight.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (!((c >= '0') && (c <= '9') ||
								(c == KeyEvent.VK_BACK_SPACE) ||
								(c == KeyEvent.VK_DELETE))) {
							e.consume();
							getToolkit().beep();
						}
					}
				});
				panel.add(textFieldHeight, "cell 1 0,growx");
				textFieldHeight.setColumns(10);
			}
			{
				{
					JLabel lblEnterWidth = new JLabel("Enter width:");
					panel.add(lblEnterWidth, "cell 0 1,alignx center");
				}
			}
			textFieldWidth = new JTextField();
			textFieldWidth.setTransferHandler(null);
			textFieldWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
				}
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			panel.add(textFieldWidth, "cell 1 1,growx");
			textFieldWidth.setColumns(10);
			{
				JLabel lblNewLabel = new JLabel("Select edge color:");
				panel.add(lblNewLabel, "cell 0 2,alignx trailing");
			}
			{
				btnEdgeColor = new JButton("Color");
				btnEdgeColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						edgeColor = JColorChooser.showDialog(null, "Chose edge color", Color.RED);
						btnEdgeColor.setBackground(edgeColor);
					}
				});
				panel.add(btnEdgeColor, "cell 1 2,growx");
			}
			{
				JLabel lblSelect = new JLabel("Select inside color:");
				panel.add(lblSelect, "cell 0 3");
			}
			{
				btnInsideColor = new JButton("Color");
				btnInsideColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insideColor = JColorChooser.showDialog(null, "Chose inside color", Color.RED);
						btnInsideColor.setBackground(insideColor);
					}
				});
				panel.add(btnInsideColor, "cell 1 3,growx");
			}
			{
				lblUpperLeftX = new JLabel("Upper left point X:");
				panel.add(lblUpperLeftX, "cell 0 4,alignx trailing");
			}
			{
				textFieldUpperLeftX = new JTextField();
				textFieldUpperLeftX.setTransferHandler(null);
				textFieldUpperLeftX.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (!((c >= '0') && (c <= '9') ||
								(c == KeyEvent.VK_BACK_SPACE) ||
								(c == KeyEvent.VK_DELETE))) {
							e.consume();
							getToolkit().beep();
						}
					}
				});
				panel.add(textFieldUpperLeftX, "cell 1 4,growx");
				textFieldUpperLeftX.setColumns(10);
			}
			{
				lblUpperLeftY = new JLabel("Upper left point Y:");
				panel.add(lblUpperLeftY, "cell 0 5,alignx trailing");
			}
			{
				textFieldUpperLeftY = new JTextField();
				textFieldUpperLeftY.setTransferHandler(null);
				textFieldUpperLeftY.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (!((c >= '0') && (c <= '9') ||
								(c == KeyEvent.VK_BACK_SPACE) ||
								(c == KeyEvent.VK_DELETE))) {
							e.consume();
							getToolkit().beep();
						}
					}
				});
				panel.add(textFieldUpperLeftY, "cell 1 5,growx");
				textFieldUpperLeftY.setColumns(10);
			}
		}
	}

}

package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color color = Color.BLACK;
	private boolean isOK;
	private JTextField textFieldStartX;
	private JTextField textFieldStartY;
	private JTextField textFieldEndX;
	private JTextField textFieldEndY;
	private JLabel lblStartX, lblStartY, lblEndX, lblEndY;
	private JButton btnColor;
	
	public JButton getBtnColor() {
		return btnColor;
	}

	public JTextField getTextFieldStartX() {
		return textFieldStartX;
	}

	public JTextField getTextFieldStartY() {
		return textFieldStartY;
	}

	public JTextField getTextFieldEndX() {
		return textFieldEndX;
	}

	public JTextField getTextFieldEndY() {
		return textFieldEndY;
	}

	public JLabel getLblStartX() {
		return lblStartX;
	}

	public JLabel getLblStartY() {
		return lblStartY;
	}

	public JLabel getLblEndX() {
		return lblEndX;
	}

	public JLabel getLblEndY() {
		return lblEndY;
	}

	public boolean isOK() {
		return isOK;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgLine() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				isOK=false;
			}
		});
		setTitle("Line");
		setModal(true);
		setBounds(100, 100, 182, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		{
			JLabel lblSelectColor = new JLabel("Select color:");
			contentPanel.add(lblSelectColor, "cell 0 0");
		}
		{
			btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Chose color", Color.RED);
					btnColor.setBackground(color);
				}
			});
			contentPanel.add(btnColor, "cell 1 0");
		}
		{
			lblStartX = new JLabel("Start point X:");
			contentPanel.add(lblStartX, "cell 0 1,alignx trailing");
		}
		{
			textFieldStartX = new JTextField();
			textFieldStartX.setTransferHandler(null);
			textFieldStartX.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldStartX, "cell 1 1,growx");
			textFieldStartX.setColumns(10);
		}
		{
			lblStartY = new JLabel("Start point Y:");
			contentPanel.add(lblStartY, "cell 0 2,alignx trailing");
		}
		{
			textFieldStartY = new JTextField();
			textFieldStartY.setTransferHandler(null);
			textFieldStartY.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldStartY, "cell 1 2,growx");
			textFieldStartY.setColumns(10);
		}
		{
			lblEndX = new JLabel("End point X:");
			contentPanel.add(lblEndX, "cell 0 3,alignx trailing");
		}
		{
			textFieldEndX = new JTextField();
			textFieldEndX.setTransferHandler(null);
			textFieldEndX.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldEndX, "cell 1 3,growx");
			textFieldEndX.setColumns(10);
		}
		{
			lblEndY = new JLabel("End point Y:");
			contentPanel.add(lblEndY, "cell 0 4,alignx trailing");
		}
		{
			textFieldEndY = new JTextField();
			textFieldEndY.setTransferHandler(null);
			textFieldEndY.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldEndY, "cell 1 4,growx");
			textFieldEndY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							if (textFieldStartX.getText().isEmpty() || textFieldStartY.getText().isEmpty() || textFieldEndX.getText().isEmpty() || textFieldEndY.getText().isEmpty() ) {
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
						isOK=false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

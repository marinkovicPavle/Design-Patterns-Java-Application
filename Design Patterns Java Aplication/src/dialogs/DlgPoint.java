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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color color = Color.BLACK;
	private boolean isOK;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JLabel lblX;
	private JLabel lblY;
	private JButton btnColor;

	public boolean isOK() {
		return isOK;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public JLabel getLblY() {
		return lblY;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgPoint() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				isOK=false;
			}
		});
		setTitle("Point");
		setModal(true);
		setBounds(100, 100, 164, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][grow][]"));
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
			lblX = new JLabel("X:");
			contentPanel.add(lblX, "cell 0 1,alignx trailing");
		}
		{
			textFieldX = new JTextField();
			textFieldX.setTransferHandler(null);
			textFieldX.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldX, "cell 1 1,growx");
			textFieldX.setColumns(10);
		}
		{
			lblY = new JLabel("Y:");
			contentPanel.add(lblY, "cell 0 2,alignx trailing");
		}
		{
			textFieldY = new JTextField();
			textFieldY.setTransferHandler(null);
			textFieldY.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldY, "cell 1 2,growx");
			textFieldY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if (textFieldX.getText().isEmpty() || textFieldY.getText().isEmpty() ) {
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

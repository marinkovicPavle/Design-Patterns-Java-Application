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
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DlgHexagon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRadius;
	
	private boolean isOK;
	private Color edgeColor = Color.BLACK;
	private Color insideColor = Color.BLACK;
	private JTextField textFieldCenterX;
	private JTextField textFieldCenterY;
	
	private JButton btnInsideColor;
	private JButton btnEdgeColor;
	
	public JButton getBtnInsideColor() {
		return btnInsideColor;
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}
	
	public JTextField getTextFieldCenterX() {
		return textFieldCenterX;
	}

	public JTextField getTextFieldCenterY() {
		return textFieldCenterY;
	}

	public boolean isOK() {
		return isOK;
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
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
			DlgHexagon dialog = new DlgHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgHexagon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				isOK=false;
			}
		});
		setTitle("Hexagon");
		setModal(true);
		setBounds(100, 100, 309, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		{
			JLabel lblEnterRadius = new JLabel("Enter radius:");
			contentPanel.add(lblEnterRadius, "cell 0 0,alignx center");
		}
		{
			textFieldRadius = new JTextField();
			textFieldRadius.setTransferHandler(null);
			textFieldRadius.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldRadius, "cell 1 0,growx");
			textFieldRadius.setColumns(10);
		}
		{
			JLabel lblSelectInsideColor = new JLabel("Select inside color:");
			contentPanel.add(lblSelectInsideColor, "cell 0 1,alignx center");
		}
		{
			btnInsideColor = new JButton("Color");
			btnInsideColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					insideColor = JColorChooser.showDialog(null, "Chose edge color", Color.RED);
					btnInsideColor.setBackground(insideColor);
				}
			});
			contentPanel.add(btnInsideColor, "cell 1 1,growx");
		}
		{
			JLabel lblSelectEdgeColor = new JLabel("Select edge color:");
			contentPanel.add(lblSelectEdgeColor, "cell 0 2,alignx center");
		}
		{
			btnEdgeColor = new JButton("Color");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edgeColor = JColorChooser.showDialog(null, "Chose edge color", Color.RED);
					btnEdgeColor.setBackground(edgeColor);
				}
			});
			contentPanel.add(btnEdgeColor, "cell 1 2,growx");
		}
		{
			JLabel lblCenterX = new JLabel("Center point X:");
			contentPanel.add(lblCenterX, "cell 0 3,alignx trailing");
		}
		{
			textFieldCenterX = new JTextField();
			textFieldCenterX.setTransferHandler(null);
			textFieldCenterX.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldCenterX, "cell 1 3,growx");
			textFieldCenterX.setColumns(10);
		}
		{
			JLabel lblCenterY = new JLabel("Center point Y:");
			contentPanel.add(lblCenterY, "cell 0 4,alignx trailing");
		}
		{
			textFieldCenterY = new JTextField();
			textFieldCenterY.setTransferHandler(null);
			textFieldCenterY.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(textFieldCenterY, "cell 1 4,growx");
			textFieldCenterY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldRadius.getText().isEmpty() || textFieldCenterX.getText().isEmpty() || textFieldCenterY.getText().isEmpty()) {
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
	}

}

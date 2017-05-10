package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class CambiosPanel extends JPanel {
	
	private JTextField txtEfectivo = new JTextField();

	/**
	 * Create the panel.
	 * @param total 
	 */
	public CambiosPanel(double total) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTotal = new JLabel("Total: "+String.format("%.2f", total));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 0;
		add(lblTotal, gbc_lblTotal);
		
		JLabel lblCambios = new JLabel("Cambios: "+String.format("%.2f", getCambios(total)));
		GridBagConstraints gbc_lblCambios = new GridBagConstraints();
		gbc_lblCambios.gridx = 0;
		gbc_lblCambios.gridy = 2;
		add(lblCambios, gbc_lblCambios);
		
		// Listen for changes in the text
		txtEfectivo.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
			  mostrarCambios();
		  }
		  public void removeUpdate(DocumentEvent e) {
			  mostrarCambios();
		  }
		  public void insertUpdate(DocumentEvent e) {
			  mostrarCambios();
		  }

		  public void mostrarCambios() {
			  lblCambios.setText("Cambios: "+String.format("%.2f", getCambios(total)));
		  }
		});
		
		//txtEfectivo.selectAll();
		
//		txtEfectivo.addCaretListener(new CaretListener() {
//			public void caretUpdate(CaretEvent arg0) {
//				lblCambios.setText("Cambios: "+String.format("%.2f", getCambios(total)));
//			}
//		});
		
		txtEfectivo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtEfectivo = new GridBagConstraints();
		gbc_txtEfectivo.insets = new Insets(0, 0, 5, 0);
		gbc_txtEfectivo.fill = GridBagConstraints.BOTH;
		gbc_txtEfectivo.gridx = 0;
		gbc_txtEfectivo.gridy = 1;
		add(txtEfectivo, gbc_txtEfectivo);
		txtEfectivo.setColumns(10);

	}
	
	private String getTxtEfectivo() {
		return txtEfectivo.getText();
	}
	
	private double getCambios(double total){
		if (!getTxtEfectivo().equals("")) {
			double cambios = Double.parseDouble(getTxtEfectivo()) - total;
			return cambios;
		} else {
			return 0;
		}
	}

	public void addTxtEfectivo(String str) {
		txtEfectivo.setText(txtEfectivo.getText().concat(str));
	}

	public void delTxtEfectivo() {
		txtEfectivo.setText(getTxtEfectivo().substring(0, getTxtEfectivo().length()-1));
		
	}

}

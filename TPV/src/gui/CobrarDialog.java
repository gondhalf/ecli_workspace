package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CobrarDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * 
	 * @param total
	 */
	public CobrarDialog(DefaultTableModel dm, double total) {
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Cobrar");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 2, 0, 0));
		CambiosPanel cambiosPanel = new CambiosPanel(total);
		contentPanel.add(cambiosPanel);
		CalculadoraPanel calculadoraPanel = new CalculadoraPanel(cambiosPanel);
		contentPanel.add(calculadoraPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonClick(dm);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
			}
			{
				JButton ticketButton = new JButton("OK+Ticket");
				ticketButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						imprimirTicket();
						okButtonClick(dm);
					}
				});
				ticketButton.setActionCommand("OK+Ticket");
				buttonPane.add(ticketButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton vaciarButton = new JButton("Cancelar y Vaciar Tabla");
				vaciarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dm.setRowCount(0);
						dispose();
					}
				});
				vaciarButton.setActionCommand("Cancelar y Vaciar Tabla");
				buttonPane.add(vaciarButton);
			}
		}
	}

	private void okButtonClick(DefaultTableModel dm) {
		int res = JOptionPane.showConfirmDialog(null, "Estas segur@?", "Cobrar?", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			// ANADIR TICKET A LA BBDD
			dm.setRowCount(0);
			dispose();
		}
	}

	private void imprimirTicket() {

	}

}

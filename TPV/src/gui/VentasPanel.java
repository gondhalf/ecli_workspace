package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import model.BotonProducto;

@SuppressWarnings("serial")
public class VentasPanel extends JPanel {

	private DefaultTableModel dm;
	private JTable table_Ventas;

	/**
	 * Create the panel.
	 */
	public VentasPanel() {
		setFont(new Font("Arial", Font.PLAIN, 20));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setBorder(new LineBorder(Color.DARK_GRAY));
		setLayout(new GridLayout(2, 1, 0, 0));

		dm = new DefaultTableModel(new Object[][] {}, new String[] { "Producto", "Cantidad", "Precio", "Button" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, Integer.class, Double.class, String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		JScrollPane scrollPane_tabla = new JScrollPane();
		scrollPane_tabla.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_tabla.setBorder(new LineBorder(Color.DARK_GRAY));
		scrollPane_tabla.setViewportBorder(new LineBorder(Color.DARK_GRAY));
		scrollPane_tabla.setBackground(Color.DARK_GRAY);
		add(scrollPane_tabla);
		table_Ventas = new JTable(dm);
		table_Ventas.setFont(new Font("Arial", Font.PLAIN, 20));
		table_Ventas.setBackground(Color.WHITE);
		table_Ventas.setForeground(Color.DARK_GRAY);
		table_Ventas.setBorder(new LineBorder(Color.DARK_GRAY));

		scrollPane_tabla.setViewportView(table_Ventas);

		table_Ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_Ventas.getColumnModel().getColumn(1).setMinWidth(60);
		table_Ventas.getColumnModel().getColumn(1).setMaxWidth(100);
		table_Ventas.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_Ventas.getColumnModel().getColumn(2).setMinWidth(50);
		table_Ventas.getColumnModel().getColumn(2).setMaxWidth(100);
		table_Ventas.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_Ventas.getColumnModel().getColumn(3).setMinWidth(50);
		table_Ventas.getColumnModel().getColumn(3).setMaxWidth(50);
		table_Ventas.getColumn("Button").setCellRenderer(new ButtonRenderer());
		table_Ventas.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));

		table_Ventas.setRowHeight(30);

		JPanel panel_Opcines_BtnCobrar = new JPanel();
		panel_Opcines_BtnCobrar.setForeground(Color.DARK_GRAY);
		panel_Opcines_BtnCobrar.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_Opcines_BtnCobrar.setBackground(Color.DARK_GRAY);
		add(panel_Opcines_BtnCobrar);
		GridBagLayout gbl_panel_Opcines_BtnCobrar = new GridBagLayout();
		gbl_panel_Opcines_BtnCobrar.columnWidths = new int[] { 0, 0 };
		gbl_panel_Opcines_BtnCobrar.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Opcines_BtnCobrar.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_Opcines_BtnCobrar.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_Opcines_BtnCobrar.setLayout(gbl_panel_Opcines_BtnCobrar);

		JButton btnCobrar = new JButton(new ImageIcon("imagenes/bcobrar.png"));
		btnCobrar.setForeground(Color.DARK_GRAY);
		btnCobrar.setPreferredSize(new Dimension(100, 50));
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCobrarClick();
			}
		});

		GridBagConstraints gbc_btnCobrar = new GridBagConstraints();
		gbc_btnCobrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCobrar.gridx = 0;
		gbc_btnCobrar.gridy = 0;
		panel_Opcines_BtnCobrar.add(btnCobrar, gbc_btnCobrar);

		JPanel panel_Opciones = new JPanel();
		panel_Opciones.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_Opciones.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_Opciones = new GridBagConstraints();
		gbc_panel_Opciones.fill = GridBagConstraints.BOTH;
		gbc_panel_Opciones.gridx = 0;
		gbc_panel_Opciones.gridy = 1;
		panel_Opcines_BtnCobrar.add(panel_Opciones, gbc_panel_Opciones);

	}

	private void btnCobrarClick() {
		double total = 0;
		for (int i = 0; i < table_Ventas.getRowCount(); i++) {
			int cantidad = Integer.parseInt(table_Ventas.getModel().getValueAt(i, 1).toString());
			double precio = Double.parseDouble(table_Ventas.getModel().getValueAt(i, 2).toString());
			total = total + precio * cantidad;
		}
		CobrarDialog winCobrar = new CobrarDialog(dm, total);
		// winCobrar.setTitle("Total: "+String.format("%.2f", total));
		winCobrar.setVisible(true);
	}

	private void borrarFila(int fila) {
		dm.removeRow(fila);
	}

	public void pulsarBotonProducto(BotonProducto boton) {
		for (int i = 0; i < table_Ventas.getRowCount(); i++) {
			if (table_Ventas.getModel().getValueAt(i, 0).equals(boton.getProducto().getNombre())) {
				int cantAct = Integer.parseInt(table_Ventas.getModel().getValueAt(i, 1).toString()) + 1;
				table_Ventas.getModel().setValueAt(cantAct, i, 1);
				return;
			}
		}
		dm.addRow(
				new Object[] { boton.getProducto().getNombre(), new Integer(1), boton.getProducto().getPrecio(), "X" });
	}

	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(Color.WHITE);
				setBackground(Color.RED);
			}

			setText((value == null) ? "" : value.toString());

			setFont(new Font("Arial", Font.PLAIN, 20));
			setMargin(new Insets(0, 0, 0, 0));

			return this;
		}
	}

	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;

		private String label;
		private int row;

		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.setFont(new Font("Arial", Font.PLAIN, 5));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					borrarFila(row);
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			this.row = row;
			label = value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				// JOptionPane.showMessageDialog(button, label + ": Ouch!");
				// System.out.println(label + ": Ouch!");
			}
			isPushed = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

}

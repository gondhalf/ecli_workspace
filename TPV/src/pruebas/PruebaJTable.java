package pruebas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import manager.GestorProductos;
import model.BotonProducto;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PruebaJTable extends JFrame {
	
	private GestorProductos gp = new GestorProductos();
	
	private ImageIcon icon = new ImageIcon("images/lata.png");

	private JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel dm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaJTable frame = new PruebaJTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		//ButtonColumn buttonColumn = new ButtonColumn(table, null, 3);
		
	    dm = new DefaultTableModel();
	    dm.setDataVector(new Object[][] { { new Integer(1), "Patatas jamon", new Double(2.15), "X" },
	        { new Integer(2), "Pititis", new Double(3.95), "X" } }, new Object[] { "Cantidad", "Producto", "Precio", "Button" });

		
		table = new JTable(dm);
		

		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{new Integer(1), "Patatas jamon", new Double(2.15), 9},
//				{new Integer(2), "Pititis", new Double(3.95), "X"},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//			},
//			new String[] {
//				"Cantidad", "Producto", "Precio", "Button"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, String.class, Double.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
	    table.getColumn("Button").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.setRowHeight(30);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(table);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 3;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		ArrayList<BotonProducto> lstBotones = gp.getBotones();
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Todos", null, panel_1, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Aperitivos", null, panel_4, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Cervezas", null, panel_3, null);
		
//		for (Boton boton : lstBotones) {
//			panel_5.add(boton);
//		}
		
		for (BotonProducto boton : lstBotones) {
			//panel_1.add(boton);
			
			if (boton.getProducto().getCategoria().equals("otros")) {
				boton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						pulsarBotonProducto(boton);
					}
				});
				panel_4.add(boton);
			}
			
			if (boton.getProducto().getCategoria().equals("refrescos")) {
				panel_3.add(boton);
			} 
			
			//panel_5.add(boton);
		}

		
		JButton btnCobrar = new JButton("Cobrar");
		GridBagConstraints gbc_btnCobrar = new GridBagConstraints();
		gbc_btnCobrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCobrar.gridx = 0;
		gbc_btnCobrar.gridy = 1;
		contentPane.add(btnCobrar, gbc_btnCobrar);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 2;
		contentPane.add(tabbedPane_1, gbc_tabbedPane_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_2, null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.add(btnNewButton);
		
//		Boton btnNewButton2 = new Boton("Boton");
//		panel_2.add(btnNewButton2);
//		
//		Boton btnNewButton3 = new Boton(icon);
//		panel_2.add(btnNewButton3);
//		
//		Boton btnNewButton4 = new Boton("Boton", icon);
//		btnNewButton4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnNewButton4.setHorizontalAlignment(SwingConstants.LEADING);
//		btnNewButton4.setVerticalAlignment(SwingConstants.TOP);
//		panel_2.add(btnNewButton4);
		


	}
	
	private void pulsarBotonProducto(BotonProducto boton){
		for(int i = 0; i < table.getRowCount(); i++){
			if(table.getModel().getValueAt(i, 1).equals(boton.getProducto().getNombre())){
				int cantAct = Integer.parseInt(table.getModel().getValueAt(i, 0).toString())+1;
				table.getModel().setValueAt(cantAct, i, 0);
				return;
			}
		}
		dm.addRow(new Object[]{new Integer(1), boton.getProducto().getNombre(), boton.getProducto().getPrecio(), "X"});
	}
	
	private void borrarFila(int fila){
		dm.removeRow(fila);
	}
	
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

	  public ButtonRenderer() {
	    setOpaque(true);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(UIManager.getColor("Button.background"));
	    }
	    //setText((value == null) ? "" : value.toString());
	    
	    setText((value == null) ? "" : value.toString());
	    //prueba igor
	    //setFont(new Font("Tahoma", Font.BOLD, 11));
	    setFont(new Font("Tahoma", Font.PLAIN, 11));
	    setMargin(new Insets(0, 0, 0, 0));
	    //setMargin(new Insets(0, -1, 0, -20));
	    //setHorizontalAlignment(SwingConstants.CENTER);
	    //fin prueba igor
	    
	    return this;
	  }
	}

	/**
	 * @version 1.0 11/09/98
	 */

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
	    //button.setText("A");
	    //button.setText("a");
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	        borrarFila(row);
	      }
	    });
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else {
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    //label = (value == null) ? "" : value.toString();
	    this.row = row;
	    label = value.toString();
	    button.setText(label);
	    isPushed = true;
	    return button;
	  }

	  public Object getCellEditorValue() {
	    if (isPushed) {
	      // 
	      // 
	      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
	      // System.out.println(label + ": Ouch!");
	      
	      //borrarFila(row);
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

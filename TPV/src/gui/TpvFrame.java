package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import manager.GestorCategorias;
import manager.GestorProductos;
import model.BotonProducto;

@SuppressWarnings("serial")
public class TpvFrame extends JFrame {

	private GestorProductos gp = new GestorProductos();
	private GestorCategorias gc = new GestorCategorias();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Para modificar la apariencia de la interfaz por defecto
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TpvFrame frame = new TpvFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// frame.setUndecorated(true);
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
	public TpvFrame() {
		setBackground(Color.WHITE);
		setTitle("TPV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		VentasPanel panel_Venta = new VentasPanel();
		panel_Venta.setForeground(Color.DARK_GRAY);
		panel_Venta.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_Venta);

		JTabbedPane tabbedPane_Productos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Productos.setBorder(new LineBorder(Color.DARK_GRAY));
		tabbedPane_Productos.setBackground(new Color(204, 204, 204));
		tabbedPane_Productos.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane_Productos.setForeground(Color.BLACK);
		tabbedPane_Productos.setFont(new Font("Agency FB", Font.PLAIN, 30));
		contentPane.add(tabbedPane_Productos);

		ArrayList<BotonProducto> lstBotones = gp.getBotones();
		ArrayList<String> categorias = gc.getCategorias();

		for (String categoria : categorias) {
			JPanel panel = new JPanel();
			// modifica Jpanel
			panel.setBackground(Color.GRAY);
			panel.setBorder(null);
			// fin modificaJpanel
			// icono cutre
			ImageIcon icono = new ImageIcon("imagenes/vinacho.png");
			// fin icono cutre
			tabbedPane_Productos.addTab(categoria, icono, panel, null);

			for (BotonProducto boton : lstBotones) {
				if (boton.getProducto().getCategoria().equals(categoria)) {
					boton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							panel_Venta.pulsarBotonProducto(boton);
						}
					});
					panel.add(boton);
				}
			}
		}
	}

}

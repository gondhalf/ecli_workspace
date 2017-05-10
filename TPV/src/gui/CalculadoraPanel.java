package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CalculadoraPanel extends JPanel {
	
	private CambiosPanel cambiosPanel;

	/**
	 * Create the panel.
	 * @param cambiosPanel 
	 */
	public CalculadoraPanel(CambiosPanel cambiosPanel) {
		setLayout(new GridLayout(4, 3, 0, 0));
		this.cambiosPanel = cambiosPanel;
		
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buttonClick(button);
				}
			});
			add(button);
		}
		
		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonClick(button_0);
			}
		});
		add(button_0);
		
		JButton button_punto = new JButton(".");
		button_punto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonClick(button_punto);
			}
		});
		add(button_punto);
		
		JButton button_C = new JButton("C");
		button_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonClick(button_C);
			}
		});
		add(button_C);

	}
	
	private void buttonClick(JButton button){
		if (button.getText().equals("C")) {
			cambiosPanel.delTxtEfectivo();
		} else {
			cambiosPanel.addTxtEfectivo(button.getText());
		}
	}

}

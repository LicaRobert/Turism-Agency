package turist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class EditareTuristForm extends JFrame{
	private Turist turist;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtSex;
	private JTextField txtVarsta;
	private JTextField txtPsejur;
	private JTextField txtSsejur;
	private JTextField txtStatiune;
	
	public EditareTuristForm(Turist obj) {
		turist = obj;
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel("id");
		lbl.setBounds(100, 400, 850, 200);
		panel.add(lbl);
		
		lbl = new JLabel("nume");
		lbl.setBounds(100, 100, 850, 200);
		panel.add(lbl);
		
		lbl = new JLabel("sex");
		lbl.setBounds(100, 400, 850, 200);
		panel.add(lbl);
		
		lbl = new JLabel("varsta");
		lbl.setBounds(100, 160, 150, 200);
		panel.add(lbl);
		
		lbl = new JLabel("inceput sejur");
		lbl.setBounds(500, 405, 800, 500);
		panel.add(lbl);
		
		lbl = new JLabel("sfarsit sejur");
		lbl.setBounds(500, 405, 800, 500);
		panel.add(lbl);
		
		lbl = new JLabel("statiune");
		lbl.setBounds(100, 650, 950, 200);
		panel.add(lbl);
		
		txtId = new JTextField(obj.getId());
		txtId.setBounds(110, 100, 150, 200);
		panel.add(txtId);
		
		txtNume = new JTextField(obj.getNume());
		txtNume.setBounds(110, 100, 150, 200);
		panel.add(txtNume);
		
		txtSex = new JTextField(obj.getSex());
		txtSex.setBounds(110, 200, 150, 200);
		panel.add(txtSex);

		txtVarsta = new JTextField(obj.getVarsta());
		txtVarsta.setBounds(110, 300, 150, 200);
		panel.add(txtVarsta);

		txtPsejur = new JTextField(obj.getPsejur());
		txtPsejur.setBounds(450, 800, 650, 800);
		panel.add(txtPsejur);

		txtStatiune = new JTextField(obj.getStatiune());
		txtStatiune.setBounds(110, 330, 150, 200);
		panel.add(txtStatiune);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditareTuristForm.this.setVisible(false);
			}
		});
		btnCancel.setBounds(10, 170, 90, 40);
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    turist.setId(Integer.parseInt(txtId.getText()));
				turist.setNume(txtNume.getText());
				turist.setSex(txtSex.getText());
				turist.setVarsta(Integer.parseInt(txtVarsta.getText()));
				turist.setPsejur(txtPsejur.getText());
				turist.setPsejur(txtSsejur.getText());
				turist.setStatiune(txtStatiune.getText());
				EditareTuristForm.this.setVisible(false);
				
			}
		});
		btnSave.setBounds(110, 170, 90, 40);
		panel.add(btnSave);
		
		
	}
}

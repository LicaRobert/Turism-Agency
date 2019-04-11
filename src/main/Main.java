package main;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import login.LoginDialog;
import login.LoginMain;
import readwrite.ReadSaxXML;

import readwrite.WriteDomXML;
import statiune.Statiune;
import turist.Turist;
import turist.TuristCellRender;
import turist.TuristTableModel;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.GroupLayout.Alignment.CENTER;

public class Main extends JFrame{
	private List<Turist> turisti;
	private JTable jt;
	public Main() {
		super("Agentie de turism");
	    JPanel panel = new JPanel();  
	    panel.setLayout(new FlowLayout());  
	    JLabel label = new JLabel("");  
	    JButton button = new JButton();  
	    JButton button2 = new JButton();
	    JTextField numeStatiune = new JTextField(5);
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  JFileChooser fc= new JFileChooser();    
				  int i = fc.showOpenDialog(Main.this);    
				  if(i == JFileChooser.APPROVE_OPTION){    
				        File f = fc.getSelectedFile();    
				        String filepath = f.getPath();    
				        Main.this.parseXML(filepath);
				  }    
			}
		});
	    panel.add(numeStatiune);
	    button2.setText("Salvati XML");  
	    panel.add(button2); 
		button2.setBounds(200, 120, 150, 20); 
	    button2.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
					WriteDomXML domWriter = new WriteDomXML();
		    		ArrayList<Turist> oturisti = new  ArrayList<Turist>();
					  for (Turist t : turisti)
					  {    
						  String obj = t.getStatiune();
						  if (obj.equalsIgnoreCase(numeStatiune.getText()))
						  { 
							  oturisti.add(t);
						  } 
					  }
					  try {
							domWriter.createXMLFrom(oturisti, "oTuristi.xml");
						} catch (Exception e1) {	
							e1.printStackTrace();
						} 		
			 }
			});
	    button.setText("Selecteaza XML-ul turistilor");  
	    panel.add(button);  
	    add(panel);  
	    jt = new JTable();    
	    jt.setEditingColumn(6);
	    jt.setBounds(200,200,200,200);          
	    JScrollPane sp = new JScrollPane(jt);    
	    panel.add(sp);          
	    TuristCellRender render = new TuristCellRender();
	    jt.setDefaultRenderer(String.class, render);
	   jt.setDefaultRenderer(Integer.class, render);
	    jt.setCellSelectionEnabled(true);
	    Statiune obiect = new Statiune();
	    obiect.setVisible(true);
		setSize(650, 800);
		setLocationRelativeTo(null);
		setVisible(true);  
	}
	public void parseXML(String file){
		ReadSaxXML saxReader = new ReadSaxXML();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(file, saxReader);
			turisti = saxReader.getTurist();
			jt.setModel(new TuristTableModel(turisti));
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	} 	
	public static void main(String[] args) throws Exception {

		 final JFrame frame = new JFrame("Logare");
	        final JButton btnLogin = new JButton("Apasa sa te loghezi");
	 
	        btnLogin.addActionListener(
	                new ActionListener(){
	                    public void actionPerformed(ActionEvent e) {
	                        LoginDialog loginDlg = new LoginDialog(frame);
	                        loginDlg.setVisible(true);
	                        if(loginDlg.isSucceeded()){
	                            btnLogin.setText("Salut " + loginDlg.getUsername() + "!");
	                            frame.setVisible(false);
	                            Statiune obiect = new Statiune();
	                            Main fereastra = new Main();
	                        
	                        }
	                    }
	               });
	 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 100);
	        frame.setLayout(new FlowLayout());
	        frame.getContentPane().add(btnLogin);
	        frame.setVisible(true);  	
	}
}
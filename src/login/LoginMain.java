package login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginMain  
{
    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("Log");
        final JButton btnLogin = new JButton("Log in");
 
        btnLogin.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          	{
          LoginDialog loginDlg = new LoginDialog(frame);
          loginDlg.setVisible(true);
          if(loginDlg.isSucceeded())
          		{
        	  btnLogin.setText("Salut " + loginDlg.getUsername() + "!");
              frame.setVisible(false);
          		}
            }
        });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(true);  
    }
}
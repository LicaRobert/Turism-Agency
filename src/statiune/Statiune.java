package statiune;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Statiune extends JFrame {

    private DefaultListModel model;
    private JList list;
    private JButton remAllBtn;
    private JButton addBtn;
    private JButton renBtn;
    private JButton delBtn;

    public Statiune() {

        initUI();
    }

    public void createList() {

        model = new DefaultListModel();
        model.addElement("Sinaia(Perioada sejur : 03.03.2018-04.04.2018, pret : 1550 lei)");
        model.addElement("Ranca(Perioada sejur : 04.06.2018-05.07.2018 , pret : 1820 lei)");
        model.addElement("Ranca(Perioada sejur : 04.06.2018-05.07.2018 , pret : 1820 lei)");
        model.addElement("Herculane(Perioada sejur : 02.03.2018-04.04.2018 , pret : 1270 lei)");
        model.addElement("Balvanyos(Perioada sejur : 12.08.2018-20.08.2018 , pret : 550 lei)");
        model.addElement("Balvanyos(Perioada sejur : 13.08.2018-17.08.2018 , pret : 450 lei)");

    
        
        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int index = list.locationToIndex(e.getPoint());
                    Object item = model.getElementAt(index);
                    String text = JOptionPane.showInputDialog("Renumeste", item);
                    String newItem;

                    if (text != null) {
                        newItem = text.trim();
                    } else {
                        return;
                    }

                    if (!newItem.isEmpty()) {

                        model.remove(index);
                        model.add(index, newItem);
                        ListSelectionModel selModel = list.getSelectionModel();
                        selModel.setLeadSelectionIndex(index);
                    }
                }
            }
        });
    }

    public void createButtons() {

        remAllBtn = new JButton("Sterge tot");
        addBtn = new JButton("Adauga statiune,perioada sejur si pret");
        renBtn = new JButton("Schimba nume,perioada sejur sau pret");
        delBtn = new JButton("Sterge statiune");

        addBtn.addActionListener(e -> {

            String text = JOptionPane.showInputDialog("Adauga o noua statiune,perioada sejur sau pret");
            String item;

            if (text != null) {
                item = text.trim();
            } else {
                return;
            }

            if (!item.isEmpty()) {

                model.addElement(item);
            }
        });

        delBtn.addActionListener(event -> {

            ListSelectionModel selModel = list.getSelectionModel();
            int index = selModel.getMinSelectionIndex();

            if (index >= 0) {
                model.remove(index);
            }
        });

        renBtn.addActionListener(e -> {

            ListSelectionModel selModel = list.getSelectionModel();
            int index = selModel.getMinSelectionIndex();
            if (index == -1) {
                return;
            }

            Object item = model.getElementAt(index);
            String text = JOptionPane.showInputDialog("Renumeste", item);
            String newItem;

            if (text != null) {
                newItem = text.trim();
            } else {
                return;
            }

            if (!newItem.isEmpty()) {

                model.remove(index);
                model.add(index, newItem);
            }
        });

        remAllBtn.addActionListener(e -> model.clear());
    }

    public void initUI() {

        createList();
        createButtons();

        JScrollPane scrollPane = new JScrollPane(list);
        createLayout(scrollPane, addBtn, renBtn, delBtn, remAllBtn);

        setTitle("Detalii despre Statiuni");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        gl.linkSize(addBtn, renBtn, delBtn, remAllBtn);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Statiune ex = new Statiune();
            ex.setVisible(true);  
        });
  }
}

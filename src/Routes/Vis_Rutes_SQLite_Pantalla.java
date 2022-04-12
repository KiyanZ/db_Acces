package Routes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Vis_Rutes_SQLite_Pantalla extends JFrame implements ActionListener{

    JComboBox combo;
    JButton eixir = new JButton("Eixir");
    JTextArea area = new JTextArea();
    Connection con;

    public void iniciar() throws SQLException {
        // sentències per a fer la connexió
        String url = "jdbc:sqlite:Rutes.sqlite";
        Connection con = DriverManager.getConnection(url);

        this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());

        JPanel panell1 = new JPanel(new FlowLayout());
        JPanel panell2 = new JPanel(new BorderLayout());
        this.add(panell1,BorderLayout.NORTH);
        this.add(panell2,BorderLayout.CENTER);

        ArrayList<String> llista_rutes = new ArrayList<String>();
        // sentències per a omplir l'ArrayList amb el nom de les rutes


        combo = new JComboBox(llista_rutes.toArray());

        panell1.add(combo);
        panell1.add(eixir);

        panell2.add(new JLabel("LLista de punts de la ruta:"),BorderLayout.NORTH);
        panell2.add(area,BorderLayout.CENTER);

        this.setVisible(true);
        combo.addActionListener(this);
        eixir.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combo){
            //accions quan s'ha seleccionat un element del combobox, i que han de consistir en omplir el JTextArea

        }

        if (e.getSource() == eixir){
            //accions quan s'ha apretat el botó d'eixir

        }
    }
}
package Exercici;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Pantalla_Veure_Pobles_Comarca_Combo_List extends JFrame implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;
    JLabel etiqueta = new JLabel("Comarca:");
    JLabel et_ini = new JLabel("Introdueix la comarca:");
    JComboBox combo = new JComboBox();
    JButton eixir = new JButton("Eixir");
    DefaultListModel listModel = new DefaultListModel();
    JList list = new JList(listModel);
    JTextField peu = new JTextField();

    Connection con = null;

    // en iniciar posem un contenidor per als elements anteriors
    public void iniciar() {
        this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        setTitle("Comarques, pobles i instituts");
        // contenidor per als elements
        JPanel panell1 = new JPanel(new FlowLayout());
        panell1.add(et_ini);
        panell1.add(combo);
        panell1.add(eixir);
        getContentPane().add(panell1,BorderLayout.NORTH);

        JPanel panell2 = new JPanel(new BorderLayout());
        panell2.add(etiqueta,BorderLayout.NORTH);
        list.setForeground(Color.blue);
        JScrollPane scroll = new JScrollPane(list);
        panell2.add(scroll,BorderLayout.CENTER);
        getContentPane().add(panell2,BorderLayout.CENTER);
        getContentPane().add(peu,BorderLayout.SOUTH);

        connexio();

        agafarComarques();

        setVisible(true);

        combo.addActionListener(this);
        list.addListSelectionListener(this);
        eixir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combo) {
            etiqueta.setText("Llista de pobles de la comarca: " + combo.getSelectedItem());
            visualitzaCom(combo.getSelectedItem().toString());
        }
        if (e.getSource() == eixir){
            eixir();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e){
        JList l = (JList) e.getSource();
        if (l.getSelectedIndex()>=0){
            visualitzaInstituts(l.getSelectedValue().toString());
        }
    }

    private void connexio(){
        String url = "jdbc:postgresql://89.36.214.106:5432/geo";
        String usuari = "geo";
        String password = "geo";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, usuari, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connexió completada");
    }

    private void eixir(){
        // Instruccions per a tancar la connexió i eixir del programa
        try {
            con.close();
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void agafarComarques(){
        // Instruccions per a posar en el ComboBox el nom de totes les comarques, millor si és per ordre alfabètic
        // Pots utilitzar el mètode de JComboBox addItem(string)
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("select nom_c from comarca order by 1");
            while ()
            combo.addItem(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void visualitzaCom(String comarca) {

        // Instruccions per a llegir els pobles de la comarca que arriba com a paràmetre,
        // i introduir-los en el JList
        // La manera d'anar introduint informació en el JList és a través del DefaultListModel:
        // listModel.addElement("Linia que es vol introduir ")
        // Una manera de solucionar el problema de la cometa simple és utilitzar comarca.replaceAll("'","''").

    }

    private void visualitzaInstituts(String poble){
        // Instruccions per a mostrar el número d'Instituts del poble seleccionat en el JTextField peu
        // Una manera de solucionar el problema de la cometa simple és utilitzar poble.replaceAll("'","''").

    }

}
package Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class provaConnexioMySQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String url = "jdbc:mysql://89.36.214.106:3306/factura";
        String usuari = "factura";
        String password = "factura";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, usuari, password);
        System.out.println("Connexió completada");
        con.close();
    }
}
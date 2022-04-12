package Examples;

public class carregaControladors {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Ja s'ha carregat el controlador");
    }
}


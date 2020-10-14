package fr.epsi.ATK;
import java.sql.*;

/**
 * Classe client stockant tous les clients pour les inserer facilement en base de donnée
 */
public class Client {
    String id;
    String nom;
    String prenom;
    String mail;

    public Client() {
    }

    /**
     * Constructeur de la classe client comprenant tous les paramètres.
     * @param id id du client
     * @param prenom prénom du client
     * @param nom nom du iencli
     * @param mail mail du client
     */
    public Client(String id, String prenom, String nom, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    void insertClient(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ATK",
                            "postgres", "admin");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO CLIENT (ID,PRENOM,NOM,MAIL) "
                    + "VALUES ('" + this.id +"', '"+ this.prenom +"', '"+ this.nom +"', '"+ this.mail +"');";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}

package fr.epsi.ATK;

import java.sql.Statement;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main{
    public static void main(String[] args){
        System.out.println("démarrage...");

        //connexion à la DB
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ATK",
                            "postgres", "admin");

            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS CLIENT CASCADE; " +
                    "CREATE TABLE CLIENT " +
                    "(ID             CHAR(3) PRIMARY KEY     NOT NULL," +
                    " PRENOM         VARCHAR(20)    NOT NULL, " +
                    " NOM            VARCHAR(30)    NOT NULL, " +
                    " MAIL           VARCHAR(50)    NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();




        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("database created successfully");


        //System.out.println(new File(".").getAbsoluteFile());
        try {
            File fichier = new File("E:/IdeaProjects/ATK/src/fr/epsi/ATK/client.txt");
            if (fichier.length() == 0) {
                System.out.println("Erreur: le fichier est vide");
            }
            Scanner scanner = new Scanner(fichier);

            while (scanner.hasNext()) {
                String[] tokens = scanner.nextLine().split(";");

                if (tokens.length < 4) {
                    System.out.println("Erreur, il manque un champ pour ce client...");
                } else {
                    String id = tokens[0];
                    String prenom = tokens[1];
                    String nom = tokens[2];
                    String mail = tokens[3];

                    Client client = new Client(id, prenom, nom, mail);
                    client.insertClient();
                    System.out.println(client.toString());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erreur: le fichier n'existe pas! Les traitements ne peuvent donc pas être effectués!");
        }
    }
}

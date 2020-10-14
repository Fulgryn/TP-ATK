package fr.epsi.ATK;

import java.sql.Statement;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main{
    public static void main(String[] args) throws FileNotFoundException{
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
            String sql = "CREATE TABLE CLIENT " +
                    "(ID             CHAR(3) PRIMARY KEY     NOT NULL," +
                    " PRENOM         VARCHAR(20)    NOT NULL, " +
                    " NOM            VARCHAR(30)    NOT NULL, " +
                    " MAIL           VARCHAR(50)    NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            /*-- Table: public.client

                    -- DROP TABLE public.client;

            CREATE TABLE public.client
                    (
                            prenom character varying(20) COLLATE pg_catalog."default",
                            nom character varying(30) COLLATE pg_catalog."default",
                            id character(3) COLLATE pg_catalog."default" NOT NULL,
                            mail character varying(60) COLLATE pg_catalog."default",
                            CONSTRAINT "Client_pkey" PRIMARY KEY (id)
                    )

            TABLESPACE pg_default;

            ALTER TABLE public.client
            OWNER to postgres;*/




        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("database created successfully");


        //System.out.println(new File(".").getAbsoluteFile());
        Scanner scanner = new Scanner(new File("E:/IdeaProjects/ATK/src/fr/epsi/ATK/client.txt"));
        while(scanner.hasNext()){
            String[] tokens = scanner.nextLine().split(";");
            String id = tokens[0];
            String prenom = tokens[1];
            String nom = tokens[2];
            String mail = tokens[3];

            Client client = new Client(id, prenom, nom, mail);
            client.insertClient();
            System.out.println(client.toString());
    }


    }
}

package fr.epsi.ATK;

import java.util.*;
import java.io.*;
import java.lang.*;


public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("démarrage...");

        //System.out.println(new File(".").getAbsoluteFile());
        Scanner scanner = new Scanner(new File("E:/IdeaProjects/ATK/src/fr/epsi/ATK/client.txt"));

        while(scanner.hasNext()){
            String[] tokens = scanner.nextLine().split(";");
            String id = tokens[0];
            String prenom = tokens[1];
            String nom = tokens[2];
            String mail = tokens[3];

            Client client = new Client(id, prenom, nom, mail);

            System.out.println(client.toString());
        }

    }
}

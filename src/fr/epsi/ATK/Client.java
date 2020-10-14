package fr.epsi.ATK;

/**
 *
 */
public class Client {
    String id;
    String nom;
    String prenom;
    String mail;

    public Client() {
    }

    /**
     *
     * @param id
     * @param prenom
     * @param nom
     * @param mail
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
}

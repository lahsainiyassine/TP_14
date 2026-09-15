package ma.projet;

import java.util.List;
import ma.projet.bean.Profile;
import ma.projet.bean.Utilisateur;
import ma.projet.service.ProfileService;
import ma.projet.service.UserService;

public class TestApp {
    public static void main(String[] args) {
        ProfileService ps = new ProfileService();
        UserService us = new UserService();

        Profile mn = ps.create("MN", "Manager");
        Profile cp = ps.create("CP", "Chef de projet");
        us.create("youssef", "pwd1", mn);
        us.create("fatima",  "pwd2", cp);
        us.create("omar",    "pwd3", mn);

        System.out.println("Profils : " + ps.findAll());
        System.out.println("Users   : " + us.findAll());

        mn.setDescription("Manager confirmé");
        ps.update(mn);
        Utilisateur u2 = us.findById(2);
        if (u2 != null) {
            u2.setPassword("newPwd");
            us.update(u2);
        }

        us.delete(1);          // Supprime l'utilisateur ID 1 (youssef)
        ps.delete(cp.getId()); // Supprime le profil CP

        System.out.println("\nManagers restants :");
        List<Utilisateur> mgrs = us.findByProfile(mn);
        mgrs.forEach(System.out::println);
    }
}

package ma.projet.service;

import java.util.List;
import java.util.stream.Collectors;
import ma.projet.bean.Profile;
import ma.projet.bean.Utilisateur;
import ma.projet.dao.Dao;
import ma.projet.dao.ListDao;

public class UserService {
    private final Dao<Utilisateur> dao = new ListDao<>();

    public Utilisateur create(String login, String pwd, Profile profile) {
        Utilisateur u = new Utilisateur(login, pwd, profile);
        dao.create(u);
        return u;
    }

    public Utilisateur update(Utilisateur u) {
        return dao.update(u);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public Utilisateur findById(int id) {
        return dao.findById(id);
    }

    public List<Utilisateur> findAll() {
        return dao.findAll();
    }

    public List<Utilisateur> findByProfile(Profile profile) {
        return dao.findAll().stream()
            .filter(u -> u.getProfile() != null && u.getProfile().getId() == profile.getId())
            .collect(Collectors.toList());
    }
}
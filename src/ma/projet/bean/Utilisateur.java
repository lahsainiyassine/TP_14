package ma.projet.bean;

public class Utilisateur implements Identifiable {
    private static int counter = 0;
    private final int id = ++counter;
    private String login;
    private String password;
    private Profile profile;

    public Utilisateur(String login, String password, Profile profile) {
        this.login = login;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return String.format("Utilisateur[id=%d, login=%s, profil=%s]",
            id, login, (profile != null ? profile.getCode() : "aucun"));
    }
}
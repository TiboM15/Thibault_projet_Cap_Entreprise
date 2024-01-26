package fr.thibault.cap_entreprise.mapping;

public class UrlRoute {

    public final static String URL_LOGIN = "/login";
    public final static String URL_LOGOUT = "/logout";
    public final static String URL_REGISTER = "/register";
    public final static String URL_ADMIN = "/admin";
    public final static String URL_GAMER = "/gamer";
    public final static String URL_REVIEW = "/avis";
    public final static String URL_REVIEW_NEW = URL_REVIEW + "/nouveau";
    public final static String URL_REVIEW_ID = URL_REVIEW + "/avis/{id}";

    public final static String URL_GAME = "/jeu";
    public final static String URL_GAME_NEW = URL_GAME + "/nouveau";
    public final static String URL_GAME_ID = "/jeu/{id}";
}

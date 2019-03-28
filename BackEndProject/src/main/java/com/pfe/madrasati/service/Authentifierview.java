package com.pfe.madrasati.service;

import static DAO.DAOUtilitaire.fermeturesSilencieuses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DAOException.DAOException;
import LesObjets.Utilisateur;
public class Authentifierview implements Authentifier{
	private static final String selectionUserCons = "select login,Password from utilisateur where login = ? and motdepasse = motdepasse (?)";
	private static final String loginCons = "login";
	private static final String passwordCons = "password";
	private DAOFactory daoFactory;

	public UtilisateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
}


}

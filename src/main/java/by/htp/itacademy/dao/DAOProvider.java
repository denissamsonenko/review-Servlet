package by.htp.itacademy.dao;

import by.htp.itacademy.dao.impl.SQLNewsDAO;

public class DAOProvider {
	private static DAOProvider instance;

	private static final NewsDAO newsDAO = new SQLNewsDAO();

	private DAOProvider() {
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public static DAOProvider getInstance() {
		if (instance == null) {
			instance = new DAOProvider();
		}
		return instance;
	}
}

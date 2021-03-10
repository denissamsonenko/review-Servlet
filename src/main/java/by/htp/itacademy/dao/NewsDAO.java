package by.htp.itacademy.dao;

import java.util.List;

import by.htp.itacademy.entity.News;

public interface NewsDAO {
	
	void create(News news) throws DAOException;
	void update(News news) throws DAOException;
	void delete(int id) throws DAOException;
	News read(int id) throws DAOException;
	
	List<News> readAll() throws DAOException;
}

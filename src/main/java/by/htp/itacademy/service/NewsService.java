package by.htp.itacademy.service;

import java.util.List;
import by.htp.itacademy.entity.News;

public interface NewsService {
	
	void save(News news) throws ServiceException;
	void update(News news) throws ServiceException;
	void delete(int id) throws ServiceException;
	News find(int id) throws ServiceException;
	
	List<News> findAll() throws ServiceException;
	
}

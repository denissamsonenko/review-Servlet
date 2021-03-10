package by.htp.itacademy.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import by.htp.itacademy.dao.DAOException;
import by.htp.itacademy.dao.DAOProvider;
import by.htp.itacademy.dao.NewsDAO;
import by.htp.itacademy.entity.News;
import by.htp.itacademy.service.NewsService;
import by.htp.itacademy.service.ServiceException;
import by.htp.itacademy.service.validation.ValidationNews;

public class NewsServiceImpl implements NewsService{

	private final DAOProvider provider = DAOProvider.getInstance();
	private final NewsDAO newsDAO = provider.getNewsDAO();
	
	private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);
	
	@Override
	public void save(News news) throws ServiceException {
		if(!ValidationNews.isCorrect(news)) {
			logger.error("invalid title,brief,content in SAVE");
			throw new ServiceException("invalid title,brief,content");
		}
		
		try {
			newsDAO.create(news);
		} catch (DAOException e) {
			logger.error("Create news err" + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void update(News news) throws ServiceException {
		if(!ValidationNews.isCorrect(news)) {
			logger.error("invalid title,brief,content in UPDATE");
			throw new ServiceException("invalid title,brief,content");
		}
		
		try {
			newsDAO.update(news);
		} catch (DAOException e) {
			logger.error("Update news err" + " " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(int id) throws ServiceException {
		
		try {
			newsDAO.delete(id);
		} catch (DAOException e) {
			logger.error("Delete news err" + e);
			throw new ServiceException(e);
		}	
	}

	@Override
	public News find(int id) throws ServiceException {
		News news;
		
		try {
			news = newsDAO.read(id);
		} catch (DAOException e) {
			logger.error("Find news err" + e);
			throw new ServiceException(e);
		}
		return news;
	}

	@Override
	public List<News> findAll() throws ServiceException {
		List<News> listNews;
		
		try {
			listNews = newsDAO.readAll();
		} catch (DAOException e) {
			logger.error("FindAll news err" + e);
			throw new ServiceException(e);
		}			
			return listNews;		
	}	
}

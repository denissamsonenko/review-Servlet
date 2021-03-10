package by.htp.itacademy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import by.htp.itacademy.dao.NewsDAO;
import by.htp.itacademy.dao.DAOException;
import by.htp.itacademy.dao.pool.ConnectionPool;
import by.htp.itacademy.entity.News;

public class SQLNewsDAO implements NewsDAO{
	
	private final ConnectionPool pool = ConnectionPool.getInstance();
	private static final Logger logger = Logger.getLogger(SQLNewsDAO.class);
	
	private static final String NEWS_CREATE_QUARY = 
			"INSERT INTO news(title, brief, content, date) VALUES(?,?,?,?)";
	private static final String NEWS_SELECT_ALL = 
			"SELECT * FROM news";
	private static final String NEWS_SELECT_ID = 
			"SELECT * FROM news WHERE id = ?";
	private static final String NEWS_UPDATE_BY_ID = 
			"UPDATE news SET title = ?, brief =?, content =? WHERE id = ?";
	private static final String NEWS_DELETE_BY_ID =
			"DELETE FROM news WHERE id=?";
	
	
	@Override
	public void delete(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(NEWS_DELETE_BY_ID);

			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException(e);
		}finally {
			pool.closeConnection(con, ps);
		}		
	}
	
	@Override
	public News read(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet;
		News news = null;
		
		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(NEWS_SELECT_ID);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				String title = resultSet.getString("title");
				String brief = resultSet.getString("brief");
				String content = resultSet.getString("content");
				LocalDate date = LocalDate.parse((resultSet.getString("date")));
				news = new News(id, title, brief, content, date);
			}	
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException(e);
		}finally {
			pool.closeConnection(con, ps);
		}
		return news;
	}
	
	@Override
	public List<News> readAll() throws DAOException {
		
		Connection con = null;
		Statement st = null;
		ResultSet resultSet;
		
		try {
			List<News> listNews = new ArrayList<>(); 
			con = pool.takeConnection();
			st = con.createStatement();
			resultSet = st.executeQuery(NEWS_SELECT_ALL);
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String brief = resultSet.getString("brief");
				String content = resultSet.getString("content");
				LocalDate date = LocalDate.parse((resultSet.getString("date")));
				
				News news = new News(id, title, brief, content, date);
				listNews.add(news);
			}
			return listNews;	
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException(e);
		}finally {
			pool.closeConnection(con, st);
		}		
	}
	
	@Override
	public void create(News news) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(NEWS_CREATE_QUARY);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setDate(4, java.sql.Date.valueOf(news.getDate()));

			ps.execute();
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException(e);
		}finally {
			pool.closeConnection(con, ps);
		}
	}
	
	@Override
	public void update(News news) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(NEWS_UPDATE_BY_ID);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setInt(4, news.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException(e);
		}finally {
			pool.closeConnection(con, ps);
		}
	}
}

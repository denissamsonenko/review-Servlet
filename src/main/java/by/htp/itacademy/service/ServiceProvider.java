package by.htp.itacademy.service;

import by.htp.itacademy.service.impl.NewsServiceImpl;

public class ServiceProvider {
	
	private static ServiceProvider instance;
	
	private static final NewsService newsService = new NewsServiceImpl();
	
	private ServiceProvider() {
	}

	public NewsService getNewsservice() {
		return newsService;
	}

	public static ServiceProvider getInstance() {
		if(instance == null) {
			instance = new ServiceProvider();
		}
		return instance;
	}
}

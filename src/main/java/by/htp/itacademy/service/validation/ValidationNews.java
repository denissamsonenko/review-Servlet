package by.htp.itacademy.service.validation;

import by.htp.itacademy.entity.News;

public class ValidationNews {
	private static final String EMPTY_VALUE = "";
	private static final int TITLE_LENGTH = 100;
	private static final int BRIEF_LENGTH = 500;
	private static final int CONTENT_LENGTH = 2048;

	public static boolean isCorrect(News news) {
		return isTitleCorrect(news.getTitle()) || isBriefCorrect(news.getBrief())
				|| isContentCorrect(news.getContent());
	}

	public static boolean isTitleCorrect(String title) {
		if (title.length() >= TITLE_LENGTH || EMPTY_VALUE.equals(title)) {
			return false;
		}
		return true;
	}

	public static boolean isBriefCorrect(String brief) {
		if (brief.length() >= BRIEF_LENGTH || EMPTY_VALUE.equals(brief)) {
			return false;
		}
		return true;
	}

	public static boolean isContentCorrect(String content) {
		if (content.length() >= CONTENT_LENGTH || EMPTY_VALUE.equals(content)) {
			return false;
		}
		return true;
	}
}

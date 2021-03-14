<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/style_save.css" />
<title>News list view</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="loc" />
<c:set var="now" value="<%= LocalDate.now() %>" />
<fmt:message bundle="${loc}" key="lang.ru" var="ru" />
<fmt:message bundle="${loc}" key="lang.en" var="en" />
<fmt:message bundle="${loc}" key="title.title" var="title" />
<fmt:message bundle="${loc}" key="title.date" var="date" />
<fmt:message bundle="${loc}" key="title.brief" var="brief" />
<fmt:message bundle="${loc}" key="title.content" var="content" />
<fmt:message bundle="${loc}" key="button.save" var="save" />
<fmt:message bundle="${loc}" key="button.cancel" var="cancel" />
<fmt:message bundle="${loc}" key="title.newstitle" var="news" />
<fmt:message bundle="${loc}" key="link.list" var="list" />
<fmt:message bundle="${loc}" key="title.news" var="news" />
<fmt:message bundle="${loc}" key="title.newstitle" var="news_title" />
<fmt:message bundle="${loc}" key="link.create" var="create" />
</head>
<body>
	<div class="wpapper">
		<div class="title">
			<div class="container">
				<div class="title__row">
					<div class="title__name">${news_title}</div>
					<div class="title__lang">
						<a href="controller?command=CHANGE_LOCALE&local=ru">${ru}</a> <a
							href="controller?command=CHANGE_LOCALE&local=en">${en}</a>
					</div>
				</div>
			</div>
		</div>
		<div class="news">
			<div class="container">
				<div class="news__row">
					<div class="news__nav">
						<div class="news__nav1">
							<div class="news__name">${news}</div>
							<ul class="news__li">
								<li><a href="controller?command=show_all_news">${list}</a></li>
								<li><a href="controller?command=create_news">${create}</a></li>
							</ul>
						</div>
					</div>
					<div class="news__list">
						<c:choose>
							<c:when test="${param.command == 'create_news'}">
								<form action="controller" method="post">
									<input type="hidden" name="command" value="save_news">
									<div class="edit__news">
										<div class="edit__title">${title}</div>
										<input class="edit__textbox1" type="textbox"
											placeholder="${title}" name="title">
									</div>
									<div class="edit__news">
										<div class="edit__title">${date}</div>
										<input readonly class="edit__textbox2" type="textbox"
											placeholder="${now}">
									</div>
									<div class="edit__news">
										<div class="edit__title">${brief}</div>
										<textarea class="edit__textbox3" wrap="soft"
											placeholder="${brief}" name="brief"></textarea>
									</div>
									<div class="edit__news">
										<div class="edit__title">${content}</div>
										<textarea class="edit__textbox4" wrap="soft"
											placeholder="${content}" name="content"></textarea>
									</div>
									<div class="news__navi">
										<div class="button">
											<button type="submit">${save}</button>
											<button type="reset">${cancel}</button>
										</div>
									</div>
								</form>
							</c:when>
							<c:when test="${param.command == 'find_for_update'}">
								<form action="controller" method="post">
									<input type="hidden" name="command" value="update_news">
									<input type="hidden" name="id" value="${requestScope.news.id}">
									<div class="edit__news">
										<div class="edit__title">${title}</div>
										<input class="edit__textbox1" type="textbox"
											value="${requestScope.news.title}" name="title">
									</div>
									<div class="edit__news">
										<div class="edit__title">${date}</div>
										<input readonly class="edit__textbox2" type="textbox"
											placeholder="${now}">
									</div>
									<div class="edit__news">
										<div class="edit__title">${brief}</div>
										<textarea class="edit__textbox3" wrap="soft" name="brief">${requestScope.news.brief}</textarea>
									</div>
									<div class="edit__news">
										<div class="edit__title">${content}</div>
										<textarea class="edit__textbox4" wrap="soft" name="content">${requestScope.news.content}</textarea>
									</div>
									<div class="news__navi">
										<div class="button">
											<button type="submit">${save}</button>
											<button type="reset">${cancel}</button>
										</div>
									</div>
								</form>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<footer class="footer">
			<div class="container">
				<div class="footer__row">
					<div class="footer__text">Copyright EPAM 2008. All rights
						reserved.</div>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>
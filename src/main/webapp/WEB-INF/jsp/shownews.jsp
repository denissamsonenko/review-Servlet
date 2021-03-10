<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="css/style.css"/>	
<link rel="stylesheet" type="text/css" href="css/style_show.css"/>
<title>${requestScope.news.title}</title>
	<fmt:setLocale value="${sessionScope.local}"/>
	<fmt:setBundle basename="local" var="loc"/>
	<fmt:message bundle="${loc}" key="lang.ru" var="ru"/>
	<fmt:message bundle="${loc}" key="lang.en" var="en"/>
	<fmt:message bundle="${loc}" key="title.title" var="title"/>
	<fmt:message bundle="${loc}" key="title.date" var="date"/>
	<fmt:message bundle="${loc}" key="title.brief" var="brief"/>
	<fmt:message bundle="${loc}" key="title.content" var="content"/>
	<fmt:message bundle="${loc}" key="button.edit" var="edit"/>
	<fmt:message bundle="${loc}" key="button.delete" var="delete"/>
	<fmt:message bundle="${loc}" key="title.news" var="news"/>
	<fmt:message bundle="${loc}" key="link.list" var="list"/>
	<fmt:message bundle="${loc}" key="title.newstitle" var="news_title"/>
	<fmt:message bundle="${loc}" key="link.create" var="create"/>
	<fmt:message bundle="${loc}" key="news.alarm" var="alarm"/>	
<script>
   function deleteName(f) {
    if (confirm("${alarm}")) 
       f.submit();
   }
</script>
</head>
<body>
<div class="wpapper">
	<div class="title">
		<div class="container">
			<div class="title__row">
				<div class="title__name">${news_title}</div>
				<div class="title__lang">
					<a href ="controller?command=CHANGE_LOCALE&local=ru">${ru}</a>
					<a href ="controller?command=CHANGE_LOCALE&local=en">${en}</a>
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
					<div class="news__views">
						<div class="view__title">${title}</div>
						<div class="view__text">${requestScope.news.title}</div>
					</div>
					<div class="news__views">
						<div class="view__title">${date}</div>
						<div class="view__text">${requestScope.news.date}</div>
					</div>
					<div class="news__views">
						<div class="view__title">${brief}</div>
						<div class="view__text">${requestScope.news.brief}</div>
					</div>
					<div class="news__views">
						<div class="view__title">${content}</div>
						<div class="view__text">${requestScope.news.content}</div>
					</div>
					<div class="view__navi">	
					<form action="controller" method="post">
						<input type="hidden" name="command" value="find_for_update">	
						<input type="hidden" name="id" value="${requestScope.news.id}">
						<button type="submit">${edit}</button>
					</form>
					<form action="controller" method="post" onsubmit="deleteName(this);return false;">
						<input type="hidden" name="command" value="delete_news">
						<input type="hidden" name="id" value="${requestScope.news.id}">
						<button type="submit">${delete}</button>
					</form>							
					</div>						
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<div class="footer__row">
				<div class="footer__text">Copyright EPAM 2008. All rights reserved.</div>
			</div>
		</div>
	</footer>
</body>
</html>
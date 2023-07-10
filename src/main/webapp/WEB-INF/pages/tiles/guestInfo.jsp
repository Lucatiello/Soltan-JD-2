<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  

 <!--   <div class="body-title"> 
 <a href="">News >> </a> Latest News
</div>
     --> 
	

<form action="command.do?method=delete" method="post">
	<c:if test="${requestScope.news2 eq 'latestNews'}">
	
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
				<h3> <c:out value="${news.title}" /> </h3>	
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
			</div>
		</div>

	</c:forEach>
	
	</c:if>

	<div class="no-news">
	 	
		<c:if test="${requestScope.news2 eq null}">
		No news.
      	<br>
      	<c:out value="${requestScope.user2 }"></c:out>
      
	</c:if>
	</div>

</form>

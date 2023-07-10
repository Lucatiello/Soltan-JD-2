<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="body-title">
	<!-- <a href="">News >> </a> View News   -->               
	<a href="controller?command=go_to_news_list"> Back to news list</a>
</div>

<div class="add-table-margin">
	<table class="news_text_format">
		
		<tr>
			
			
			<td class="space_around_title_text"> News id</td>

			<td class="space_around_view_text"><div class="word-breaker">
				<h3><c:out value="${requestScope.news.idNews }" /> </h3>	
				</div></td>
		</tr>
		
		
		<tr>
			<td class="space_around_title_text"> News title</td>

			<td class="space_around_view_text"><div class="word-breaker">
				<h3><c:out value="${requestScope.news.title }" /> </h3>	
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">News Date</td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.newsDate }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">Brief</td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.briefNews }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">Content</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
					<c:out value="${requestScope.news.content }" />
				</div>
				</td>
		</tr>
		
		<tr>
			<td class="space_around_title_text">Images</td>
			<td >
			<div >
				<!-- <c:out value="${requestScope.news.imagePath}" /> -->	
					<p> 
					 <img alt="${requestScope.news.title}" src="${requestScope.news.imagePath}"> </p>
				<!--  <img alt="news" src="${requestScope.news.imagePath}">-->	
				
				
				</div></td>
		</tr>
			
		<tr>
			<td class="space_around_title_text">
			
			<a href="controller?command=go_to_news_list"> Back  to news list</a></td>
			
		</tr>
		
		

		
	</table>
		
		
			
</div>




<c:if test="${sessionScope.role eq 'admin'}">
<div class="first-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="edit" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="Edit" />
	</form>
</div>

<div class="second-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="delete" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="Delete" />
	</form>
</div>
</c:if>
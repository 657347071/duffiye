<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="paginator" type="com.duffiye.dao.common.Paginator" required="true"%>
<%@ attribute name="url" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%
   int current =  paginator.getPageIndex();
   int begin = 1;
   int end = paginator.getEndIndex() ;
   int totalPage = paginator.getTotalPage();
   request.setAttribute("current", current);
   request.setAttribute("begin", begin);
   request.setAttribute("end", end);
   request.setAttribute("totalPage", totalPage);
%>

	<div id="pagination">
		  <ul class="pagination pagination-lg">
		    <li><a href="${url }">首页</a></li>
		    <!-- 如果是第一页，就显示“上一页” -->
		    <c:if test="${current > 1 }">
		   		 <li><a style="cursor:pointer;" onclick="pageSearch('${current - 1}')">上一页</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${begin }" end="${totalPage }" step="1"> 
		 	    <c:choose>
			       <c:when test="${i == current }">
			 		 <li class="active"><a style="cursor:pointer;" onclick="pageSearch('${i}')">${i}</a></li>
			       </c:when>
			       <c:otherwise>
			       	 <li><a style="cursor:pointer;" onclick="pageSearch('${i}')">${i}</a></li>
			       </c:otherwise>
				</c:choose>
            </c:forEach> 

            <!-- 如果当前页 ！= 总页数，就显示下一页  -->
            <c:if test="${current != totalPage }">
            	<li><a style="cursor:pointer;" onclick="pageSearch('${current + 1}')">下一页</a></li>
			</c:if>
			
		    <li><a style="cursor:pointer;" onclick="lastPage('${totalPage}')">尾页</a></li>
		  </ul>
	</div>

<script type="text/javascript">
	function pageSearch(i){
		var pageIndex =	document.getElementById("pageIndex");
		pageIndex.setAttribute("value",parseInt(i));
		document.getElementById('searchForm').submit();
	}

	function lastPage(end) {
		var els = document.querySelector("div#pagination");
		var uls = els.firstChild;
		var lis = uls.nextSibling.children[uls.nextSibling.children.length-2].firstChild.innerHTML;
		var pageIndex =	document.getElementById("pageIndex");
		pageIndex.setAttribute("value",parseInt(end));
		document.getElementById('searchForm').submit();
	}
</script>
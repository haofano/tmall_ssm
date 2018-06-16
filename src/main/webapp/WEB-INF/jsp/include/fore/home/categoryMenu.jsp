<%--
  Created by IntelliJ IDEA.
  User: KID
  Date: 2018/6/16
  Time: 11:29
  To change this template use File | Settings | File Templates.
  左侧竖状分类导航
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<div class="categoryMenu">
    <c:forEach items="${cs}" var="c">
        <div cid="${c.id}" class="eachCategory">
            <span class="glyphicon glyphicon-link"></span>
            <a href="forecategory?cid=${c.id}">
                ${c.name}
            </a>
        </div>
    </c:forEach>
</div>

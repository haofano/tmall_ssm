<%--
  Created by IntelliJ IDEA.
  User: KID
  Date: 2018/6/18
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<title>模仿天猫官网 ${p.name}</title>
<div class="categoryPictureProductPageDiv">
    <img class="categoryPictureInProductPage" src="img/category/${p.category.id}.jpg">
</div>

<div class="productPageDiv">
    <%@include file="imgAndInfo.jsp"%>
    <%@include file="productReview.jsp"%>
    <%@include file="productDetail.jsp"%>
</div>

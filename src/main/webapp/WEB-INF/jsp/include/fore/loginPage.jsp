<%--
  Created by IntelliJ IDEA.
  User: KID
  Date: 2018/6/17
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<script>
    $(function(){
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        $("form.loginForm").submit(function(){
            if(0==$("#name").val().length||0==$("#password").val().length){
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });
        $("form.loginForm input").keyup(function(){
            $("div.loginErrorMessageDiv").hide();
        });
        var left = window.innerWidth/2+163;
        $("div.loginSmallDiv").css("left",left);
    })
</script>
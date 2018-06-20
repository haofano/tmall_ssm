<%--
  Created by IntelliJ IDEA.
  User: KID
  Date: 2018/6/20
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    var deleteOrderItem = false;
    var deleteOrderItemid = 0;
    $(function(){
        $("a.deleteOrderItem").click(function(){
            deleteOrderItem = false;
            var oiid = $(this).attr("oiid");
            deleteOrderItemid = oiid;
            $("#deleteConfirmModal").modal('show');
        });
        $("button.deleteConfirmButton").click(function(){
            deleteOrderItem = true;
            $("#deleteConfirmModal").modal('hide');
        });
        $('#deleteConfirmModal').on('hidden.bs.modal',function(e){
            if(deleteOrderItem){
                var page = "foredeleteOrderItem";
                $.post(
                    page,
                    {"oiid":deleteOrderItemid},
                    function(result){
                        if("success"==result){
                            $("tr.cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
                        }
                        else{
                            location.href="login"
                        }
                    }
                )
            }
        })
    })
</script>

package com.dong.tmall.interceptor;

import com.dong.tmall.pojo.Category;
import com.dong.tmall.pojo.OrderItem;
import com.dong.tmall.pojo.User;
import com.dong.tmall.service.CategoryService;
import com.dong.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OtherInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //获取分类集合信息，用于放在搜索栏下面
        List<Category> cs = categoryService.list();
        request.getSession().setAttribute("cs", cs);

        //获取当前的contextPath:tmall_ssm，用于跳转首页
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        request.getSession().setAttribute("contextPath", contextPath);

        //获取购物车中一共有多少数量
        User user = (User) session.getAttribute("user");
        int cartTotalItemNumber = 0;
        if(null != user){
            List<OrderItem> ois = orderItemService.listByUser(user.getId());
            for(OrderItem oi : ois){
                cartTotalItemNumber += oi.getNumber();
            }
        }
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {


    }
}

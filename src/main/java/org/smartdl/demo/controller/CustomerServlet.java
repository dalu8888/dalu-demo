package org.smartdl.demo.controller;


import org.smartdl.demo.model.Customer;
import org.smartdl.demo.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
/*
创建客户
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init(){
        customerService=new CustomerService();
    }

    /*
    进入创建客户界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Customer> customerList=customerService.getCustomerList();
        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req,resp);

    }

    /*
    处理创建客户请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO
    }

}

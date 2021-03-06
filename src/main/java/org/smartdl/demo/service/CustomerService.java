package org.smartdl.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smartdl.demo.helper.DatabaseHelper;
import org.smartdl.demo.model.Customer;
import org.smartdl.demo.util.PropsUtil;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by asus on 2016/11/20.
 */
/*
提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);

    private static final String  DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");

        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
    }
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        String sql ="SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取客户
     */
    public Customer GetCustomer(long id){

        return  null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object>fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id,Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }

}

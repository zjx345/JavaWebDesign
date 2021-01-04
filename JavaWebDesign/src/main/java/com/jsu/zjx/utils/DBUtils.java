package com.jsu.zjx.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtils {
    public static Connection getConnection() throws Exception {

        //读取配置文件
        InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    public static <T> List<T> getList(Class<T> tClass, String sql, Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> userList = null;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //数据结果集
            rs = ps.executeQuery();

            //获取结果集数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int columnCount = rsmd.getColumnCount();


            //创建集合
            userList = new ArrayList<T>();

            while (rs.next()) {
                //key存放列明，value存放列值，rowMap存放一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    //放入Map集合
                    rowMap.put(columnName, columnValue);

                }
                //创建T对象
                T bean = tClass.newInstance();

                //服务名，id  == 给User对象id 属性赋值的方法名，，setId = setId  调用setId方法给User对象赋值，map中的value
                //循环rowMap给User所有属性 entry{key,value} {{"id":1},{"username"，"king"},{"birthday","2020-10-14"}}
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                    /*//设置方法
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    //对象获取自己类对应字节码
                    Method method = tClass.getMethod(methodName, propertyValue.getClass());
                    method.invoke(bean, propertyValue);*/

                }
                userList.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, rs);
        }
        //打印
        return userList;


    }
    //保存对象方法
    public static boolean save(String sql, Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        Integer count = null;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新记录数
            count = ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, null);
        }
        //打印
        return count != null && count > 0 ? true : false;


    }

    public static <T> T getSingleObject(Class<T> tClass, String sql, Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T bean = null;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //数据结果集
            rs = ps.executeQuery();

            //获取结果集数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                //key存放列明，value存放列值，rowMap存放一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    //放入Map集合
                    rowMap.put(columnName, columnValue);

                }
                //创建T对象
                bean = tClass.newInstance();

                //服务名，id  == 给User对象id 属性赋值的方法名，，setId = setId  调用setId方法给User对象赋值，map中的value
                //循环rowMap给User所有属性 entry{key,value} {{"id":1},{"username"，"king"},{"birthday","2020-10-14"}}
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                    /*//设置方法
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    //对象获取自己类对应字节码
                    Method method = tClass.getMethod(methodName, propertyValue.getClass());
                    method.invoke(bean, propertyValue);*/
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, rs);
        }
        return bean;


    }

    private static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer getCount(String sql, Object...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //数据结果集
            rs = ps.executeQuery();


            while (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, rs);
        }
        //打印
        return count;

    }
    //更新操作
    public static boolean update(String sql, Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //判断当前类型，是不是java.util.Date,转成java.sql.Date
                    if (args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date) args[i];
                       args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
            //数据结果集
            count = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, null);
        }
        //打印
        return count>0?true:false;


    }

    //更新操作
    public static Integer updateForPrimary(String sql, Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;
        try {
            //获取数据库连接
            connection = getConnection();
            //执行sql语句
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //设置sql语句参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //判断当前类型，是不是java.util.Date,转成java.sql.Date
                    if (args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date) args[i];
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
            //数据结果集
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                primaryKey = rs.getInt(1);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, rs);
        }
        //打印
        return primaryKey;


    }
}

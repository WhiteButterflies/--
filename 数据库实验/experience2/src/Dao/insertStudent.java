package Dao;

import bean.Student;

import java.sql.*;
import java.util.ArrayList;

public class insertStudent {
    private String url="jdbc:mysql://localhost:3306/shujukushiyan2?user=root&password=zxcvbnm31415926&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;
    public void insert(Student student) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return ;
        }
        System.out.println("jdbcForInsert:Line18 right/error");
        connection= (Connection) DriverManager.getConnection(url);
        sql="insert into student(Sno,Sname,Sex,Age,Sdept)values(?,?,?,?,?);";

        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getSno());
        preparedStatement.setString(2,student.getSname());
        preparedStatement.setString(3,student.getSex());
        preparedStatement.setInt(4,student.getAge());
        preparedStatement.setString(5,student.getSdept());
        System.out.println(student.toString());
        resultInsert=preparedStatement.execute();
        connection.close();
    }
}

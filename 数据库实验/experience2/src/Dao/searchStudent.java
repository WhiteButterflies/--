package Dao;

import bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchStudent {
    private String url="jdbc:mysql://localhost:3306/shujukushiyan2?user=root&password=zxcvbnm31415926&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    ArrayList<Student> students=new ArrayList<>();
    public ArrayList<Student> search(String sentence) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("jdbcForInsert:Line18 right/error");
        connection= (Connection) DriverManager.getConnection(url);
        sql="select * from student where Sno like '%"+sentence+"%'";
        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
        res=preparedStatement.executeQuery();
        StringBuffer sb=new StringBuffer();
        String s="";
        Boolean bool=res.next();
        if(!bool){
            return null;
        }
        while(bool){
            students.add(new Student(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5)));
            bool=res.next();
        }
        preparedStatement.close();
        connection.close();
        if(students!=null&&students.size()!=0) {
            return students;
        }
        else {
            return null;
        }
    }
}

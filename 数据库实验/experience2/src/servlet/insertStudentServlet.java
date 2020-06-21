package servlet;

import Dao.insertStudent;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/insert")
public class insertStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(4);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String number=req.getParameter("number");
        String name =req.getParameter("name");
        String sex = req.getParameter("sex");
        int  age = Integer.parseInt(req.getParameter("age"));
        String sdept = req.getParameter("sdept");
        Student student = new Student(number,name,sex,age,sdept);
        System.out.println(student.getSname());
        insertStudent insertStudent=new insertStudent();
        try {
            insertStudent.insert(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.getWriter().write("插入成功");

    }
}

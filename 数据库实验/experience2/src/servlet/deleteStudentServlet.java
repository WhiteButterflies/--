package servlet;

import Dao.deleteStudent;
import Dao.insertStudent;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/delete")
public class deleteStudentServlet extends HttpServlet {
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
        int  age = 0;
        String sdept = req.getParameter("sdept");
        Student student = new Student(number,name,sex,age,sdept);
        System.out.println(student.getSname());
        deleteStudent insertStudent=new deleteStudent();
        try {
            insertStudent.delete(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.getWriter().write("删除成功");

    }
}

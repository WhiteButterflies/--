package servlet;

import Dao.insertStudent;
import Dao.updateStudent;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/update")
public class updateStudentServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        updateStudent updateStudent=new updateStudent();
        try {
            updateStudent.update(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.getWriter().write("修改成功");

    }
}

package servlet;
import Dao.searchStudent;
import bean.Student;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class searchStudentServlet extends HttpServlet {
    //MissionDao missionDao=new MissionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> list;
        searchStudent search=new searchStudent();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String str="";
        str = req.getParameter("number");
        System.out.println("searchServlet:42Line  "+str);
        PrintWriter printWriter;
        printWriter=resp.getWriter();
        String json;
        try {
            list=search.search(str);
            json= JSON.toJSONString(list);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

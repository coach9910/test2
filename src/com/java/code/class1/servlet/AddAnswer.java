package com.java.code.class1.servlet;
import com.java.code.class1.jdbc.StudentHomeworkJdbc;
import com.java.code.class1.model.StudentHomework;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/handin")
public class AddAnswer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            StudentHomework sh =new StudentHomework();
            sh.setSno(Integer.parseInt(req.getParameter("studentno")));
            sh.setHno(Integer.parseInt(req.getParameter("homeworkno")));
            sh.setHtitle(req.getParameter("homeworktitle"));
            sh.setHcontent(req.getParameter("homeworkcontent"));
            StudentHomeworkJdbc.handHomework(sh);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setHeader("refresh","5;URL=index.jsp");
    }
}

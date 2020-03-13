package com.java.code.class1.servlet;
import com.java.code.class1.jdbc.HomeworkJdbc;
import com.java.code.class1.model.Homework;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addhomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            Homework h =new Homework();
            h.setHno(Integer.parseInt(req.getParameter("homeworkno")));
            h.setHtitle(req.getParameter("homeworktitle"));
            HomeworkJdbc.addHomework(h);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setHeader("refresh","5;URL=index.jsp");
    }

}

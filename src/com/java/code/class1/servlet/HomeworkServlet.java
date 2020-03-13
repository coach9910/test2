package com.java.code.class1.servlet;
import com.java.code.class1.jdbc.HomeworkJdbc;
import com.java.code.class1.model.Homework;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> h =  HomeworkJdbc.selectAllh();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("homeworklist",h);
        req.getRequestDispatcher("homework.jsp").forward(req,resp);
    }
}

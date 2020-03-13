package com.java.code.class1.servlet;
import com.java.code.class1.jdbc.StudentJdbc;
import com.java.code.class1.model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            Student s =new Student();
            s.setSno(Integer.parseInt(req.getParameter("studentno")));
            s.setSname(req.getParameter("studentname"));
            StudentJdbc.addStudent(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setHeader("refresh","5;URL=index.jsp");
        }
    }


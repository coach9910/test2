package com.java.code.class1.jdbc;
import com.java.code.class1.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    public static List<Student> selectAlls(){
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        String sqlString = "SELECT * FROM student";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Student> list =new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Student s= new Student();
                        s.setSno(resultSet.getInt("sno"));
                        s.setSname(resultSet.getString("sname"));
                        list.add(s);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public static void addStudent(Student s) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        Connection connection =  DriverManager.getConnection(allUrl);


        try {
            String sqlString = "insert into student(sno,sname) values (?,?)";
            PreparedStatement t = connection.prepareStatement(sqlString);
            t.setInt(1,s.getSno());
            t.setString(2,s.getSname());
            t.execute();
            Class.forName(driverName);// 加载驱动

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

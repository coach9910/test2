package com.java.code.class1.jdbc;
import com.java.code.class1.model.Homework;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkJdbc {
    public static List<Homework> selectAllh(){
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        String sqlString = "SELECT * FROM homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Homework> list =new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Homework h = new Homework();
                        h.setHno(resultSet.getInt("hno"));
                        h.setHtitle(resultSet.getString("htitle"));
                        list.add(h);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void addHomework(Homework h) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        Connection connection =  DriverManager.getConnection(allUrl);


        try {
            String sqlString = "insert into homework(hno,htitle) values (?,?) ";
            PreparedStatement t = connection.prepareStatement(sqlString);
            t.setInt(1,h.getHno());
            t.setString(2,h.getHtitle());
            t.execute();
            Class.forName(driverName);// 加载驱动

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

package com.java.code.class1.jdbc;
import com.java.code.class1.model.StudentHomework;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    public static void main(String[] args) {
        List<StudentHomework> list = selectALL();
        for(StudentHomework sh :list){
            System.out.println(sh.getHcontent());
        }

    }

    public static List<StudentHomework> selectALL(){
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        String sqlString = "SELECT * FROM student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<StudentHomework> list =new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh= new StudentHomework();
                        sh.setNo(resultSet.getInt("no"));
                        sh.setHno(resultSet.getInt("hno"));
                        sh.setSno(resultSet.getInt("sno"));
                        sh.setHtitle(resultSet.getString("htitle"));
                        sh.setHcontent(resultSet.getString("hcontent"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public static void handHomework(StudentHomework sh)throws SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        Connection connection =  DriverManager.getConnection(allUrl);


        try {
            String sqlString = "insert into student_homework(no, hno, sno, htitle, hcontent) values (?,?,?,?,?)";
            PreparedStatement t = connection.prepareStatement(sqlString);
            List<StudentHomework> s = StudentHomeworkJdbc.selectALL();
            t.setInt(1,s.size()+1);
            t.setInt(2,sh.getHno());
            t.setInt(3,sh.getSno());
            t.setString(4,sh.getHtitle());
            t.setString(5,sh.getHcontent());
            t.execute();
            Class.forName(driverName);// 加载驱动

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

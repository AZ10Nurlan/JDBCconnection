import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println(getAllStudentInfos());
    }
    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/div_academy1";
        String username="postgres";
        String password="root";
        Connection con= DriverManager.getConnection(url,username,password);

        if(con!=null){
            System.out.println("Connection is succesfully");
        }
        return con;
    }

    public static List<Student> getAllStudentInfos() throws SQLException, ClassNotFoundException {
        List<Student> students=new ArrayList<>();

        try(Connection connection=connect()){
            Statement st=connection.createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM student");

            while (resultSet.next()){
                String name=resultSet.getString("student_name");
                String surname=resultSet.getString("student_surname");
                String profession=resultSet.getString("profession");

                students.add(new Student(name,surname,profession));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

}

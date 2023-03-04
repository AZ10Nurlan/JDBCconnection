import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        //connect();

        //getAllStudentInfos();

        //getInfoWithScanner();

        //updateTable();
    }

    //Bazaya connect oluruq
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

    //Bazadaki Student infosunu cap edir
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

    //Scanner ile bazadan student infosu alir
    public static void getInfoWithScanner() throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Student name: ");
        String name=scanner.nextLine();

        Connection connection=connect();
        PreparedStatement st=connection.prepareStatement("SELECT * FROM student WHERE student_name=?");
        st.setString(1,name);
        ResultSet rs=st.executeQuery();

        while (rs.next()){
            System.out.println("Student name: "+rs.getString("student_name")+"\nStudent surname: "+rs.getString("student_surname")+"\nProfession: "+rs.getString("profession")+"\nStart date: "+rs.getDate("startdate"));
        }
    }

    //Tabloyu update edirem
    public static void updateTable() throws Exception{
        Connection connection=connect();
        Statement st=connection.createStatement();
        st.executeUpdate("UPDATE student SET student_name='Hikmet' WHERE student_name='Nurlan'");
        System.out.println("Updating is succesfully :)");
    }


}

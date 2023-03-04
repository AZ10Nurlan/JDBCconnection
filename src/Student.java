import java.time.LocalDate;

public class Student {
    private int id;
    private String student_name;
    private String student_surname;
    private String profession;
    private LocalDate startdate;
    private LocalDate leavedate;
    private int student_row_info_id;
    private int teacher_id;
    private int student_status;

    public Student(String student_name, String student_surname,String profession) {
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.profession=profession;
    }

    public Student(int id, String student_name, String student_surname, String profession, LocalDate startdate, LocalDate leavedate, int student_row_info_id, int teacher_id, int student_status) {
        this.id = id;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.profession = profession;
        this.startdate = startdate;
        this.leavedate = leavedate;
        this.student_row_info_id = student_row_info_id;
        this.teacher_id = teacher_id;
        this.student_status = student_status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ",student_surname='" + student_surname + '\'' +
                ",profession='" + profession + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(LocalDate leavedate) {
        this.leavedate = leavedate;
    }

    public int getStudent_row_info_id() {
        return student_row_info_id;
    }

    public void setStudent_row_info_id(int student_row_info_id) {
        this.student_row_info_id = student_row_info_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStudent_status() {
        return student_status;
    }

    public void setStudent_status(int student_status) {
        this.student_status = student_status;
    }
}

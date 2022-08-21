package com.example.assign_2_bscs_19011519_011;

public class RegistrationModel extends Application{



   // private String Student_Name;
   // private String Father_Name;
   // private String Roll_No;
    private String Department;
   // private String Registration_No;
    private String Semester;
    private String Degree_status;
    private String Contact_no;
    private String Program;
    private String Date;
    private String Subject;
    private String Student_Signature;

    public RegistrationModel(String student_Name, String father_Name, String roll_No,
                             String department, String registration_No, String semester,
                             String degree_status, String contact_no, String program,
                             String date, String subject, String student_Signature)
    {

        super();
        super.setStudent_Name(student_Name);
        super.setFather_Name(father_Name);
        super.setRoll_No(roll_No);
        super.setRegistration_No(registration_No);
//        Student_Name = student_Name;
//        Father_Name = father_Name;
//        Roll_No = roll_No;
//        Registration_No = registration_No;
        Department = department;
        Semester = semester;
        Degree_status = degree_status;
        Contact_no = contact_no;
        Program = program;
        Date = date;
        Subject = subject;
        Student_Signature = student_Signature;
    }

//    public String getStudent_Name() {
//        return Student_Name;
//    }
//
//    public void setStudent_Name(String student_Name) {
//        Student_Name = student_Name;
//    }
//
//    public String getFather_Name() {
//        return Father_Name;
//    }
//
//    public void setFather_Name(String father_Name) {
//        Father_Name = father_Name;
//    }
//
//    public String getRoll_No() {
//        return Roll_No;
//    }
//
//    public void setRoll_No(String roll_No) {
//        Roll_No = roll_No;
//    }
//
//    public String getRegistration_No() {
//        return Registration_No;
//    }
//
//    public void setRegistration_No(String registration_No) {
//        Registration_No = registration_No;
//    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getDegree_status() {
        return Degree_status;
    }

    public void setDegree_status(String degree_status) {
        Degree_status = degree_status;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getStudent_Signature() {
        return Student_Signature;
    }

    public void setStudent_Signature(String student_Signature) {
        Student_Signature = student_Signature;
    }



}

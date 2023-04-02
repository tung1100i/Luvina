package OOP.Excep.Chaining;

public class StudentProgram {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentManager manager = new StudentManager(dao);

        try {
            manager.findStudents("Tom");
        } catch (StudentException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();

        }
    }
}
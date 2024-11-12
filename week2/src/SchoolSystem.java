/**
 * Test program for the implementation of Lecturer and Project
 * @author COSC2440 Teaching Team
 * @version 1.0
 */

public class SchoolSystem {
    private static Lecturer[] lecturerList = new Lecturer[10];
    private static int lecturerCount = 0;
    private static Student[] studentList = new Student[10];
    private static int studentCount = 0;
    private static Project[] projectList = new Project[10];
    private static int projectCount = 0;

    public static void addLecturer(Lecturer o) {
        lecturerList[lecturerCount++] = o;
    }

    public static void addStudent(Student o) {
        studentList[studentCount++] = o;
    }
    public static void addProject(Project o) {
        projectList[projectCount++] = o;
    }


    public static void main(String[] args) {
        Lecturer lecturer1 = new Lecturer("L001", "Alice", "Lecturer");
        Lecturer lecturer2 = new Lecturer("L002", "Bob", "Senior Lecturer");
        Lecturer lecturer3 = new Lecturer("L003", "Carol", "Assoc Lecturer");

        SchoolSystem.addLecturer(lecturer1);
        SchoolSystem.addLecturer(lecturer2);
        SchoolSystem.addLecturer(lecturer3);

        Student student1 = new PartTimeStudent("Donna", "IT", "S001", 5, 20);
        Student student2 = new FullTimeStudent("Elanor", "Prof. Com", "S002");
        Student student3 = new FullTimeStudent("Frank", "BA", "S003");
        Student student4 = new PartTimeStudent("Donna", "IT", "S001");
        Student student5 = new PartTimeStudent();
        Student student6 = new PartTimeStudent("Donna", "IT", "S001", 5, 20);

        SchoolSystem.addStudent(student1);
        SchoolSystem.addStudent(student2);
        SchoolSystem.addStudent(student3);
        SchoolSystem.addStudent(student4);
        SchoolSystem.addStudent(student5);
        SchoolSystem.addStudent(student6);

        Project p1 = new Project("AI", 999.9);
        Project p2 = new Project("ML", 1234.5);
        SchoolSystem.addProject(p1);
        SchoolSystem.addProject(p2);

        // Must display true
        boolean b = lecturer1.leadProject(p1);
        System.out.println(b);

        // Must display false (p1 has a leader already)
        b = lecturer2.leadProject(p1);
        System.out.println(b);

        // Must display false (lecturer1 is leading a project)
        b = lecturer1.leadProject(p2);
        System.out.println(b);

        // Must display false
        b = p1.addMember(student1);
        System.out.println(b);

        // Must display true
        b = ((FullTimeStudent) student2).joinProject(p1);
        System.out.println(b);

        // Must display true
        b = p1.addMember(student3);
        System.out.println(b);

        System.out.println();
        // Must display lecturer1 as a leader and lecturer2 and lecturer3 as members
        lecturer2.joinProject(p1);
        lecturer3.joinProject(p1);
        p1.displayMembers();

        System.out.println();
        System.out.println("Number of part-time students is: " + PartTimeStudent.getCount());
    }
}

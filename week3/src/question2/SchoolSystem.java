package question2;

public class SchoolSystem {


    public static void main(String[] args) {
        LeaderSet leaderSet = new LeaderSet();

        Lecturer lecturer1 = new Lecturer("L001", "Alice", "Lecturer");
        Lecturer lecturer2 = new Lecturer("L002", "Bob", "Senior Lecturer");
        Lecturer lecturer11 = new Lecturer("L001", "Alice11", "Lecturer11");

        Project p1 = new Project("AI", 999.9);
        Project p2 = new Project("ML", 1234.5);

        // Must display true
        boolean b = lecturer1.leadProject(p1);
        System.out.println(b);

        // Must display false
        b = leaderSet.isLeadingProject(lecturer1);
        System.out.println(b);

        leaderSet.addLeader(lecturer1);

        // Must display true
        b = leaderSet.isLeadingProject(lecturer1);
        System.out.println(b);

        // Must display true (lecturer11 and lecturer1 is considered equals due to the same id)
        b = leaderSet.isLeadingProject(lecturer11);
        System.out.println(b);
    }
}

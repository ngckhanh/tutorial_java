package question3;

import java.util.List;

public class SchoolSystem {
    public static void main(String[] args) {
        ProjectMember projectMember = new ProjectMember();

        Lecturer lecturer1 = new Lecturer("L001", "Alice", "Lecturer");
        Lecturer lecturer2 = new Lecturer("L002", "Bob", "Senior Lecturer");

        Project p1 = new Project("AI", 999.9);
        Project p2 = new Project("ML", 1234.5);

        // Must display true
        boolean b = lecturer1.leadProject(p1);
        System.out.println(b);

        // Must display null (Original list of projects of lecturer1)
        System.out.println(projectMember.addProjectToMember(lecturer1, p1));

        // Must display a list that contains p1 (p1 is already in the project list of lecturer1)
        System.out.println(projectMember.addProjectToMember(lecturer1, p1));

        // Must display true
        b = lecturer1.joinProject(p2);
        System.out.println(b);

        // Must display a list that contains p1
        System.out.println(projectMember.addProjectToMember(lecturer1, p2));

        // Must display true
        b = lecturer2.leadProject(p2);
        System.out.println(b);

        // Must display null (Original list of projects of lecturer2)
        System.out.println(projectMember.addProjectToMember(lecturer2, p2));

        List<Project> l1Projects = projectMember.getAllProjects(lecturer1);
        System.out.print("List of projects of lecturer 1: ");
        System.out.println(l1Projects);

        List<Project> l2Projects = projectMember.getAllProjects(lecturer2);
        System.out.print("List of projects of lecturer 2: ");
        System.out.println(l2Projects);

        projectMember.removeProjectForMember(lecturer1, p1);
        l1Projects = projectMember.getAllProjects(lecturer1);
        System.out.print("List of projects of lecturer 1 after remove p1: ");
        System.out.println(l1Projects);
    }
}

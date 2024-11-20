package question4;

import java.util.List;

public class SchoolSystem {
    public static void main(String[] args) {
        ProjectMember projectMember = new ProjectMember();

        Lecturer lecturer1 = new Lecturer("L001", "Alice", "Lecturer");

        Project p1 = new Project("AI", 999.9);
        Project p2 = new Project("ML", 1234.5);
        Project p3 = new Project("IoT", 330.5);


        projectMember.addProjectToMember(lecturer1, p1);
        projectMember.addProjectToMember(lecturer1, p2);
        projectMember.addProjectToMember(lecturer1, p3);

        List<Project> l1Projects = projectMember.getAllProjects(lecturer1);
        for (Project p: l1Projects) {
            System.out.println(p.getName());
        }
    }
}

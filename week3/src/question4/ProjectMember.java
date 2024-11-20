package question4;


import java.util.*;

public class ProjectMember {
    private Map<String, List<Project>> memberToProjects;

    public ProjectMember() {
        this.memberToProjects = new HashMap<String, List<Project>>();
    }

    public List<Project> getAllProjects(Researcher member) {
        List<Project> reverseList = memberToProjects.get(member.getId());
        Collections.sort(reverseList, new ProjectBudgetInReverseComparator());
        return reverseList;
    }

    public List<Project> addProjectToMember(Researcher member, Project project) {
        ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(project);
        List<Project> preProjects = memberToProjects.put(member.getId(), projects);
        if (preProjects == null) {
            return null;
        } else {
            for (Project p: preProjects) {
                if (p.equals(project)) {
                    return preProjects;
                }
            }

            preProjects.add(project);
            return memberToProjects.replace(member.getId(), preProjects);
        }
    }

    boolean removeProjectForMember(Researcher member, Project project) {
        boolean isDoing = false;
        List<Project> projects = getAllProjects(member);
        if (projects != null) {
            isDoing = projects.remove(project);
            memberToProjects.replace(member.getId(), projects);
        }
        return isDoing;
    }
}

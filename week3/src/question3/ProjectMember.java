package question3;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectMember {
    // Use Map and List interfaces
    private Map<String, List<Project>> memberToProjects;

    public ProjectMember() {
        // An empty set at the begining
        memberToProjects = new HashMap<String, List<Project>>();
    }

    /**
     * Get a list of projects this person is doing
     *
     * @param member the CanJoinProject member
     * @return get a list of projects this person is doing,
     * otherwise, return null if this person is not a member of any project
     */
    public List<Project> getAllProjects(Researcher member) {
        return memberToProjects.get(member.getId());
    }

    /**
     * Add a project to a CanJoinProject person
     *
     * @param member the CanJoinProject member
     * @param project An added project for the member
     * @return the previous list of projects associated with the member,
     * or null if there was no project mapping for the member
     */
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


    /**
     * Remove a project to a CanJoinProject person
     *
     * @param member The CanJoinProject member
     * @param project A removed project for the member
     * @return Return true if the member is doing the project,
     * or false otherwise.
     */
    boolean removeProjectForMember(Researcher member, Project project) {
        boolean isDoing = false;
        List<Project> projects = getAllProjects(member);
        if (projects != null) {
            // We assume that the list does not contain duptications
            isDoing = projects.remove(project);
            memberToProjects.replace(member.getId(), projects);
        }
        return isDoing;
    }
}

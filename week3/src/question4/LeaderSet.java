package question4;

import java.util.HashSet;
import java.util.Set;

public class LeaderSet {
    // Use Set interface
    private Set<Lecturer> leaders;

    public LeaderSet() {
        // An empty set at the begining
        leaders = new HashSet<Lecturer>();
    }

    /**
     * Check whether a lecturer is leading a project or not
     * @param lecturer a lecturer to be checked
     * @return true if the lecturer is leading a project, otherwise, return false
     */
    public boolean isLeadingProject(Lecturer lecturer) {
        return leaders.contains(lecturer);
    }

    /**
     * Add a lecturer to the set
     * @param lecturer a lecturer to be added to the set
     * @return true if the set is changed, otherwise, return false
     */
    public boolean addLeader(Lecturer lecturer) {
        return leaders.add(lecturer);
    }

    /**
     * Remove a lecturer to the set
     * @param lecturer a lecturer to be removed from the set
     * @return true if the set is changed, otherwise, return false
     */
    public boolean removeLeader(Lecturer lecturer) {
        return leaders.remove(lecturer);
    }
}

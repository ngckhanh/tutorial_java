package question2;

// Import library for Collection

import java.util.ArrayList;
import java.util.List;

public class Lecturer implements Researcher {
    private String employeeId;
    private String fullName;
    private String rank;
    private Project projectLed;
    // assume the maximum number of projects a lecturer can join at one time is 10
    //private final int MAX_PROJECTS = 10;
    //private Project[] joinedProjects;
    //private int projectCount = 0;
    private List<Project> joinedProjects;
    private String researchProfile;

    public Lecturer()  {
        this.employeeId = "Default";
        this.fullName = "Default";
        this.rank = "Default";
        //joinedProjects = new Project[MAX_PROJECTS];
        joinedProjects = new ArrayList<Project>();
        this.researchProfile = "";
    }
    public Lecturer(String employeeId, String fullName, String rank) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.rank = rank;
        //joinedProjects = new Project[MAX_PROJECTS];
        joinedProjects = new ArrayList<Project>();
        this.researchProfile = "";
    }

    /**
     * assign the current lecturer as the leader of a project
     * <p>
     * Given a project, assign the current lecturer as its leader.
     * If the assignment is successful, return true,
     * otherwise, return false
     * </p>
     * @param p the project to lead
     * @return true if the assignment is successful, otherwise, return false
     */
    public boolean leadProject(Project p) {
        /*
          two conditions below must satisfy
          the lecturer has no project to lead
          the assigned project has no leader
         */
        if (!isLeading() && p.getLeader() == null) {
            projectLed = p;
            p.assignLeader(this);
            return true;
        }
        return false;
    }

    //public int getProjectCount() {
    //    return projectCount;
    //}

    //public void setProjectCount(int projectCount) {
    //    this.projectCount = projectCount;
    //}

    /**
     * assign the current lecturer as a member of a project
     * <p>
     * Join a project as a member. It's the job of the Project class
     * to check for validity of this action or to check if
     * this Lecturer member exists in the project already
     * </p>
     * @param p the project to join
     * @return true if the assignment is successful, otherwise, return false
     */
    @Override
    public boolean joinProject(Project p) {
        if (p.getMembers().contains(this)){
            return false;
        }
        joinedProjects.add(p);
        p.setMember(this);
        return true;
    }

    @Override
    public void setProfile(String profile) {
        this.researchProfile = "Lecturer(" + profile + ")";
    }

    @Override
    public String getProfile() {
        return this.researchProfile;
    }


    /**
     * check if the current lecturer is leading any project
     * @return true if the current lecturer is leading any project, false if not
     */
    public boolean isLeading() {
        return projectLed != null;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRank() {
        return rank;
    }

    public List<Project> getJoinedProjects() {
        return joinedProjects;
    }

    /**
     * set the rank of a lecturer
     * <p>
     * Given a rank, assign the rank for the current lecturer
     * If the assignment is successful, return true,
     * otherwise, return false
     * </p>
     * @param rank the rank to set for the lecturer
     * @return true if the assignment is successful, otherwise, return false
     */
    public boolean setRank(String rank) {
        String [] rankList = {"Assoc Lecturer" , "Lecturer", "Senior Lecturer"};
        boolean checked = false;
        for (String availableRank: rankList){
            if (availableRank.equals(rank))
                checked = true;
        }
        if (checked){
            this.rank = rank;
            return true;
        }
        return false;
    }

    /**
     * String representation of this lecturer
     * <p>
     * This method is called automatically when you use a Lecturer object
     * in places where a String value is required.
     * </p>
     */
    @Override
    public String toString() {
        // String.format() is similar to printf, but it return instead of display
        return String.format("Id: %s, Name: %s, Rank: %s",
                employeeId, fullName, rank);
    }

    /**
     * compare two lecturer objects
     * <p>
     * Two lecturer objects are equal if they contain the same employee ids
     * otherwise, return false
     * </p>
     * @param other an object that compare with
     * @return true if two lecturers have the same ids, otherwise, return false
     */
    @Override
    public boolean equals(Object other) {

        // If the object is compared with itself then return true
        if (other == this) {
            return true;
        }

    /* Check if other is an instance of Lecturer or not
      "null instanceof [type]" also returns false */
        if (!(other instanceof Lecturer)) {
            return false;
        }

        // typecast other to Project so that we can compare data members
        Lecturer otherLecturer = (Lecturer) other;

        // Compare student ids and return accordingly
        return this.employeeId.equals(otherLecturer.employeeId);
    }

    // The contract between equals() and hashCode() is:
    // 1) If two objects are equal, then they must have the same hash code.
    // 2) If two objects have the same hash code, they may or may not be equal.
    @Override
    public int hashCode() {
        return this.employeeId.length();
    }
}

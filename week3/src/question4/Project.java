package question4;

// Import library for Collection

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private double budget;
    private Lecturer leader;

    //private Researcher[] members;
    //private final int MAX_MEMBERS = 10;
    //private int memberCount = 0;
    // Use List interface
    private List<Researcher> members;

    public Project() {
        this.name = "Default";
        this.budget = 0;
        //members = new Researcher[MAX_MEMBERS];
        members = new ArrayList<Researcher>();
    }
    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
        //members = new Researcher[MAX_MEMBERS];
        members = new ArrayList<Researcher>();
    }

    /**
     * get the current leader of this project
     * @return the Lecturer who is the leader,
     * or null if there is no leader for this project
     */
    public Lecturer getLeader() {
        return leader;
    }

    /**
     * assign a new leader for this project
     * <p>
     * Assign the given Lecturer as the new leader for this project.
     * It's the job of the Lecturer class to ensure this assignment
     * is valid. This class just does the assignment
     * </p>
     * @param leader the new leader for this project
     */
    public void assignLeader(Lecturer leader) {
        this.leader = leader;
    }

    /**
     * add a new member to this project
     * <p>
     * Check condition and add a new member to this project
     * </p>
     * @param newMember a Researcher who want to join this project
     */
    public boolean addMember(Researcher newMember) {
        return newMember.joinProject(this);
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        //return memberCount;
        return members.size();
    }

    public List<Researcher> getMembers() {
        return members;
    }

    public void setMember(Researcher newMember) {
        //members[memberCount++] = newMember;
        members.add(newMember);
    }

    //public boolean isNotFull(){
    //    return memberCount != MAX_MEMBERS;
    //}


    public double getBudget() {
        return budget;
    }

    /**
     * display all members in this project (including leader and regular member)
     */
    public void displayMembers() {
        // display leader
        System.out.println("Leader: " + leader);

        // display regular members
        //for(int i = 0; i < memberCount; i++) {
        //    System.out.printf("Member #%d: " + members[i] + "\n", i + 1);
        //}
        for (int i = 0; i < members.size(); i++)  {
            System.out.printf("Member #%d: " + members.get(i) + "\n", i + 1);
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}


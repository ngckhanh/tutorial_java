package question4;


import java.util.Comparator;

public class ProjectBudgetInReverseComparator implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        return (int) Math.ceil(o2.getBudget() - o1.getBudget());
    }
}

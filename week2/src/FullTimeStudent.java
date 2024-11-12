public class FullTimeStudent extends Student {
    private Project joinedProject;

    public FullTimeStudent() {
        super();
        this.joinedProject = null;
    }

    public FullTimeStudent(String name, String major, String id) {
        super(name, major, id);
        this.joinedProject = null;
    }

    public FullTimeStudent(String name, String major, String id, Project project) {
        super(name, major, id);
        this.joinedProject = project;
    }

    public Project getProject() {
        return joinedProject;
    }

    public void setProject(Project project) {
        this.joinedProject = project;
    }

    public boolean joinProject(Project p) {
        if (this.joinedProject == null && p.addMember(this)) {
            this.joinedProject = p;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FullTimeStudent{" +
                "name='" + getName() + '\'' +
                ", major='" + getMajor() + '\'' +
                ", id='" + getId() + '\'' +
                ", project='" + getProject().getName() + '\'' +
                '}';
    }
}

public class FullTimeStudent extends Student implements Researcher{
    private Project joinedProject;
    private String researchProfile;

    public FullTimeStudent() {
        super();
        this.joinedProject = null;
        this.researchProfile = "";
    }

    public FullTimeStudent(String name, String major, String id) {
        super(name, major, id);
        this.joinedProject = null;
        this.researchProfile = "";
    }

    public FullTimeStudent(String name, String major, String id, Project project) {
        super(name, major, id);
        this.joinedProject = project;
        this.researchProfile = "";
    }

    public Project getProject() {
        return joinedProject;
    }

    public void setProject(Project project) {
        this.joinedProject = project;
    }

    @Override
    public boolean joinProject(Project p) {
        if (this.joinedProject == null && p.isNotFull()) {
            this.joinedProject = p;
            p.setMember(this);
            return true;
        }
        return false;
    }

    @Override
    public void setProfile(String profile) {
        this.researchProfile = "Student(" + profile + ")";
    }

    @Override
    public String getProfile() {
        return this.researchProfile;
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

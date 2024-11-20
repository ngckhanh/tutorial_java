package question4;

public class PartTimeStudent extends Student {
    private int minHour;
    private int maxHour;

    private static int count = 0;

    public PartTimeStudent() {
        super();
        this.minHour = this.maxHour = 0;
        count++;
    }

    public PartTimeStudent(String name, String major, String id) {
        super(name, major, id);
        this.minHour = this.maxHour = 0;
        count++;
    }

    public PartTimeStudent(String name, String major, String id, int minHour, int maxHour) {
        super(name, major, id);
        this.minHour = minHour;
        this.maxHour = maxHour;
        count++;
    }

    public static int getCount() {
        return count;
    }
    public int getMinHour() {
        return minHour;
    }

    public int getMaxHour() {
        return maxHour;
    }

    public void registerHour(int minHour, int maxHour) {
        this.minHour = minHour;
        this.maxHour = maxHour;
    }

    @Override
    public String toString() {
        return "PartTimeStudent{" +
                "name='" + getName() + '\'' +
                ", major='" + getMajor() + '\'' +
                ", id='" + getId() + '\'' +
                "minHour=" + minHour +
                ", maxHour=" + maxHour +
                '}';
    }
}













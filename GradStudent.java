package proj1;

public class GradStudent extends Student {
    private static final double PASSING_PERCENTAGE = 80;

    public GradStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public double getPassingPercentage() {
        return PASSING_PERCENTAGE;
    }

    @Override
    public String getType() {
        return "Graduate";
    }
}
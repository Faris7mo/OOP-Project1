package proj1;

public class UndergradStudent extends Student {
    private static final double PASSING_PERCENTAGE = 60;

    public UndergradStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public double getPassingPercentage() {
        return PASSING_PERCENTAGE;
    }

    @Override
    public String getType() {
        return "Undergraduate";
    }
}
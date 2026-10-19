package proj1;

import java.util.ArrayList;

public abstract class Student implements Gradable {
    private String id;
    private String name;
    private ArrayList<Double> marks;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarksCount() {
        return marks.size();
    }

    public double getMark(int index) {
        return marks.get(index);
    }

    public boolean addMark(double mark) {
        if (!isValidMark(mark)) {
            return false;
        }
        marks.add(mark);
        return true;
    }

    public boolean setMark(int index, double mark) {
        if (index < 0 || index >= marks.size() || !isValidMark(mark)) {
            return false;
        }
        marks.set(index, mark);
        return true;
    }

    private boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }

    @Override
    public double getAverage() {
        if (marks.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.size();
    }

    @Override
    public boolean isPassed() {
        return getAverage() >= getPassingPercentage();
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-14s Marks: %-25s Avg: %6.2f%%  Pass mark: %.0f%%  %s",
                id, name, getType(), marks, getAverage(), getPassingPercentage(),
                isPassed() ? "PASS" : "FAIL");
    }
}
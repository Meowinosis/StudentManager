import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private double[] scores = new double[3];
    private boolean gender;
    private static int count =0;
    public Student() {
        setId(++count);
    }

    public Student(String name, double[] scores, boolean gender) {
        setId(++count);
        this.name = name;
        this.scores = scores;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getScore() {
        return scores;
    }

    public void setScore(double[] scores) {
        this.scores = scores;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getAvgScore(){
        double sum =0.0;
        for (double score : scores){
            sum += score;
        }
        return sum/scores.length;
    }

    @Override
    public String toString() {
        String genderString =gender ? "Male":"Female";
        return "Student{" +
                "id=" + id +
                ", name = '" + name + '\'' +
                ", scores = " + Arrays.toString(scores) +
                ", gender = " +  genderString +
                ", avgScore = " + getAvgScore() +
                '}';
    }
}

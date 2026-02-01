public class MainApp {
    public static void main(String[] args) {
        Student s = new EngineeringStudent();
        System.out.println(s.calculateGrade());

        SportsParticipant sp = new AllRounderStudent();
        sp.playSport();
    }
}

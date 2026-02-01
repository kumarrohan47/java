class AllRounderStudent extends Student
        implements SportsParticipant, CulturalParticipant {

    int score;

    @Override
    double calculateGrade() {
        return score;
    }

    public void playSport() {
        System.out.println("Playing sports");
    }

    public void performActivity() {
        System.out.println("Performing cultural activity");
    }
}

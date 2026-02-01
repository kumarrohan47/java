
class EngineeringStudent extends Student {
    int internal, external;

    @Override
    double calculateGrade() {
        return internal * 0.4 + external * 0.6;
    }
}

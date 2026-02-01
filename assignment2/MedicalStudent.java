
class MedicalStudent extends Student {
    int theory, practical;

    @Override
    double calculateGrade() {
        return (theory + practical) / 2.0;
    }
}

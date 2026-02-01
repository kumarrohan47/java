abstract class Student {
    private int rollNumber;
    private String name;
    private int semester;

    static String universityName;
    static {
        universityName = "Global Tech University";
    }

    final int MAX_SEMESTER = 8;

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) {
        if (rollNumber <= 0) throw new IllegalArgumentException();
        this.rollNumber = rollNumber;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    public int getSemester() { return semester; }
    public void setSemester(int semester) {
        if (semester < 1 || semester > MAX_SEMESTER)
            throw new IllegalArgumentException();
        this.semester = semester;
    }

    abstract double calculateGrade();

    void displayDetails() {
        System.out.println(name + " | Semester " + semester);
    }

    static void displayUniversityName() {
        System.out.println(universityName);
    }

    final void showRules() {
        System.out.println("University rules apply");
    }
}

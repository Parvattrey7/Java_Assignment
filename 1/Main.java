class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
}

class BCAStudent extends Student {
    int semester;

    BCAStudent(String name, int rollNo, int semester) {
        super(name, rollNo);
        this.semester = semester;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo + ", Semester: " + semester);
    }
}

public class Main {
    public static void main(String[] args) {
        BCAStudent[] students = new BCAStudent[3];

        students[0] = new BCAStudent("Parv Attrey", 302, 5);
        students[1] = new BCAStudent("Krish Chopra", 269, 5);
        students[2] = new BCAStudent("Krrish Tiwari", 271, 5);

        System.out.println("BCA Student Details:");
        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
        try {
            System.out.println("\nTrying to access invalid index...");
            System.out.println(students[5].name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e);
        }

        System.out.println("\nProgram executed successfully!");
    }
}

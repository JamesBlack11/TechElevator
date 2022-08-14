import com.techelevator.student.Student;

public class ScratchPad {


    private String name;

    public ScratchPad() {

    }

public ScratchPad(String n) {
    name = n;
}
public String getName() {
            return name;
}


    public static void main(String[] args) {
        System.out.println("Hello World!");


        //   create a variable called myScratchpad of type ScratchPad.
        //assign to it a new instance of ScratchPad created by calling the no-arg constructor for ScratchPad
        ScratchPad myScratchPad = new ScratchPad();
        ScratchPad myScratchPad2 = new ScratchPad("Tom");
        ScratchPad myScratchPad3 = new ScratchPad("Joe");

        System.out.println(myScratchPad2.getName());
        System.out.println(myScratchPad3.getName());

        Student student1 = new Student("Bootyboy", "789 Main St.");
        Student student2 = new Student("MeanMary");
        Student student3 = new Student("Jake", " 123 Main St.");

        student2.setName("Mary");
        student1.setAddress("789 Main St.");
        student2.setAddress("456 Main St.");
        student3.setAddress("457 Main St.");

        System.out.println(student1.getName() + " " + student1.getAddress());
        System.out.println(student2.getName() + " " + student2.getAddress());
        System.out.println(student3.getName() + " " + student3.getAddress());

        System.out.println(student1.getSchool());
        System.out.println(student2.getSchool());
        System.out.println(student3.getSchool());

    }
}

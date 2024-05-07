package task.code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${student.name}")
    private String studentName;

    @Value("${student.last_name}")
    private String studentLastName;

    @Value("${student.group}")
    private String studentGroup;

    public void printStudentDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Last Name: " + studentLastName);
        System.out.println("Student Group: " + studentGroup);
    }
}

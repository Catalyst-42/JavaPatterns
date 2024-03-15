package Task14;

public class Patient {
    private String firstName;
    private String lastName;
    private String position;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    @Override
    public String toString() {
        if (position != null)
            return "Patient2 [firstName=" + firstName + ", lastName=" + lastName + ", position=" + position + "]";
            
        return "Patient1 [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}

package Task14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    ArrayList<Patient> patients = new ArrayList<>();

    @GetMapping("/get/patient")
    public @ResponseBody String getPatient1() {
        if (patients.size() != 0)
            return patients.get(patients.size() - 1).toString();
        
        return "List is empty";
    }

    @GetMapping(value="/set/patient", params={"firstName", "lastName"})
    public @ResponseBody String setPatient1(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        System.err.println("Going to set " + firstName + " " + lastName);

        Patient patient = new Patient(firstName, lastName);
        patients.add(patient);
        return "Created " + patient.toString();
    }

    @GetMapping(value="/set/patient", params={"firstName", "lastName", "position"})
    public @ResponseBody String setPatient2(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("position") String position) {
        System.err.println("Going to set " + firstName + " " + lastName + " " + position);

        Patient patient = new Patient(firstName, lastName, position);
        patients.add(patient);
        return "Created " + patient.toString();
    }
    
    @GetMapping("/home")
    public @ResponseBody String home() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("Task14/index.html")));
        return content;
    }
}

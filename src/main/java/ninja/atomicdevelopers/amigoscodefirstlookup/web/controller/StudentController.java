package ninja.atomicdevelopers.amigoscodefirstlookup.web.controller;

import ninja.atomicdevelopers.amigoscodefirstlookup.db.student.Student;
import ninja.atomicdevelopers.amigoscodefirstlookup.db.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path ="/api/v1/student")
public class StudentController {
    private final StudentService studentService;


//    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity addNewStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addNewStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "localhost:8080/api/v1/student/" + savedStudent.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}

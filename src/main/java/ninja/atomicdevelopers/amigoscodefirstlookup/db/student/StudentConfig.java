package ninja.atomicdevelopers.amigoscodefirstlookup.db.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student( "Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.APRIL, 12));

            Student genaro = new Student( "Genaro", "gtinoco@gmail.com", LocalDate.of(1996, Month.JUNE, 15));

            Student alex = new Student("Alex", "alex@gmail.com",  LocalDate.of(2004, Month.JULY, 25));

            repository.saveAll(List.of(genaro, mariam, alex));
        };
    }
}

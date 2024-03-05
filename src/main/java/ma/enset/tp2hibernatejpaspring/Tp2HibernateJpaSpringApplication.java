package ma.enset.tp2hibernatejpaspring;

import ma.enset.tp2hibernatejpaspring.entities.Patient;
import ma.enset.tp2hibernatejpaspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2HibernateJpaSpringApplication implements CommandLineRunner{
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2HibernateJpaSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(-1, "Hassan", new Date(), false, 4));
        patientRepository.save(new Patient(-1, "Khalid", new Date(), false, 5));
        patientRepository.save(new Patient(-1, "Zaid", new Date(), true, 6));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        Patient patient = patientRepository.findById(Long.valueOf(2)).get();
        System.out.println("**" + patient.getName() + "**" + patient.getDateNaissance());
    }
}

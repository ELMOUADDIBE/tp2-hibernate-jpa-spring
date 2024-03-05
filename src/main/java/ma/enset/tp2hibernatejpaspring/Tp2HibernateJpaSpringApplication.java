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
        //Ajouter des patients
//        patientRepository.save(new Patient(-1, "Hassan", new Date(), false, 4));
//        patientRepository.save(new Patient(-1, "Khalid", new Date(), false, 5));
//        patientRepository.save(new Patient(-1, "Zaid", new Date(), true, 6));
//        patientRepository.save(new Patient(-1, "Younes", new Date(), false, 7));
//        patientRepository.save(new Patient(-1, "Zakaria", new Date(), true, 8));

        //Afficher les patients
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });

        //Consulter un patient, exemple id=2
        Patient patient = patientRepository.findById(Long.valueOf(2)).get();
        System.out.println("*****");
        System.out.println(patient.getId());
        System.out.println(patient.getName());
        System.out.println(patient.getDateNaissance());
        System.out.println("*****");

        //Rechercher des patients
        List<Patient> patients2 = patientRepository.findByNameContains("Z");

        //Modifier un patient
        Patient patient2 = patientRepository.findById(Long.valueOf(5)).get();
        patient2.setName("ZaidModifier");
        patientRepository.save(patient2);
        //Afficher
        Patient patient3 = patientRepository.findById(Long.valueOf(10)).get();
        System.out.println(patient3.getName());

        //Supprimer un patient
        patientRepository.deleteById(Long.valueOf(3));
    }
}

package ma.enset.tp2hibernatejpaspring;

import ma.enset.tp2hibernatejpaspring.entities.Medecin;
import ma.enset.tp2hibernatejpaspring.entities.Patient;
import ma.enset.tp2hibernatejpaspring.entities.RendezVous;
import ma.enset.tp2hibernatejpaspring.repository.MedecinRepository;
import ma.enset.tp2hibernatejpaspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2HibernateJpaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tp2HibernateJpaSpringApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository){
        return args -> {
            //Patient
            patientRepository.save(new Patient(-1,"Hassan",new Date(), false, 2300,null));
            patientRepository.save(new Patient(-1,"Youssef",new Date(), false, 500,null));
            patientRepository.save(new Patient(-1,"Imane",new Date(), false, 100,null));

            //Medecin
            Stream.of("Rachid","Karim","Omar").forEach(m->{
                Medecin medecin = new Medecin();
                medecin.setName(m);
                medecin.setEmail(m+"@fsm.ma");
                medecin.setSpecialite(Math.random()>0.5?"Cardiologue":"Dentiste");
                medecinRepository.save(medecin);
            });
        };

    }
}

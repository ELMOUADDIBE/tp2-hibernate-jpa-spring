package ma.enset.tp2hibernatejpaspring;

import ma.enset.tp2hibernatejpaspring.entities.*;
import ma.enset.tp2hibernatejpaspring.repository.ConsulatationRepository;
import ma.enset.tp2hibernatejpaspring.repository.MedecinRepository;
import ma.enset.tp2hibernatejpaspring.repository.PatientRepository;
import ma.enset.tp2hibernatejpaspring.repository.RendezVousRepository;
import ma.enset.tp2hibernatejpaspring.service.IHospital;
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
    CommandLineRunner start(IHospital iHospital, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsulatationRepository consulatationRepository){
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
                iHospital.saveMedecin(medecin);
            });

            //RendezVous
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.CONFIRMED);
            rendezVous.setPatient(patientRepository.findById(1L).get());
            rendezVous.setMedecin(medecinRepository.findById(1L).get());
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

            //Consultation
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation");
            iHospital.saveConsultation(consultation);
        };
    }
}

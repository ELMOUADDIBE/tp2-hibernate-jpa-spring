package ma.enset.tp2hibernatejpaspring.repository;

import ma.enset.tp2hibernatejpaspring.entities.Consultation;
import ma.enset.tp2hibernatejpaspring.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulatationRepository extends JpaRepository<Consultation, Long>{
}

package ma.enset.tp2hibernatejpaspring.repository;

import ma.enset.tp2hibernatejpaspring.entities.Medecin;
import ma.enset.tp2hibernatejpaspring.entities.Patient;
import ma.enset.tp2hibernatejpaspring.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{
}

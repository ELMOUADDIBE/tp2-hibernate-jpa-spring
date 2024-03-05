package ma.enset.tp2hibernatejpaspring.repository;

import ma.enset.tp2hibernatejpaspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}

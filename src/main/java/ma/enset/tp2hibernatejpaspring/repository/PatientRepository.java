package ma.enset.tp2hibernatejpaspring.repository;

import ma.enset.tp2hibernatejpaspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    List<Patient> findByNameContains(String name);
    Patient findByName(String name);
    @Query("select p from Patient p where p.name like :x")
    List<Patient> search(@Param("x") String mc);
}

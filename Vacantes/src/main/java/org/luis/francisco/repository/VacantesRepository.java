package org.luis.francisco.repository;

import org.luis.francisco.entity.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}

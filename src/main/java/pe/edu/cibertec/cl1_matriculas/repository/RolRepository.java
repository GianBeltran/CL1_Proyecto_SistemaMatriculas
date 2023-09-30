package pe.edu.cibertec.cl1_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectomatriculas.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}

package pe.edu.cibertec.cl1_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.cl1_matriculas.model.bd.Pagos;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer> {
}

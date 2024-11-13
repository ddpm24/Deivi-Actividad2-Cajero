package cajeroweb.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cajeroweb.modelo.entities.Movimiento;
import java.util.List;




public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	@Query("select m from Movimiento m where m.cuenta.idCuenta = ?1")
	public List<Movimiento> finAllByIdCuenta(long cuenta);
}

package cajeroweb.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cajeroweb.modelo.entities.Movimiento;



public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}

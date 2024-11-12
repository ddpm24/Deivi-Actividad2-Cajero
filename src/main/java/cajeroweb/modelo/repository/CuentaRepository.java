package cajeroweb.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cajeroweb.modelo.entities.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

	public Cuenta findByIdCuenta(long idCuenta);
}

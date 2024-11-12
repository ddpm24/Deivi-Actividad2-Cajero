package cajeroweb.modelo.dao;

import cajeroweb.modelo.entities.Cuenta;

public interface CuentaDao {
	
	Cuenta buscarPorIdCuenta(long idCuenta);
	Cuenta insertOne(Cuenta cuenta);
	
}

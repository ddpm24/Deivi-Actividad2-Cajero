package cajeroweb.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajeroweb.modelo.entities.Cuenta;
import cajeroweb.modelo.repository.CuentaRepository;

@Repository
public class CuentaDaoImplJpaMy8 implements CuentaDao{
	
	@Autowired
	private CuentaRepository crepo;

	@Override
	public Cuenta buscarPorIdCuenta(long idCuenta) {
		// TODO Auto-generated method stub
		return crepo.findByIdCuenta(idCuenta);
	}

	@Override
	public Cuenta insertOne(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return crepo.save(cuenta);
	}

}

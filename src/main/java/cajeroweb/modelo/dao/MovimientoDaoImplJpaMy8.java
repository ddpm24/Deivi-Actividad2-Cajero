package cajeroweb.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajeroweb.modelo.entities.Movimiento;
import cajeroweb.modelo.repository.MovimientoRepository;

@Repository
public class MovimientoDaoImplJpaMy8 implements MovimientoDao {

	@Autowired
	private MovimientoRepository mrepo;
	
	@Override
	public Movimiento findById(int idMovimiento) {
		// TODO Auto-generated method stub
		return mrepo.findById(idMovimiento).orElse(null);
	}

	@Override
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return mrepo.findAll();
	}

	@Override
	public int insertOne(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return (mrepo.save(movimiento) != null) ? 1 : 0;
	}

	@Override
	public int updateOne(Movimiento movimiento) {
		// TODO Auto-generated method stub
		if (mrepo.existsById(movimiento.getIdMovimiento())) {
			mrepo.save(movimiento);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteOne(Movimiento movimiento) {
		if (mrepo.existsById(movimiento.getIdMovimiento())) {
			mrepo.delete(movimiento);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteOne(int idMovimiento) {
		if (mrepo.existsById(idMovimiento)) {
			mrepo.deleteById(idMovimiento);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Movimiento> buscarMovimientosPorIdCuenta(long idCuenta) {
		// TODO Auto-generated method stub
		return mrepo.finAllByIdCuenta(idCuenta);
	}

}

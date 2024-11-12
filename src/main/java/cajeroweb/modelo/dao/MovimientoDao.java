package cajeroweb.modelo.dao;

import java.util.List;

import cajeroweb.modelo.entities.Movimiento;

public interface MovimientoDao {
	Movimiento findById(long idProducto);
	List<Movimiento> findAll();
	
	int insertOne(Movimiento movimiento);
	int updateOne(Movimiento movimiento);
	int deleteOne(Movimiento movimiento);
	int deleteOne(int idMovimiento);
}

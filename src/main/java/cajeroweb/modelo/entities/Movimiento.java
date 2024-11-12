package cajeroweb.modelo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="movimientos")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private int idMovimiento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private double cantidad;
	private String operacion;
	
	@ManyToOne
	@JoinColumn(name = "id_cuenta")
	private Cuenta cuenta;

}

package cajeroweb.modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cuenta")
	private long idCuenta;
	private double saldo;
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos = new ArrayList<>();
	
	public Cuenta() {
		super();
	}

	public Cuenta(long idCuenta, double saldo, String tipoCuenta, List<Movimiento> movimientos) {
		super();
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.movimientos = movimientos;
	}

	public long getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuenta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cuenta))
			return false;
		Cuenta other = (Cuenta) obj;
		return idCuenta == other.idCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + "]";
	}
			
			
	
	
	
}

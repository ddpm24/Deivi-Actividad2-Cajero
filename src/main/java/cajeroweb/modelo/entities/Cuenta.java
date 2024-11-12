package cajeroweb.modelo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	
	
	public Cuenta() {
		super();
	}


	public Cuenta(long idCuenta, double saldo, String tipoCuenta) {
		super();
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
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


	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + "]";
	}
			
			
	
	
	
}

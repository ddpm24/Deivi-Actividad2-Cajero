package cajeroweb.restcontoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cajeroweb.modelo.dao.CuentaDao;
import cajeroweb.modelo.entities.Cuenta;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cajero")
public class CuentaController {
	
	@Autowired
	private CuentaDao cdao;

	
	@GetMapping("/porid/{idCuenta}")
	public Cuenta buscarPorIdCuenta(@PathVariable long idCuenta){
		return cdao.buscarPorIdCuenta(idCuenta);
	}
	
}

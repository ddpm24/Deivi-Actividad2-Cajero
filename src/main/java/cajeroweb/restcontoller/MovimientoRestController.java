package cajeroweb.restcontoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cajeroweb.modelo.dao.MovimientoDao;
import cajeroweb.modelo.entities.Movimiento;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cajero")
public class MovimientoRestController {

	@Autowired
	private MovimientoDao mdao;
	
	@GetMapping("/all")
	public List<Movimiento> buscarPorIdCuenta(){
		return mdao.findAll();
	}
	
}

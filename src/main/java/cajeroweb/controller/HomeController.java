package cajeroweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajeroweb.modelo.dao.CuentaDao;
import cajeroweb.modelo.dao.MovimientoDao;
import cajeroweb.modelo.entities.Cuenta;
import cajeroweb.modelo.entities.Movimiento;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private CuentaDao cuentaDao;
	@Autowired
	private MovimientoDao movimientoDao;
	
	@GetMapping({"","/"})
	public String home(Model model) {
		return "FormLogin";
	}
	
	
	@PostMapping("/login")
	public String procesarFormLogin(@RequestParam long idCuenta,
									HttpSession session, 
									RedirectAttributes ratt){
		
		Cuenta cuenta = cuentaDao.buscarPorIdCuenta(idCuenta);
		
		if (cuenta != null) {
			
			session.setAttribute("cuenta", cuenta);
			return "redirect:/menu";
			
		}else {
			ratt.addFlashAttribute("mensaje", "El número de cuenta no existe");
				return "redirect:/";
		}
		
	}
	
	@GetMapping("/menu")
	public String mostrarMenu() {
		
		return "Menu";
	}
	
	@GetMapping("/movimientos/all")
	public String buscarTodosMovimientos(Model model) {
	    // Obtiene la lista de movimientos desde la base de datos
	    List<Movimiento> movimientos = movimientoDao.findAll();
	    model.addAttribute("movimientos", movimientos);

	    // Devuelve la vista que contiene la tabla de movimientos (sin redirección)
	    return "Menu"; // Asegúrate de que "movimientos" sea la plantilla con la tabla
	}
	
	
}

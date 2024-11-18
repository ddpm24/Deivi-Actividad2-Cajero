package cajeroweb.controller;

import java.util.Date;
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
	public String home(Model model, HttpSession session) {
		
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
	
	//para cerrar sesion
	@GetMapping("/logout")
 	public String cerrarSesion(HttpSession sesion) {
 		sesion.removeAttribute("cuenta");
 		sesion.invalidate();
 		return "redirect:/";
 		
 	}
	
		
	@GetMapping("/menu")
	public String mostrarMenu() {
		
		return "Menu";
	}
	
	@GetMapping("/movimientos/all")
	public String buscarTodosMovimientos(Model model, HttpSession session) {
		
		Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
		
	    List<Movimiento> movimientos = movimientoDao.buscarMovimientosPorIdCuenta(cuenta.getIdCuenta());
	    model.addAttribute("movimientos", movimientos);

	    return "Menu"; 
	}
	
	
	@PostMapping("/movimientos/ingresar")
	public String procIngresar(Movimiento movimiento, HttpSession session, Model model) {
	    Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
	    movimiento.setOperacion("ingreso");
	    movimiento.setFecha(new Date());
	    movimiento.setCuenta(cuenta);
	    
	    if (cuenta.ingresar(movimiento.getCantidad())) {
	    	model.addAttribute("mensajePositivo", "Ingreso realizado correctamente");
	    } else {
	    	model.addAttribute("mensajeNegativo", "Operación NO realizada");
	    }
	    
	    movimientoDao.insertOne(movimiento);
	    cuentaDao.insertOne(cuenta);
	    
	    return "Menu";  
	}
	
	@PostMapping("/movimientos/extraer")
	public String procExtraer(Movimiento movimiento, HttpSession session, Model model) {
		Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
		movimiento.setOperacion("extraccion");
		movimiento.setFecha(new Date());
		movimiento.setCuenta(cuenta);
		
		
		if (cuenta.extraer(movimiento.getCantidad()) && movimientoDao.insertOne(movimiento) == 1 && cuentaDao.insertOne(cuenta) != null)
			model.addAttribute("mensajePositivo", "Extracción realizada correctamente");
		else
			model.addAttribute("mensajeNegativo", "Operación NOO realizada");
		
		buscarTodosMovimientos(model, session);
		return "Menu";
	}
	
	@PostMapping("/movimientos/transferir")
	public String procTransferir(@RequestParam long idCuenta, Movimiento movimientoOrigen, HttpSession session, Model model) {
		System.out.println(movimientoOrigen);
		Movimiento movimientoDestino = new Movimiento();
		Cuenta cuentaDestino = cuentaDao.buscarPorIdCuenta(idCuenta);
		
		Cuenta cuentaOrigen = (Cuenta) session.getAttribute("cuenta");
		movimientoOrigen.setOperacion("extraccion");
		movimientoOrigen.setFecha(new Date());
		movimientoOrigen.setCuenta(cuentaOrigen);
		
		movimientoDestino.setCuenta(cuentaDestino);
		movimientoDestino.setOperacion("ingreso");
		movimientoDestino.setFecha(new Date());
		movimientoDestino.setCantidad(movimientoOrigen.getCantidad());
		

		if (cuentaOrigen.extraer(movimientoOrigen.getCantidad()) && cuentaDestino.ingresar(movimientoOrigen.getCantidad()) &&
				movimientoDao.insertOne(movimientoOrigen) == 1 && movimientoDao.insertOne(movimientoDestino) == 1 && 
				cuentaDao.insertOne(cuentaOrigen) != null && cuentaDao.insertOne(cuentaDestino)!= null)
			model.addAttribute("mensajePositivo", "Transferencia realizada correctamente");
		else
			model.addAttribute("mensajeNegativo", "Operación NOO realizada");
		
		buscarTodosMovimientos(model, session);
		return "Menu";
	}
	
	
}

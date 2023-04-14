package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import service.CajeroService;

@Controller
public class CajeroController {
	@Autowired
	CajeroService service;
	@PostMapping("validar")
	public String validar(@RequestParam("idCuenta") int numeroCuenta, HttpSession sesion) {
		if(service.comprobarCuenta(numeroCuenta)) {
			//guardamos el n�mero de cuenta en un atributo de sesi�n
			sesion.setAttribute("idCuenta", numeroCuenta);
			return "menu";
		}else {
			return "inicio";
		}
	}
	/*public String ingresar(@RequestParam("cantidad") double cantidad, HttpSession sesion) {
		int idCuenta=(int)sesion.getAttribute("idCuenta");
		service.ingresar(idCuenta, cantidad);
		return "menu";
	}*/
	@PostMapping("ingresar")
	public String ingresar(@RequestParam("cantidad") double cantidad, @SessionAttribute("idCuenta") int idCuenta) {
		service.ingresar(idCuenta, cantidad);
		return "menu";
	}
	@PostMapping("extraer")
	public String extraer(@RequestParam("cantidad") double cantidad, @SessionAttribute("idCuenta") int idCuenta) {
		service.extraer(idCuenta, cantidad);
		return "menu";
	}
	
	@PostMapping("transferir")
	public String transferencia(@RequestParam("cantidad") double cantidad, 
								@RequestParam("destino") int idCuentaDestino,
								@SessionAttribute("idCuenta") int idCuenta) {
		service.transferir(idCuenta, idCuentaDestino, cantidad);
		return "menu";
	}
	@GetMapping("movimientosSaldo")
	public String saldoMovimiento(@SessionAttribute("idCuenta") int idCuenta, HttpServletRequest request) {
		request.setAttribute("saldo", service.consultarSaldo(idCuenta));
		request.setAttribute("movimientos", service.consultarMovimientos(idCuenta));
		return "movimientos";
	}
	
	
	
	
	
	
}

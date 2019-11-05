package examen.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import examen.demo.model.entity.Pedido;
import examen.demo.service.PedidoService;

@Controller
@RequestMapping("/pedido")
@SessionAttributes( {"plato" ,"pedido" , "usuario"} )
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Pedido> pedido = pedidoService.findAll();
			model.addAttribute("pedidos", pedido);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/inicio";
	}
	
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			if(pedido.isPresent()) {
				pedidoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Pedido> pedido = pedidoService.findAll();
				model.addAttribute("pedido", pedido);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/pedido/inicio";
		}
		return "redirect:/pedido";
	}
	
}

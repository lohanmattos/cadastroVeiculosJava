package projeto.cadastroVeiculos.controle;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeControler {
	
	@RequestMapping("/")
	public String Home() {
		return "homePrincipal";
	}
	
}

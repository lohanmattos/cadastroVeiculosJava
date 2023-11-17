package projeto.cadastroVeiculos.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projeto.cadastroVeiculos.modelo.Combustivel;
import projeto.cadastroVeiculos.modelo.Fabricante;
import projeto.cadastroVeiculos.modelo.Veiculo;
import projeto.cadastroVeiculos.repositorio.CombustivelRepositorio;
import projeto.cadastroVeiculos.repositorio.FabricanteRepositorio;
import projeto.cadastroVeiculos.repositorio.VeiculoRepositorio;


@Controller
public class VeiculoControle {
	
	@Autowired
	private VeiculoRepositorio produtoRepositorio;
	
	@Autowired
	private FabricanteRepositorio fabricanteRespositorio;
	
	@Autowired
	private CombustivelRepositorio combustivelRepositorio;
	
		
	//Listar
	@RequestMapping("/produtos")
	public String listarProduto(Model model) {				
		  List<Veiculo> produto = produtoRepositorio.findAllProdutoListado();
		  model.addAttribute("listarProduto", produto);
		  
		  return "home";
	}
	
		
	//Novo
	@GetMapping("adm/novo")
	public String novoProduto(Model model, Veiculo produto) {
		
		model.addAttribute("produto", produto);
		
		List<Fabricante> fabricantes = fabricanteRespositorio.findAll();
		
		List<Combustivel> tiposCombustiveis = combustivelRepositorio.findAll();
		
		model.addAttribute("fabricantes", fabricantes);
		model.addAttribute("tiposCombustiveis", tiposCombustiveis);
		

		return "cadastrarProduto";
	}
	
	//Salvar
	@PostMapping("adm/salvar")
	public String salvarProduto(Model model, Veiculo produto, RedirectAttributes attributes) {
		model.addAttribute("produto", produtoRepositorio.save(produto));
	
		attributes.addFlashAttribute("mensagem", "Produto Cadastrado com Sucesso.");
		return "redirect:/produtos";	
	}
	
	//Editar Produto
	@GetMapping("adm/{placa}")
	public String alterarProduto(@PathVariable("placa") String placa, Model model) {
		Optional<Veiculo> produto = produtoRepositorio.findById(placa);
		
		
		List<Fabricante> fabricantes = fabricanteRespositorio.findAll();
		
		List<Combustivel> tiposCombustiveis = combustivelRepositorio.findAll();
		
		model.addAttribute("fabricantes", fabricantes);
		model.addAttribute("tiposCombustiveis", tiposCombustiveis);
					
		model.addAttribute("produto", produto);	
		return "editarProduto";
	}		
		
	//Deletar Produto
	@RequestMapping(path = "adm/deletar/{id}", method = RequestMethod.GET)
	public String excluirProduto(@PathVariable String id, RedirectAttributes attributes) {
		produtoRepositorio.deleteById(id);
		attributes.addFlashAttribute("mensagemErro", "Produto Excluído com Sucesso.");
		return "redirect:/produtos";
	}
	
				
}

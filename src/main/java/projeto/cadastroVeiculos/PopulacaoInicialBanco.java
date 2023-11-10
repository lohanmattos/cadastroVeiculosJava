package projeto.cadastroVeiculos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import projeto.cadastroVeiculos.modelo.Combustivel;
import projeto.cadastroVeiculos.modelo.Fabricante;
import projeto.cadastroVeiculos.repositorio.CombustivelRepositorio;
import projeto.cadastroVeiculos.repositorio.FabricanteRepositorio;


//Roda a primeira vez, apenas para popular o banco
//@Component
//@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	public FabricanteRepositorio fabricanteRepositorio; 
	
	@Autowired
	public CombustivelRepositorio combustivelRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Cria as Fabricantes
		Fabricante fabricante01 =  new Fabricante();
		fabricante01.setNomeFabricante("FIAT");
		fabricanteRepositorio.save(fabricante01);
		
		Fabricante fabricante02 =  new Fabricante();
		fabricante02.setNomeFabricante("FORD");
		fabricanteRepositorio.save(fabricante02);
		
		Fabricante fabricante03 =  new Fabricante();
		fabricante03.setNomeFabricante("TESLA");
		fabricanteRepositorio.save(fabricante03);
		
		
		
		//Criar os Combustiveis
		Combustivel combustivel01 =  new Combustivel();
		combustivel01.setNomeCombustivel("Gasolina");
		combustivelRepositorio.save(combustivel01);
		
		Combustivel combustivel02 =  new Combustivel();
		combustivel02.setNomeCombustivel("Álcool");
		combustivelRepositorio.save(combustivel02);
		
		Combustivel combustivel03 =  new Combustivel();
		combustivel03.setNomeCombustivel("Flex");
		combustivelRepositorio.save(combustivel03);
		
	}

}

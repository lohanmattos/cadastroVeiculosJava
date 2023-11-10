package projeto.cadastroVeiculos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.cadastroVeiculos.modelo.Fabricante;

@Repository
public interface FabricanteRepositorio extends JpaRepository<Fabricante, String> {
	
	@Query(value = "SELECT * FROM tb_fabricante",  nativeQuery = true)
	List<Fabricante> findAllFabricantes();
}

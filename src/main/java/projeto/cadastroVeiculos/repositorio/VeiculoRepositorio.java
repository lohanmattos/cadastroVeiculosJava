package projeto.cadastroVeiculos.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.cadastroVeiculos.modelo.*;


@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, String> {
		
	
	@Query(value = "SELECT * FROM tb_veiculos",  nativeQuery = true)
	List<Veiculo> findAllProdutoListado();

	
	@Query(value = "SELECT * FROM tb_veiculo", countQuery = "select count(v) from tb_veiculos v",  nativeQuery = true)
	Page<Veiculo> findAllProdutoListadoPaginado(Pageable pageable);
	
}

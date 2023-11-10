package projeto.cadastroVeiculos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.cadastroVeiculos.modelo.Combustivel;

@Repository
public interface CombustivelRepositorio extends JpaRepository<Combustivel, String> {

}

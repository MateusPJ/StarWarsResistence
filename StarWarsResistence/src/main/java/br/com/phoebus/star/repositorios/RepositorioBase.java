package br.com.phoebus.star.repositorios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.phoebus.star.entidades.EntidadeBase;


/**
 * 
 * Interface generica utilizadas como base para implemetação de todas as outras interfaces.
 * 
 * @author Mateus P Jorge
 *
 * @param <Entidade> - Entidade generica que recebe apenas EntidadeBase.
 * @param <ID> - Entidade generica que recebe o tipo do id da entidade.
 */
@NoRepositoryBean
public interface RepositorioBase<Entidade extends EntidadeBase, ID extends Serializable> extends JpaRepository<Entidade, ID> {

	/**
	 * 
	 * Método responsável por salvar uma entidade genericamente.
	 *
	 * @author Mateus P Jorge
	 * 
	 * @param S - Entidade genérica que extende de EntidadeBase.
	 * @return S - Entidade genérica que extende de EntidadeBase.
	 */
	<S extends Entidade> S save(S entidade);
	
	/**
	 * 
	 * Metodo responsável por deletar uma entidade genericamente.
	 * 
	 * @author Mateus P Jorge
	 * 
	 * @param Entidade - Entidade gererica que extende EntidadeBase. 
	 */
	void delete(Entidade entidade);
	
	/**
	 * 
	 * Metodo responsável por retornar uma lista de entidades definidas pelo generic
	 * sem clausulas de consulta.
	 * 
	 * @author Mateus P Jorge
	 * 
	 * @return List - Returno de uma lista das entidades definidas pelo generic.
	 */
	List<Entidade> findAll();
	
	/**
	 * 
	 * Metodo responsável por recuperar uma entidade a partir do id.
	 * 
	 * @author Mateus P Jorge
	 * 
	 * @param ID - Id da entidade a ser recuperada.
	 * @return Entidade - Entidade recuperada a partir do id.
	 */
	Optional<Entidade> findById(ID id);
	
}

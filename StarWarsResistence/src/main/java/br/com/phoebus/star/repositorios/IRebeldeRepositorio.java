/**
 * 
 */
package br.com.phoebus.star.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import br.com.phoebus.star.entidades.Rebelde;

/**
 * @author Mateus P Jorge
 *
 */
public interface IRebeldeRepositorio extends RepositorioBase<Rebelde, Long> {

	/**
	 * 
	 * Retorna todos os rebeldes qeu NÃO são traidores. 
	 * 
	 * 	@author Mateus P Jorge
	 */
	@Query(
	  value = "select * " + 
	  		"from tb_rebelde reb " + 
	  		"where reb.id not in (select traidores.id_traidor " + 
	  		"		    from (select r.id_traidor, count(r.id_traidor) " + 
	  		"			  from tb_report r " + 
	  		"			  group by r.id_traidor " + 
	  		"			  HAVING count(r.id_traidor) >= 3) traidores)", 
	  nativeQuery = true)
	@Override
	List<Rebelde> findAll();	
	
}

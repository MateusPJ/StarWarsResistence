package br.com.phoebus.star.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.phoebus.star.entidades.Report;

/**
 * 
 * Interface responsável por controlar as informações sobre Report.
 * 
 * @author Mateus P Jorge
 *
 * @param <Entidade> - Entidade generica que recebe apenas Report.
 * @param <ID>       - Entidade generica que recebe o tipo do id da entidade
 *                   Report (Long).
 */
public interface IReporteRepositorio extends RepositorioBase<Report, Long> {

	/**
	 * 
	 * Método responsável por retorna todos os reports de um mesmo rebelde.
	 * 
	 * @author Mateus P Jorge
	 */
	@Query("select r from Report r where r.id = ?1")
	List<Report> listarReports(Long idTraidor);

}

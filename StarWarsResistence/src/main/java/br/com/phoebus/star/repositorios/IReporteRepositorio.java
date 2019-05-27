/**
 * 
 */
package br.com.phoebus.star.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.phoebus.star.entidades.Report;

/**
 * @author Mateus P Jorge
 *
 */
public interface IReporteRepositorio extends RepositorioBase<Report, Long> {
	
	@Query("select r from Report r.traidor.id = ?1")
	List<Report> listarReports(Long idTraidor);

}

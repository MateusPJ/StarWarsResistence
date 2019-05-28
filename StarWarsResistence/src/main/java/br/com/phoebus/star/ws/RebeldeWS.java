package br.com.phoebus.star.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.star.entidades.InventarioRebelde;
import br.com.phoebus.star.entidades.Localizacao;
import br.com.phoebus.star.entidades.Rebelde;
import br.com.phoebus.star.entidades.Report;
import br.com.phoebus.star.entidades.util.DtoTroca;
import br.com.phoebus.star.repositorios.IInventarioRebeldeRepositorio;
import br.com.phoebus.star.repositorios.ILocalizacaoRepositorio;
import br.com.phoebus.star.repositorios.IRebeldeRepositorio;
import br.com.phoebus.star.repositorios.IRecursoRepositorio;
import br.com.phoebus.star.repositorios.IReporteRepositorio;
import br.com.phoebus.star.repositorios.util.Util;

@RestController
@RequestMapping("rebelde")
public class RebeldeWS {

	private IRebeldeRepositorio repositorioRebelde;
	private ILocalizacaoRepositorio repositorioLocalizacao;
	private IInventarioRebeldeRepositorio repositorioInventario;
	private IRecursoRepositorio repositorioRecurso;
	private IReporteRepositorio repositorioReport;

	/**
	 * 
	 * Injeção de dependencias da classe RebeldeWS.
	 * 
	 * @param repositorioRebelde
	 * @param repositorioLocalizacao
	 * @param repositorioInventario
	 * @param repositorioRecurso
	 * @param repositorioReport
	 */
	@Autowired
	public RebeldeWS(IRebeldeRepositorio repositorioRebelde, ILocalizacaoRepositorio repositorioLocalizacao,
					 IInventarioRebeldeRepositorio repositorioInventario, IRecursoRepositorio repositorioRecurso,
					 IReporteRepositorio repositorioReport) {
		this.repositorioRebelde = repositorioRebelde;
		this.repositorioLocalizacao = repositorioLocalizacao;
		this.repositorioInventario = repositorioInventario;
		this.repositorioRecurso = repositorioRecurso;
		this.repositorioReport = repositorioReport;

	}

	/**
	 * 
	 * Método para cadastro de rebelde.
	 * 
	 * @param rebelde
	 * @return rebelde cadastrado
	 */
	@PostMapping("cadastrarRebelde")
	public Rebelde salveRebelde(@RequestBody Rebelde rebelde) {

		salvaLocalizacaoRebelde(rebelde.getLocalizacao());

		List<InventarioRebelde> listaParaSalvar = null;

		if (rebelde.getInventario() != null && !rebelde.getInventario().isEmpty()) {
			listaParaSalvar = Util.removeInvetarioRebelde(rebelde);
			rebelde.setInventario(null);
		}

		repositorioRebelde.save(rebelde);

		rebelde.setInventario(salvarInventarioRebelde(listaParaSalvar, rebelde));

		return rebelde;
	}

	/**
	 * 
	 * Método responsável por atualizar a localização do rebelde.
	 * 
	 * @param localizacao
	 * @param idRebelde
	 * @return localizacao
	 */
	@PostMapping("atualizarLocalizacao/{idRebelde}")
	public Localizacao autualizarLocalizacao(@RequestBody Localizacao localizacao,
											 @PathVariable("idRebelde") Long idRebelde) {

		Rebelde rebelde = repositorioRebelde.findById(idRebelde).get();
		Localizacao localizacaoAntiga = rebelde.getLocalizacao();
		localizacaoAntiga.setGalaxia(localizacao.getGalaxia());
		localizacaoAntiga.setLatitude(localizacao.getLatitude());
		localizacaoAntiga.setLongitude(localizacao.getLongitude());

		return repositorioLocalizacao.save(localizacaoAntiga);
	}

	/**
	 * 
	 * Método responsável por realizar o report de um rebelde.
	 * 
	 * @param idTraidor
	 * @param idAcusador
	 * @return true caso o report seja realizado
	 */
	@PostMapping("realizarReport/{idTraidor}/{idAcusador}")
	public Boolean autualizarLocalizacao(@PathVariable("idTraidor") Long idTraidor,
										 @PathVariable("idAcusador") Long idAcusador) {

		Rebelde rebeldeTraidor = repositorioRebelde.findById(idTraidor).get();
		Rebelde rebeldeAcusador = repositorioRebelde.findById(idAcusador).get();

		repositorioReport.save(new Report(rebeldeAcusador, rebeldeTraidor));

		return true;
	}

	/**
	 * 
	 * Método responsável por realizar troca entre os rebeldes.
	 * 
	 * @param listaOferecida
	 * @param listaRecebida
	 * @return
	 */
	@PostMapping("realizaTroca")
	public Boolean realizaTroca(@RequestBody List<DtoTroca> listaOferecida, @RequestBody List<DtoTroca> listaRecebida) {

		if (!Util.validaTroca(listaOferecida, listaRecebida)) {
			boolean reposta;
			reposta = rebeldeTrocando(listaOferecida);
			reposta = rebeldeTrocando(listaRecebida);

			return true;
		}

		return false;
	}

	/**
	 * 
	 * Método responsável por retornar a lista de rebeldes.
	 * 
	 * @return rebeldes salvos
	 */
	@GetMapping(value = "rebeldes")
	public List<Rebelde> listarRebeldes() {
		return repositorioRebelde.findAll();
	}

	/**
	 * 
	 * Método responsável por salvar a localização do rebelde.
	 * 
	 * @param localizacaoRebelde
	 */
	private void salvaLocalizacaoRebelde(Localizacao localizacaoRebelde) {
		repositorioLocalizacao.save(localizacaoRebelde);
	}

	/**
	 * 
	 * Método responsável por salvar o inventário do rebelde.
	 * 
	 * @param listaParaSalvar
	 * @param rebelde
	 * @return 
	 */
	private List<InventarioRebelde> salvarInventarioRebelde(List<InventarioRebelde> listaParaSalvar, Rebelde rebelde) {
		if (listaParaSalvar != null && !listaParaSalvar.isEmpty()) {
			for (InventarioRebelde inventario : listaParaSalvar) {
				inventario.setRebelde(rebelde);
				repositorioInventario.save(inventario);
				Util.iniciaRecurso(inventario, repositorioRecurso);
			}
			return listaParaSalvar;
		}

		return null;

	}
	
	/**
	 * 
	 * Método responsável por finalizar a troca entre os rebeldes.
	 * 
	 * @param idRecurso
	 * @param qtde
	 * @param rebelde
	 * @return 
	 */
	private boolean finalizaTroca(Long idRecurso, int qtde, Rebelde rebelde) {
		for (InventarioRebelde inventario : rebelde.getInventario()) {
			if (inventario.getRecurso().getId().equals(idRecurso)) {
				inventario.setQuantidade(inventario.getQuantidade() - qtde);
				repositorioInventario.save(inventario);

				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * Método responsável por verificar se o rebelde não é um traidor antes de realizar a troca.
	 * 
	 * @param listaTroca
	 * @return
	 */
	private boolean rebeldeTrocando(List<DtoTroca> listaTroca) {

		Rebelde rebeldeTrocando = null;
		for (DtoTroca dtoTroca : listaTroca) {
			if (rebeldeTrocando == null) {
				rebeldeTrocando = repositorioRebelde.findById(dtoTroca.getIdRebelde()).get();
				if (repositorioReport.listarReports(rebeldeTrocando.getId()).size() > 2) {
					return false;
				}
			}
			return finalizaTroca(dtoTroca.getRecurso().getId(), dtoTroca.getQtde(), rebeldeTrocando);
		}

		return false;
	}

}

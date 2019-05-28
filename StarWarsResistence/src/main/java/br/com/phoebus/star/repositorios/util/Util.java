package br.com.phoebus.star.repositorios.util;

import java.util.List;

import br.com.phoebus.star.entidades.InventarioRebelde;
import br.com.phoebus.star.entidades.Rebelde;
import br.com.phoebus.star.entidades.util.DtoTroca;
import br.com.phoebus.star.repositorios.IRecursoRepositorio;

/**
 * Classe utilitária que carrega vários métodos que seram utilizados pelo
 * sistema.
 * 
 * @author Mateus P Jorge
 *
 */
public class Util {

	/**
	 * 
	 * Método responsável por remover o inventário do rebelde.
	 * 
	 * @param rebelde
	 * @return inventario
	 */
	public static List<InventarioRebelde> removeInvetarioRebelde(Rebelde rebelde) {
		List<InventarioRebelde> listaParaSalvar = null;

		if (rebelde.getInventario() != null && !rebelde.getInventario().isEmpty()) {
			listaParaSalvar = rebelde.getInventario();
			rebelde.setInventario(null);
		}

		return listaParaSalvar;
	}

	/**
	 * 
	 * Método responsável por iniciar um recurso.
	 * 
	 * @param inventario
	 * @param recursoRepositorio
	 * @return recurso no inventário
	 */
	public static InventarioRebelde iniciaRecurso(InventarioRebelde inventario,
												  IRecursoRepositorio recursoRepositorio) {
		inventario.setRecurso((recursoRepositorio.findById(inventario.getRecurso().getId()).get()));
		return inventario;
	}

	/**
	 * 
	 * Método responsável por verificar se os pontos dos itens oferecidos são o
	 * equivalente dos itens recebidos.
	 * 
	 * @param itensOferecido
	 * @param itensRecebidos
	 * @return retorna true caso o número dos pontos estejam equivalentes
	 */
	public static boolean validaTroca(List<DtoTroca> itensOferecido, List<DtoTroca> itensRecebidos) {
		if (itensOferecido == null && itensRecebidos == null && itensOferecido.isEmpty() && itensRecebidos.isEmpty()) {
			return false;
		}
		int somaItensOferecidos = contaPontos(itensOferecido);
		int somaItensRecebidos = contaPontos(itensRecebidos);

		return (somaItensOferecidos == somaItensRecebidos);
	}

	/**
	 * 
	 * Método responsável por verificar a quantidade de itens no inventário.
	 * 
	 * @param qtdeRemovida
	 * @param itens
	 * @param itensParaRemover
	 * @return retorna true caso a quantidade de itens no inventário seja maior que
	 *         zero.
	 */
	public static boolean verificaListaQtdeItemMenor0(int qtdeRemovida, List<InventarioRebelde> itens,
																		List<DtoTroca> itensParaRemover) {
		for (DtoTroca dtoTroca : itensParaRemover) {
			for (InventarioRebelde inventarioRebelde : itens) {
				if (inventarioRebelde.getRecurso().getId().equals(dtoTroca.getRecurso().getId())) {
					return (inventarioRebelde.getQuantidade() - qtdeRemovida) < 0;
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * Método responsável por realizar a contagem dos pontos dos itens no
	 * inventário.
	 * 
	 * @param itens
	 * @return total de pontos equivalente aos itens
	 */
	private static int contaPontos(List<DtoTroca> itens) {
		int contPontos = 0;
		for (DtoTroca dtoTroca : itens) {
			contPontos += dtoTroca.getRecurso().getPontos() * dtoTroca.getQtde();
		}

		return contPontos;
	}
}

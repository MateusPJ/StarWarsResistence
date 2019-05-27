package br.com.phoebus.star.repositorios.util;

import java.util.List;

import br.com.phoebus.star.entidades.InventarioRebelde;
import br.com.phoebus.star.entidades.Rebelde;
import br.com.phoebus.star.entidades.util.DtoTroca;
import br.com.phoebus.star.repositorios.IRecursoRepositorio;

public class Util {

	public static List<InventarioRebelde> removeInvetarioRebelde(Rebelde rebelde) {
		List<InventarioRebelde> listaParaSalvar = null;

		if (rebelde.getInventario() != null && !rebelde.getInventario().isEmpty()) {
			listaParaSalvar = rebelde.getInventario();
			rebelde.setInventario(null);
		}

		return listaParaSalvar;
	}

	public static InventarioRebelde iniciaRecurso(InventarioRebelde inventario,
			IRecursoRepositorio recursoRepositorio) {
		inventario.setRecurso((recursoRepositorio.findById(inventario.getRecurso().getId()).get()));
		return inventario;
	}

	public static boolean validaTroca(List<DtoTroca> itensOferecido, List<DtoTroca> itensRecebidos) {
		if (itensOferecido == null && itensRecebidos == null && itensOferecido.isEmpty() && itensRecebidos.isEmpty()) {

			return false;
		}
		int somaItensOferecidos = contaPontos(itensOferecido);
		int somaItensRecebidos = contaPontos(itensRecebidos);

		return (somaItensOferecidos == somaItensRecebidos);
	}

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

	private static int contaPontos(List<DtoTroca> itens) {
		int contPontos = 0;
		for (DtoTroca dtoTroca : itens) {
			contPontos += dtoTroca.getRecurso().getPontos() * dtoTroca.getQtde();
		}

		return contPontos;
	}
}

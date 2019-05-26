package br.com.phoebus.star.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.star.entidades.Rebelde;
import br.com.phoebus.star.repositorios.IRebeldeRepositorio;

@RestController
@RequestMapping("rebelde")
public class RebeldeWS {
	
	private IRebeldeRepositorio repositorioRebelde;
	
	@Autowired
	public RebeldeWS(IRebeldeRepositorio repositorioRebelde) {
		this.repositorioRebelde = repositorioRebelde;
	}
	
	@PostMapping(value = "cadastrarRebelde")
	public Rebelde salveRebelde(Rebelde rebelde) {
		return repositorioRebelde.save(rebelde);
	}
	
//	public void deleteRebelde(Rebelde rebelde) {
//		repositorioRebelde.delete(rebelde);
//	}
	
	@GetMapping(value = "rebeldes")
	public List<Rebelde> listarRebeldes(){
		return repositorioRebelde.findAll();
	}

}

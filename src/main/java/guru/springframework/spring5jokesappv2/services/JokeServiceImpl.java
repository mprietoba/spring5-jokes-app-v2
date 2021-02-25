package guru.springframework.spring5jokesappv2.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import guru.springframework.spring5jokesappv2.model.Joke;

@Service
public class JokeServiceImpl implements JokeService {

	private final ChuckNorrisQuotes quotesService;

	public JokeServiceImpl() {
		super();
		this.quotesService = new ChuckNorrisQuotes();
	}

	@Override
	public Joke getChuckNorrisJoke() {
		Joke model = new Joke();
		model.setJoke(this.quotesService.getRandomQuote());
		return model;
	}

}

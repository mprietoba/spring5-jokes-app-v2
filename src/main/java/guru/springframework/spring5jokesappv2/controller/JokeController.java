package guru.springframework.spring5jokesappv2.controller;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.spring5jokesappv2.services.JokeService;

@Controller
public class JokeController {

	private final Logger LOGGER = Logger.getLogger(JokeController.class.toString());

	private JokeService jokeService;

	public JokeController(@Qualifier("jokeServiceImpl") JokeService jokeService) {
		super();
		this.jokeService = jokeService;
	}

	@RequestMapping(path = "/",
					method = RequestMethod.GET)
	public String getChuckNorrisJoke(Model model) {
		model.addAttribute("joke", jokeService.getChuckNorrisJoke());
		LOGGER.log(Level.INFO, MessageFormat.format("Recover joke: {0}", model.getAttribute("joke")));
		return "index";

	}
}

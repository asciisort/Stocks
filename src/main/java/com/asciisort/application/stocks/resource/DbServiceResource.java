package com.asciisort.application.stocks.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asciisort.application.stocks.entity.Quote;
import com.asciisort.application.stocks.entity.Quotes;
import com.asciisort.application.stocks.repository.QuotesRepository;

/*
 * @author Sangwan K.
 */

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private QuotesRepository quotesRepository;

	public DbServiceResource(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		return getQuotesByUserName(username);
	}

	private List<String> getQuotesByUserName(@PathVariable("username") String username) {
		return quotesRepository.findByUserName(username)
				.stream()
				.map(Quote::getQuote)
				.collect(Collectors.toList());
	}

	@PostMapping("/add")
	public List<String> add (@RequestBody final Quotes quotes) {

		quotes.getQuotes().stream()
		.map(quote -> new Quote(quotes.getUserName(), quote))
		.forEach(quote -> quotesRepository.save(quote));

		return getQuotesByUserName(quotes.getUserName());
	}

	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username) {

		quotesRepository.findByUserName(username)
		.stream()
		.map(Quote::getId)
		.collect(Collectors.toList())
		.forEach(s -> quotesRepository.deleteById(s));

		return getQuotesByUserName(username);
	}
}

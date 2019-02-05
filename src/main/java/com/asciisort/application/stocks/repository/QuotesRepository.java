package com.asciisort.application.stocks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asciisort.application.stocks.entity.Quote;

/*
 * @author Sangwan K.
 */

public interface QuotesRepository extends JpaRepository<Quote, Integer>{

	List<Quote> findByUserName(String username);

}

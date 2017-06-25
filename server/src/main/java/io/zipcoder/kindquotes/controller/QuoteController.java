package io.zipcoder.kindquotes.controller;

import io.zipcoder.kindquotes.data.QuoteRepository;
import io.zipcoder.kindquotes.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RequestMapping("/")
@RestController
@CrossOrigin("http://localhost:8100")
public class QuoteController {

    public static final Logger logger = LoggerFactory.getLogger(QuoteController.class);

    @Autowired
    QuoteRepository quoteRepository; //Service which will do all data retrieval/manipulation work

    //GET method - reads
    @RequestMapping(value = "/quote/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuote(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        Quote quote = quoteRepository.findOne(id);
        if (quote == null) {
            logger.error("Quote with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Quote with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }
    // GET all, without specifying ID
    @RequestMapping(value = "/quote/", method = RequestMethod.GET)
    public ResponseEntity<?> getQuote() {
        logger.info("Fetching all quotes");
        List<Quote> quoteList  = (List<Quote>) quoteRepository.findAll();
        // this return an iterable  which is a super interface for list, so we can safely cast to a list
        return new ResponseEntity<>(quoteList, HttpStatus.OK);
    }

    // POST create an input
    @RequestMapping(value = "/quote/", method = RequestMethod.POST)
    public ResponseEntity<?> createQuote(@RequestBody Quote quote) {
        logger.info("Creating quote : {}", quote);
        quoteRepository.save(quote);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    // DELETE an input
    @RequestMapping(value = "/quote/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuote(@PathVariable("id") long id) {
        logger.info("Deleting User with id {}", id);
        quoteRepository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT updates an input
    @RequestMapping(value = "/quote/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuote(@RequestBody Quote quote) {
        logger.info("Updating quote : {}", quote);
        quoteRepository.save(quote);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }
}
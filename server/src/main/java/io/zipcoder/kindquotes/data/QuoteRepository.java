package io.zipcoder.kindquotes.data;

import io.zipcoder.kindquotes.model.Quote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vidyachandasekhar on 6/25/17.
 */
public interface  QuoteRepository  extends CrudRepository<Quote, Long> {
}

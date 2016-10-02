package pe.edu.utp.quotesexpress.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.utp.quotesexpress.R;

/**
 * Created by GrupoUTP on 17/09/2016.
 */
public class QuotesService {

    private List<Quote> quotes;

    public List<Quote> getQuotes() {
        if(quotes == null) {
            quotes = new ArrayList<>();
            initializeData();
        }
        return quotes;
    }

    public Quote findQuoteById(int id){
        return quotes.get(id);
    }

    private void initializeData() {
        quotes.add(new Quote("Phrase 1", "Author 1",
                Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Phrase 2", "Author 2",
                Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Phrase 3", "Author 3",
                Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Phrase 4", "Author 4",
                Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Phrase 5", "Author 5",
                Integer.toString(R.mipmap.ic_default)));
    }

}

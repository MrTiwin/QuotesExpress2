package pe.edu.utp.quotesexpress.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.utp.quotesexpress.QuotesApplication;
import pe.edu.utp.quotesexpress.R;
import pe.edu.utp.quotesexpress.models.Quote;

public class QuoteActivity extends AppCompatActivity {
    ImageView pictureImageView;
    TextView phraseTextView, authorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        phraseTextView = (TextView) findViewById(R.id.phraseTextView);
        authorTextView = (TextView) findViewById(R.id.authorTextView);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        Quote quote = getQuoteById(id);

        phraseTextView.setText(quote.getPhrase());
        authorTextView.setText(quote.getAuthor());
        pictureImageView.setImageResource(Integer.parseInt(quote.getPictureUri()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private Quote getQuoteById(int id){
        return ((QuotesApplication) getApplication())
                .getService()
                .findQuoteById(id);
    }
}

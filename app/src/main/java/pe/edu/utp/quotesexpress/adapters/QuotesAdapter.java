package pe.edu.utp.quotesexpress.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.utp.quotesexpress.R;
import pe.edu.utp.quotesexpress.activities.QuoteActivity;
import pe.edu.utp.quotesexpress.models.Quote;

/**
 * Created by GrupoUTP on 17/09/2016.
 */
public class QuotesAdapter
        extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {
    private List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_quote, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            QuotesAdapter.ViewHolder holder, final int position) {
        holder.phraseTextView.setText(
                quotes.get(position).getPhrase());
        holder.authorTextView.setText(
                quotes.get(position).getAuthor());
        holder.pictureImageView.setImageResource(
                Integer.parseInt(
                        quotes.get(position).getPictureUri()));
        holder.quoteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", position);
                //bundle.putString("phrase", quotes.get(position).getPhrase());
                //bundle.putString("author", quotes.get(position).getAuthor());
                //bundle.putString("pictureUri", quotes.get(position).getPictureUri());
                Intent itemIntent = new Intent(v.getContext(), QuoteActivity.class);
                itemIntent.putExtras(bundle);
                v.getContext().startActivity(itemIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView quoteCardView;
        TextView phraseTextView;
        TextView authorTextView;
        ImageView pictureImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteCardView = (CardView) itemView.findViewById(R.id.quoteCardView);
            phraseTextView = (TextView) itemView.findViewById(R.id.phraseTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.authorTextView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
        }
    }
}

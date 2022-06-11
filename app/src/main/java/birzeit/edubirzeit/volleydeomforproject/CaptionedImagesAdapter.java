package birzeit.edubirzeit.volleydeomforproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import birzeit.edubirzeit.volleydeomforproject.models.Category;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private Context context;
    private List<Category> items;


    public CaptionedImagesAdapter(Context context, List<Category> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Category category = items.get(position);
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Glide.with(context).load(category.getCatImage()).into(imageView);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(category.getCatName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
                Toast.makeText(cardView.getContext(), "Helloooo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}


package widyanto.fauzan.pesenanku;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M Nur Fauzan W on 21-Aug-18.
 */

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.MakananHolder> {

    private List<ModelMakanan> mMakanan;
    public ClickListerner clickListerner;

    public AdapterMakanan(List<ModelMakanan> datas){ mMakanan = datas; }

    public  AdapterMakanan(List<ModelMakanan> datas, ClickListerner click){
        mMakanan = datas;
        clickListerner = click;
    }

    @Override
    public MakananHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_makanan, parent, false);
        return new MakananHolder(view);
    }

    @Override
    public void onBindViewHolder(MakananHolder holder, int position) {
        holder.bind(mMakanan.get(position), clickListerner);
    }

    @Override
    public int getItemCount() {
        return mMakanan.size();
    }

    public class MakananHolder extends RecyclerView.ViewHolder{
        private ImageView gambarMakanan;
        private CardView cardView;
        private TextView namaMakanan, hargaMakanan;

        public MakananHolder (View dataView) { super(dataView);}

        public void bind( final ModelMakanan modelMakanan, final ClickListerner clickListerner){
            cardView = itemView.findViewById(R.id.cardView);
            gambarMakanan = itemView.findViewById(R.id.imageView);
            namaMakanan = itemView.findViewById(R.id.textNama);
            hargaMakanan = itemView.findViewById(R.id.textHarga);

            gambarMakanan.setImageResource(modelMakanan.getGambarMakanan());
            namaMakanan.setText(modelMakanan.getNamaMakanan());
            hargaMakanan.setText(modelMakanan.getHargaMakanan());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListerner != null){
                        clickListerner.onClick(modelMakanan, v);
                    }
                }
            });
        }
    }
    interface ClickListerner {
        public void onClick(ModelMakanan modelMakanan, View view);
    }
}

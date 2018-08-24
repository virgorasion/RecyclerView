package widyanto.fauzan.pesenanku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMakanan adapterMakanan;
    private List<ModelMakanan> listMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        listMakanan = new ArrayList<>();

        DataList();

        adapterMakanan = new AdapterMakanan(listMakanan, new AdapterMakanan.ClickListerner() {
            @Override
            public void onClick(ModelMakanan modelMakanan) {
                Intent i = new Intent(MainActivity.this,DataPesananActivity.class);
                i.putExtra("gambarMakanan", modelMakanan.getGambarMakanan());
                i.putExtra("namaMakanan", modelMakanan.getNamaMakanan());
                i.putExtra("hargaMakanan", modelMakanan.getHargaMakanan());
                i.putExtra("deskripsi", modelMakanan.getDeskripsi());
                startActivityForResult(i,1);
            }
        });

        GridLayoutManager glm = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapterMakanan);
    }

    public void DataList(){

        listMakanan.add(new ModelMakanan(R.drawable.bakso,"Bakso Malang", "Rp 10.000", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse imperdiet luctus congue. Nulla facilisi. Duis pellentesque interdum nisl scelerisque placerat. Nunc sit amet dui at felis consectetur cursus quis tincidunt purus. Suspendisse potenti. Nam a pellentesque mauris, laoreet hendrerit magna. Aliquam at interdum orci. Nam eget neque magna. Morbi iaculis diam sit amet tellus volutpat vulputate. Pellentesque posuere mauris at augue pellentesque volutpat. Vivamus molestie tincidunt euismod. Donec tincidunt, tellus ac eleifend consectetur, purus massa sodales lorem, a interdum sem turpis sit amet orci. Fusce vitae lobortis enim."));
        listMakanan.add(new ModelMakanan(R.drawable.soto_ayam,"Soto Jumbo", "Rp 15.000", "Soto yang enak di tambah porsinya yang jumbo membuat anda menjadi lebih sehat seperti sediakala."));
        listMakanan.add(new ModelMakanan(R.drawable.pisang_keju,"Pisang keju", "Rp 5.000", "Pisang Keju yang spesial dengan parutan paku dan pines membuat makanan anda terasa lebih nikmat untuk di buang"));
        listMakanan.add(new ModelMakanan(R.drawable.pizza,"Pizza", "Rp 70.000", "Pizza ala Italia yang sangat terkenal dibumbui dengan kuku kaki serta saus santan yang sangat lezat."));
        listMakanan.add(new ModelMakanan(R.drawable.burger,"Hamburger", "Rp 20.000", "Hamburger Yang Enak :)"));
        listMakanan.add(new ModelMakanan(R.drawable.sup_buah,"Sop Buah", "Rp 10.000", "Sop Buah Segar sesegar melihat BLAKPINK"));
        listMakanan.add(new ModelMakanan(R.drawable.es_campur,"Es Campur", "Rp 12.000", "Es Campur yang kaya akan campuran dan perbedaan yang menjadi satu seperti semboyan negara ini"));
        listMakanan.add(new ModelMakanan(R.drawable.es_batu,"Es Batu", "Rp 500", "Es batu yang spesial, jika diletakkan di luar ruangan mereka dapat berubah menjadi air"));
        listMakanan.add(new ModelMakanan(R.drawable.es_teh,"Es Teh", "Rp 4.000","Es Teh hangat dengan gula pasir, jika kurang manis diperbolehkan melihat saya"));
        listMakanan.add(new ModelMakanan(R.drawable.kentang,"Kentang Goreng", "Rp 20.000", "Kentang Goreng AJA."));
        listMakanan.add(new ModelMakanan(R.drawable.lasagna,"Lasagna", "Rp 50.000","Lasagna adalah makanan kecil yang terlihat enak untuk di pandang, karena harga yang mahal membuat terasa sayang untuk dimakan."));
        listMakanan.add(new ModelMakanan(R.drawable.sate_kadal,"Sate Kadal", "Rp 20.000", "Sate Kadal adalah makanan yang tepat saat berada di pedalaman, karena mengingat keterbatasan makanan yang ada di pedalaman menjadika makanan ini menjadi makanan terfavorit."));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            if (data != null){
                Toast.makeText(MainActivity.this, data.getStringExtra("dataPesanan"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

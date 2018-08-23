package widyanto.fauzan.pesenanku;

import android.support.v7.widget.CardView;

/**
 * Created by M Nur Fauzan W on 21-Aug-18.
 */

public class ModelMakanan {
    private int gambarMakanan;
    private String namaMakanan;
    private String hargaMakanan;
    private String deskripsi;

    public ModelMakanan(int gambarMakanan, String namaMakanan, String hargaMakanan, String deskripsi) {
        this.gambarMakanan = gambarMakanan;
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.deskripsi = deskripsi;
    }

    public int getGambarMakanan() {
        return gambarMakanan;
    }

    public void setGambarMakanan(int gambarMakanan) {
        this.gambarMakanan = gambarMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public void setHargaMakanan(String hargaMakanan) {
        this.hargaMakanan = hargaMakanan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

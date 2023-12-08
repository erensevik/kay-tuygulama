public class ogrenci {
    import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class Ogrenci {
        private int ogrenciNo;
        private String ogrenciAd;
        private String ogrenciSoyad;
        private String ogrenciBolum;
        private List<Ders> ogrenciDersler;

        public Ogrenci(int ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum, List<Ders> ogrenciDersler) {
            this.ogrenciNo = ogrenciNo;
            this.ogrenciAd = ogrenciAd;
            this.ogrenciSoyad = ogrenciSoyad;
            this.ogrenciBolum = ogrenciBolum;
            this.ogrenciDersler = ogrenciDersler;
        }

        // Getter ve Setter metotları buraya eklenebilir

        // Diğer gerekli metotlar da buraya eklenebilir

        @Override
        public String toString() {
            return "Ogrenci [ogrenciNo=" + ogrenciNo + ", ogrenciAd=" + ogrenciAd + ", ogrenciSoyad=" + ogrenciSoyad
                    + ", ogrenciBolum=" + ogrenciBolum + ", ogrenciDersler=" + ogrenciDersler + "]";
        }

        // JSON formatında dosyaya yazma
        public static void kaydetJson(List<Ogrenci> ogrenciListesi, String dosyaAdi) {
            try (FileWriter fileWriter = new FileWriter(dosyaAdi)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(ogrenciListesi, fileWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // JSON formatındaki dosyadan okuma
        public static List<Ogrenci> yukleJson(String dosyaAdi) {
            List<Ogrenci> ogrenciListesi = new ArrayList<>();
            try (FileReader fileReader = new FileReader(dosyaAdi)) {
                Gson gson = new Gson();
                Ogrenci[] ogrenciler = gson.fromJson(fileReader, Ogrenci[].class);
                if (ogrenciler != null) {
                    for (Ogrenci ogrenci : ogrenciler) {
                        ogrenciListesi.add(ogrenci);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ogrenciListesi;
        }
    }


}

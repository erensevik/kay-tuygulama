
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("ogrenci kayit!");


           import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

        public class Main {

            public static void main(String[] args) {
                // Ders verilerini oluştur
                List<Ders> dersListesi = new ArrayList<>();
                dersListesi.add(new Ders("101", "Matematik", 1));
                dersListesi.add(new Ders("102", "Fizik", 1));
                dersListesi.add(new Ders("201", "Kimya", 2));

                // Ders verilerini JSON dosyasına kaydet
                Ders.kaydetJson(dersListesi, "dersler.json");

                // Ders verilerini JSON dosyasından yükle
                List<Ders> yuklenenDersListesi = Ders.yukleJson("dersler.json");

                // Yüklenen verileri ekrana yazdır
                for (Ders ders : yuklenenDersListesi) {
                    System.out.println(ders);
                }
            }
        }

        class Ders {
            private String dersKodu;
            private String dersAd;
            private int dersDonem;

            public Ders(String dersKodu, String dersAd, int dersDonem) {
                this.dersKodu = dersKodu;
                this.dersAd = dersAd;
                this.dersDonem = dersDonem;
            }

            @Override
            public String toString() {
                return "Ders [dersKodu=" + dersKodu + ", dersAd=" + dersAd + ", dersDonem=" + dersDonem + "]";
            }

            // JSON formatında dosyaya yazma
            public static void kaydetJson(List<Ders> dersListesi, String dosyaAdi) {
                try (FileWriter fileWriter = new FileWriter(dosyaAdi)) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    gson.toJson(dersListesi, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // JSON formatındaki dosyadan okuma
            public static List<Ders> yukleJson(String dosyaAdi) {
                List<Ders> dersListesi = new ArrayList<>();
                try (FileReader fileReader = new FileReader(dosyaAdi)) {
                    Gson gson = new Gson();
                    Ders[] dersler = gson.fromJson(fileReader, Ders[].class);
                    if (dersler != null) {
                        for (Ders ders : dersler) {
                            dersListesi.add(ders);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return dersListesi;
            }
        }


        }
    }
}
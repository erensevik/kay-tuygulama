public class projemenuform {
    import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class Ders {
        private String dersKodu;
        private String dersAd;
        private int dersDonem;

        // Getter ve Setter metotları buraya eklenebilir

        // Diğer gerekli metotlar da buraya eklenebilir

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

// Öğrenci sınıfı için de benzer işlemleri gerçekleştirebilirsiniz.

}

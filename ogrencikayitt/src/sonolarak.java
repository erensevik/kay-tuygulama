public class sonolarak {
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

            // Ogrenci verilerini oluştur
            List<Ogrenci> ogrenciListesi = new ArrayList<>();
            ogrenciListesi.add(new Ogrenci(1, "Eren", "Sevik", "Bilgisayar Mühendisliği", dersListesi));
            ogrenciListesi.add(new Ogrenci(2, "Elif", "Sevik", "Elektrik Mühendisliği", dersListesi));

            // Ogrenci verilerini JSON dosyasına kaydet
            Ogrenci.kaydetJson(ogrenciListesi, "ogrenciler.json");

            // Ogrenci verilerini JSON dosyasından yükle
            List<Ogrenci> yuklenenOgrenciListesi = Ogrenci.yukleJson("ogrenciler.json");

            // Yüklenen verileri ekrana yazdır
            for (Ogrenci ogrenci : yuklenenOgrenciListesi) {
                System.out.println(ogrenci);
            }
        }
    }

}

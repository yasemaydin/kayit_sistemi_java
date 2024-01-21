
# Ders Kayıt Sistemi

Bu ders kayıt uygulaması, öğrenci bilgilerini, Öğretim Görevlilerini, Dersleri kaydetmek ve görüntülemek için kullanılan bir Java Swing uygulamasını içerir.

## Özellikler

- Öğrenci, Ders, Ogretim Görevlileri ve alt bilgilerini kaydetme
- Kaydedilen bilgileri görüntüleme
- Kaydedilen bilgileri filtreleme
- Verilen JSON dosyasından okunması ve kaydedilmesi

## Gereksinimler

- Java SE Development Kit (JDK) 8 veya üstü
- JSON Simple kütüphanesi

## Kullanım

1. Uygulama başladığında, istediğiniz formu açın sol paneli kullanarak bilgileri girin.
2. "Kaydet" butonuna tıklayarak bilgileri saklayın.
3. Sağ üst köşedeki filtre alanını kullanarak öğrenci bilgilerini filtreleyin.
4. Tablodaki bilgileri görüntülemek için filtreleme yapın veya tüm bilgileri görüntüleyin.

## Ogrenci Sınıfı

Bu uygulamada kullanılan `Ogrenci` sınıfı, öğrenci bilgilerini temsil etmek için kullanılır. Sınıf aşağıdaki özelliklere sahiptir:

### Özellikler

- `ogrenciNo` (int): Öğrenci numarasını temsil eder.
- `ogrenciAd` (String): Öğrenci adını temsil eder.
- `ogrenciSoyad` (String): Öğrenci soyadını temsil eder.
- `ogrenciBolum` (String): Öğrenci bölümünü temsil eder.
- `ogrenciDersler` (String): Öğrencinin aldığı dersleri temsil eder.
- `ogrenciDersKodu` (String): Öğrencinin aldığı derslerin kodlarını temsil eder.

### Metodlar

- `getTamAd(): String`: Öğrencinin tam adını döndürür.
- `getOgrenciBilgisi(): String`: Öğrencinin tüm bilgilerini bir metin olarak döndürür.

### Kullanım


// Örnek kullanım
Ogrenci ogrenci = new Ogrenci(123456789, "Ahmet", "Yılmaz", "Bilgisayar Mühendisliği", "Calculus", "101");

// Yeni metodları kullanma
System.out.println("Tam Ad: " + ogrenci.getTamAd());
System.out.println("Öğrenci Bilgisi:\n" + ogrenci.getOgrenciBilgisi());

## Ders Sınıfı
- `dersKodu` (int): Dersin kodunu temsil eder.
- `dersAd` (String): Dersin adını temsil eder.
- `dersDonem` (int): Dersin hangi dönemde olduğunu temsil eder.
- `ogretimGorevlisi` (String): Dersin öğretim görevlisini temsil eder.
### Kullanım
```java
// Ders sınıfının örnek kullanımı
Ders ders = new Ders(101, "Matematik", 2, "Prof. Ahmet Yılmaz");

// Ders sınıfının özelliklerine erişim
System.out.println("Ders Kodu: " + ders.getDersKodu());
System.out.println("Ders Adı: " + ders.getDersAd());
System.out.println("Dönem: " + ders.getDersDonem());
System.out.println("Öğretim Görevlisi: " + ders.getOgretimGorevlisi());
 ```

# Metodlar

`validasyonKontrol(): boolean`
Bu metod, ders bilgilerinin geçerliliğini kontrol eder. Ders kodu ve dönem numarası sayısal olmalıdır.

`kaydetDers(): void`
Bu metod, kullanıcının girdiği ders bilgilerini JSON dosyasına kaydeder.

`okuOgretimGorevlileri(String dosyaAdi): List<String>`
Bu metod, öğretim görevlilerini içeren JSON dosyasını okur ve bir liste olarak döndürür.

`yazdirDers(JSONObject dersJson): void`
Bu metod, verilen ders bilgilerini JSON dosyasına ekler.

`refreshDersTable(): void`
Bu metod, ders tablosunu günceller.

`okuDersler(String dosyaAdi): List<Ders>`
Bu metod, ders bilgilerini içeren JSON dosyasını okur ve bir liste olarak döndürür.

`filterDersTable(): void`
Bu metod, ders tablosunu filtreler.

## OgretimGorevlisiFormu

### Metodlar

#### `validasyonKontrol(): boolean`

Bu metod, öğretmen numarasının geçerliliğini kontrol eder. Öğretmen numarası pozitif bir tamsayı olmalıdır.

#### `createStyledButton(String buttonText): JButton`

Bu metod, özel bir stile sahip bir JButton nesnesi oluşturur.

#### `kaydetOgretimGorevlisi(): void`

Bu metod, kullanıcının girdiği öğretim görevlisi bilgilerini JSON dosyasına kaydeder.

#### `refreshOgretimGorevlisiTable(): void`

Bu metod, öğretim görevlisi tablosunu günceller.

#### `okuOgretimGorevlileri(String dosyaAdi): List<JSONObject>`

Bu metod, öğretim görevlilerini içeren JSON dosyasını okur ve bir liste olarak döndürür.

#### `filterOgretimGorevlisiTable(): void`

Bu metod, öğretim görevlisi tablosunu filtreler.





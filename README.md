# Java OpenPDF Resume Generator

Bu proje, **Java** programlama dili ve **OpenPDF** kütüphanesi kullanılarak programatik olarak A4 formatında profesyonel bir özgeçmiş (CV) PDF'i üreten konsol tabanlı bir uygulamadır.

## 🚀 Proje Hakkında
Yazılım mühendisliği prensipleri ve nesne yönelimli programlama (OOP) ilkeleri gözetilerek geliştirilmiştir. Kod tek bir merkezde toplanmamış; PDF üretim mantığı `ResumeGenerator` sınıfında soyutlanırken, çalıştırma işlemi `Main` sınıfı üzerinden gerçekleştirilmiştir.

### Özellikler
* **OpenPDF Kütüphanesi:** Harici bir araç bağımlılığı olmadan saf Java ile PDF üretimi.
* **Modern Tablo Mimarisi (`PdfPTable`):** Profil fotoğrafının sol sütunda tam kare ve büyütülmüş olarak yer aldığı, kişisel bilgilerin ise sağ sütunda dikey ortalandığı şık bir header tasarımı.
* **Türkçe Karakter Desteği:** Standart fontların desteklemediği Türkçe karakter sorununu aşmak için sistem fontu (`arial.ttf`) gömülü (`EMBEDDED`) ve kodlanmış (`IDENTITY_H`) olarak entegre edilmiştir.
* **Hayali Deneyimler:** Yönergeye uygun olarak 3 adet profesyonel yazılım/siber güvenlik deneyimi içermektedir.

---

## 🛠️ Kullanılan Teknolojiler ve Araçlar
* **Dil:** Java (JDK 17+)
* **Build Sistemi:** Maven
* **PDF Kütüphanesi:** OpenPDF (v1.3.38)
* **IDE:** IntelliJ IDEA

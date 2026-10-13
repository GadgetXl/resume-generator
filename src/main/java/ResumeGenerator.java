import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResumeGenerator {

    private final String outputPath;
    private final String photoPath;

    public ResumeGenerator(String outputPath, String photoPath) {
        this.outputPath = outputPath;
        this.photoPath = photoPath;
    }

    public void createResume() {
        // A4 boyutunda belge oluşturuluyor (kenar boşlukları ayarlanmış)
        Document document = new Document(PageSize.A4, 36, 36, 54, 54);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Font tanımlamaları
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font titleFont = new Font(baseFont, 20, Font.BOLD);
            Font subtitleFont = new Font(baseFont, 12, Font.ITALIC);
            Font headingFont = new Font(baseFont, 12, Font.BOLD);
            Font bodyFont = new Font(baseFont, 10, Font.NORMAL);
            Font boldBodyFont = new Font(baseFont, 10, Font.BOLD);

            // --- HEADER (FOTOĞRAF SOLDA + BİLGİLER SAĞDA TABLO YAPISI) ---
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{2f, 5f}); // Sol sütun (fotoğraf) ve sağ sütun oranları

            // 1. Sol Hücre: Fotoğraf (Kare ve büyütülmüş)
            PdfPCell imageCell = new PdfPCell();
            imageCell.setBorder(Rectangle.NO_BORDER);
            try {
                Image profileImage = Image.getInstance(photoPath);
                profileImage.scaleAbsolute(95, 95); // Tam kare ve biraz daha büyük boyut
                imageCell.addElement(profileImage);
            } catch (IOException e) {
                System.out.println("Fotoğraf yüklenemedi, fotoğrafsız devam ediliyor: " + e.getMessage());
            }
            headerTable.addCell(imageCell);

            // 2. Sağ Hücre: Kişisel Bilgiler
            PdfPCell textCell = new PdfPCell();
            textCell.setBorder(Rectangle.NO_BORDER);
            textCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

            textCell.addElement(new Paragraph("Burak Çelik", titleFont));
            textCell.addElement(new Paragraph("Yazılım Mühendisliği Öğrencisi & Backend Geliştirici", subtitleFont));
            textCell.addElement(new Paragraph("E-posta: burakcelik@example.com | GitHub: github.com/GadgetXl | Telefon: +90 555 000 0000", bodyFont));

            headerTable.addCell(textCell);

            document.add(headerTable);
            document.add(Chunk.NEWLINE);

            // Çizgi Ayırıcı
            document.add(new LineSeparator());
            document.add(Chunk.NEWLINE);

            // İş Deneyimleri Başlığı
            document.add(new Paragraph("İŞ DENEYİMLERİ", headingFont));
            document.add(Chunk.NEWLINE);

            // Deneyim 1
            document.add(new Paragraph("1. Junior Backend Developer - TechNova Solutions", boldBodyFont));
            document.add(new Paragraph("Haziran 2025 - Eylül 2025", subtitleFont));
            document.add(new Paragraph("• Python tabanlı soket sunucusu arka uç geliştirmeleri yapıldı.\n• SQLite veri tabanı entegrasyonu ve veri kalıcılığı sağlandı.\n• Performans optimizasyonları ve hata ayıklama süreçleri yürütüldü.", bodyFont));
            document.add(Chunk.NEWLINE);

            // Deneyim 2
            document.add(new Paragraph("2. Cybersecurity Stajyeri - CyberShield Labs", boldBodyFont));
            document.add(new Paragraph("Ocak 2025 - Mayıs 2025", subtitleFont));
            document.add(new Paragraph("• Web uygulaması güvenlik testleri ve zafiyet analizi gerçekleştirildi.\n• Burp Suite ve Nmap araçları kullanılarak güvenlik denetimleri yapıldı.\n• Ağ trafiği analiz raporları hazırlandı.", bodyFont));
            document.add(Chunk.NEWLINE);

            // Deneyim 3
            document.add(new Paragraph("3. Proje Katkı Sağlayıcısı - OpenCode AI", boldBodyFont));
            document.add(new Paragraph("Eylül 2024 - Aralık 2024", subtitleFont));
            document.add(new Paragraph("• Terminal tabanlı yapay zeka kodlama asistanı entegrasyonları geliştirildi.\n• Otomasyon betikleri yazılarak geliştirici iş akışları hızlandırıldı.\n• Yerel LLM uç noktaları Ollama ile yapılandırıldı.", bodyFont));

            System.out.println("PDF özgeçmiş başarıyla oluşturuldu: " + outputPath);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
}
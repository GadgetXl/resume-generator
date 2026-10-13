public class Main {
    public static void main(String[] args) {
        String destPdf = "resume.pdf";
        String photoPath = "image.jpg";

        ResumeGenerator generator = new ResumeGenerator(destPdf, photoPath);
        generator.createResume();
    }
}
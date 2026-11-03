package ro.uvt.info.splabmayagrozav.models;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("Paragraph: " + paragraph.getText());
    }
}

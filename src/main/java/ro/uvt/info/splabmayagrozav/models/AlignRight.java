package ro.uvt.info.splabmayagrozav.models;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("Pharagraph:                                " + paragraph.getText());
    }
}

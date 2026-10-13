import java.util.ArrayList;
import java.util.List;

public class GenerateToC implements Visitor {
    private List<String> entries = new ArrayList<>();
    private int page = 1;

    @Override
    public void visit(Book book) {
        page++;
    }

    @Override
    public void visit(Section section) {
        entries.add(section.getTitle() + " ................ " + page);
        page++;
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        page++;
    }

    @Override
    public void visit(Paragraph paragraph) {
        page++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        page++;
    }

    @Override
    public void visit(Image image) {
        page++;
    }

    @Override
    public void visit(Table table) {
        page++;
    }

    public TableOfContents getToC() {
        TableOfContents toc = new TableOfContents();
        for (String entry : entries) {
            toc.addEntry(entry);
        }
        return toc;
    }
}

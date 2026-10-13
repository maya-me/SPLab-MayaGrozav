public class BookStatistics implements Visitor {
    private int bookCount = 0;
    private int sectionCount = 0;
    private int tableOfContentsCount = 0;
    private int paragraphCount = 0;
    private int imageCount = 0;
    private int tableCount = 0;

    @Override
    public void visit(Book book) {
        bookCount++;
    }

    @Override
    public void visit(Section section) {
        sectionCount++;
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        tableOfContentsCount++;
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraphCount++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageCount++;
    }

    @Override
    public void visit(Image image) {
        imageCount++;
    }

    @Override
    public void visit(Table table) {
        tableCount++;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + imageCount);
        System.out.println("*** Number of tables: " + tableCount);
        System.out.println("*** Number of paragraphs: " + paragraphCount);
    }
}

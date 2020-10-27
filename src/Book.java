import java.util.ArrayList;
import java.util.Vector;

public class Book {
    private String title;

    private ArrayList<Author> authors = new ArrayList<>();
    private Vector<Element> elements = new Vector<Element>();

    Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public Vector<Element> getElements() {
        return elements;
    }

    public void setElements(Vector<Element> elements) {
        this.elements = elements;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void print(){
        System.out.println("Book name: " + this.title);
        printAuthors();
        for(Element i:elements) {
            i.print();
        }
    }

    private void printAuthors(){
        for(Author i: authors)
        {
            i.print();
        }
    }


}

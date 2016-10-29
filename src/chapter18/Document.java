package wang;

/**
 * Created by wangqi on 16/10/28.
 */
public class Document {
    public Document setTitle() {
        System.out.println("hehehe");
        return this;
    }

    public Document setAuthor() {
        System.out.println("hehehe");
        return this;
    }

    public static void main(String[] args) {
        Book b = new Book();
        ((Book)(b.setTitle())).addChapter();
    }
}

class Book extends Document {
    public Book addChapter() {
        System.out.println("heiheihei");
        return this;
    }
}

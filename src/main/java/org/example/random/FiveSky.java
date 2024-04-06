package org.example.random;

import java.awt.print.Book;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FiveSky {
    public static void main(String[] arg) {
        Books b1 = new Books("s1", "t1","a1","l1");
        Books b2 = new Books("s2", "t1","a1","l2");
        Books b8 = new Books("s5", "t1","a2","l5");
        Books b3 = new Books("s3", "t2","a2","l3");
        Books b4 = new Books("s4", "t3","a3","l4");
        Books b5 = new Books("s1", "t1","a1","l1");
        Books b6 = new Books("s2", "t1","a1","l2");
        Books b7 = new Books("s3", "t2","a2","l3");
        Books b9 = new Books("s4", "t5","a2","l4");
        List<Books> aBooks = new ArrayList<>();
        List<Books> bBooks = new ArrayList<>();
        aBooks.add(b1);
        aBooks.add(b2);
        aBooks.add(b3);
        aBooks.add(b4);
        aBooks.add(b8);
        bBooks.add(b6);
        bBooks.add(b7);
        bBooks.add(b5);
        Library a = new Library("LIB_A", aBooks);
        Library b = new Library("LIB_B", bBooks);

        LibUtils u = new LibUtils();
        System.out.println(u.getBooksDiff(a,b));
    }
}

class Books {
    private String stampId;
    private String title;
    private String author;
    private String loc;

    public Books(String stampId, String title, String author, String loc) {
        this.stampId = stampId;
        this.title = title;
        this.author = author;
        this.loc = loc;
    }

    public String getStampId() {
        return stampId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLoc() {
        return loc;
    }

    public void setStampId(String stampId) {
        this.stampId = stampId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Books b = (Books) obj;
        return this.getTitle().equals(b.getTitle()) && this.getAuthor().equals(b.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor());
    }

    @Override
    public String toString() {
        return "Books{" +
                "stampId='" + stampId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

class Library{
    private String name;
    private List<Books> list;

    public Library(String name, List<Books> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<Books> getList() {
        return list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList(List<Books> list) {
        this.list = list;
    }
}

class LibUtils {
    public static List<String> getBooksDiff(Library a, Library b) {
        List<String> res = new ArrayList<>();
        Map<Books, Long> mapA = new HashMap<>();
        Map<Books, Long> mapB = new HashMap<>();
//        for(Books book: a.getList()) {
//            Integer val = mapA.putIfAbsent(book,11);
//            if(val != null) {
//                mapA.put(book, val + 1);
//            }
//        }
        mapA = a.getList().stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        mapB = b.getList().stream()
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(mapA);
        System.out.println(mapB);
        for(Books book: a.getList()) {
            if(!mapB.containsKey(book)) {
                res.add(book.getTitle()+" "+book.getAuthor());
            }
        }
        return res;
    }
}

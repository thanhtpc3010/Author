import Entity.Author;
import Entity.Book;
import Entity.Gender;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Author>  authors= new ArrayList<>();
        Author author = new Author("Alan","alan890@gmail.com", Gender.M);
        Author author1= new Author("Justin","Justin123@gmail.com",Gender.M);
        Author author2=new Author("Zoe","Zoe31@gmail.com",Gender.F);
        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        List<Book> books= new ArrayList<>();
        Book book1 =new Book("Walker",author,8000,0);
        Book book2 =new Book("Bieber",author1,7500,0);
        Book book3 =new Book("Moon",author2,900,0);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        books.stream()
                .sorted(Comparator.comparing(Book::getName).reversed())
                .forEach(System.out::println);
        //Info of book has max price
        Book maxbook =book1;
        for (Book book : books) {
            if (book.getPrice()>maxbook.getPrice()) {
                maxbook=book;
            }
        }
        System.out.println(maxbook.getName());
//Listing Book of author by name input via scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter author name to list their books:");
        String authorName = scanner.nextLine();

        List<Book> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
        if (!booksByAuthor.isEmpty()) {
            System.out.println("Books by " + authorName + ":");
            booksByAuthor.forEach(System.out::println);
        } else {
            System.out.println("No books found for the author: " + authorName);
        }
    }
}
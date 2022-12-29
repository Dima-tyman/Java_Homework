package Seminar6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Reader {

    private String firstName, secondName, lastName;
    private int ticketNumber;
    private String faculty;
    private Date birthday;
    private int phone;
    private Set<Book> books = new HashSet<>();

    Reader (String name, int ticketNumber, String faculty, String birthday, int phone) {
        this.firstName = name.split(" ")[1];
        this.secondName = name.split(" ")[0];
        this.lastName = name.split(" ")[2];
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthday = new Date(birthday);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.secondName + " " +
                this.firstName.charAt(0) + "." +
                this.lastName.charAt(0) + ".";
    }

    //по кол-ву книг (int)
    public void takeBook(int books) {
        String[] names = {"книгу", "книги", "книг"};
        System.out.printf("%s взял %d %s\n", this, books,
                books == 1 ? names[0] :
                        books < 5 ? names[1] : names[2]);
    }
    public void returnBook(int books) {
        String[] names = {"книгу", "книги", "книг"};
        System.out.printf("%s вернул %d %s\n", this, books,
                books == 1 ? names[0] :
                        books < 5 ? names[1] : names[2]);
    }

    //по названию книг (String)
    public void takeBook(String... books) {
        String[] names = {"книгу", "книги", "книг"};
        System.out.printf("%s взял %d %s: ", this, books.length,
                books.length == 1 ? names[0] :
                        books.length < 5 ? names[1] : names[2]);
        for (String book : books) {
            System.out.printf("%s" + " ", book);
        }
        System.out.println();
    }
    public void returnBook(String... books) {
        String[] names = {"книгу", "книги", "книг"};
        System.out.printf("%s вернул %d %s: ", this, books.length,
                books.length == 1 ? names[0] :
                        books.length < 5 ? names[1] : names[2]);
        for (String book : books) {
            System.out.printf("%s" + " ", book);
        }
        System.out.println();
    }

    //по конкретным книгам (Object)
    public void takeBook(Book... books) {
        String[] names = {"книгу", "книги", "книг"};
        System.out.printf("%s взял %d %s: ", this, books.length,
                books.length == 1 ? names[0] :
                        books.length < 5 ? names[1] : names[2]);
        for (Book book : books) {
            System.out.printf("%s" + " ", book);
            this.books.add(book);
        }
        System.out.println();
    }
    public void returnBook(Book... books) {
        List<Book> notFoundBooks = new ArrayList<>();
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (this.books.contains(book)) {
                this.books.remove(book);
                foundBooks.add(book);
            } else {
                notFoundBooks.add(book);
            }
        }
        if (!notFoundBooks.isEmpty()) {
            System.out.printf("%s попытался вернуть кгини, которых у него нет! Список книг: %s. ", this, notFoundBooks);
        }
        String[] names = {"книгу", "книги", "книг"};
        if (!foundBooks.isEmpty()) {
            System.out.printf("%s вернул %d %s: ", this, books.length,
                    books.length == 1 ? names[0] :
                            books.length < 5 ? names[1] : names[2]);
            System.out.print(foundBooks);
        }
        System.out.println();
    }

    public void viewTakenBooks(){
        System.out.printf("%s имеет следующие книги: %s\n",this, this.books);
    }
}

class Book {

    private String name;
    private String author;

    Book (String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString () {
        return "\"" + this.name + "\"";
    }
}

class Date{

    private int day, month, year;

    Date (String date) {
        this.day = Integer. parseInt(date.split("\\.")[0]);
        this.month = Integer. parseInt(date.split("\\.")[1]);
        this.year = Integer. parseInt(date.split("\\.")[2]);
    }

    public int getDay () {
        return this.day;
    }
    public void setDay (int day) {
        this.day = day;
    }

    public int getMonth () {
        return this.month;
    }
    public void setMonth (int month) {
        this.month = month;
    }

    public int getYear () {
        return this.year;
    }
    public void setYear (int year) {
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Reader people1 = new Reader("Петров Иван Сергеевич", 542, "Журналист", "15.03.2002", 486214);
        Reader people2 = new Reader("Сергеев Юлий Михайлович", 245, "Математика", "25.11.1996", 486214);
        Book travelBook1 = new Book("Андарктида.", "Роберт Д.");
        Book travelBook2 = new Book("Аляска.", "Стивен А.");
        Book romansBook1 = new Book("Ромео и Джульетта.", "Уильям Ш.");
        Book scienceBook1 = new Book("Совершенный алгоритм. I часть.", "Тим Р.");

        people2.takeBook(5);
        people1.takeBook("Приключение");

        people1.returnBook(4);
        people2.returnBook("Сказки", "Энциклопедия");
        System.out.println();
        people2.takeBook(travelBook1, romansBook1, scienceBook1);
        people2.viewTakenBooks();
        people2.returnBook(travelBook1);
        people2.viewTakenBooks();
        System.out.println();
        people1.takeBook(travelBook2, romansBook1);
        people1.returnBook(romansBook1);
        people1.viewTakenBooks();
        people1.returnBook(travelBook2, travelBook1, romansBook1);

    }
}
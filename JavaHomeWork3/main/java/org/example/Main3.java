package org.example;

import org.example.Task3.Books;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        Books book1 = new Books("Война и мир", "Толстой", 290.23, 1996, 13);
        Books book2 = new Books("Авокадо", "Тайландова", 200.99, 2020, 7);
        Books book3 = new Books("Масло", "Росси", 190.99, 1800, 1);
        Books book4 = new Books("Метафизика", "Аристотель", 54.99, -400, 100);
        Books book5 = new Books("Хлеб и зрелища", "Маркс", 45.99, 1850, 200);
        Books book6 = new Books("Айран", "Казахстан", 20.99, 2010, 23);
        Books book7 = new Books("Устрицы королевские высший свет", "Тай", 490.23, 2023, 100);
        Books book8 = new Books("Айран2", "Казакович", 20.99, 2017, 13);

        List<Books> booksList = new ArrayList<>();

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);
        booksList.add(book5);
        booksList.add(book6);
        booksList.add(book7);
        booksList.add(book8);
        System.out.println(booksList);

        StringBuilder sortedBooks = new StringBuilder();
        for (Books books : booksList) {
            if (isPrime(books.getPgNum()) && books.getAuthor().toLowerCase().contains("а")) {
                if (books.getYear() >= 2010 && books.getYear() <= 2023) {
                    sortedBooks.append(books.getName()).append("\n");
                }
            }
        }
        System.out.println(sortedBooks);
    }

    private static boolean isPrime(Integer num) {

        if (num == 1) {
            return true;
        }
        if ((num % 2 == 0 && num != 2) || (num % 3 == 0 && num != 3) || (num % 5 == 0 && num != 5)) {
            return false;
        }
        for (int i = 2; i < num * num; i++) {
            if (i != num) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;

    }


}

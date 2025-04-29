package com.esen.bookstore.shell;


import com.esen.bookstore.model.BookStore;
import com.esen.bookstore.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@ShellCommandGroup("Bookstore related commands")
@RequiredArgsConstructor
public class BookstoreHandler {
    private  final BookStoreService bookStoreService;


    @ShellMethod(value = "List all bookstores", key = "List bookstores")
    public String listsBookstores(){
        return bookStoreService.findAll().stream().map(bookstore -> {
            bookstore.setInventory(null);
            return bookstore;
        })
                .map(BookStore::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @ShellMethod(value = "Delete a book by ID", key = "delete bookstore")
    public void deleteBookstore(Long id)  {
        bookStoreService.delete(id);
    }



}

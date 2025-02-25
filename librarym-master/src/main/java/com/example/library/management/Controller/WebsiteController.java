package com.example.library.management.Controller;


import com.example.library.management.Model.Author;
import com.example.library.management.Model.Book;
import com.example.library.management.Model.Category;
import com.example.library.management.Service.AuthorService;
import com.example.library.management.Service.BookService;
import com.example.library.management.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/website")
public class WebsiteController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }

    @GetMapping("/books/all")
    public List<Book> getAllBooksWithoutPagination() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/category/{categoryId}")
    public List<Book> getBooksByCategory(@PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/book/{bookId}")
    public Book getBookDetails(@PathVariable Long bookId) {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}

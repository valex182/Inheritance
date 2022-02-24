package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book = new Book(111, "First Book", 300, "First Author");
    Product smartphone = new Smartphone(222, "iPhone", 90000, "Apple");
    Product product = new Product(333, "Milk", 60);

    @Test
    public void shouldSaveOneItem() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = { book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(222);
        Product[] expected = { book, product };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.repository.Repository;
import ru.netology.manager.ProductManager;

class ProductManagerTest {


    @Test
    void shouldSearchByAuthor() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "Евгений Онегин", 100, "Пушкин А.")};
        Product[] actual = manager.searchBy("Пушкин А.");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, "Война и мир", 100, "Толстой Л.")};
        Product[] actual = manager.searchBy("Война и мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, "Galaxy S21", 300, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(5, "Redmi 9", 300, "Xiaomi")};
        Product[] actual = manager.searchBy("Redmi 9");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneNameEmpty() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Redmi 10");
        assertArrayEquals(expected, actual);
        //assertEquals(0, actual.length);
    }

    @Test
    void shouldSearchByPhoneNameMany() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(new Smartphone(7, "Galaxy S20", 200, "Samsung"));
        Product[] expected = {new Smartphone(4, "Galaxy S21", 300, "Samsung"),
                new Smartphone(7, "Galaxy S20", 200, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }


}
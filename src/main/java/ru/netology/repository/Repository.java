package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class Repository {
    Product[] repository = {new Book(1, "Мастер и Маргарита", 200, "Булгаков М."),
            new Book(2, "Евгений Онегин", 100, "Пушкин А."),
            new Book(3, "Война и мир", 100, "Толстой Л."),
            new Smartphone(4, "Galaxy S21", 300, "Samsung"),
            new Smartphone(5, "Redmi 9", 300, "Xiaomi"),
            new Smartphone(6, "Iphone 12 mini", 50, "Apple")};

    public void save(Product item) {
        Product[] newRepository = new Product[repository.length + 1];
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        int lastIndex = newRepository.length - 1;
        newRepository[lastIndex] = item;
        repository = newRepository;
    }

    public Product[] getAll() {
        return repository;
    }

    public void removeById(int id) {
        boolean ifExists = false;
        for (Product item : repository) {
            if (item.getId() == id) {
                ifExists = true;
                break;
            }
        }
        if (ifExists) {
            Product[] newRepository = new Product[repository.length - 1];
            int index = 0;
            for (Product item : repository) {
                if (item.getId() != id) {
                    newRepository[index] = item;
                    index++;
                }
            }
            repository = newRepository;
        }
    }
}

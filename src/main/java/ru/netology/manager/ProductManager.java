package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

@AllArgsConstructor
@Data
public class ProductManager {
    private Repository repository;

    public void addProduct(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] newList = new Product[0];
        for (Product item : repository.getAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = item;//
                newList = tmp;
            }
        }
        return newList;

    }

    private boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }

        } else if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            if (phone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            if (phone.getName().equalsIgnoreCase(search)) {
                return true;
            }

        }
        return false;

    }

}
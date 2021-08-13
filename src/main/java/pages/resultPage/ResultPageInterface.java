package pages.resultPage;

import models.products.AbstractProduct;

import java.util.List;

public interface ResultPageInterface {
    void switchToSortType(String sortType);
    List<AbstractProduct> getProducts();
}

package khly.codelean.project2.service.product;

import khly.codelean.project2.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public Product findById(int theId);

    public void save(Product theProduct);

    public void deleteById(int theId);
}

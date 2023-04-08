package shop.mtcoding.product.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class ProductRepository {
    public int insert(Product product);

    public int updateById(Product product);
    
    public int deleteById(int id);

    public List<Product> findAll();

    public Product findById(int id);
}

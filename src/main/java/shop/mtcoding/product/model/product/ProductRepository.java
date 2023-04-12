package shop.mtcoding.product.model.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(int id);

    public int insert(Product product);

    public int delete(int id);

    public int updateById(@Param("id") int id, @Param("name") String name, @Param("price") int price,
            @Param("qty") int qty);

}

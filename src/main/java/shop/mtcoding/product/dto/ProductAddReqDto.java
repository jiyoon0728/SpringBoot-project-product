package shop.mtcoding.product.dto;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.product.model.product.Product;

@Getter
@Setter
public class ProductAddReqDto {
    private String name;
    private int price;
    private int qty;

    public Product toModel() {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQty(qty);
        return product;
    }
}

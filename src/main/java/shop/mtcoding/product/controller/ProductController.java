package shop.mtcoding.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.product.dto.ProductAddReqDto;
import shop.mtcoding.product.model.product.Product;
import shop.mtcoding.product.model.product.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({ "/", "/product" })
    public String findAll(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/addForm")
    public String addForm() {
        return "product/addForm";
    }

    @PostMapping("/product/add")
    public String add(ProductAddReqDto productAddReqDto) {

        int result = productRepository.insert(productAddReqDto.toModel());
        if (result != 1) {
            System.out.println("상품등록실패");
            return "redirect:/product/addForm";
        }
        return "redirect:/product";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {
        int result = productRepository.delete(id);
        if (result != 1) {
            System.out.println("삭제 실패");
        }
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product/updateForm";
    }

    @PostMapping("/product/{id}/update")
    public String update(@PathVariable int id, String name, int price, int qty) {
        int result = productRepository.updateById(id, name, price, qty);
        if (result != 1) {
            System.out.println("업데이트 실패");
            return "redirect:/product/" + id + "/updateForm";
        }
        return "redirect:/product/" + id;
    }
}

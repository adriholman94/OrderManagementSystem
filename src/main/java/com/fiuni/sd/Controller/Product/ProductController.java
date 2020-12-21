package com.fiuni.sd.Controller.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fiuni.sd.Service.Product.IProductService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private Setting setting;

    @Autowired
    private IProductService productService;

    @GetMapping(path = "/{id}", produces = { "application/xml" })
    public ProductDTO getById(@PathVariable(value = "id") Integer Id) {
        return productService.getById(Id);
    }

    @GetMapping(path = "/page/{page_num}", produces = { "application/xml" })
    public ProductResult getProducts(@PathVariable(value = "page_num") Integer pageNum) {
        return productService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
    }

    @PostMapping(path = "", produces = { "application/xml" })
    public ProductDTO save(@Valid @RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @PutMapping(path = "/{id}", produces = { "application/xml" })
    public ProductDTO update(@PathVariable final Integer id, @RequestBody final ProductDTO product) {
        return productService.update(product, id);
    }

    @DeleteMapping(path = "/{id}", produces = { "application/xml" })
    public ProductDTO delete(@PathVariable int id) {
        return productService.deleteById(id);
    }
}

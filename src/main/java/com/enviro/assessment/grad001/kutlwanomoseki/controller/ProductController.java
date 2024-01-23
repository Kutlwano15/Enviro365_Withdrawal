package com.enviro.assessment.grad001.kutlwanomoseki.controller;
import com.enviro.assessment.grad001.kutlwanomoseki.model.Investor;
import com.enviro.assessment.grad001.kutlwanomoseki.model.Product;
import com.enviro.assessment.grad001.kutlwanomoseki.repository.InvestorRepo;
import com.enviro.assessment.grad001.kutlwanomoseki.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private InvestorRepo investorRepo;

    @GetMapping("/getAllProduct/{investorId}")
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
//
@GetMapping("/getInvestorProducts/{investorId}")
public ResponseEntity<Product> getInvestorProducts(@PathVariable Long productInvestorId) {
    Optional<Product> productData = productRepo.findById(productInvestorId);

    if (productData.isPresent()) {
        return new ResponseEntity<>(productData.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
    @PostMapping("/createProduct/{investorId}")
    public ResponseEntity<Product> createProduct(@PathVariable Long investorId, @RequestBody Product newProduct) {
        if (isInvalidProductData(newProduct)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Investor> investorData = investorRepo.findById(investorId);
        if (investorData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Investor investor = investorData.get();
        newProduct.setProductInvestorId(investor);
        Product savedProduct = productRepo.save(newProduct);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    private boolean isInvalidProductData(Product product) {
        return product == null || product.getName() == null || product.getType() == null ||
                product.getCurrentBalance() == null;
    }

    @PutMapping("/updateProductById/{investorId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct){
    Optional<Product> oldData = productRepo.findById(productId);

    if(oldData.isPresent()){
        Product update = oldData.get();
        update.setProductId(updatedProduct.getProductId());
        update.setName(updatedProduct.getName());
        update.setType(updatedProduct.getType());
        update.setCurrentBalance(updatedProduct.getCurrentBalance());
        update.setProductInvestorId(updatedProduct.getProductInvestorId());

        Product productObj = productRepo.save(update);
        return new ResponseEntity<>(productObj,HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        Optional<Product> productData = productRepo.findById(productId);
            productRepo.delete(productData.get());
            return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.encore.controllers;

import com.encore.entities.Product;
import com.encore.icontrollers.IProductController;
import com.encore.iservices.IProductService;
import com.encore.requests.AddProductRequest;
import com.encore.validators.AddProductRequestValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import util.JSONUtil;
import util.SelectType;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController extends BaseController implements IProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private AddProductRequestValidator validator;

    @Override
    public ModelAndView productView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("secured/product");
        List<Product> productList = productService.getAllProduct();
        modelAndView.addObject("products",productList);
        modelAndView.addObject("productTypeSelectList", Utils.getSelectOptionByType(request, SelectType.PRODUCT_TYPE.getValue()));
        return modelAndView;
    }

    @Override
    public Object addProductView(@RequestBody AddProductRequest req, HttpServletRequest request, HttpServletResponse response, Errors errors) {
        validator.validate(req, errors);
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getJSONValidationResult(errors));
        productService.addProduct(req);
        List<Product> productList = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(productList));
    }

    @Override
    public Object removeEmployee(String id, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONUtil.getJSONResultWithValidationError("Silinecek satırın numarası boş olamaz"));
        productService.removeProduct(id);
        List<Product> productList = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(productList));
    }
}

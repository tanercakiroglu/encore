package com.encore.requests;

import java.math.BigDecimal;

public class AddProductRequest {

    private Long id;

    private String productName;

    private String productOwner;

    private int productType;

    private int productHeight;

    private int productWeight;

    private int productDepth;

    private BigDecimal productBuyPrice;

    private BigDecimal productSellPrice;

    private String productSupplier;


    public AddProductRequest() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(int productHeight) {
        this.productHeight = productHeight;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductDepth() {
        return productDepth;
    }

    public void setProductDepth(int productDepth) {
        this.productDepth = productDepth;
    }

    public BigDecimal getProductBuyPrice() {
        return productBuyPrice;
    }

    public void setProductBuyPrice(BigDecimal productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
    }

    public BigDecimal getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(BigDecimal productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

 }
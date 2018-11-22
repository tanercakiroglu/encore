package com.encore.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_owner")
    private String productOwner;

    @Column(name = "product_type")
    private int productType;

    @Column(name = "product_height")
    private int productHeight;

    @Column(name = "product_weight")
    private int productWeight;

    @Column(name = "product_depth")
    private int productDepth;

    @Column(name = "product_buy_price")
    private BigDecimal productBuyPrice;

    @Column(name = "product_sell_price")
    private BigDecimal productSellPrice;

    @Column(name = "product_supplier")
    private String productSupplier;

    @Column(name = "file_id")
    private int fileId;

    public Product() {
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}

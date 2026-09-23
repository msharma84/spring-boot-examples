package com.grisham.dto;

import com.grisham.enumeration.ProductType;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto {

    private String productName;
    private String productCode;
    private BigDecimal price;
    private Boolean isActive;
    private ProductType productType;
    private String specification;
    private String manufacturer;
    private UUID uniqueId;

    public ProductDto() {
    }

    public ProductDto(String productName, String productCode, BigDecimal price,
                      Boolean isActive, ProductType productType, String specification,
                      String manufacturer, UUID uniqueId) {
        this.productName = productName;
        this.productCode = productCode;
        this.price = price;
        this.isActive = isActive;
        this.productType = productType;
        this.specification = specification;
        this.manufacturer = manufacturer;
        this.uniqueId = uniqueId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }
}

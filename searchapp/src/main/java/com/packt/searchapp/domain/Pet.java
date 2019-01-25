package com.packt.searchapp.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 16.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Entity
@Table(name = "pet")
public class Pet {

    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private @Id Long id;

    private Long cost;
    private Integer numberInStock;
    private String itemName;
    private String pictureUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", cost=" + cost +
                ", numberInStock=" + numberInStock +
                ", itemName='" + itemName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}

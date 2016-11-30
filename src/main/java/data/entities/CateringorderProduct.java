/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author srostantkritikos06
 */
@Entity
@Table(name = "cateringorder_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CateringorderProduct.findAll", query = "SELECT c FROM CateringorderProduct c"),
    @NamedQuery(name = "CateringorderProduct.findByCateringId", query = "SELECT c FROM CateringorderProduct c WHERE c.cateringorderProductPK.cateringId = :cateringId"),
    @NamedQuery(name = "CateringorderProduct.findByProductId", query = "SELECT c FROM CateringorderProduct c WHERE c.cateringorderProductPK.productId = :productId"),
    @NamedQuery(name = "CateringorderProduct.findByQuantity", query = "SELECT c FROM CateringorderProduct c WHERE c.quantity = :quantity")})
public class CateringorderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CateringorderProductPK cateringorderProductPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "catering_id", referencedColumnName = "catering_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cateringorder cateringorder;

    public CateringorderProduct() {
    }

    public CateringorderProduct(CateringorderProductPK cateringorderProductPK) {
        this.cateringorderProductPK = cateringorderProductPK;
    }

    public CateringorderProduct(String cateringId, String productId) {
        this.cateringorderProductPK = new CateringorderProductPK(cateringId, productId);
    }

    public CateringorderProductPK getCateringorderProductPK() {
        return cateringorderProductPK;
    }

    public void setCateringorderProductPK(CateringorderProductPK cateringorderProductPK) {
        this.cateringorderProductPK = cateringorderProductPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cateringorder getCateringorder() {
        return cateringorder;
    }

    public void setCateringorder(Cateringorder cateringorder) {
        this.cateringorder = cateringorder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateringorderProductPK != null ? cateringorderProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CateringorderProduct)) {
            return false;
        }
        CateringorderProduct other = (CateringorderProduct) object;
        if ((this.cateringorderProductPK == null && other.cateringorderProductPK != null) || (this.cateringorderProductPK != null && !this.cateringorderProductPK.equals(other.cateringorderProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.entities.CateringorderProduct[ cateringorderProductPK=" + cateringorderProductPK + " ]";
    }
    
}

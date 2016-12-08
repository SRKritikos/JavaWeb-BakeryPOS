/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Steven Kritikos
 */
@Embeddable
public class CateringorderProductPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "catering_id")
    private String cateringId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "product_id")
    private String productId;

    public CateringorderProductPK() {
    }

    public CateringorderProductPK(String cateringId, String productId) {
        this.cateringId = cateringId;
        this.productId = productId;
    }

    public String getCateringId() {
        return cateringId;
    }

    public void setCateringId(String cateringId) {
        this.cateringId = cateringId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateringId != null ? cateringId.hashCode() : 0);
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CateringorderProductPK)) {
            return false;
        }
        CateringorderProductPK other = (CateringorderProductPK) object;
        if ((this.cateringId == null && other.cateringId != null) || (this.cateringId != null && !this.cateringId.equals(other.cateringId))) {
            return false;
        }
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.entities.CateringorderProductPK[ cateringId=" + cateringId + ", productId=" + productId + " ]";
    }

}

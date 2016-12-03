/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Steven Kritikos
 * email: stevenrktitikos@outlook.com
 */
@Entity
@Table(name = "cateringorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cateringorder.findAll", query = "SELECT c FROM Cateringorder c"),
    @NamedQuery(name = "Cateringorder.findByCateringId", query = "SELECT c FROM Cateringorder c WHERE c.cateringId = :cateringId"),
    @NamedQuery(name = "Cateringorder.findByDateCreated", query = "SELECT c FROM Cateringorder c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Cateringorder.findByDeliveryDate", query = "SELECT c FROM Cateringorder c WHERE c.deliveryDate = :deliveryDate")})
public class Cateringorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "catering_id")
    private String cateringId;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Paymentmethod paymentMethodId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cateringorder", fetch = FetchType.EAGER)
    private List<CateringorderProduct> cateringorderProductList;

    public Cateringorder() {
    }

    public Cateringorder(String cateringId) {
        this.cateringId = cateringId;
    }

    public String getCateringId() {
        return cateringId;
    }

    public void setCateringId(String cateringId) {
        this.cateringId = cateringId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Paymentmethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Paymentmethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public List<CateringorderProduct> getCateringorderProductList() {
        return cateringorderProductList;
    }

    public void setCateringorderProductList(List<CateringorderProduct> cateringorderProductList) {
        this.cateringorderProductList = cateringorderProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateringId != null ? cateringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cateringorder)) {
            return false;
        }
        Cateringorder other = (Cateringorder) object;
        if ((this.cateringId == null && other.cateringId != null) || (this.cateringId != null && !this.cateringId.equals(other.cateringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.entities.Cateringorder[ cateringId=" + cateringId + " ]";
    }

}

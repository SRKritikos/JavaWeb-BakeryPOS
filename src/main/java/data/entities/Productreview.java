/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven Kritikos
 */
@Entity
@Table(name = "productreview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productreview.findAll", query = "SELECT p FROM Productreview p"),
    @NamedQuery(name = "Productreview.findByReviewId", query = "SELECT p FROM Productreview p WHERE p.reviewId = :reviewId"),
    @NamedQuery(name = "Productreview.findByReviewText", query = "SELECT p FROM Productreview p WHERE p.reviewText = :reviewText"),
    @NamedQuery(name = "Productreview.findByReviewDate", query = "SELECT p FROM Productreview p WHERE p.reviewDate = :reviewDate"),
    @NamedQuery(name = "Productreview.findByNumberStars", query = "SELECT p FROM Productreview p WHERE p.numberStars = :numberStars")})
public class Productreview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "review_id")
    private String reviewId;
    @Size(max = 6000)
    @Column(name = "review_text")
    private String reviewText;
    @Column(name = "review_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    @Column(name = "number_stars")
    private Integer numberStars;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customerId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productId;

    public Productreview() {
    }

    public Productreview(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getNumberStars() {
        return numberStars;
    }

    public void setNumberStars(Integer numberStars) {
        this.numberStars = numberStars;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productreview)) {
            return false;
        }
        Productreview other = (Productreview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.entities.Productreview[ reviewId=" + reviewId + " ]";
    }

}

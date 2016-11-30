/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author srostantkritikos06
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByUsername", query = "SELECT c FROM Customer c WHERE c.username = :username"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_id")
    private String customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    private String username;
    @Size(max = 32)
    @Column(name = "password")
    private String password;
    @Size(max = 64)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 64)
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Productreview> productreviewList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Cateringorder> cateringorderList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Paymentmethod> paymentmethodList;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userroles roleId;

    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, String username) {
        this.customerId = customerId;
        this.username = username;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public List<Productreview> getProductreviewList() {
        return productreviewList;
    }

    public void setProductreviewList(List<Productreview> productreviewList) {
        this.productreviewList = productreviewList;
    }

    @XmlTransient
    public List<Cateringorder> getCateringorderList() {
        return cateringorderList;
    }

    public void setCateringorderList(List<Cateringorder> cateringorderList) {
        this.cateringorderList = cateringorderList;
    }

    @XmlTransient
    public List<Paymentmethod> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<Paymentmethod> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    public Userroles getRoleId() {
        return roleId;
    }

    public void setRoleId(Userroles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.entities.Customer[ customerId=" + customerId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.clients;

import config.PaymentMethod;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * Class used to return appropriate payment process 
 * 
 * @author srostantkritikos06
 */
@Stateful
public class PaymentsFactory{
    
    private Map<PaymentMethod,IPaymentProcess> paymentMap; 
    
    @EJB
    private MasterCardPayment mastercard;
    @EJB
    private PaypalPayment paypal;
    @EJB
    private VisaPayment visa;
    @EJB
    private AmericanExpressPayment americanexpress;
    
    
    @PostConstruct
    public void initializeFactory() {
        this.paymentMap = new HashMap();
        this.paymentMap.put(PaymentMethod.Visa, visa);
        this.paymentMap.put(PaymentMethod.AmericanExpress, americanexpress);
        this.paymentMap.put(PaymentMethod.Paypal, paypal);
        this.paymentMap.put(PaymentMethod.MasterCard, mastercard);
        
    }

    public IPaymentProcess getPayment(PaymentMethod method) {
        return this.paymentMap.get(method);
    }
    
    public Map<PaymentMethod, IPaymentProcess> getPaymentMap() {
        return paymentMap;
    }

    public void setPaymentMap(Map<PaymentMethod, IPaymentProcess> paymentMap) {
        this.paymentMap = paymentMap;
    }

    public void setMastercard(MasterCardPayment mastercard) {
        this.mastercard = mastercard;
    }

    public void setPaypal(PaypalPayment paypal) {
        this.paypal = paypal;
    }

    public void setVisa(VisaPayment visa) {
        this.visa = visa;
    }

    public void setAmericanexpress(AmericanExpressPayment americanexpress) {
        this.americanexpress = americanexpress;
    }
    
    
    
    
}

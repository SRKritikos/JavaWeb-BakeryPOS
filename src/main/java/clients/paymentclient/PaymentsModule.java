/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.paymentclient;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import config.PaymentMethod;

/**
 *
 * @author srostantkritikos06
 */
public class PaymentsModule extends AbstractModule{

    @Override
    protected void configure() {
        MapBinder<PaymentMethod, IPaymentProcess> mapbinder = 
                MapBinder.newMapBinder(binder(), PaymentMethod.class, IPaymentProcess.class);
        mapbinder.addBinding(PaymentMethod.Visa).to(VisaPayment.class);
        mapbinder.addBinding(PaymentMethod.AmericanExpress).to(AmericanExpressPayment.class);
        mapbinder.addBinding(PaymentMethod.MasterCard).to(MasterCardPayment.class);
        mapbinder.addBinding(PaymentMethod.Paypal).to(PaypalPayment.class);
    }
    
}

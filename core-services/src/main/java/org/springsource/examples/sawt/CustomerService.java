package org.springsource.examples.sawt;

import org.springsource.examples.sawt.services.model.Customer;

public interface CustomerService {
    Customer updateCustomer(long id, String fn, String ln);

    Customer getCustomerById(long id);

    void deleteCustomer( long id);

    Customer createCustomer(String fn, String ln);
}

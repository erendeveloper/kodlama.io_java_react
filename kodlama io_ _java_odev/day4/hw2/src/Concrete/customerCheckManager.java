package Concrete;

import Abstract.ICustomerCheckService;
import Entities.Customer;

public class customerCheckManager implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {
         return true;

    }
}

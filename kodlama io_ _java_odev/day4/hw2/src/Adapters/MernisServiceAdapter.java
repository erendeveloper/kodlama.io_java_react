package Adapters;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import MernisService.IDUKPSPublicSoap;

import java.util.Locale;

public class MernisServiceAdapter implements ICustomerCheckService {
    @Override
    public boolean checkIfRealPerson(Customer customer) throws Exception {
        //return false;
        IDUKPSPublicSoap client = new IDUKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.decode(customer.getNationalityId()),customer.getFirstName().toUpperCase(),customer.getLastName().toUpperCase(),customer.getDateOfBirth().getYear());
    }
}

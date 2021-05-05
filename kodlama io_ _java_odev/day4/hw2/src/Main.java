import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BaseCustomerManager customerManager = new NeroCustomerManager(new MernisServiceAdapter());
        //BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());

        customerManager.save(new Customer(1,"Ad","Soyad", LocalDate.of(2000,1,1),"01234567891"));


    }
}

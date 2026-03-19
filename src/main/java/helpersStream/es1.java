package helpersStream;

import data.SampleData;
import entities.Customer;
import entities.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class es1 {

    public static Map<Customer, List<Order>> raggruppaOrdiniPerCliente() {
        return SampleData.ORDERS.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }
}

package helpersStream;

import data.SampleData;
import entities.Customer;
import entities.Order;

import java.util.Map;
import java.util.stream.Collectors;

public class es2 {
    public static Map<Customer, Double> totaleSpesaPerCliente() {
        return SampleData.ORDERS.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getTotalAmount)));
    }
}

package helpersStream;

import data.SampleData;
import entities.Order;

import java.util.OptionalDouble;

public class es4 {

    public static OptionalDouble calcolaMediaImportoOrdini() {
        return SampleData.ORDERS.stream()
                .mapToDouble(Order::getTotalAmount)
                .average();
    }
}

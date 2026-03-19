package helpersStream;

import data.SampleData;
import entities.Product;

import java.util.Map;
import java.util.stream.Collectors;

public class es5 {

    public static Map<String, Double> sommaPrezziPerCategoria() {
        return SampleData.PRODUCTS.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
    }
}

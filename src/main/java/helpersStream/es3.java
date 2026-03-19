package helpersStream;

import data.SampleData;
import entities.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class es3 {
    public static List<Product> getProdottiPiuCostosi(int quanti) {
        return SampleData.PRODUCTS.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(quanti)
                .collect(Collectors.toList());
    }
}

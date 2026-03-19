package AndreiB;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.util.List;
import java.util.Map;

import static helpersStream.es1.raggruppaOrdiniPerCliente;

public class Application {

    public static void main(String[] args) {

        System.out.println("=== ESERCIZIO 1 ===\n");
        System.out.println(" Mappa clienti con numeri dei loro ordini\n");

        Map<Customer, List<Order>> ordiniPerCliente = raggruppaOrdiniPerCliente();

        for (Customer cliente : ordiniPerCliente.keySet()) {
            List<Order> ordini = ordiniPerCliente.get(cliente);

            System.out.println(cliente.getName());
            System.out.println("Numero ordini: " + ordini.size());

            if (ordini.isEmpty()) {
                System.out.println(" Nessun ordine effettuato");
            } else {
                for (Order o : ordini) {
                    System.out.println(" Ordine del " + o.getOrderDate());
                    System.out.println("  Prodotti:");
                    for (Product p : o.getProducts()) {
                        System.out.print(p.getName() + ". ");
                    }
                }
            }
            System.out.println("\n");

        }
    }
}

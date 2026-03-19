package AndreiB;

import data.SampleData;
import entities.Customer;
import entities.Order;
import entities.Product;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import static helpersStream.es1.raggruppaOrdiniPerCliente;
import static helpersStream.es3.getProdottiPiuCostosi;
import static helpersStream.es4.calcolaMediaImportoOrdini;

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

        System.out.println("=== ESERCIZIO 2 ===\n");
        System.out.println(" Totale speso da ogni cliente\n");


        for (Customer cliente : ordiniPerCliente.keySet()) {
            List<Order> ordini = ordiniPerCliente.get(cliente);

            double totale = 0;

            for (Order ordine : ordini) {
                for (Product p : ordine.getProducts()) {
                    totale += p.getPrice();
                }
            }

            System.out.println(" Ordini: " + ordini.size());
            System.out.println(cliente.getName() + ": " + totale + " €");
            System.out.println("\n");
        }

        System.out.println("\n=== ESERCIZIO 3 ===\n");
        System.out.println("I " + 3 + " prodotti più costosi:\n");

        List<Product> top = getProdottiPiuCostosi(4);

        for (Product p : top) {
            System.out.println("Prodotto: " + p.getName() + ", Prezzo: " + p.getPrice() + ", Categoria: " + p.getCategory());
        }

        System.out.println("\n=== ESERCIZIO 4 ===\n");
        System.out.println("Media degli importi degli ordini:\n");

        OptionalDouble media = calcolaMediaImportoOrdini();


        // Come abbiamo fatto in classe
        if (media.isPresent()) {

            System.out.println("Importo medio per ordine: " + media.getAsDouble() + " €");
            System.out.println("Numero ordini considerati: " + SampleData.ORDERS.size());
            System.out.println();

        } else System.out.println("Non ci sono ordini media = 0.00 €");

        // Ho messo un'altro metodo in caso mi fossi dimenticato di isPeresent()

//        if (SampleData.ORDERS.isEmpty()) {
//            System.out.println("Non ci sono ordini media = 0.00 €");
//        } else {
//            System.out.println("Importo medio per ordine: " + media.getAsDouble() + " €");
//            System.out.println("Numero ordini considerati: " + SampleData.ORDERS.size());
//            System.out.println();
//        }
    }
}

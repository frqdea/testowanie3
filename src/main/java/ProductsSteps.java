import domain.Customer;
import domain.Product;
import operations.ProductOperations;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.stringtemplate.v4.StringRenderer;

import java.util.List;
import java.util.Scanner;


public class ProductsSteps {

    private Product product;
    private StringRenderer renderer;
    private int selectedOption;
    private ProductOperations productOperations;

    @Given("The products menu")
    public void theProductsMenuIsOpen() {
        Scanner scanner = new Scanner(System.in);
        this.productOperations = new ProductOperations();

        System.out.println("[PRODUKTY]Wybierz opcje:\n1.Pokaż listę\n2.Dodaj\n3.Wyszukaj\n4.Zaktualizuj\n5.Usuń");
    }

    @When("I choose option number ($option)")
    public void iChooseOptionNumber(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                List<Product> productList = productOperations.getProductList();

                for (Product product : productList)
                    System.out.println(product);
                break;
            case 2:
                productOperations.menuAddProduct(scanner);
                break;
            case 3:
                productOperations.menuFindProduct(scanner);
                break;
            case 4:
                productOperations.menuUpdateProduct(scanner);
                break;
            case 5:
                productOperations.menuRemoveProduct(scanner);
                break;
            default:
                System.out.println("Błędna opcja");
        }
    }

    @Then("System shows the list of products")
    public void systemShowsTheListOfProducts() {
    }
}

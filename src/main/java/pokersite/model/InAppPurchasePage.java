package pokersite.model;


import pokersite.model.dao.UserDAO;
import pokersite.model.entity.Product;
import pokersite.model.entity.User;

import java.util.Scanner;

public class InAppPurchasePage {

    private UserDAO userDAO;

    public InAppPurchasePage(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void displayOptions(){
        System.out.println("1. Buy Background");
        System.out.println("2. Buy Coins");
        System.out.println("3. Buy Sounds");
        System.out.println("4. Exit");
    }

    public void processPurchase(User user, Product product){
        if(user != null){
            if(user.getCoins() >= product.getPrice()){
                user.purchase(product);
                System.out.println("Purchase successful: " + product.getName());
                userDAO.update(user);
            }else {
                System.out.println("Insufficient coins to purchase " + product.getName());
            }
        }else{
            System.out.print("User not found");

        }
    }

    public void showPage(User user){
        Scanner scanner = new Scanner(System.in);

        while(true){
            displayOptions();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    processPurchase(user, new Product("Background", 5.0));
                    break;
                case 2:
                    processPurchase(user, new Product("Coins", 2.0));
                    break;
                case 3:
                    processPurchase(user, new Product("Sounds", 3.0));
                    break;
                case 4:
                    System.out.println("Exiting In-App Purchase Page");
                    return;
                default:
                    System.out.println("Invalid Choice. Try Again");
            }
        }
    }
}


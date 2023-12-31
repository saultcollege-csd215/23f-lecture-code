package _02_data_calculations_actions.megaMart.functional;

import _02_data_calculations_actions.megaMart.givenCode.CartItem;
import _02_data_calculations_actions.megaMart.givenCode.DOM;

import java.util.ArrayList;
import java.util.List;

import static _02_data_calculations_actions.megaMart.givenCode.App.shoppingCart;
// After refactoring with calculation, the following import is no longer needed:
// import static _02_data_calculations_actions.megaMart.givenCode.App.shoppingCartTotal;


public class Main {

    public static void addItemToCart(String name, Double price) {
        shoppingCart = addItem(shoppingCart, new CartItem(name, price));    // Updating/reading a global variable is an action
        // calcCartTotal();                                                 // The lines below fit better in this function than as a separate function
        var total = calcTotal(shoppingCart);
        DOM.setCartTotal(total);                    // Updating the DOM is an action
        updateShippingIcons(shoppingCart);          // This is still an action, but it now uses an explicit input
        updateTaxDom(total);
    }

    // This new function is a calculation, and thus easily testable and reusable
    // (We now use addItem in a couple places: addItemToCart, and in updateShippingIcons to test for free shipping)
    public static List<CartItem> addItem(List<CartItem> items, CartItem item) {
        var newItems = new ArrayList<>(items);
        newItems.add(item);
        return newItems;
    }

    // After refactoring with calculation, the following method is no longer needed, and is merged into
    // the addItemToCart method:
//    public static void calcCartTotal() {
//        shoppingCartTotal = 0.0;
//        for (CartItem item : shoppingCart) {
//            shoppingCartTotal += item.price();  // Updating a global variable is an action
//        }
//        DOM.setCartTotal(shoppingCartTotal);    // Updating the DOM is an action
//        // Reading a global variable is an action
//        updateShippingIcons();
//        updateTaxDom();
//    }

    public static void updateShippingIcons(List<CartItem> cart) {
        var buyButtons = DOM.getBuyButtons();   // Reading the DOM is an action

        for (var button : buyButtons) {
            // There is a business rule embedded here (carts >= 20 get free shipping)
            // This code also requires the shoppingCartTotal to be initialized before testing
            if (getsFreeShipping(addItem(cart, button.item()))) {
                // Can't test this code without a mock DOM
                button.showFreeShippingIcon();      // Updating the DOM is an action
            } else {
                button.hideFreeShippingIcon();      // Updating the DOM is an action
            }
        }
    }

    public static void updateTaxDom(double shoppingCartTotal) {
        // By passing in the total we now have no external inputs
        // var tax = shoppingCartTotal * 0.13;  // Reading a global variable is an action
        DOM.setTax(calcTax(shoppingCartTotal));                     // Updating the DOM is still an action
    }

    // These are business rules encapsulated as calculations.
    // It is often useful to place business rule calculations like this into pure functions
    // so they may be easily reused.
    public static double calcTax(double amount) {
        return amount * 0.13;
    }

    public static boolean getsFreeShipping(List<CartItem> cart) {
        return calcTotal(cart) >= 20.0;
    }

    public static double calcTotal(List<CartItem> items) {
        var total = 0.0;
        for (CartItem item : items) {
            total += item.price();
        }
        return total;

        // Or, a few equivalent one-liners using streams:
//        return items.stream().map( item -> item.price() ).reduce(0.0, (a, b) -> a + b);
//        return items.stream().map(CartItem::price).reduce(0.0, Double::sum);
//        return items.stream().mapToDouble(CartItem::price).sum();
    }


}


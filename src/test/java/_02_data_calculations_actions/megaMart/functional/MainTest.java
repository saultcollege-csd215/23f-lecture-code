package _02_data_calculations_actions.megaMart.functional;

import _02_data_calculations_actions.megaMart.givenCode.CartItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    List<CartItem> cart3x10 = List.of(
            new CartItem("item1", 10.0),
            new CartItem("item2", 10.0),
            new CartItem("item3", 10.0)
    );
    List<CartItem> cart1x30 = List.of(
            new CartItem("item1", 30.0)
    );
    List<CartItem> cart1x20 = List.of(
            new CartItem("item1", 20.0)
    );
    List<CartItem> cart2x10 = List.of(
            new CartItem("item1", 10.0),
            new CartItem("item2", 10.0)
    );
    List<CartItem> cart1x19_99 = List.of(
            new CartItem("item1", 19.99)
    );
    List<CartItem> cart5x1 = List.of(
            new CartItem("item1", 1.0),
            new CartItem("item2", 1.0),
            new CartItem("item3", 1.0),
            new CartItem("item4", 1.0),
            new CartItem("item5", 1.0)
    );

    @Test
    void addItem() {
        assertEquals(cart1x20, Main.addItem(List.of(), new CartItem("item1", 20.0)));
        assertEquals(cart3x10, Main.addItem(cart2x10, new CartItem("item3", 10.0)));
    }

    @Test
    void calcTax() {
        assertEquals(0.0, Main.calcTax(0.0));
        assertEquals(1.3, Main.calcTax(10.0));
    }

    @Test
    void getsFreeShippingDetectsCartsThatShouldHaveFreeShipping() {
        assertTrue(Main.getsFreeShipping(cart3x10));
        assertTrue(Main.getsFreeShipping(cart1x30));
        assertTrue(Main.getsFreeShipping(cart1x20));
        assertTrue(Main.getsFreeShipping(cart2x10));
        assertFalse(Main.getsFreeShipping(cart1x19_99));
        assertFalse(Main.getsFreeShipping(cart5x1));
    }

    @Test
    void calcTotal() {
        assertEquals(0.0, Main.calcTotal(List.of()));
        assertEquals(19.99, Main.calcTotal(cart1x19_99));
        assertEquals(30.0, Main.calcTotal(cart3x10));
        assertEquals(5.0, Main.calcTotal(cart5x1));
    }
}
package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * References:
 * JUnit Testing Docs: https://junit.org/junit5/docs/current/user-guide/
 * GPT-4o
 */

public class ShoppingCartTest {

    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 999.99);
        assertEquals(999.99, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for adding item with 0 price")
    public void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertDoesNotThrow(() -> cart.addItem("Free Sample", 0.0));
        assertEquals(1, cart.getCartSize());
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Refund", -50.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE10'")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.01);
    }

    @Test
    @DisplayName("Test for applying 'SAVE20'")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.01);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    public void testApplyInvalidCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 200.0);
        assertEquals(300.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(180.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test removing existing item")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Phone", 500.0);
        assertTrue(cart.removeItem("Phone"));
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test removing non-existent item")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Phone", 500.0);
        assertFalse(cart.removeItem("Laptop"));  // Not added
        assertEquals(1, cart.getCartSize());
    }

    @Test
    @DisplayName("Test cart size updates correctly")
    public void testCartSizeUpdates() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 200.0);
        assertEquals(2, cart.getCartSize());
        cart.removeItem("Item1");
        assertEquals(1, cart.getCartSize());
    }
}

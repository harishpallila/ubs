package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    
    private final HashMap<Furniture, Integer> orderMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        orderMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        if (orderMap.containsKey(type))
            orderMap.merge(type, furnitureCount, (prev, one) -> prev + one);
        else
            orderMap.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return orderMap;
    }

    public float getTotalOrderCost() {
        return orderMap.isEmpty() ? 0.0f : orderMap.entrySet().stream().map(e -> e.getKey().cost() * e.getValue()).reduce(Float::sum).get();
    }

    public int getTypeCount(Furniture type) {
        return orderMap.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        return orderMap.getOrDefault(type, 0.0f) * type.cost();
    }

    public int getTotalOrderQuantity() {
        return orderMap.isEmpty() ? 0 : orderMap.values().stream().reduce(Integer::sum).get();
    }
}

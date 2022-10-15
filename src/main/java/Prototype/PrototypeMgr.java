package Prototype;

import Product.Product;

import java.util.HashMap;
import java.util.Map;

public class PrototypeMgr {
    private Map<String, Product> prototypes = new HashMap<String, Product>();
    public void addPrototype(String brand, Product prototype) {
        prototypes.put(brand, prototype);
    }
    public Product getPrototype(String brand){
        return (Product)prototypes.get(brand).deepClone();
    }
}

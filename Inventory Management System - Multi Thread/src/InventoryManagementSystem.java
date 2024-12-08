import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManagementSystem {
    //check with public and private in method, what needed here
    private final ConcurrentHashMap<String, Seller> sellerIdToSellerMapper;
    private final ConcurrentHashMap<Integer, Product> productIdToProductMapper;

    public InventoryManagementSystem(){
        sellerIdToSellerMapper = new ConcurrentHashMap<>();
        productIdToProductMapper = new ConcurrentHashMap<>();
    }

    public void createSeller(String sellerId, List<String> pincodes, List<String> paymentMode){
        if(sellerIdToSellerMapper.containsKey(sellerId)) return;
        Seller seller = new Seller(sellerId, pincodes, paymentMode);
        sellerIdToSellerMapper.put(sellerId, seller);
    }

    public synchronized String addInventory(int productId, String sellerId, int delta){
        Inventory inventory = Inventory.createInventory();
        inventory.addInventory(productId, sellerId, delta);
        Product product = new Product(productId);
        productIdToProductMapper.put(productId, product);
        return "Inventory Added!";
    }

    public synchronized int getInventory(int productId, String sellerId){
        if(!sellerIdToSellerMapper.containsKey(sellerId)  || !productIdToProductMapper.containsKey(productId)) return 0;
        Inventory inventory = Inventory.createInventory();
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, AtomicInteger>> sellerToProductToDeltaMapper = inventory.getSellerToProductToDeltaMapper();
        if(sellerToProductToDeltaMapper.get(sellerId).containsKey(productId) == false) return 0;
        ConcurrentHashMap<Integer, AtomicInteger> productToDeltaMapper = sellerToProductToDeltaMapper .get(sellerId);
        return productToDeltaMapper.get(productId).get();
    }

    public synchronized String createOrder(String orderId, String destinationPincode, String sellerId, int productId, int productCount, String paymentMode){

            //we need to check pincode not serviceable
            Seller seller = sellerIdToSellerMapper.get(sellerId);
            if(seller.checkIsPincodeAvailable(destinationPincode) == false) return "pincode in not serviceable";

            // payment mode is not supported
            if(!seller.checkPaymentModeAvailable(paymentMode)) return "payement mode not supported";

            // number of product is less in inventory
            Inventory inventory = Inventory.createInventory();
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, AtomicInteger>> sellerToProductToDeltaMapper = inventory.getSellerToProductToDeltaMapper();
            ConcurrentHashMap<Integer, AtomicInteger> productToDeltaMapper = sellerToProductToDeltaMapper.get(sellerId);
            if(productToDeltaMapper.get(productId).get() < productCount) return "insufficient product in inventory";

            //we have to create order
            Order order = new Order(orderId, destinationPincode, sellerId, productId, productCount, paymentMode);

            //then we have to update the inventory quantity
            productToDeltaMapper = sellerToProductToDeltaMapper.get(sellerId);
            //here you have to update

            productToDeltaMapper.get(productId).addAndGet(-productCount);
            sellerToProductToDeltaMapper.put(sellerId, productToDeltaMapper);
            //we have to update seller holding list of orders as well
            seller.setOrders(orderId);
            //we have to update the seller history
            seller.addInSellerHistory(productId, productCount);
        return "Order Placed!!";
    }

}

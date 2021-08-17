import java.util.ArrayList;
public class BevShop implements BevShopInterface{
        private int alchcount;
        private int orderIndex;
        private ArrayList <Order> orders;
        public BevShop() {
                orders = new ArrayList<>();
        }
        public String toString() {
                String print = "Monthly Orders\n";
                for (Order o : orders) {
                        print += o.toString();
                }
                print += "Total Sale: " + totalMonthlySale();
                return print;
        }
        public boolean validTime(int time) {
                if (time >= MIN_TIME && time <= MAX_TIME) {
                }
                return false;
        }
        public boolean validAge(int age) {
                if (age >= MIN_AGE_FOR_ALCOHOL) {
                        return true;
                }else {
                return false;
                }
        }
        public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
            orders.get(orderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
        public void processSmoothieOrder(String bevName, SIZE size, int fruitCount, boolean addProtein) {
            orders.get(orderIndex).addNewBeverage(bevName, size, fruitCount, addProtein);
        }
        public void processAlcoholOrder(String bevName, SIZE size) {
            orders.get(orderIndex).addNewBeverage(bevName, size);
            alchcount++;
        }
        public boolean eligibleForMore() {
                if (alchcount < 3) {
                        return true;
                }else {
                return false;
                }
        }
        public boolean isMaxFruit(int num) {
                if (num > MAX_FRUIT) {
                        return true;
                }
                return false;
        }
        public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
                Customer customer = new Customer(customerName, customerAge);
                Order order = new Order(time, day, customer);
                orders.add(order);
                orderIndex = orders.indexOf(order);
                alchcount = 0;
        }

        public int findOrder(int orderNo) {
                for (int i = 0; i < orders.size(); i++) {
                        if (orders.get(i).getOrderNo() == orderNo) {
                                return i;
                        }
                }
                return -1;
        }
        public double totalOrderPrice(int orderNo) {
                double currentSale = 0;
                for (Order o : orders) {
                        if (o.getOrderNo() == orderNo) {
                                for (Beverage b : o.getBeverages()) {
                                        currentSale += b.calcPrice();
                                }
                        }
                }
                return currentSale;
        }
        public double totalMonthlySale() {
                double saleTotal = 0;
                for (Order o : orders) {
                        for (Beverage b : o.getBeverages()) {
                                saleTotal += b.calcPrice();
                        }
                }
                return saleTotal;
        }
        public int totalNumOfMonthlyOrders() {
                return orders.size();
        }
        public void sortOrders() {
                for (int i = 0; i < orders.size()-1; i++) {
                        int minIndex = i;
                        for (int j = i+1; j < orders.size(); j++) {
                                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                                        minIndex = j;
                                }
                        }
                        Order temp = orders.get(minIndex);
                        orders.set(minIndex, orders.get(i));
                        orders.set(i, temp);
                }
        }
        public Order getOrderAtIndex(int index) {
                return orders.get(index);
        }
        public Order getCurrentOrder() {
                return orders.get(orderIndex);
        }
        public int getNumOfAlcoholDrink() {
                return alchcount;
        }
        public int getMaxOrderForAlcohol() {
                return MAX_ORDER_FOR_ALCOHOL;
        }
        public int getMinAgeForAlcohol() {
                return MIN_AGE_FOR_ALCOHOL;
        }
}

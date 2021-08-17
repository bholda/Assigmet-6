public interface BevShopInterface {
        int MIN_AGE_FOR_ALCOHOL = 21;
        int MAX_ORDER_FOR_ALCOHOL= 3;
        int MIN_TIME= 8;
        int MAX_TIME= 23;                              
        int MAX_FRUIT = 5;                              
        public boolean validTime(int time);
        public boolean eligibleForMore();
        public boolean validAge(int age);
        public void startNewOrder(int time, DAY day, String customerName, int customerAge);
        public void processCoffeeOrder( String bevName, SIZE size, boolean extraShot, boolean extraSyrup );
        public void  processAlcoholOrder( String bevName, SIZE size );
        public void processSmoothieOrder( String bevName, SIZE size, int numOfFruits, boolean addProtien);
        public int findOrder(int orderNo);
        public double totalOrderPrice(int orderNo);
        public double totalMonthlySale();
        public void sortOrders();
        public Order getOrderAtIndex(int index);
}
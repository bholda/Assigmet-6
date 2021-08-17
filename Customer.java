public class Customer {
        private String customerName;
        private int customerAge;
        public Customer(String n, int a) {
                customerName = n;
                customerAge = a;
        }
        public Customer(Customer c) {
                customerName = c.getName();
                customerAge = c.getAge();
        }
        public String toString() {
                return customerName +", " +customerAge +"y/o";
        }
        public String getName() {
                return customerName;
        }
        public int getAge() {
                return customerAge;
        }
        public void setName(String n) {
                customerName = n;
        }
        public void setAge(int a) {
                customerAge = a;
        }
}
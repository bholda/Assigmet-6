public class Alcohol extends Beverage{
        private boolean theWeekend;
        private final double WEEKEND_FEE = .6;
        public Alcohol(String count, SIZE s, boolean istheweekend) {
                super(count, TYPE.ALCOHOL, s);
                theWeekend = istheweekend;
        }
        public String toString() {
                String finish = getBevName() + ", " + getSize();
                if (theWeekend) {
                        finish += " Weekend";
                }
                finish += ", $" + calcPrice();
                return finish;
        }
        public boolean equals(Alcohol alc) {
                if (super.equals(alc) && theWeekend == alc.getIsWeekend()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        public double calcPrice() {
                double total = super.getBasePrice();
                if (super.getSize() == SIZE.MEDIUM) {
                        total += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        total += 2 * super.getSizePrice();
                }
                if (theWeekend) {
                        total += WEEKEND_FEE;
                }
                return total; 
        }
        public boolean getIsWeekend() {
                return theWeekend;
        }
        public double getWeekendFee() {
                return WEEKEND_FEE;
        }
        public void setIsWeekend(boolean is) {
                theWeekend = is;
        }
}
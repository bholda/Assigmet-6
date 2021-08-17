public class Coffee extends Beverage{
        private boolean moreShot;
        private boolean moreSyrup;
        private final double SHOT_COST = .5;
        private final double SYRUP_COST = .5;
        public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
                super(n, TYPE.COFFEE, s);
                moreShot = shot;
                moreSyrup = syrup;
        }
        public String toString() {
                String returnString = getBevName() + ", " +getSize();
                if (moreShot) {
                	returnString += " Extra shot";
                }
                if (moreSyrup) {
                	returnString += " Extra syrup";
                }
                
                returnString += ", $" +calcPrice();
                return returnString;
        }
        public double calcPrice() {
                double price = super.getBasePrice();
                if (super.getSize() == SIZE.MEDIUM) {
                        price += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        price += 2 * super.getSizePrice();
                }
                if (moreShot) {
                        price += SHOT_COST;
                }
                if (moreSyrup) {
                        price += SYRUP_COST;
                }
                return price;
        }
        public boolean equals(Coffee c) {
                if (super.equals(c) && moreShot== c.getExtraShot() && moreSyrup== c.getExtraSyrup()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        public void setExtraShot(boolean shot) {
                moreShot = shot;
        }
        public void setExtraSyrup(boolean syrup) {
                moreSyrup = syrup;
        }
        public boolean getExtraShot() {
            return moreShot;
        }
        public boolean getExtraSyrup() {
        	return moreSyrup;
        }
        public double getShotCost() {
            return SHOT_COST;
        }
        public double getSyrupCost() {
            return SYRUP_COST;
        }
}
package lib;

public class TaxFunction {

	private static final int TAX_EXEMPTION_SINGLE = 54000000;
  	private static final int TAX_EXEMPTION_MARRIED = 58500000;
  	private static final int TAX_EXEMPTION_CHILD = 1500000;
  	private static final double TAX_RATE = 0.05;
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,int deductible, boolean isMarried, int numberOfChildren) {
        int annualSalary = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxExemption = getTaxExemption(isMarried, numberOfChildren);
        int taxableIncome = Math.max(0, annualSalary - deductible - taxExemption);
        int tax = (int) Math.round(taxableIncome * TAX_RATE);
        return tax;
    }

    private static int getTaxExemption(boolean isMarried, int numberOfChildren) {
        int taxExemption = 0;
        if (isMarried) {
            taxExemption = ANNUAL_TAX_EXEMPTION_MARRIED;
        } else {
            taxExemption = ANNUAL_TAX_EXEMPTION_SINGLE;
        }
        taxExemption += Math.min(numberOfChildren, MAX_CHILDREN_COUNT) * ANNUAL_TAX_EXEMPTION_PER_CHILD;
        return taxExemption;
    }
}


	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}

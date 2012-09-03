

package lab3;

import javax.swing.*;

/**
 *
 * @author Brian
 */
public class PartList {
    private static final int MAX_RECS = 10;
    private static final int NOT_FOUND = -1;

    private static String partNo;  // should be private!
    private static int foundIndex = NOT_FOUND;  // should be private!
    private static String partDesc;
    private static double partPrice;  // should be private!

    // should be private!
    private static String[] partNums = new String[10];
    private static String[] partDescs = new String[10];
    private static double[] partPrices = new double[10];
    private static int emptyRow;
    
    public static void add(String partNo,String partDesc,String partPrice){
        try {
            this.partPrice = Double.parseDouble(partPrice);
        } catch(Exception e) {
            JOptionPane.
            JOptionPane.showMessageDialog(this,
                    "Sorry, the price entry must be a whole or floating point number only.\n",
                    "Number Format Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (emptyRow > 10) {
            JOptionPane.showMessageDialog(this, 
                    "Sorry, you have reach the maximum of 10 items.\n"
                    + "No more items can be saved.", "Maximum Reached", JOptionPane.WARNING_MESSAGE);

        } else if (partNo.length() == 0 || partDesc.length() == 0 
                || this.txtNewProdPrice.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(this, 
                    "Sorry, you must complete all fields. Please try again.",
                    "Incomplete Part Entry", JOptionPane.WARNING_MESSAGE);
            this.txtNewProdNo.requestFocus();

        } else {
            partNums[emptyRow] = partNo;
            partDescs[emptyRow] = partDesc;
            partPrices[emptyRow] = partPrice;
            this.emptyRow += 1;
        }
    }
}

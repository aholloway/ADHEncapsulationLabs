package lab3;

import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class PartList {

    private static final int MAX_RECS = 10;
    private static final int NOT_FOUND = -1;
    private static int foundIndex = NOT_FOUND;
    private static String partNo;
    private static String partDesc;
    private static double partPrice;
    private static String[] partNums = new String[10];
    private static String[] partDescs = new String[10];
    private static double[] partPrices = new double[10];
    private static int emptyRow;

    /**
     *
     * @param partNo
     * @param partDesc
     * @param partPrice
     */
    public static int add(String partNo, String partDesc, String partPrice) {

        if (partNo.length() == 0 || partDesc.length() == 0
                || partPrice.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, you must complete all fields. Please try again.",
                    "Incomplete Part Entry", JOptionPane.WARNING_MESSAGE);
            //Send focus back to the GUI
            return 2; //tells gui to request focus for the Prod No.
            //this.txtNewProdNo.requestFocus();

        } else if (emptyRow > 10) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, you have reach the maximum of 10 items.\n"
                    + "No more items can be saved.", "Maximum Reached", JOptionPane.WARNING_MESSAGE);
            return 0;

        }

        try {
            PartList.partPrice = Double.parseDouble(partPrice);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, the price entry must be a whole or floating point number only.\n",
                    "Number Format Error", JOptionPane.WARNING_MESSAGE);
            return 1;// tells the GUI to request focus for the Number input.
        }

        partNums[emptyRow] = partNo;
        partDescs[emptyRow] = partDesc;
        partPrices[emptyRow] = PartList.partPrice;
        PartList.emptyRow += 1;
        return 0;

    }

    public static String getPartNums(int subscript) {
        return partNums[subscript];
    }

    public static String getPartDescs(int subscript) {
        return partDescs[subscript];
    }

    public static double getPartPrices(int subscript) {
        return partPrices[subscript];
    }

    public static String[] getPartDescs() {
        return partDescs;
    }

    public static double[] getPartPrices() {
        return partPrices;
    }

    public static int getEmptyRow() {
        return emptyRow;
    }
}

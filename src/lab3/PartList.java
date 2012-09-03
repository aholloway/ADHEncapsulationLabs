package lab3;

import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class PartList {

    public static final int MAX_RECS = 10;
    public static final int NOT_FOUND = -1;
    private static int foundIndex = NOT_FOUND;
    private static String[] partNums = new String[10];
    private static String[] partDescs = new String[10];
    private static double[] partPrices = new double[10];
    private static int emptyRow;

    public static int add(String partNo, String partDesc, String partPriceString) {

        if (partNo.length() == 0 || partDesc.length() == 0
                || partPriceString.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, you must complete all fields. Please try again.",
                    "Incomplete Part Entry", JOptionPane.WARNING_MESSAGE);

            return 2; //tells gui to request focus for the Prod No.

        } else if (emptyRow > 10) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, you have reach the maximum of 10 items.\n"
                    + "No more items can be saved.", "Maximum Reached", JOptionPane.WARNING_MESSAGE);
            return 0;
        }

        double partPrice = 0;
        try {
            partPrice = Double.parseDouble(partPriceString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, the price entry must be a whole or floating point number only.\n",
                    "Number Format Error", JOptionPane.WARNING_MESSAGE);
            return 1;// tells the GUI to request focus for the Number input.
        }

        partNums[emptyRow] = partNo;
        partDescs[emptyRow] = partDesc;
        partPrices[emptyRow] = partPrice;
        PartList.emptyRow += 1;
        return 0;

    }

    public static void searchNum(String searchNum) {
        //reset foundIndex for each search.
        foundIndex = NOT_FOUND;
        if (searchNum != null && searchNum.length() > 0) {
            for (int i = 0; i < partNums.length; i++) {
                if (searchNum.equalsIgnoreCase(partNums[i])) {
                    foundIndex = i;
                    break;
                }
            }
            if (foundIndex == NOT_FOUND) {
                JOptionPane.showMessageDialog(null,
                        "Part Number not found. Please try again.",
                        "Not Found", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please enter a Part No. to search",
                    "Entry Missing", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Sort by partNumber
    public static int sortList() {
        // Only perform the sort if we have records
        if (emptyRow > 0) {
            // Bubble sort routine adapted from sample in text book...
            // Make sure the operations are peformed on all 3 arrays!
            for (int passNum = 1; passNum < emptyRow; passNum++) {
                for (int i = 1; i <= emptyRow - passNum; i++) {
                    String temp = "";
                    temp += partPrices[i - 1];
                    partPrices[i - 1] = partPrices[i];
                    partPrices[i] = Double.parseDouble(temp);

                    temp = partNums[i - 1];
                    partNums[i - 1] = partNums[i];
                    partNums[i] = temp;

                    temp = partDescs[i - 1];
                    partDescs[i - 1] = partDescs[i];
                    partDescs[i] = temp;
                }
            }
            return 1; //success.  display list in the GUI
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sorry, there are not items to sort", "Sort Error",
                    JOptionPane.WARNING_MESSAGE);
            return 0; //does not display list
        }
    }

    public static int updatePart(String partNo, String partDesc, String partPriceString) {
        //may need to revamp this first check.
        if (foundIndex == NOT_FOUND) {
            JOptionPane.showMessageDialog(null,
                    "Part Number not found. Please try again.",
                    "Search Failure", JOptionPane.WARNING_MESSAGE);
            return 1;
        } else {
            double partPrice = 0;
            //validatate that partPrice is a number
            try {
                partPrice = Double.parseDouble(partPriceString);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Sorry, the price entry must be a whole or floating point number only.\n",
                        "Number Format Error", JOptionPane.WARNING_MESSAGE);
            }


            partPrices[foundIndex] = partPrice;
            partNums[foundIndex] = partNo;
            partDescs[foundIndex] = partDesc;
            return 0;
        }
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

    public static void setPartNums(int subscript, String PartNo) {
        partNums[subscript] = PartNo;
    }

    public static void setPartDescs(int subscript, String PartDesc) {
        partDescs[subscript] = PartDesc;
    }

    public static void setPartPrices(int subscript, String partPriceString) {
        double partPrice = 0;
        try {
            partPrice = Double.parseDouble(partPriceString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, the price entry must be a whole or floating point number only.\n",
                    "Number Format Error", JOptionPane.WARNING_MESSAGE);
        }
        partPrices[subscript] = partPrice;
    }

    public static int getEmptyRow() {
        return emptyRow;
    }

    public static int getFoundIndex() {
        return foundIndex;
    }
}

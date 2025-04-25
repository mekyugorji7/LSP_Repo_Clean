package org.howard.edu.lspfinal.question3;

/**
 * References:
 * Template Method Pattern: https://www.geeksforgeeks.org/template-method-design-pattern/#
 */

/**
 * Abstract base class for all reports following the Template Method pattern.
 */
public abstract class Report {

    /**
     * Template method defining the workflow for generating a report.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads the data for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the loaded data.
     */
    protected abstract void formatData();

    /**
     * Prints the final report. 
     */
    protected abstract void printReport();
}
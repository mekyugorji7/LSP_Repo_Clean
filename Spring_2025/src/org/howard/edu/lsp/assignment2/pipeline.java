package org.howard.edu.lsp.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class pipeline {
    
    public static void main(String[] args) {
		String inputFilePath = "Spring_2025/data/products.csv";
        String outputFilePath = "Spring_2025/data/transformed_products.csv";

        List<String[]> transformedData = new ArrayList<>();

	    try	(BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
			
			String line = reader.readLine();
		
			//for line in products, perform the following operations and output to transformed_products.csv
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length < 4) {
					continue;
				}

				//make name uppercase
				int productId = Integer.parseInt(parts[0].trim());
				String name = parts[1].trim().toUpperCase(); 
				double price = Double.parseDouble(parts[2].trim());
				String category = parts[3].trim();

				//if item category is electronics apply 10% discount 
				if (category.equalsIgnoreCase("Electronics")) {
                    price = Math.round(price * 0.90 * 100.0) / 100.0; 
					
					//if product price > $500, make category "Premium Electronics"
					if (price > 500) {
						category = "Premium Electronics";
					}
				}

				// create PriceRange
				String priceRange;
				if (price <= 10) {
					priceRange = "Low";
				} else if (price <= 100) {
					priceRange = "Medium";
				} else if (price <= 500) {
					priceRange = "High";
				} else {
					priceRange = "Premium";
				}

				// add transformed data to list
				transformedData.add(new String[]{String.valueOf(productId), name, String.format("%.2f", price), category, priceRange});
	
			}
			// write header
            writer.write("ProductID,Name,Price,Category,PriceRange\n");

			// write transformed data
            for (String[] record : transformedData) {
                writer.write(String.join(",", record) + "\n");
            }

			System.out.println("Transformation complete. Output saved to: " + outputFilePath);

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

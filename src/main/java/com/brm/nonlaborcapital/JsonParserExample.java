package com.brm.nonlaborcapital;

import com.brm.nonlaborcapital.dbModel.FinancialDetails;
import com.brm.nonlaborcapital.dbModel.NonLaborFinancialDetailsContainer;
import com.brm.nonlaborcapital.dbModel.NonLaborResource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * This prototype will become the Non-labor-capital-controller
 */
@SpringBootApplication
public class JsonParserExample {

	public static void main(String[] args) {

		SpringApplication.run(JsonParserExample.class, args);
		System.out.println("Spring Boot Application started");


		String sampleInput = "/Users/apjenkins/Development/Java/PNC/demo/src/main/resources/sampleInput.json";

		try{

			//Read Json File
			Reader reader = Files.newBufferedReader(Paths.get(sampleInput));

			//Create a new Gson Instance
			Gson gson = new Gson();

			// Parse the JSON content and map it to NonLaborFinancialDetailsContainer object
			NonLaborFinancialDetailsContainer nonLaborFinancialDetailsContainer = gson.fromJson(reader, NonLaborFinancialDetailsContainer.class);

			//Close
			reader.close();

			// Get the list of NonLaborResource objects from the container
			List<NonLaborResource> nonLaborResources = nonLaborFinancialDetailsContainer.getNonLaborFinancialDetails();



			// Print the elements of the NonLaborResource objects
			for (NonLaborResource nonLaborResource : nonLaborResources) {
				System.out.println("Initiate Id: " + nonLaborResource.getNonLaborResourceId());
				for (FinancialDetails financialDetails : nonLaborResource.getFinancialDetails()) {
					System.out.println("Year: " + financialDetails.getFinancialYear());
//					System.out.println("Monthly cost Array "+ Arrays.toString(financialDetails.getMonthlyCostArray()));
//					System.out.println("MonthlyCost: " + financialDetails.getMonthlyCost());
					System.out.println("Qs Totals:" + Arrays.toString(financialDetails.getQuarterlyTotal()));
					System.out.println("Financial Year Totals: " + financialDetails.getFinancialYearTotal());
				}
			}


		}catch(IOException e){
				e.printStackTrace();
		}

	}

}

package com.bridgelabz.fellowship.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.fellowship.model.StockInventory;
import com.bridgelabz.fellowship.model.UserModel;

public class StockAccountController {
	UserModel user = new UserModel();
	StockInventory invent = new StockInventory();
	ObjectMapper mapper = new ObjectMapper();

	Scanner sc = new Scanner(System.in);
	File file = new File("C:\\Users\\Admin\\eclipse-workspace\\CommercialDataProcessing\\StockInventory.json");
	File userFile = new File("C:\\Users\\Admin\\eclipse-workspace\\CommercialDataProcessing\\User.json");

	public List<UserModel> readUserFile() throws JsonParseException, JsonMappingException, IOException {
		List<UserModel> list1 = mapper.readValue(userFile, new TypeReference<List<UserModel>>() {
		});
		return list1;
	}

	public List<StockInventory> readFile() throws JsonParseException, JsonMappingException, IOException {
		List<StockInventory> list = mapper.readValue(file, new TypeReference<List<StockInventory>>() {
		});
		return list;
	}

	@SuppressWarnings("deprecation")
	public void writeFile(List<StockInventory> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, list);

	}

	@SuppressWarnings("deprecation")
	public void writeUserFile(List<UserModel> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(userFile, list);

	}

	public void buyStock(int amount, List<StockInventory> companyList, List<UserModel> userList) {
		System.out.println("Enter a user name ");
		String name = sc.next();
		for (int j = 0; j < userList.size(); j++) {
			if (userList.get(j).getName().equalsIgnoreCase(name)) {
				System.out.println("Enter a stock symbol you want to buy ");
				String symbol = sc.next();
				for (int i = 0; i < companyList.size(); i++) {
					if (companyList.get(i).getCompany_symbol().equalsIgnoreCase(symbol)) {
						System.out.println(companyList.get(i).getCompany_name() + " "
								+ companyList.get(i).getCompany_shares() + " " + companyList.get(i).getShare_price());
						System.out.println("Enter a value ");
						int value = sc.nextInt();
						int buyvalue = companyList.get(i).getCompany_shares() - value;
						
						System.out.println(buyvalue);
						companyList.get(i).setCompany_shares(buyvalue);

					}

				}
			}
		}

	}

	public void sellStock(List<StockInventory> companyList, List<UserModel> userList) {
		System.out.println("Enter a user name ");
		String name = sc.next();
		for (int j = 0; j < userList.size(); j++) {
			if (userList.get(j).getName().equalsIgnoreCase(name)) {
				System.out.println("Enter a stock symbol you want to sell ");
				String symbol = sc.next();
				for (int i = 0; i < companyList.size(); i++) {
					if (companyList.get(i).getCompany_symbol().equalsIgnoreCase(symbol)) {
						System.out.println(companyList.get(i).getCompany_name() + " "
								+ companyList.get(i).getCompany_shares() + " " + companyList.get(i).getShare_price());
						System.out.println("Enter a stock value you want to sell ");
						int value = sc.nextInt();
						int sellValue = companyList.get(i).getCompany_shares() + value;
						int remainingSellValue = userList.get(j).getSell_share() + sellValue;
						int remainingBuyValue = userList.get(j).getBuy_share() - sellValue;
						System.out.println(sellValue);
						companyList.get(i).setCompany_shares(sellValue);
						userList.get(j).setSell_share(remainingSellValue);
						userList.get(j).setBuy_share(remainingBuyValue);
						userList.add(user);

					}
				}
			}

		}
	}

	public List<StockInventory> addCompny(List<StockInventory> companyList) {
		System.out.println("Enter a company name ");
		invent.setCompany_name(sc.next());
		System.out.println("Enter a share value ");
		invent.setCompany_shares(sc.nextInt());
		System.out.println("Enter a company symbnol ");
		invent.setCompany_symbol(sc.next());
		System.out.println("Enter a share price ");
		invent.setShare_price(sc.nextInt());
		companyList.add(invent);
		return companyList;

	}

	public List<UserModel> addUser(List<UserModel> userList) {
		System.out.println("Enter a user name ");
		user.setName(sc.next());
		user.setBuy_share(0);
		user.setSell_share(0);
		userList.add(user);
		return userList;

	}
}

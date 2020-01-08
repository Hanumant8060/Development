import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.fellowship.controller.StockAccountController;
import com.bridgelabz.fellowship.model.StockInventory;
import com.bridgelabz.fellowship.model.UserModel;

public class StockAccountManagement {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Scanner sc = new Scanner(System.in);

		StockAccountController control = new StockAccountController();
		System.out.println("--------------Users-----------------");
		List<UserModel> customer = control.readUserFile();
		for (UserModel userModel : customer) {
			System.out.println(userModel.getName() + " " + userModel.getBuy_share() + " " + userModel.getSell_share());

		}
		System.out.println("----------------Company-------------------");
		List<StockInventory> stock = control.readFile();
		for (StockInventory stockInventory : stock) {
			System.out.println(stockInventory.getCompany_name() + " " + stockInventory.getCompany_symbol() + "\n" + " "
					+ stockInventory.getCompany_shares() + " " + stockInventory.getShare_price());

		}
		System.out.println("1.Add compaany\n2.Add User\n3.buy a share\n4.sell a share");
		System.out.println("Enter a choice ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			List<StockInventory> add = control.readFile();
			List<StockInventory> added = control.addCompny(add);
			control.writeFile(added);

			break;
		case 2:
			List<UserModel> add1 = control.readUserFile();
			List<UserModel> added1 = control.addUser(add1);
			control.writeUserFile(added1);

			// control.sellStock(stock);

			break;
		case 3:
			System.out.println("Enter a amount ");
			int buyAmount = sc.nextInt();
			control.buyStock(buyAmount, stock, customer);

			break;
		case 4:

			break;
		default:
			System.out.println("Enter a proper choice ");
			choice = sc.nextInt();
			break;
		}

	}

}

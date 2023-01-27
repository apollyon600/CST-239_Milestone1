import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import item.Items;
import item.Salable;
import page.HomePage;
import page.Page;
import user.User;

public class StoreFront {
	
	
	private Page currentPage;
	private User user;
		
	public StoreFront() {
		this.currentPage = new HomePage();
		this.user = new User();
	}
	
	public void initialize() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			currentPage.load(user);
			this.currentPage = currentPage.handle(user, scanner.nextInt());
		}
	}
	
}

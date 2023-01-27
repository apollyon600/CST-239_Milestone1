package page;

import user.User;

public class HomePage extends Page {

	@Override
	public void load(User user) {
		clear();
		System.out.println(LINE);
		System.out.println("\t\t      Choose a page to load");
		System.out.println("\t\t\t 1) Store Front");
		System.out.println("\t\t\t 2) Refund Item");
		System.out.println("\t\t\t 3) Exit Program");
		System.out.println(LINE);
		System.out.println("\t\t  Type the corresponding number");
		System.out.print("\t\t\t\t ");
	}

	@Override
	public Page handle(User user, int option) {
		switch (option) {
			case 1:
				return new StoreFront();
			case 2:
				return new RefundPage();
			case 3:
				System.exit(0);
			default:
				return this;
		}
	}

}

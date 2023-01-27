package page;

import user.User;

public abstract class Page {
	
	protected static final String LINE = "---------------------------------------------------------------";
	public abstract void load(User user);
	public abstract Page handle(User user, int option);
	public void clear() {
		for (int i = 0; i < 100; i++)
			System.out.println("\t");
	}
	
}

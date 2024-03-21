public class Product {
	private int amount;

	public Product(int amount) {
			this.amount = amount;
	}

	public synchronized int getAmount() {
			return this.amount;
	}

	public synchronized void buy(int n, String name) throws Exception {
			if (amount >= n) {
					int amountUpdated = this.amount - n;
					this.amount = amountUpdated;
					System.out.println(name + " withdrew " + n + " units. Current balance: " + amount);
			} else {
					throw new Exception("Insufficient balance");
			}
	}
}

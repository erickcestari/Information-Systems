import java.util.Random;

public class Distributor extends Thread{
	private String name;
	private Product product;
	private int productsBuyed;

	public Distributor(String name,Product product){
		super(name);
		this.name=name;
		this.product=product;
	}

	public void run(){
		try{
			while(true){
				if(this.product.getAmount() <= 0) {
					System.out.println(name + " buyed " + productsBuyed);
					return;
				}
				Random randomGenerator = new Random();
				var itensToBuy = randomGenerator.nextInt(this.product.getAmount()+ 1);
				if (itensToBuy  == 0 ) {
					itensToBuy++;
				}
				product.buy(itensToBuy,name);
				this.productsBuyed += itensToBuy;
				Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("name: " + e.getMessage());
		}
	}
}

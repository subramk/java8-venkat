package java8.in.action.chapter5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



public class TradesAndTransactions {

		public static void main(String[] args) {
			TradesAndTransactions tt = new  TradesAndTransactions() ;
			tt.doWork(); 
		}

		public void doWork() {
			
			Trader kasi = new Trader("kasi", "london"); 
			Trader deva = new Trader("deva", "chicago"); 
			Trader ramana = new Trader("ramana", "melbourne"); 
			Trader dilip = new Trader("dilip", "sivakasi"); 
			Trader ashok = new Trader("ashok", "ponneri"); 
			
			List<Transaction> transactions = Arrays.asList( new Transaction(kasi, 2011, 300),
					 new Transaction(kasi, 2012, 200),
					 new Transaction(deva, 2013, 500),
					 new Transaction(ramana, 2014, 400),
					 new Transaction(dilip, 2015, 322),
					 new Transaction(ashok, 2016, 1320)	) ; 
		
			
			// operations on Transactions 
			
			
			
			List<Transaction> sortedTx = transactions
						.stream()
						.filter( tx -> tx.getYear() == 2011)
						.sorted(comparing(Transaction::getValue))
						.collect(toList());
			
			
			
			// Transaction of the greateest Values is  
			
			Optional<Integer> highest = transactions
											.stream()
											.map(Transaction::getValue)
											.reduce(Integer::max);
			System.out.println("highest value of Tx ~~~~~~~~ ");
			System.out.println(highest.isPresent() ? highest.get(): "no value present" ) ;
		
			// smallest transaction 
			Optional<Transaction>  smallestTx  = transactions.stream()
							.reduce( (t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2); 
			System.out.println("Smallest  value of Tx ~~~~~~~~~");
			System.out.println(smallestTx.isPresent() ? smallestTx.get(): "no value present" ) ;
			
			Optional<Transaction>  smallestTx2  = transactions
														.stream()
														.min(comparing(Transaction::getValue)); 
			
			
			
			
		}
		
}

package poker;

public class Poker {
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFullHouse(String cards[], int n) {
		if (isFourOfAKind(cards, n)){
			return false;
		}
		return isThreeOfaKind(cards, n) && isTwoPairs(cards, n);
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n) {
		for (int i=0; i<n-2; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1))
					return true;
		}

		return false;
	}
	public boolean isFourOfAKind(String cards[], int n) {
		for (int i=0; i<n-3; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1) &&
					cards[i+2].charAt(1) == cards[i+3].charAt(1)) 
					return true;
		}
		return false;
	}
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n) {
		int count = 0;
		for (int i=0; i<n-1; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1)) {
				count++;
				i++;
			}
		}
		if (count == 2)
			return true;
		else
			return false;
	}

	//sort card function
	public void sort(String cards[], int n) {
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (cards[i].charAt(1) > cards[j].charAt(1)) {
					String temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));
	}

}
// end of Poker.java

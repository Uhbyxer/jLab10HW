package za.mixins;

public interface InvestorIF {
	default void buyShares() {
		System.out.println("Inv buy share");
	}
	default void sellShare() {
		System.out.println("Inv sell share");
	}
}

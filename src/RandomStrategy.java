
public class RandomStrategy extends GreedStrategy {

	@Override
	public int choose(GreedOption[] options, int[] dice, int bank) {
		int random = (int)(Math.random()*options.length);
	//	System.out.println("COMPUTER CHOOSES: " + random);
		return random;
	}

	@Override
	public String playerName() {
		// TODO Auto-generated method stub
		return "Random Player";
	}

	@Override
	public String author() {
		// TODO Auto-generated method stub
		return "Random";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}

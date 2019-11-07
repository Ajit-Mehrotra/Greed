
public class StrategyEvaluator {

	public static int evaluateStrategy(GreedStrategy theStrategy, int turns){
		ComputerGreedStrategyPlayer player 
		= new ComputerGreedStrategyPlayer(theStrategy);
		int score
		= (new GreedGame(false)).evaluatePlayer(player, turns);
		System.out.println("Goes into Strategy Evaluator");
		return score;
	}
	
	public static double practiceGreed(){
		return (new GreedGame(true)).evaluatePlayer(new ComputerGreedStrategyPlayer(new Test()),20000);
	}
	
	public static void main(String[] args) {
		System.out.println(practiceGreed());
		
	}

}

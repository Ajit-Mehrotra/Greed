
public class Test extends GreedStrategy {

	private boolean crashed = false;
	private double score = 0.0;
	private boolean ascending;

	public int choose(GreedOption[] options, int[] dice, int bank) {
		int numOnes = 0, numTwos = 0, numThrees = 0, numFours = 0, numFives = 0, numSixes = 0;
		int length = 0;
		int numScores = 0;
		int largest = 0;
		boolean first6 = false, first5 = false, first4 = false, first3 = false, first2 = false, first1 = false,  
				second = false, third = false, fourth = false, fifth = false, 
				sixth = false, seventh = false, eighth = false, ninth = false, tenth = false;
		ScoringCombination[] sc;
		int[][] combo = {{6, 6, 6, 6, 6, 6}, {5, 5, 5, 5, 5, 5}, {4, 4, 4, 4, 4, 4}, {3, 3, 3, 3, 3, 3}, {2, 2, 2, 2, 2, 2}, {1, 1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6}, 
				{1, 1, 1, 1}, {6, 6, 6}, {5, 5, 5}, {4, 4, 4}, {3, 3, 3}, {2, 2, 2}, {1}, {5}};
		int[] values = {5000, 5000, 5000, 5000, 5000, 5000, 1000, 1000, 600, 500, 400, 300, 200, 100, 50};

		double prob61 = (double) 6 / 46656, prob62 = (double) 720 / 46656, prob63 = (double) 300 / 46656, prob64 = (double) 2280 / 46656, prob65 = (double) 2280 / 46656, prob66 = (double) 2280 / 46656, prob67 = (double) 2280 / 46656, prob68 = (double) 2280 / 46656, prob69 = (double) 13272 / 46656, prob610 = (double) 13272 / 46656;
		double prob53 = (double) 25 / 7776, prob54 = (double) 250 / 7776, prob55 = (double) 250 / 7776, prob56 = (double) 250 / 7776, prob57 = (double) 250 / 7776, prob58 = (double) 250 / 7776, prob59 = (double) 2760 / 7776, prob510 = (double) 2760 / 7776;
		double prob43 = (double) 1 / 1296, prob44 = (double) 20 / 1296, prob45 = (double) 20 / 1296, prob46 = (double) 20 / 1296, prob47 = (double) 20 / 1296, prob48 = (double) 20 / 1296, prob49 = (double) 483 / 1296, prob410 = (double) 483 / 1296;
		double prob34 = (double) 1 / 216, prob35 = (double) 1 / 216, prob36 = (double) 1 / 216, prob37 = (double) 1 / 216, prob38 = (double) 1 / 216, prob39 = (double) 75 / 216, prob310 = (double) 75 / 216;
		double prob29 = (double) 11 / 36, prob210 = (double) 11 / 36;
		double prob19 = (double) 1 / 6, prob110 = (double) 1 / 6;
		
		double non6 = (double) 200000 / 100000;
		double non5 = (double) 800 / 10000;
		double non4 = (double) 100 / 1296;
		double non3 = (double) 10 / 216;
		double non2 = (double) 5 / 50;
		double non1 = (double) 1 / 20;
		
		double expected6, expected5, expected4, expected3, expected2, expected1;
		expected6 = (prob61 * 5000) + (prob62 * 1000) + (prob63 * 1000) + (prob64 * 600) + (prob65 * 500) + (prob66 * 400) + (prob67 * 300) + (prob68 * 200) + (prob69 * 100) + (prob610 * 50);
		expected5 = (prob53 * 1000) + (prob54 * 600) + (prob55 * 500) + (prob56 * 400) + (prob57 * 300) + (prob58 * 200) + (prob59 * 100) + (prob510 * 50);
		expected4 = (prob43 * 1000) + (prob44 * 600) + (prob45 * 500) + (prob46 * 400) + (prob47 * 300) + (prob48 * 200) + (prob49 * 100) + (prob410 * 50);
		expected3 = (prob34 * 600) + (prob35 * 500) + (prob36 * 400) + (prob37 * 300) + (prob38 * 200) + (prob39 * 100) + (prob310 * 50);
		expected2 = (prob29 * 100) + (prob210 * 50);
		expected1 = (prob19 * 100) + (prob110 * 50);
		
// System.out.println(expected6 + " " + expected5 + " " + expected4 + " " + expected3 + " " + expected2 + " " + expected1);
		
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == 1) {
				numOnes += 1;
			} else if (dice[i] == 2) {
				numTwos += 1;
			} else if (dice[i] == 3) {
				numThrees += 1;
			} else if (dice[i] == 4) {
				numFours += 1;
			} else if (dice[i] == 5) {
				numFives += 1;
			} else if (dice[i] == 6) {
				numSixes += 1;
			}
		}

		if (numSixes == 6) {
			first6 = true;
		}
		if (numFives == 6) {
			first5 = true;
		}
		if (numFours == 6) {
			first4 = true;
		}
		if (numThrees == 6) {
			first3 = true;
		}
		if (numTwos == 6) {
			first2 = true;
		}
		if (numOnes == 6) {
			first1 = true;
		}
		if (numOnes == 1 && numTwos == 1 && numThrees == 1 && numFours == 1 && numFives == 1 && numSixes == 1) {
			second= true;
		}
		if (numOnes >= 4) {
			third = true;
		}
		if (numSixes >= 3) {
			fourth = true;
		}
		if (numFives >= 3) {
			fifth = true;
		}
		if (numFours >= 3) {
			sixth = true;
		}
		if (numThrees >= 3) {
			seventh = true;
		}
		if (numTwos >= 3) {
			eighth = true;
		}
		if (numOnes >= 1) {
			ninth = true;
		}
		if (numFives >= 1) {
			tenth = true;
		}

		for (int i = 0; i < options.length; i++) {
			if (options[i].optionType() == 2) {
				numScores += 1;
			}
		}

		sc = new ScoringCombination[numScores];
		for (int i = 0; i < sc.length; i++) {
			if (first6) {
				sc[i] = new ScoringCombination(combo[0], values[0]);
				first6 = false;
			} else if (first5) {
				sc[i] = new ScoringCombination(combo[1], values[1]);
				first5 = false;
			} else if (first4) {
				sc[i] = new ScoringCombination(combo[2], values[2]);
				first4 = false;
			} else if (first3) {
				sc[i] = new ScoringCombination(combo[3], values[3]);
				first3 = false;
			} else if (first2) {
				sc[i] = new ScoringCombination(combo[4], values[4]);
				first2 = false;
			} else if (first1) {
				sc[i] = new ScoringCombination(combo[5], values[5]);
				first1 = false;
			} else if (second) {
				sc[i] = new ScoringCombination(combo[6], values[6]);
				second = false;
			} else if (third) {
				sc[i] = new ScoringCombination(combo[7], values[7]);
				third = false;
			} else if (fourth) {
				sc[i] = new ScoringCombination(combo[8], values[8]);
				fourth = false;
			} else if (fifth) {
				sc[i] = new ScoringCombination(combo[9], values[9]);
				fifth = false;
			} else if (sixth) {
				sc[i] = new ScoringCombination(combo[10], values[10]);
				sixth = false;
			} else if (seventh) {
				sc[i] = new ScoringCombination(combo[11], values[11]);
				seventh = false;
			} else if (eighth) {
				sc[i] = new ScoringCombination(combo[12], values[12]);
				eighth = false;
			} else if (ninth) {
				sc[i] = new ScoringCombination(combo[13], values[13]);
				ninth = false;
			} else if (tenth) {
				sc[i] = new ScoringCombination(combo[14], values[14]);
				tenth = false;
			}
		}

		/*for (int i = 0; i < sc.length; i++) {
			System.out.println(sc[i].toString());
		}*/

		if (numScores > 0) {
			if (numScores == options.length) {
				return 0;
			} else {
				for (int i = 1; i < sc.length; i++) {
					if (sc[i].getValue() > sc[largest].getValue()) {
						largest = i;
					}
				}
				if (dice.length == 6) {
					if (sc[largest].getValue() >= expected6) {
						return largest;
					} else {
						return sc.length;
					}
				} else if (dice.length == 5) {
					if (sc[largest].getValue() >= expected5) {
						return largest;
					} else {
						return sc.length;
					}
				} else if (dice.length == 4) {
					if (sc[largest].getValue() >= expected4) {
						return largest;
					} else {
						return sc.length;
					}
				} else if (dice.length == 3) {
					if (sc[largest].getValue() >= expected3) {
						return largest;
					} else {
						return sc.length;
					}
				} else if (dice.length == 2) {
					if (sc[largest].getValue() >= expected2) {
						return largest;
					} else {
						return sc.length;
					}
				} else {
					if (sc[largest].getValue() >= expected1) {
						return largest;
					} else {
						return sc.length;
					}
				}
			}
		} else {
			if (dice.length == 6) {
				if ((non6 * bank) + expected6 > bank) {
					return 0;
				} else {
					return 1;
				}
			} else if (dice.length == 5) {
				if ((non5 * bank) + expected5 > bank) {
					return 0;
				} else {
					return 1;
				}
			} else if (dice.length == 4) {
				if ((non4 * bank) + expected4 > bank) {
					return 0;
				} else {
					return 1;
				}
			} else if (dice.length == 3) {
				if ((non3 * bank) + expected3 > bank) {
					return 0;
				} else {
					return 1;
				}
			} else if (dice.length == 2) {
				if ((non2 * bank) + expected2 > bank) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if ((non1 * bank) + expected1 > bank) {
					return 0;
				} else {
					return 1;
				}
			}
		}

	}

	public String playerName() {
		return "Test playerName";
	}

	public String author() {
		return "Test author";
	}

	public static void main(String[] args) {
		/*GreedOption[] g = {new GreedOption(2), new GreedOption(2), new GreedOption(2)};
		int[] d = {1, 1, 1, 1, 1, 1};
		new Test().choose(g,  d,  0);*/
	}

}





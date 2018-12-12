import java.util.Arrays;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int... dice) {
        int counts = 0;
        int diceValue = 0;
        for (int die : dice){
            if (diceValue == 0 || diceValue == die){
                diceValue = die;
                counts++;
            }
        }
        return (counts == 5)? 50 : 0;
    }

    public static int countOccurrence(int number, int[] roll) {
        int occurrencesNumber = 0;
        for (int i = 0; i < roll.length; i++)
            if (number == roll[i]) occurrencesNumber++;
        return occurrencesNumber;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int onesOccurrences = Yatzy.countOccurrence(1, roll);
        return onesOccurrences;
    }


    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int twosOccurrences = Yatzy.countOccurrence(2, roll);
        return twosOccurrences * 2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int threeOccurrences = Yatzy.countOccurrence(3, roll);
        return threeOccurrences * 3;
    }

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int fours() {
        return Yatzy.countOccurrence(4, dice) * 4;
    }

    public int fives() {
        return Yatzy.countOccurrence(5, dice) * 5;
    }

    public int sixes() {
        return Yatzy.countOccurrence(6, dice) * 6;
    }

    public static int findCategory(int number, int[] roll, int occurrenceCategory){
        int occurrence = Yatzy.countOccurrence(number, roll);
        return (occurrence >= occurrenceCategory)? number * occurrenceCategory : 0;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=6; i>=1; i--){
            score = Yatzy.findCategory(i, roll, Category.PAIR.getValue());
            if(score > 0) return score;
        }
        return score;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int score = 0;
        int pairOccurrence = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=6; i>=1; i--){
            int pairScore = Yatzy.findCategory(i, roll, Category.PAIR.getValue());
            if(pairScore > 0) {
                score += pairScore;
                pairOccurrence++;
            }
        }
        return (pairOccurrence == 2)? score : 0;
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=1; i<=6; i++){
            score += Yatzy.findCategory(i, roll, Category.FOUR_OF_A_KIND.getValue());
        }
        return score;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=1; i<=6; i++){
            score += Yatzy.findCategory(i, roll, Category.THREE_OF_A_KIND.getValue());
        }
        return score;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        int[] smallStraight = {1, 2, 3, 4, 5};
        Arrays.sort(roll);
        if(Arrays.equals(smallStraight, roll))
            score = 15;
        return score;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        int[] largeStraight = {2, 3, 4, 5, 6};
        Arrays.sort(roll);
        if(Arrays.equals(largeStraight, roll))
            score = 20;
        return score;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}
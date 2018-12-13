public class Yatzy {

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
    }

    public int chance(){
        return Yatzy.chance(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int yatzy(){
        return Yatzy.yatzy(this.dice);
    }

    public int ones(){
        return Yatzy.ones(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int twos(){
        return Yatzy.ones(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int threes(){
        return Yatzy.ones(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int fours() {
        return Util.countOccurrence(4, dice) * 4;
    }

    public int fives() {
        return Util.countOccurrence(5, dice) * 5;
    }

    public int sixes() {
        return Util.countOccurrence(6, dice) * 6;
    }

    public int score_pair(){
        return Yatzy.score_pair(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int two_pair(){
        return Yatzy.two_pair(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int four_of_a_kind(){
        return Yatzy.four_of_a_kind(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int three_of_a_kind(){
        return Yatzy.three_of_a_kind(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int smallStraight(){
        return Yatzy.smallStraight(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int largeStraight(){
        return Yatzy.largeStraight(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

    public int fullHouse(){
        return Yatzy.fullHouse(this.dice[0], this.dice[1], this.dice[2], this.dice[3], this.dice[4]);
    }

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


    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int onesOccurrences = Util.countOccurrence(1, roll);
        return onesOccurrences;
    }


    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int twosOccurrences = Util.countOccurrence(2, roll);
        return twosOccurrences * 2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5} ;
        int threeOccurrences = Util.countOccurrence(3, roll);
        return threeOccurrences * 3;
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).fours();
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).fives();
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).sixes();
    }


    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=6; i>=1; i--){
            score = Util.findCategory(i, roll, Category.PAIR.getValue());
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
            int pairScore = Util.findCategory(i, roll, Category.PAIR.getValue());
            if(pairScore > 0){
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
            score += Util.findCategory(i, roll, Category.FOUR_OF_A_KIND.getValue());
        }
        return score;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        int[] roll = {d1, d2, d3, d4, d5};
        for(int i=1; i<=6; i++){
            score += Util.findCategory(i, roll, Category.THREE_OF_A_KIND.getValue());
        }
        return score;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5};
        return (Util.countOccurrence(1, roll) == 1
                && Util.countOccurrence(2, roll) == 1
                && Util.countOccurrence(3, roll) == 1
                && Util.countOccurrence(4, roll) == 1
                && Util.countOccurrence(5, roll) == 1)? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] roll = {d1, d2, d3, d4, d5};
        return (Util.countOccurrence(2, roll) == 1
                && Util.countOccurrence(3, roll) == 1
                && Util.countOccurrence(4, roll) == 1
                && Util.countOccurrence(5, roll) == 1
                && Util.countOccurrence(6, roll) == 1)? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int scorePair = score_pair(d1, d2, d3, d4, d5);
        int threeOfAKind = three_of_a_kind(d1, d2, d3, d4, d5);
        int scoreTotal = chance(d1, d2, d3, d4, d5);
        return (scorePair > 0 && threeOfAKind > 0 && scoreTotal == scorePair + threeOfAKind)? scoreTotal : 0;
    }
}
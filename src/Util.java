public class Util {

    public static int countOccurrence(int number, int[] roll) {
        int occurrencesNumber = 0;
        for (int i = 0; i < roll.length; i++)
            if (number == roll[i]) occurrencesNumber++;
        return occurrencesNumber;
    }

    public static int findCategory(int number, int[] roll, int occurrenceCategory){
        return (Util.countOccurrence(number, roll) >= occurrenceCategory)? number * occurrenceCategory : 0;
    }
}

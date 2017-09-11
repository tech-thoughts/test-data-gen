package tk.techthoughts.demos;

import java.util.Random;
import java.util.UUID;


public class NameGenerator {

    private static final int DEFAULT_NAMES_COUNT = 10;
    private static final int NUMBER_OF_FIELDS = 2;

    private int minimumLength;
    private int maximumLength;

    public NameGenerator() {
        this.minimumLength = 3;
        this.maximumLength = 7;
    }

    public NameGenerator(int min, int max) {
        this.minimumLength = min;
        this.maximumLength = max;
    }

    public Object[][] generatefirstAndLastNames(int count) {

        if(count <= 0) {
            count = DEFAULT_NAMES_COUNT;
        }

        Object[][] names = new Object[count][NUMBER_OF_FIELDS];

        for(int i=0; i<count; i++) {

            String randomText = UUID.randomUUID()
                                    .toString()
                                    .replaceAll("[0-9]","")
                                    .replaceAll("-","");

            Random random = new Random();
            int firstNameLength = random.nextInt(maximumLength - minimumLength) + minimumLength;

            String firstName = randomText.substring(0, firstNameLength);
            String lastName = randomText.substring(firstNameLength, randomText.length());

            if((firstName.length() > lastName.length() && lastName.length() < 3)
                    || (lastName.length() > 2*firstName.length())) {
                continue;
            }

            names[i][0] = firstName;
            names[i][1] = lastName;
        }

        return names;

    }

}

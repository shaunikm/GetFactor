package com.GetFactor;

import java.util.*;

class GetFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter in a number: ");

        long user_number;
        try {
            user_number = Long.parseLong(input.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number or number too large!");
        }
        if (user_number < 0) {
            user_number *= -1;
            System.out.print("[Number converted to a positive.]\n");
        }
        System.out.print("\n");

        ArrayList<Long> factorList = new ArrayList<>(1);

        for (long n=1; n<=Math.sqrt(user_number); n++) {
            if (!(n < 1)){
                if (user_number % n == 0 && !(factorList.contains(n))) {
                    factorList.add(n);
                    if (!(factorList.contains(user_number / n))) {
                        factorList.add(user_number / n);
                    }
                }
            }
        }

        Collections.sort(factorList);
        String title = "\tFactors of " + user_number + "\n";

        StringBuilder border = new StringBuilder();

        border.append("-".repeat(Math.max(0, title.length() + 8)));

        System.out.printf("%s\n", border.toString());
        System.out.print(title);
        System.out.printf("%s\n", border.toString());

        for (Long n: factorList) {
            if (!(n == user_number)) {
                System.out.printf("%s, ", n);
            }
            else {
                System.out.printf("%s\n", n);
            }
        }
        input.close();
    }
}
package com.noob.docker_boot.other.exam;

public class Exam {

    public static void main(String[] args) {
        System.out.println(calculateIt() / Math.PI);
    }

    private int sumSubString(String a, String b){
        int sub = 0;
        while (a.contains(b)) {
            sub++;
            a = a.replaceFirst(b, " ");
            System.out.println(sub);
        }
        return sub;
    }

    public static double calculateIt() {
        double x = 0.0d;
        double y = 0.0d;
        int total = 0;

        for (int i = 0; i < 7000000 ; i++){
            x = Math.random();
            y = Math.random();

            if (Math.sqrt(x * x + y * y) < 1)
                total++;
        }

        return total / 7000000.0;
    }

}

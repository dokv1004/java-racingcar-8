package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void nowPosition() {
        int num = Randoms.pickNumberInRange(0,9);
        if (num >= 4) {
            position++;
        }
        printPosition();
    }

    public void printPosition() {
        System.out.print(this.name + " : ");
        for (int i=0; i<this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

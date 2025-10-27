package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int playTimes = 0;

    public void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        addCar(parser(Console.readLine()));
        System.out.println("시도할 회수는 몇회인가요?");
        setTimes();
        moveCar();
        printWinner();
    }

    public List<String> parser(String readLine) {
        Validator validator = new Validator();

        // 배열대신 컬렉션을 사용하자!!!
        // 1. 쉼표(,)를 기준으로 앞, 뒤 공백없이 split을 진행
        // 2. split된 항목들에 대하여 유효성 검사 -> Validator 클래스에서 담당 예정
        // 3. 유효성 검사까지 통과하면 cars를 반환

        List<String> cars = new ArrayList<>(
                Arrays.asList(readLine.trim().split("\\s*,\\s*"))
        );
        validator.isNameValidated(cars);
        return cars;
    }

    public void addCar(List<String> cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    public void setTimes() {
        Validator validator = new Validator();

        String times = Console.readLine();
        validator.isTimeValidated(times);
        this.playTimes = Integer.parseInt(times);
    }

    public void moveCar() {
        for (int i=0; i<this.playTimes; i++) {
            for (Car car : cars) {
                car.nowPosition();
            }
            System.out.println();
        }
    }

    public void printWinner() {
        int max = 0;
        ArrayList<String> winners = new ArrayList<String>();

        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}

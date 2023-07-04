package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.util.Asserts;

public class RacingGame {

    private final Car[] cars;

    public RacingGame(Car... cars) {
        assertDuplicateCarName(cars);
        this.cars = cars;
    }

    private static void assertDuplicateCarName(Car... cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
            duplicatedName.add(car.getName());
        }
    }

    public Car[] getRoundResult() {
        return cars;
    }

    public void play() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Car[] getWinners() {
        int winnerPosition = Arrays.stream(cars)
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("winnerCount는 항상 존재합니다."));

        return Arrays.stream(cars)
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .toArray(Car[]::new);
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

}

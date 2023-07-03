package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;

    public Car(String name) {
        preAssert(name);
        this.name = name;
    }

    private void preAssert(String name) {
        assertNotNull(name);
        assertNameLength(name);
    }

    private void assertNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + name + "\"");
        }
    }

    private void assertNotNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름은 null값이 될 수 없습니다.");
        }
    }

}

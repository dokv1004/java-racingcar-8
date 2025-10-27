package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean isValidatedPlayerNum(List<String> names) {
        if (names.size() > 1) {
            return true;
        }
        return false;
    }

    public boolean isValidatedNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidatedDuplication(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() == names.size();
    }

    public void isNameValidated(List<String> names) {
        if (!isValidatedPlayerNum(names)) {
            throw new IllegalArgumentException("두 명이상의 플레이어가 필요합니다.");
        }
        if (!isValidatedNameLength(names)) {
            throw new IllegalArgumentException("플레이어 이름은 5자 이하여야 합니다.");
        }
        if (!isValidatedDuplication(names)) {
            throw new IllegalArgumentException("중복된 이름 존재");
        }
    }
}

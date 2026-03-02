package dsa;

import java.util.List;

public record Course(int courseId, String courseName, List<Integer> prerequisite) {
}

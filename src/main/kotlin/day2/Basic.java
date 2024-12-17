package day2;

import java.util.ArrayList;
import java.util.List;

public class Basic {
    public static void main() {
        var items = new ArrayList<String>(List.of("a", "b", "c"));
        items.forEach((s) -> {System.out.println(s);} );
    }
}

package nl.arjen.udbackend.rest.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by arjen on 8/12/18.
 */
public class TotalItem implements Item {
    private String label;
    private double value;
    private String color = RandomColorService.getColor();

    public TotalItem() {
    }

    public TotalItem(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public TotalItem(String label, double value, String color) {
        this.label = label;
        this.value = value;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public double getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private static class RandomColorService {
        private static List<String> colors = Arrays.asList(
                "rgb(26, 188, 156)",
                "rgb(46, 204, 113)",
                "rgb(52, 152, 219)",
                "rgb(155, 89, 182)",
                "rgb(52, 73, 94)",
                "rgb(22, 160, 133)",
                "rgb(39, 174, 96)",
                "rgb(41, 128, 185)",
                "rgb(142, 68, 173)",
                "rgb(44, 62, 80)",
                "rgb(241, 196, 15)",
                "rgb(230, 126, 34)",
                "rgb(231, 76, 60)",
                "rgb(236, 240, 241)",
                "rgb(149, 165, 166)",
                "rgb(243, 156, 18)",
                "rgb(211, 84, 0)",
                "rgb(192, 57, 43)",
                "rgb(189, 195, 199)",
                "rgb(127, 140, 141)"
        );

        public static String getColor() {
            return colors.get(new Random().nextInt(colors.size()));
        }
    }
}

import java.util.function.*;
import java.util.stream.*;
import java.awt.Color;

class Camera {
    private Function<Color, Color> filter;  // i/o

    public Camera(Function<Color, Color>... filters) { 
        // filter = input -> input;
        // for(var aFilter : filters) {
        //     filter = filter.andThen(aFilter);
        // }

        //filter = Stream.of(filters)
        //    .reduce(input -> input, (composed, aFilter) -> composed.andThen(aFilter));

        filter = Stream.of(filters)
            .reduce(Function.identity(), Function::andThen);
    }


    public Color snap(Color input) {
        return filter.apply(input);
    }

}

// .. = new BufferedInputStream( new DataInputStream ( new FileInputStream ( .. )))
public class decorator_using_lambda_expressions {

    public static void print(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }
    public static void main(String[] args) {
        print(new Camera());
        print(new Camera(Color::brighter));
        print(new Camera(Color::darker));
        print(new Camera(Color::brighter, Color::darker));
    }
}
package java8.decorator;
import java.util.function.*;
import java.awt.*;
import java.util.stream.Stream;

public class Camera {

    private Function<Color,Color> filter ;

    Color snap(final Color input){
        return filter.apply(input) ;
    }

    Camera(Function<Color,Color>... filters){
        setFilters();
    }

    void setFilters(Function<Color,Color>... filters) {
        //Stream.of(filters).reduce(Function.identity() , (theFilters , aFilter) -> theFilters.andThen(aFilter));
        Stream.of(filters).reduce(Function.identity() , Function::andThen);
        filter = color -> color ; // default filter
    }
}

    class Sample {

    public static void printSnap(Camera camera){
        System.out.println( camera.snap(new Color(125,125,125)));
    }

    public static void main(String[] args) {
            printSnap(new Camera());

            printSnap(new Camera(Color::brighter));
            printSnap(new Camera(Color::darker));

    }

}
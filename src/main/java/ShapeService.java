import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class ShapeService {
    private final ObjectMapper mapper;

    public ShapeService() {
        mapper = new ObjectMapper();
    }

    public Shape findShapeWithLargestArea(List<Shape> shapes) {
        if (shapes == null) {
            throw new IllegalArgumentException("The list of figures cannot be null");
        }
        return shapes.stream()
                .max(Comparator.comparingDouble(Shape::area))
                .orElseThrow(() -> new NoSuchElementException("No figures in the list for calculation"));
    }

    public Shape findShapeWithLargestPerimeter(List<Shape> shapes, Class<? extends Shape> type) {
        if (shapes == null || type == null) {
            throw new IllegalArgumentException("The list of figures and the type of figure cannot be null");
        }
        return shapes.stream()
                .filter(type::isInstance)
                .max(Comparator.comparingDouble(Shape::perimeter))
                .orElseThrow(() -> new NoSuchElementException("No figures of the given type in the list"));
    }

    public void exportShapesToJson(List<Shape> shapes, String path) {
        if (shapes == null || path == null || path.isEmpty()) {
            throw new IllegalArgumentException("The list of figures or path cannot be null or empty");
        }
        try {
            mapper.writeValue(Paths.get(path).toFile(), shapes);
        } catch (IOException e) {
            throw new RuntimeException("Error while exporting figures to JSON: " + e.getMessage(), e);
        }
    }

    public List<Shape> importShapesFromJson(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("The path cannot be null or empty");
        }
        try {
            return mapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Shape>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error while importing figures from JSON: " + e.getMessage(), e);
        }
    }
}
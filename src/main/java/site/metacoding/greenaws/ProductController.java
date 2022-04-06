package site.metacoding.greenaws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @Value("${pic.path}")
    private String path;

    // 경로 테스트
    @GetMapping("/image")
    public ResponseEntity<?> image() {
        return new ResponseEntity<>("이미지 저장 경로 : " + path, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK); // 200
    }

    @PostMapping("/product")
    public ResponseEntity<?> save(Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED); // 201
    }
}

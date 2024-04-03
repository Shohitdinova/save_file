package com.example.file_yuklash;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Controller
@RequestMapping("/user")
public class FileController {

    @PostMapping
    public  String writeFile(@ModelAttribute FileDto fileDto
    ) throws IOException
    {
            MultipartFile file = fileDto.getFile();
            file.getOriginalFilename();
            Path path = Path
                    .of("src/main/resources/static/"
                            + file
                            .getOriginalFilename());
            Files.write(path, file
                    .getBytes());
                        return "index";
        }
}

@Data
class FileDto {
    private MultipartFile file;
}
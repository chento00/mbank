package com.co.mobile_banking.util;

import com.co.mobile_banking.api.file.FileDto;
import com.co.mobile_banking.api.file.SearchFileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class FileUtil {
    @Value("${file.server-path}")
    private String fileServerPath;
    @Value("${file.base-url}")
    private String fileBaseUrl;

    public FileDto upload(MultipartFile file) {
        int lastDotIndex = Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(lastDotIndex + 1);
        long size = file.getSize();
        String fileName = String.format("%s.%s", UUID.randomUUID(), extension);
        String url = String.format("%s%s", fileBaseUrl, fileName);
        Path path = Paths.get(fileServerPath + fileName);
        try {
            Files.copy(file.getInputStream(), path);
            return FileDto.builder()
                    .name(fileName)
                    .url(url)
                    .extension(extension)
                    .size(size)
                    .build();
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Upload file failed , please try again"
            );
        }
    }

    public SearchFileDto isFileNameExist(String fileName) {
        File file = new File(fileServerPath);
        if (Objects.requireNonNull(file.list()).length > 0) {
            List<File> fileList = new ArrayList<>(List.of(Objects.requireNonNull(file.listFiles())));
            for (File f : fileList) {
                if (f.getName().equals(fileName)) {
                    return new SearchFileDto(f, true);
                }
            }
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("file with name %s search not found", fileName)
            );
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No file in server"
        );
    }

    public String getExtensionFile(File file) {
        int lastDotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(lastDotIndex + 1);
    }

    public String getExtensionStringFile(String file) {
        int lastDotIndex = file.lastIndexOf(".");
        return file.substring(lastDotIndex + 1);
    }
}

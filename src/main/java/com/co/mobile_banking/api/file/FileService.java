package com.co.mobile_banking.api.file;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    /**
     * use to upload single file
     *
     * @param file request data from client
     * @return File Dto
     */
    FileDto uploadSingle(MultipartFile file);

    /**
     * use to upload multiple file
     *
     * @param files request data from client
     * @return List File Dto
     */
    List<FileDto> uploadMultiple(List<MultipartFile> files);

    /**
     * use to find all file in server
     *
     * @return list of files in server
     */
    List<FileDto> findAll();

    /**
     * use to find file in server by name
     *
     * @param fileName search file name
     * @return a file from sever
     */
    FileDto findByName(String fileName);

    /**
     * use to delete file by filename
     *
     * @param filename search filename then delete
     * @return a file name after delete
     */
    String deleteByName(String filename);

    boolean removeAllFiles();

    FileDto downloadFileByFileName(String filename, HttpServletResponse response);
}

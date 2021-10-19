package com.web.repository.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource load(String filename) throws MalformedURLException;

	public String copy(MultipartFile file) throws IOException;
	
	public Path getPath(String filename);
	
	public Stream<Path> loadAll()throws Exception;

	public boolean delete(String filename);

	public void deleteAll();

	public void init() throws IOException;

}

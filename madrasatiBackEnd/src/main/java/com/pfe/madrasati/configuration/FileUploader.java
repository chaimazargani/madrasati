package com.pfe.madrasati.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.Result;
import io.minio.UploadObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.RegionConflictException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.messages.Item;
@Configuration
public class FileUploader  {
	

  private  final String  bucketName = "madrasati/" ;
      // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
      @SuppressWarnings("deprecation")
	MinioClient minioClient = new MinioClient("127.0.0.1",9000, "minioadmin", "minioadmin",false);
    public void fileExist() { 
      // Check if the bucket already exists.
      boolean isExist = false;
	
		try {
			isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
		} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
				| InternalException | InvalidBucketNameException | InvalidResponseException | NoSuchAlgorithmException
				| ServerException | XmlParserException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

      if(isExist) {
        System.out.println("Bucket already exists.");
      } else {
        // Make a new bucket called asiatrip to hold a zip file of photos.
        
			try {
				minioClient.makeBucket(MakeBucketArgs.builder().bucket("madrasati").build());
			} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
					| InternalException | InvalidBucketNameException | InvalidResponseException
					| NoSuchAlgorithmException | RegionConflictException | ServerException | XmlParserException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

     }
    } 

	public List<String> getFile() {
    List<String>  listCour = new ArrayList();
		
			Iterable<Result<Item>> result;
			try {
				result = minioClient.listObjects("madrasati");
				result.forEach(obj -> { 
					getListFilesNames(listCour, obj);	
				});
				return listCour ;
			} catch (XmlParserException e) {
				// TODO Auto-generated catch block
				throw new IllegalStateException(e);
			}
			

	}

	private void getListFilesNames(List<String> listCour, Result<Item> obj) {
		try {
			
		String cours = obj.get().objectName();
		listCour.add(cours) ; 

		} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException
				| InsufficientDataException | InternalException | InvalidBucketNameException
				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
				| IOException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
      public void putFile(MultipartFile files) {
      // Upload the zip file to the bucket with putObject
   
				//creating an InputStreamReader object
				try {
					PutObjectOptions options = new PutObjectOptions(-1,6 * 1024 * 1024);
						this.minioClient.putObject("madrasati", "niveau1/cours/"+files.getOriginalFilename(), files.getInputStream(), options);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
						| InternalException | InvalidBucketNameException | InvalidResponseException
						| NoSuchAlgorithmException | ServerException | XmlParserException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

//			minioClient.putObject("madrasati","/matiere/cours/file.pdf", file, null);

  }
      
      
      public InputStream getObjectCours(String nomFichier) {
    	  
    
    		  InputStream fileObject;
			try {
				fileObject = this.minioClient.getObject("madrasati", nomFichier);
				return fileObject ;
			} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
					| InternalException | InvalidBucketNameException | InvalidResponseException
					| NoSuchAlgorithmException | ServerException | XmlParserException | IOException e) {
				// TODO Auto-generated catch block
				throw new IllegalStateException(e);
			}
    			
		
    	  }
     
      
      
      
}
 
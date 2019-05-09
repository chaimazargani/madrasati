package com.pfe.madrasati.configuration;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Repository;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;

@Repository
public class FileUploader {
	private  MinioClient minioClient;
	final private String endPoint = System.getProperty("ENDPOINT");
	final private String accessKey= System.getProperty("ACCESSKEY");
	final private String secretKey= System.getProperty("SECRETKEY");
	 public void newMinioClient () {
		     // Créer un minioClient avec le nom du serveur MinIO, le port, la clé d'accès et la clé secrète.
		      try {
				 this.minioClient = new MinioClient(this.endPoint,this.accessKey , "secretKey");
			} catch (InvalidEndpointException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		      
		      
	 
		    	  public void makeBucket (String nomBucket) {
		     	  try {
					minioClient.makeBucket(nomBucket);
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidBucketNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RegionConflictException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InsufficientDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoResponseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ErrorResponseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InternalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		    	  
		    	  
		    	  public void putObject (String nomBucket , String nomFichier , String pathRepertoire ) {
		   // Télécharger le fichier zip dans le compartiment avec putObject
		      try {
				minioClient.putObject( nomBucket,nomFichier, pathRepertoire);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidBucketNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InsufficientDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoResponseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ErrorResponseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InternalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    }
		    
}

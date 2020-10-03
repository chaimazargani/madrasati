package com.pfe.madrasati.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.madrasati.model.FileDTO;
import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Niveau;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.model.security.UserPrinciple;
import com.pfe.madrasati.service.ClasseService;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.Result;
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

	public List<String> getFile(final FileDTO fileDTO) {
    List<String>  listCour = new ArrayList<>();
		
			Iterable<Result<Item>> result;
			try {
				result = minioClient.listObjects("madrasati");

				final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				final Utilisateur utilisateur = ((UserPrinciple) principal).getUser();
				final List<MatierEnseignantClasse> list = this.getListClasseByIdEnseignantIdMatiere(utilisateur.getIdUtilisateur(), fileDTO.getMatier().getIdMatier());
				final Niveau niveau = fileDTO.getNiveau();
				final Matier matier = fileDTO.getMatier();
				result.forEach(obj -> { 
					getListFilesNames(listCour, obj,matier,niveau,utilisateur.getIdUtilisateur());	
				});
				return listCour ;
			} catch (XmlParserException e) {
				// TODO Auto-generated catch block
				throw new IllegalStateException(e);
			}
			

	}

	private void getListFilesNames(List<String> listCour, 
			Result<Item> obj,final Matier matier,final Niveau niveau,final Integer idUtilisateur) {
		try {
			
		String nomFichierComplet = obj.get().objectName();
		final String path = matier.getNomMatier()+"/"+niveau.getNomNiveau()+"/cours/"+idUtilisateur.toString();
		if(nomFichierComplet.contains(path)) {
			listCour.add(nomFichierComplet) ;
		}
		} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException
				| InsufficientDataException | InternalException | InvalidBucketNameException
				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
				| IOException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Autowired
	ClasseService classeService;
	
	private List<MatierEnseignantClasse> getListClasseByIdEnseignantIdMatiere(final Integer idEnseignant,final Integer idMatier){
		return this.classeService.getClassesByIdEnseignant(idEnseignant).stream()
				.filter(mec -> mec.getMatierEnseignantClassePk().getIdMatier() == idMatier)
				.collect(Collectors.toList());
	}

	public void putFile(MultipartFile file) {
      // Upload the zip file to the bucket with putObject
    		//creating an InputStreamReader object
				try {
					PutObjectOptions options = new PutObjectOptions(-1,6 * 1024 * 1024);
					Integer idEnseignant = 1;
						this.minioClient.putObject("madrasati", "math/niveau1/cours/"+idEnseignant.toString()+"/"+file.getOriginalFilename(), file.getInputStream(), options);
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
 
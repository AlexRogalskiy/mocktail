package com.svashishtha.mocktail.metadata.repository;

import org.yaml.snakeyaml.Yaml;

import com.svashishtha.mocktail.repository.ObjectFileOperations;
import com.svashishtha.mocktail.repository.ObjectRepository;

public class YamlDiskRepository implements ObjectRepository {

    private ObjectFileOperations fileOperations = new ObjectFileOperations();;

    @Override
    public void saveObject(Object object, String objectId, String location) {
        Yaml yaml = new Yaml();
        String yamlStr = yaml.dump(object);
        Exception e = new Exception(objectId);
        e.printStackTrace();
        fileOperations.writeStringToFile(yamlStr, objectId, location);
    }

    @Override
    public Object getObject(String objectId, String location) {
        String fileContent = fileOperations.getStringContentFromFile(objectId, location);
        return new Yaml().load(fileContent);
    }

    @Override
    public boolean objectAlreadyExist(String objectId, String location) {
        return fileOperations.fileAlreadyExists(objectId, location);
    }
    
    @Override
	public boolean clearObjectIfAvailable(String objectId, String location) {
		boolean objectAlreadyExist = objectAlreadyExist(objectId, location);
		if(objectAlreadyExist){
			return fileOperations.deleteObject(objectId, location);
		}
		return true;
	}
}

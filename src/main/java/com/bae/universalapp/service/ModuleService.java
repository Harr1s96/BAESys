package com.bae.universalapp.service;

import java.util.List;

import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ModuleService
 */
@Service
public class ModuleService {

    private ModuleRepo moduleRepo;

    public ModuleService(ModuleRepo repo) {

        this.moduleRepo = repo;
    }

    public Module addModule(Module module) {

        return this.moduleRepo.save(module);
    }

    public Module getModuleById(Long id) {

        return this.moduleRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Module> getAllModules() {

        return this.moduleRepo.findAll();
    }

    public Module updateModuleById(Module module, Long id) {

        Module toUpdate = this.moduleRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.setModuleName(module.getModuleName());
        toUpdate.setModuleCode(module.getModuleCode());

        return this.moduleRepo.save(toUpdate);
    }

    public Module updateLecturesByModuleId(Long id, List<Lecture> lectureList) {
        
        Module toUpdate = this.moduleRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.getLectures().addAll(lectureList);

        return this.moduleRepo.save(toUpdate);
    }

    public String deleteModuleById(Long id) {

        this.moduleRepo.deleteById(id);

        boolean moduleCheck = this.moduleRepo.existsById(id);

        if (moduleCheck) {
            return "Module has not been deleted";
        }
        return "Module deleted successfully";

    }

    public boolean verifyModuleCode(List<Module> moduleList) throws EmptyModuleListException {

        boolean verified = false;

        if (moduleList == null || moduleList.isEmpty()) {
            throw new EmptyModuleListException();
        }

        for (Module m : moduleList) {

            if (m.getModuleCode().matches("CHEM\\s\\d{3}")) {
                verified = true;
            } 
            else {
                throw new InvalidModuleCodeException();
            }
        }
        return verified;

    }

	public boolean verifyModuleCode(Module module) {

        boolean verified = false;

        if (module.getModuleCode().matches("CHEM\\s\\d{3}")) {
            verified = true;
        }
        else {
            throw new InvalidModuleCodeException();
        }
        return verified;
	}

}
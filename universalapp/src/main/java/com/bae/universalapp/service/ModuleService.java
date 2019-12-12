// package com.bae.universalapp.service;

// import java.util.List;

// import com.bae.universalapp.persistence.repo.ModuleRepo;
// import com.bae.universalapp.persistence.domain.Module;

// import org.springframework.stereotype.Service;

// /**
//  * ModuleService
//  */
// @Service
// public class ModuleService {

//     private ModuleRepo moduleRepo;

//     public ModuleService(ModuleRepo repo) {
        
//         this.moduleRepo = repo;
//     }

//     public Module addModule(Module module) {
        
//         return this.moduleRepo.save(module);  
//     }

//     public Module getModuleById(Long id) {

//         return this.moduleRepo.findById(id).get();
//     }

//     public List<Module> getAllModules() {

//         return this.moduleRepo.findAll();
//     }

//     public Module updateModuleById(Module module, Long id) {

//         Module toUpdate = this.moduleRepo.findById(id).get();
//         toUpdate.setModuleName(module.getModuleName());
//         toUpdate.setModuleCode(module.getModuleCode());

//         return toUpdate;
//     }

//     public String deleteModuleById(Long id) {

//         this.moduleRepo.deleteById(id);

//         boolean teacherCheck = this.moduleRepo.existsById(id);

//         if (teacherCheck) {
//             return "Module has not been deleted";
//         }
//         return "Module deleted sucessfully";


//     }

    
// }
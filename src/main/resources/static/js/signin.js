"use strict"

    function clearDatabase() {
        axios.all([
            axios.delete("http://localhost:8081/deleteAllUsers"),
            axios.delete("http://localhost:8081/deleteAllTeachers"),
            axios.delete("http://localhost:8081/deleteAllModules"),
            axios.delete("http://localhost:8081/deleteAllLectures")
        ])
        .then(responseArr => console.log(responseArr));
    }

    function postAllData() {
        
        clearDatabase();
        
        axios.all([
            axios.post("http://localhost:8081/user",
                {"email":"myuser@coldmail.com",
                "password":"mypass"}),

            axios.post("http://localhost:8081/teacher",
                {"firstName":"Joanthan",
                "lastName":"Georgiou",
                "modules":[{"moduleName":"Introduction to Physical Chemistry", "moduleCode":"CHEM 154"},
                    {"moduleName" : "Advanced Spectroscopy", "moduleCode" : "CHEM 461"},
                    {"moduleName" : "Introduction to Quantum Chemistry", "moduleCode" : "CHEM 354"}]}),
            
            axios.post("http://localhost:8081/teacher",
                {"firstName":"Matt",
                "lastName":"Farrow",
                "modules":[{"moduleName" : "Group Theory", "moduleCode":"CHEM 382"},
                    {"moduleName":"Thermodynamics", "moduleCode":"CHEM 245"},
                    {"moduleName":"Laboratory Methods", "moduleCode":"CHEM 211"}]}),
            
            axios.post("http://localhost:8081/teacher",
                {"firstName":"Liam",
                "lastName":"McIvor",
                "modules":[{"moduleName" : "introduction to Computational", "moduleCode":"CHEM 280"}]}),
            
            axios.post("http://localhost:8081/teacher",
                {"firstName":"Chloe",
                "lastName":"Adcock",
                "modules":[{"moduleName" : "Introduction to Organic Chemistry", "moduleCode":"CHEM 130"},
                    {"moduleName":"Heterocyclic Chemistry", "moduleCode":"CHEM 230"}]})   
        ])
        .then(responseArr => console.log(responseArr));
    }

    window.onload = (function() {
        this.postAllData();
    });
      
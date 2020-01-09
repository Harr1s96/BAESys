"use strict";

const teacherList = document.getElementById("teacher-list");
const listGroup = document.getElementById("list-group");

// get the dive container that the dropdown list will be within
const mainDiv = document.getElementById("list-div");

const teacherData = axios.get("http://localhost:8081/teachers")
    .then(response => {console.log(response.data); 
                    return response.data;});

function postData() {

    let str = document.getElementById("lecturer").value;
    let lecturerNameArray = str.split(" ");
    
    let moduleName = document.getElementById("moduleName").value;
    let moduleCode = document.getElementById("moduleCode").value;

    const toPost = {"firstName":lecturerNameArray[0],
            "lastName":lecturerNameArray[1],
            "modules":[{"moduleName": moduleName, "moduleCode": moduleCode}]}

    axios.post("http://localhost:8081/teacher", toPost)
        .then(response => {console.log(response); location.reload();})
    }

function showTeachers() {

    teacherData.then(data => {
        for (let teacher of data) {
            const listElement = document.createElement("li");
            listElement.className = "list-group-item list-group-item-action";
            listElement.innerHTML = teacher.firstName + " " + teacher.lastName;
            listElement.onclick = (function() {getModules(this.innerHTML)});
            listGroup.appendChild(listElement);
        }
    });
}

function getModules(listText) {

    mainDiv.innerHTML = "";

    const dropList = document.createElement("select");
    dropList.name = "dropdown";
    dropList.id = "dropdown";
    dropList.onchange = (function() {window.location.href=this.value});

    const dropListTitle = document.createElement("option");
    dropListTitle.value = "none";
    dropListTitle.setAttribute("selected", "");
    dropListTitle.setAttribute("hidden", "");
    dropListTitle.text = "Please select a module";

    mainDiv.appendChild(dropList);
    dropList.appendChild(dropListTitle); 

    let listElems = document.getElementById("list-group").getElementsByTagName("li");

    for (let i = 0; i < listElems.length; i++) {    
        teacherData.then(data => {
            if ((data[i].firstName + " " + data[i].lastName) == listText) {
                for (let m of data[i].modules) {  
                    const optionElement = document.createElement("option");
                    optionElement.value = "lecture-page.html?id=" + data[i].id;  
                    optionElement.text = m.moduleCode; 
                    dropList.appendChild(optionElement);
                }
            }
        });
    }
}
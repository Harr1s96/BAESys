"use strict";

const teacherList = document.getElementById("teacher-list");
const listGroup = document.getElementById("list-group");

// get the dive container that the dropdown list will be within
const mainDiv = document.getElementById("list-div");

const teacherData = axios.get("http://localhost:8081/teachers")
    .then(response => {return response.data});

function showTeachers() {

    teacherData.then(data => {
        for (let teacher of data) {
            const listElement = document.createElement("li");
            listElement.className = "list-group-item list-group-item-action";
            listElement.value = teacher.id;
            listElement.onclick = (function() {getModules(this.value)});
            listElement.innerHTML = teacher.firstName + " " + teacher.lastName;
            listGroup.appendChild(listElement);
        }
    });
}

function getModules(listValue) {

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
            if (data[i].id === listValue) {
                for (let m of data[i].modules) {  
                    const optionElement = document.createElement("option"); 
                    optionElement.value = "lecture-page.html";  
                    optionElement.text = m.moduleCode; 
                    dropList.appendChild(optionElement);
                }
            }
        });
    }
}
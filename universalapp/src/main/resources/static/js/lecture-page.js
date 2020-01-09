"use strict"
      
const lectureList = document.getElementById("lecture-list");
const listGroup = document.getElementById("list-group");
const mainDiv = document.getElementById("list-div");

const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('id');
  
const lectureData = axios.get("http://localhost:8081/teachers/modules/" + myParam)
    .then(response => {console.log(response.data); 
        return response.data;});

function postData() {

    let lectureName = document.getElementById("lecture").value;

    const toPost = [{"lectureName": lectureName}]

    axios.put("http://localhost:8081/module/" + myParam, toPost)
        .then(response => {console.log(response); location.reload();})
}

function showLectures() {

    lectureData.then(data => {
        let listOfLectures = data.lectures;

        for (let lecture of listOfLectures) {
            
            const listElement = document.createElement("li");
            listElement.className = "list-group-item list-group-item-action";
            
            listElement.innerHTML = lecture.lectureName;
            listGroup.appendChild(listElement);
        }
    });
}
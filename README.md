# A Lecture Repository Web Application

A simple web app that tracks modules and lectures at university and/or colleges for personal use.

## Table of Contents
* [Features](#Features)
* [Technologies](#Technologies)
* [Usage](#Usage)
* [Status](#Status)

<a name="Features"></a>
## Features
* **Create** - Users are able to create lecturer records with their corresponding taught modules and lectures.
* **Read** - Created recordings are automatically displayed on the webpage.
* **Update** - Users can update created recordings via a right-click context menu.
* **Delete** - All created records can be deleted via the context menu.

<a name="Technologies"></a>
## Technologies

* **RESTful API**: Java SpringBoot 2.2.2
* **Database** - embedded H2 SQL database
* **Front-end** - HTML5/JavaScript
* **Build Tool** - Apache Maven 3.6.3
* **Server** - Apache Tomcat 8.5.5

### Browser Support
![Chrome](https://github.com/alrra/browser-logos/blob/master/src/chrome/chrome_48x48.png) | ![Firefox](https://github.com/alrra/browser-logos/blob/master/src/firefox/firefox_48x48.png) 
--- | --- |
Latest ✔ | Latest ✔ |


<a name="Usage"></a>
## Usage

To Access the App Navigate to the address:

`http://3.11.133.109:8181/UniversalApp/`

Only CHEM XXX modules are supported at the moment, entering other modules will throw a

`HTTP 400 Bad Request`

![UniversalApp Usage Demo](project-demo.gif)



<a name="Status"></a>
## Status

* **Build** - Passing ✔
* **Test Coverage** - 89.3% ✔

Feel free to clone the repository and have a little tinker. All suggestions for improvements are welcome :)

`git clone https://github.com/Harr1s96/BAESys.git`

<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<!--
  Material Design Lite
  Copyright 2015 Google Inc. All rights reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License
-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Material Design Lite</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/material.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/Card.css">
    <link href="https://fonts.googleapis.com/css?family=Baloo+Thambi" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
    <style>
    #view-source {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
    </style>
  </head>
  <body>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header" styles="background-color:#09f">
      <div class="topbar">
          <div style=" float: left; width: 25%; height: 90px;display:table">
              <span class="topbar-left">AREA</span>
          </div>
          <div style="float: right; height: 90px;display:table;margin-top: 20px;margin-right: 13%;">
              <button class="standard-button" onclick="location.href='index'">Home</button>
              <button class="standard-button" onclick="location.href='connectAPI'">Connection</button>
              <button class="standard-button" onclick="location.href='Services'">Services</button>
              <button class="signout-button" onclick="location.href='logout'">Sign out</button>
          </div>
      </div>
        <div class="content">
          <span class="titles-cards">Select the best services for you</span>
          <br><br><br><br><br><br>
          <span class="nav">
           ${cards}
          </span>
        </div>
    </div>

    <script src="js/material.min.js"></script>
  </body>
</html>

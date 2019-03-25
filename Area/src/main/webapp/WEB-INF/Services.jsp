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
    <title>Services</title>

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
    <link rel="stylesheet" href="css/Services.css">

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

<main class="connectC">
    <h1 class="titles-service">Connect Your Services Each Other</h1>
    </br>
    </br>
    <form method="post" action="Services" style="text-align: center">
        <div class="styled-select">
            <div style="display: table-cell;float: left;margin-left: 25%;">
                <select id="GetChoice" name="getChoice">
                    <option value="Redtube">Redtube</option>
                    <option value="Sensit">Sensit</option>
                    <option value="Geolocalisation">Geolocalisation</option>
                    <option value="Youtube">Youtube</option>
                    <option value="Netfix">Netfix</option>
                </select>
            </div>
            <div style="display: table-cell;float: right;margin-right: 25%;">
                <select id="PostChoice" name="postChoice" onchange="choiceDisplay()">
                    <option value="Twitter">Twitter</option>
                    <option value="Slack">Slack</option>
                    <option value="Facebook">Facebook</option>
                </select>
            </div>
        </div>
        <br><br>
        <input style="margin-top: 40px" class="intext" id="chan" name="channel" value="enter channel" type="hidden">
        <br><br>
        <div style="text-align: center;">
            <input class="myButton" type="submit" value="Validate">
            ${errorServices}
        </div>
    </form>
    <script>
        function choiceDisplay() {
            var x = document.getElementById("PostChoice").value;
            if (x == "Yammer" || x == "Slack" || x == "Facebook")
            {
                document.getElementById('chan').type ="text";
                document.getElementById('chan').value ="";
            }
            else {
                document.getElementById('chan').type ="hidden";
                document.getElementById('chan').value ="";
            }
        }
    </script>

    </br>
    </br>
    </ul>
    </br>
    </br>
    </br>
    </br>
</main>

<script src="js/material.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>


</body>
</html>

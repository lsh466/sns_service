<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/style.css">
    <title>Document</title>
</head>
<body>
    <h1>게시글 내용</h1>
    <p id='titleP'></p>
    <p id="writerP"></p>
    <p id="contentP"></p>

    <script>
    var getParam = function(key){
        var _parammap = {};
        document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
                return decodeURIComponent(s.split("+").join(" "));
            }

            _parammap[decode(arguments[1])] = decode(arguments[2]);
        });

        return _parammap[key];
    };
    
    var titleContainer = document.getElementById('titleP');
    var writerContatiner = document.getElementById('writerP');
    var contentContainer = document.getElementById('contentP');

    contentContainer.innerHTML = '${content}';
    </script>

</body>

    <script>
        
    </script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#general").click(function () {
                $.post("http://localhost:8080/goubige/postJson", {
                    status: "5"
                }, function (data) {
                    //处理json'
                    alert(data.data.length);
                    console.log(data);
                }, "json");
            });
            $("#goodsGet").click(function () {
                alert("ok");
                $.get("http://localhost:8080/goubige/goods?pageSize=10&pageNum=1", function (data) {
                    //处理json'
                    alert(data.data.length);
                    console.log(data);
                }, "json");
            });
        });
    </script>
    <script type="text/javascript">
        var datas;
        var i=0;
        var page=1;
        var task;
        function getdata(page) {
            $.get("http://localhost:8080/goubige/goods?pageSize=10&pageNum="+page, function (data) {
                //处理json'
                datas=data.data;
                task=setInterval(adddata, 500);
            }, "json");
        }
        function adddata(){
            $("#data").append('<li>'+datas[i].title+'</li>');
            i++;
            if(i=='10'){
                i=0;
                clearInterval(task);
                page++;
                getdata(page)
            }
        }
    </script>
</head>

<body>
<h2>This is a heading</h2>
<p>This is a paragraph.</p>
<p>This is another paragraph.</p>
<button type="button" id="general">Click me</button>
<button type="button" id="goodsGet">Test goods GET</button>
<button type="button" onclick="getdata(1)">测试</button>
<ul id="data">

</ul>
</body>
</html>
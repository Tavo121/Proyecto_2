<%@ page session="true" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Calculadora</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script>
        $(document).ready(function (){
            $('#btn').click(function (){
                var name = $('#name').val();
                $.ajax({
                    type: 'POST',
                    data: {name: name},
                    url: 'AjaxController',
                    success: function (result){
                        $('#result').html(result);
                    }
                });
            });
        });
    </script>
</head>

<body>
    <form>
        <section>
            <img src="math.png" id="bg">
            <h2 id="text">Ingrese la expresion matematica</h2>
            <input type="button" id="btn" value="Enviar">
            <a href="History.jsp" id="historial">Historial de expresiones</a>
        </section>

        <label id="lb1">
            <input type="text" placeholder="Expresion matematica" id="name">
            <span id="result"></span>
        </label>
    </form>
</body>

</html>
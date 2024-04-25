<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js" integrity="sha512-+k1pnlgt4F1H8L7t3z95o3/KO+o78INEcXTbnoJQ/F2VqDVhWoaiVml/OEHv9HsVgxUaVW+IbiZPUJQfF/YxZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>

function salvar(){
	var json = {};
	json.nome = document.getElementById("nome").value;
	json.acao = "inserir";
	$.ajax({
		url:"AlunoServlet",
		data: json,
		type:"get",
		success: function(resp){
			alert(resp);
		}
	});
	
}
</script>
</head>
<body>
nome: <input type="text" id="nome"/>

<input type="button" value="salvar" onClick="salvar()"/>

</body>
</html>
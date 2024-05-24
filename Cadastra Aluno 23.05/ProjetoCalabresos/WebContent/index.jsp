<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js" integrity="sha512-+k1pnlgt4F1H8L7t3z95o3/KO+o78INEcXTbnoJQ/F2VqDVhWoaiVml/OEHv9HsVgxUaVW+IbiZPUJQfF/YxZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script>
		function excluir(ra){
			var json   = {};
			json.ra    = ra;
			json.nome  = "";
			json.curso = "";
			json.senha = "";
			json.acao  = "excluir";
			
			$.ajax({
				url:'AlunoServlet',
				data: json,
				type: "get",
				success: function (resp){
					alert(resp);
					buscar();
				}
			});
		} 
		
		function salvar(){
			var json = {};
			json.ra  = document.getElementById("ra").value;
			json.nome  = document.getElementById("nome").value;
			json.curso = document.getElementById("curso").value;
			json.senha = document.getElementById("senha").value;
			if (json.ra==""){
				json.acao  = "inserir";
			}else{
				json.acao  = "alterar";
			}
			
			$.ajax({
				url: "AlunoServlet",
				data: json,
				type: "post",
				success: function (resp){
					alert(resp);
				}
			});
		}
	
		function buscar() {
			var json = {};
			json.ra    = document.getElementById("ra").value;
			json.nome  = document.getElementById("nome").value;
			json.curso = document.getElementById("curso").value;
			json.senha = document.getElementById("senha").value;
			
			json.acao = "buscar";
			
			$.ajax({
				url: "AlunoServlet",
				data: json,
				type: "get",
				success: function (resp) {					
					if (resp==""){
						document.getElementById("corpo_tabela").innerHTML = "";
						
					}else{					
						var jsonAlunos = JSON.parse(resp);
						montar_tabela(jsonAlunos);
					}
				}
			});	
		}
		
				
		function editar(ra,nome,curso){
			document.getElementById("ra").value = ra;
			document.getElementById("nome").value = nome;
			document.getElementById("curso").value = curso;
		}
		
		function montar_tabela(vetorJson){			
			var linhas = "";			
			
			for (var i=0; i<vetorJson.length; i++){			
				var ra = vetorJson[i].ra;
				var nome = vetorJson[i].nome;
				var curso = vetorJson[i].curso;			
				var linha = `<tr>
					<td><img src='imagens/edit.png' onClick="editar('` + ra + `','` + nome + `','` + curso + `')"/></td>  
					<td><img src='imagens/delete.png'  onClick="excluir('` + ra + `')"/></td>
					<td>` + ra + `</td>
					<td>` + nome + `</td>
					<td>` + curso + `</td>
				</tr>`;
				linhas += linha; //concatenação 
			}
			document.getElementById("corpo_tabela").innerHTML = linhas;
		}
		
		
	</script>
</head>
<body>
	<div class="container text-center">
		<div class="row mt-3 p-0">
 
			<div class="col-6 offset-3 p-0">
				<img src="imagens/uninove.png" style="width: 60%; height: 80px">
			</div>
 
		</div>
		<div class="row mt-1">
			<div class="col"></div>
			<div class="col-8">
 
				<div class="row mt-3 p-0">
					<div class="col-8 offset-2">
						<form>
							<div class="row g-2 align-items-center">
								<div class="col-auto">
									<label for="ra" class="col-form-label">RA.......:</label>
								</div>
								<div class="col w-100">
									<input type="text" id="ra" class="form-control"
										style="width: 100%" disabled>
								</div>
							</div>
							<div class="row g-2 align-items-center">
								<div class="col-auto">
									<label for="nome" class="col-form-label">Nome:</label>
								</div>
								<div class="col w-100">
									<input type="text" id="nome" class="form-control">
								</div>
							</div>
							<div class="row g-2 align-items-center">
								<div class="col-auto">
									<label for="curso" class="col-form-label">Curso.:</label>
								</div>
								<div class="col w-100">
									<input type="text" id="curso" class="form-control">
								</div>
							</div>
							<div class="row g-2 align-items-center">
								<div class="col-auto">
									<label for="senha" class="col-form-label">Senha:</label>
								</div>
								<div class="col w-100">
									<input type="password" id="senha" class="form-control">
								</div>
							</div>
 
							<div class="row g-2 align-items-center mt-3">
								<div class="col-auto">
									<button type="button" class="btn btn-primary mb-3" onClick="buscar()">Buscar</button>   
									<button type="button" class="btn btn-primary mb-3" onClick="salvar()">Salvar</button>
									<button type="reset" class="btn btn-primary mb-3">Limpar</button>
								</div>
							</div>
						</form>
					</div>
				</div>
 
 
				<div class="row align-items-center mt-2">
					<div class="col w-100">
 
						<table class="table caption-top">
							<thead>
								<tr>
									<th scope="col">Editar</th>
									<th scope="col">Excluir</th>
									<th scope="col" class="text-start">RA</th>
									<th scope="col" class="text-start">Nome</th>
									<th scope="col" class="text-start">Curso</th>
								</tr>
							</thead>
							<tbody id="corpo_tabela">
								
							</tbody>
						</table>
					</div>
				</div>
 
			</div>
			<div class="col"></div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
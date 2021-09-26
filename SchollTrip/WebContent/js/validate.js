function validaForm() {
	var name = document.getElementById("name").value;
	var rm = document.getElementById("rm").value;
	var turma = document.getElementById("turma").value;


	if (name == "" || name == null || name.length < 3) {
		swal(decodeURIComponent(escape("Insira um nome valido","")));
		return false;
	}

	else if (rm == "" || rm == null || isNaN(rm) || rm.length < 5) {
		swal(decodeURIComponent(escape("Insira um RM valido","")));
		return false;
	}

	else if (turma == "" || turma == null || turma.length < 6) {
		swal(decodeURIComponent(escape("Insira uma turma valida","")));
		return false;
	}
	else {
	    swal(decodeURIComponent(escape("Inscrição feita com sucesso","")));
	    $.post("../RegistrarAluno.jsp",{iNome: name, iRM: rm, iTurma: turma});
	    document.getElementById("name").value = "";
	    document.getElementById("rm").value = "";
	    document.getElementById("turma").value = "";
		return false;
	}



}

function validaFormP() {
	var nameP = document.getElementById("nameP").value;
	var RMP = document.getElementById("RMP").value;

	if (nameP == "" || nameP == null || nameP.length < 3) {
		swal(decodeURIComponent(escape("Insira um nome valido","")));
		return false;
	}

	else if (RMP == "" || RMP == null || isNaN(RMP) || RMP.length < 6) {
		swal("Insira um RM valido");
		return false;
	}

	else {
		$.post("../RegistrarProfessor.jsp",{INome_Prof: nameP , IRM_Prof: RMP });
	    document.getElementById("Nome_Prof").value = "";
	    document.getElementById("RMP").value = "";
		return false;
	}
}


function validaFormContato() {
	var Email = document.getElementById("Email").value;
	var Mensagem = document.getElementById("Mensagem").value;

	if (Email == "" || Email == null || Email.length < 3) {
		swal(decodeURIComponent(escape("Insira um email valido","")));
		return false;
	}

	else if (Mensagem == "" || Mensagem == null || Mensagem.length < 25) {
		swal(decodeURIComponent(escape("Insira um comentário valido","")));
		return false;
	}

	else {
		swal(decodeURIComponent(escape("Mensagem salva com sucesso","")));
		 $.post("../RegistrarContato.jsp",{email: Email, message: Mensagem});
	    document.getElementById("Email").value = "";
	    document.getElementById("Mensagem").value = "";
		return false;
	}



}
function validaForm() {
    var name = document.getElementById("name").value;
    var rm = document.getElementById("rm").value;
    var turma = document.getElementById("turma").value;


    if (name == "" || name == null || name.length < 3) {
        swal("Insira um nome valido", "");
        return false;
    } else if (rm == "" || rm == null || isNaN(rm) || rm.length < 5) {
        swal("Insira um RM valido", "");
        return false;
    } else if (turma == "" || turma == null || turma.length < 6) {
        swal("Insira uma turma valida", " ");
        return false;
    } else {
        $.post(
            "../RegistrarAluno.jsp", {
                iNome: name,
                iRM: rm,
                iTurma: turma
            }
        ).done(function(data) {
            var exist = data;
            var exist1 = exist.replace("</h1>", '');
            var exist2 = exist1.replace("<h1>", '')
            var exist3 = exist2.replace("/\s/g", '');
            var exist4 = exist3.trim();
            if (exist4 == "yes") {
                var exist = decodeURIComponent(escape("Aluno já cadastrado")); 
                swal(exist, "");
            } else {
	            var insc = decodeURIComponent(escape("Inscrição feita com sucesso"));
                swal(insc, "").then(function() {
                 document.getElementById("name").value = "";
                 document.getElementById("rm").value = "";
                 document.getElementById("turma").value = "";
                  });
              
            }
        });

        return false;
    }

}

function validaFormP() {
    var nameP = document.getElementById("nameP").value;
    var RMPr = document.getElementById("RMP").value;

    if (nameP == "" || nameP == null || nameP.length < 3) {
        swal("Insira um nome valido", "");
        return false;
    } else if (RMPr == "" || RMPr == null || isNaN(RMPr) || RMPr.length < 6) {
        swal("Insira um RM valido","");
        return false;
    } else {
	$.post(
            "../RegistrarProfessor.jsp", {
                iNome_Prof: nameP,
                iRM_Prof: RMPr,
            }
        ).done(function(data) {
            var existp = data;
            var existp1 = existp.replace("</h1>", '');
            var existp2 = existp1.replace("<h1>", '')
            var existp3 = existp2.replace("/\s/g", '');
            var existp4 = existp3.trim();
            if (existp4 == "yes") {
	            var exist = decodeURIComponent(escape("Professor já cadastrado")); 
                swal(exist, "");
            } else {
	            var message = decodeURIComponent(escape("Inscrição feita com sucesso"));
                swal(message, "").then(function() {
                    document.getElementById("nameP").value = "";
                    document.getElementById("RMP").value = "";
                  });
            }
        });
       return false;
    }
}




function validaFormContato() {
    var Email = document.getElementById("Email").value;
    var Mensagem = document.getElementById("Mensagem").value;

    if (Email == "" || Email == null || Email.length < 3) {
        swal("Insira um email valido", "");
        return false;
    } else if (Mensagem == "" || Mensagem == null || Mensagem.length < 25) {
       var mes = decodeURIComponent(escape("Insira um comentário valido")); 
       swal(mes, "");
        return false;
    } else {
        swal("Mensagem salva com sucesso", "");
        $.post("../RegistrarContato.jsp", {
            email: Email,
            message: Mensagem
        });
        document.getElementById("Email").value = "";
        document.getElementById("Mensagem").value = "";
        return false;
    }



}
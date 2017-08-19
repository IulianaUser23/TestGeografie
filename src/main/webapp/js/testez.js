var raspunsuriCorecte = [];
var raspunsuriSelectate = new Array (10);

function verificaForm(form) {
    var mesaj = "Nu ati raspuns la toate intrebarile: ";
    var intrebariFaraRaspuns = [];
    for (var j = 0; j < 30; j += 3) {
        if ((form [j].checked) || (form [j + 1].checked) || (form [j + 2].checked)) {
        } else {
            intrebariFaraRaspuns.push(j / 3 + 1);
        }
    }
    if (intrebariFaraRaspuns.length > 0) {
        $("#myModal .modal-body").text(mesaj + intrebariFaraRaspuns.join(","));
        $("#myModal").modal('show');
       // alert(mesaj + intrebariFaraRaspuns.join(","));
        return false;
    }
    return true;
}

function rezultatQuizz (){
    var rezultat=0;
   for (var s=0; s<10; s++){
       if (raspunsuriCorecte[s] == raspunsuriSelectate[s]) {
           rezultat++;
       }
   } $("#myModal .modal-body").text("Rezultat final:" + rezultat);
    $("#myModal").modal('show');
   //alert ("Rezultat final:" + rezultat);
}

function listTestez(listaRaspunsuriJson) {
    var list2 = document.getElementById('listDeTestat');
    var listHtml = '';
    var grup = [];
    for (var i = 0; i < listaRaspunsuriJson.length; i += 3) {
        var rQuizz = listaRaspunsuriJson[i];
        var gresit1 = listaRaspunsuriJson[i + 1];
        var gresit2 = listaRaspunsuriJson[i + 2];
        var grupNou = [rQuizz, gresit1, gresit2];
        grup.push(grupNou);
        var random = Math.floor(Math.random() * 3);
        var corect = grupNou[random];
        raspunsuriCorecte.push(corect.capitala);
        listHtml = listHtml + "Ce capitala are " + grupNou[random].numeTara + "?" + '<br>'
            + buton(grupNou[0].capitala, i) + '<br>' + buton(grupNou[1].capitala, i)
            + '<br>' + buton(grupNou[2].capitala, i) + '<hr>' + '<br>'
    }
    list2.innerHTML += listHtml;
}

function buton(capitala, i) {
    return '<input onclick="selecteaza(\'' + capitala + '\', ' + i / 3 + ')" type="radio" name="' + i + '" value="'
        + capitala + '">' + capitala;
    }

function selecteaza(capitala, i) {
    console.log('capitala', capitala, i);
    raspunsuriSelectate[i]=capitala;
}

function listDeTestat() {
    $.ajax({
        url: 'testezurl?action=list'
    }).done(function (response) {
        listTestez(response.listaRaspunsuriJson);
    })
}


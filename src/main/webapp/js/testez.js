var raspunsuriCorecte = [];


function verificaRaspunsuri(formular) {
// console.log(formular)
    for (var i = 0; i < 60; i = +3) {
        if ((formular [i][0].checked) |
            (formular [i][1].checked) | (formular [i][2].checked)) {}
        else {
            alert("Nu ati raspuns la toate intrebarile.")
            return false;
        }
    }
    return true;
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
        raspunsuriCorecte.push(corect);
        listHtml = listHtml + "Ce capitala are " + grupNou[random].numeTara + "?" + '<br>'
            + buton(grupNou[0].capitala, i) + '<br>' + buton(grupNou[1].capitala, i)
            + '<br>' + buton(grupNou[2].capitala, i) + '<hr>' + '<br>'
    }

    list2.innerHTML = listHtml;
}

function buton(capitala, i) {
    return '<onclick="selecteaza(\'' + capitala + '\')"> <input type="radio" name="' + i + '" value="' + capitala + '">' + capitala + '</>';
    // return '<button onclick="selecteaza(\'bucuresti\')">' + capitala +'</button>';
}
function listDeTestat() {
    $.ajax({
        url: 'testezurl?action=list'
    }).done(function (response) {
        listTestez(response.listaRaspunsuriJson);
    })
}

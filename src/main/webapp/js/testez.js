
function listTestez(listaRaspunsuriJson) {
    var list2 = document.getElementById('listDeTestat');
    var listHtml = '';
    var grup = [];
    for (var i = 0; i < listaRaspunsuriJson.length; i += 3) {
        var rQuizz = listaRaspunsuriJson[i];
        var gresit1 = listaRaspunsuriJson[i + 1];
        var gresit2 = listaRaspunsuriJson[i + 2];
        grup.push([rQuizz, gresit1, gresit2]);
        listHtml = listHtml + "Ce capitala are " + rQuizz.numeTara + "?" + '<hr>' + rQuizz.capitala + '<br>' + gresit1.capitala
            + '<br>' + gresit2.capitala + '<hr>' + '<br>'
        }

    for (var j=0; j<grup.length; j++){
        var random = Math.floor(Math.random()*3);
        var listR = grup[j];
        var corect = listR[random];
        }
    list2.innerHTML = listHtml;
}

function listDeTestat() {
    $.ajax({
        url: 'testezurl?action=list'
    }).done(function (response) {
        listTestez(response.listaRaspunsuriJson);
    })
}
/**
 * Created by User on 04.08.2017.
 */


function listInvat(listaCapitaleJson) {
    var list = document.getElementById('listDeInvatat');
    var listHtml = '';

    for (var i = 0; i < listaCapitaleJson.length; i++) {
        var lCapitala = listaCapitaleJson[i];
        listHtml = listHtml + lCapitala.capitala + '&nbsp;' + lCapitala.numeTara + lCapitala.continent + '</br>';
    }
    list.innerHTML = listHtml;
}
function listDeInvatat() {
    $.ajax({
        url: 'invaturl?action=list'
    }).done(function (response) {
        listInvat(response.listaCapitaleJson);
    })
}


